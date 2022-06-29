package fr.eni.enchere.dal;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;
	import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Utilisateur;
	
public class ArticleDAOImpl implements ArticleDAO{

	
	
	private static final String INSERT = "insert Into Article_Vendus (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, no_categorie )"
											+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
	
	private static final String SELECT_ALL = "Select * from Article_Vendus";
	
	private static final String DELETE = "Delete FROM Article_Vendus Where no_article = ?";
	
	private static final String SELECT_ID = "SELECT * From Article_Vendus Where no_article = ?";
	
	private static final String UPDATE = "UPDATE Article_Vendus SET nom_article = ? ,description = ? ,date_debut_encheres = ? ,date_fin_encheres = ?,prix_initial = ?, no_categorie = ?";
	
	private static final String SELECT_USER_CATALOGUE = "SELECT * FROM UTILISATEURS";
	
	private static ResultSet rs;
	private static PreparedStatement pStmt = null;									
	private static Statement stmt;
	@Override
	public void insert (Article article) throws DALException {
		
	//Etape 1 : se connecter la BD
		
	//try with resources 
		try (Connection conn = ConnectionProvider.getConnection()){
			
			PreparedStatement stmt = conn.prepareStatement(INSERT , PreparedStatement.RETURN_GENERATED_KEYS);
			
					
		//Valoriser les parametres 
					
		stmt.setString(1, article.getNomArticle());
		stmt.setString(2, article.getDescription());
		stmt.setDate(3, article.getDateDebutEncheres());
		stmt.setDate(4, article.getDateFinEncheres());
		stmt.setInt(5, article.getMiseAPrix());
		stmt.setInt(6, article.getPrixVente());
		stmt.setInt(7, article.getNumero_utilisateur());
		stmt.setInt(8, article.getCategorie());
		
		
		//Etape : executer la requete
		
		stmt.executeUpdate();
		
		//ResultSet un tableau 
		
		ResultSet rs = stmt.getGeneratedKeys();
		if(rs.next()) {
			article.setNumero_utilisateur(1);
		}
			
		} catch (SQLException e) {
			
			
			throw new DALException ("erreur insert",e);
			
		}	
	
	}

	@Override

	public List<Article> selectAll() throws DALException {
		
		//Etape 1 : se connecter la BD
		
		//try with resources 
		try (Connection conn = ConnectionProvider.getConnection()){
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL);
	
			List<Article> listeArticle = new ArrayList<Article>();
	
			while (rs.next()) {
				listeArticle.add(new Article(rs.getInt("no_article"), rs.getString("nom_article"), rs.getString("description"), rs.getDate("date_debut_encheres"), rs.getDate("date_fin_encheres"), rs.getInt("prix_initial"), rs.getInt("no_categorie")));
			}
			return listeArticle;
				
		} catch (SQLException e) {
			
			
			throw new DALException ("erreur Select All",e);
			
		}	
	
	}

	@Override
	public void delete(int noArticle ) throws DALException {
		
		//Etape 1 : se connecter la BD

		//try with resources 
		try (Connection conn = ConnectionProvider.getConnection()){
		
			PreparedStatement stmt = conn.prepareStatement(DELETE);
			
			//Valoriser les parametres 
			
			stmt.setInt(1,noArticle);
			
			//Etape : executer la requete
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			
			
			throw new DALException ("erreur delete",e);
			
		}	
	
	}
		
	@Override
	public void update(Article article) throws DALException {
	
	
	//Etape 1 : se connecter la BD
		
	//try with resources 
		try (Connection conn = ConnectionProvider.getConnection()){
			
			PreparedStatement stmt = conn.prepareStatement(UPDATE);
			
					
		//Valoriser les parametres 
			
			stmt.setString(1, article.getNomArticle());
			stmt.setString(2, article.getDescription());
			stmt.setDate(3, article.getDateDebutEncheres());
			stmt.setDate(4, article.getDateFinEncheres());
			stmt.setInt(5, article.getMiseAPrix());
			stmt.setInt(6, article.getPrixVente());
			stmt.setInt(7, article.getNumero_utilisateur());
			stmt.setInt(8, article.getCategorie());
		
		
		//Etape : executer la requete
		
		stmt.executeUpdate();
		
		//ResultSet un tableau 

		} catch (SQLException e) {
			
			
			throw new DALException ("erreur update",e);
		}	
	}

	@Override
	public Article selectById(int noArticle) throws DALException {
		
		//Etape 1 : se connecter la BD
		
		//try with resources 
		try (Connection conn = ConnectionProvider.getConnection()){
		
			PreparedStatement stmt = conn.prepareStatement(SELECT_ID);
		
			stmt.setInt(1,noArticle);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				
			return new Article(rs.getInt("no_article"), rs.getString("nom_article"), rs.getString("description"), rs.getDate("date_debut_encheres"), rs.getDate("date_fin_encheres"), rs.getInt("prix_initial"), rs.getInt("no_categorie"));
			
			}else {
				throw new DALException ("Mauvaise Id ");
			}
			
		} catch (SQLException e) {
			
			throw new DALException ("erreur selectbyid",e);
		}	
	}
	
	public List<Utilisateur> selectAllArticle() throws DALException {
		
		try (Connection conn = ConnectionProvider.getConnection()) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_USER_CATALOGUE);
			
			while (rs.next()) {
				
			}
			
		} catch (SQLException e){
			throw new DALException("erreur selection Catalogue", e);
		}
		
	}
	
}

		

