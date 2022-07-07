package fr.eni.enchere.dal;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;
	import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateur;
	
public class ArticleDAOImpl implements ArticleDAO{

	private static final String INSERT = "insert Into ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente ,no_utilisateur ,no_categorie )"
											+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
	
	private static final String SELECT_ALL = "Select * from ARTICLES_VENDUS";
	
	private static final String DELETE = "Delete FROM ARTICLES_VENDUS Where no_article = ?";
	
	private static final String SELECT_ID = "SELECT * From ARTICLES_VENDUS Where no_article = ?";
	
	private static final String UPDATE = "UPDATE ARTICLES_VENDUS SET nom_article = ? ,description = ? ,date_debut_encheres = ? ,date_fin_encheres = ?,prix_initial = ?, no_categorie = ? WHERE no_article = ?";
	
	private static final String SELECT_USER_CATALOGUE = "SELECT * FROM UTILISATEURS";
	
	private static final String SELECT_BY_USER = "SELECT * From ARTICLES_VENDUS Where no_utilisateur = ?";
	
	private static final String SELECT_ENCHERE_BY_ARTICLE = "SELECT * FROM ENCHERES WHERE no_article = ?";
	
	private static final String SELECT_ENCHERE_BY_USER = "SELECT * FROM ENCHERES WHERE no_utilisateur = ?";
	
	private static final String SELECT_RETRAIT_BY_ARTICLE = "SELECT * FROM RETRAITS WHERE no_article = ?";
	
	private static final String SELECT_CATEGORIE = "SELECT * FROM CATEGORIES";
	
	private static final String INSERT_ENCHERE = "insert into ENCHERES (date_enchere, montant_enchere, no_article, no_utilisateur) values (?, ?, ?, ?)";
	
	private static final String INSERT_RETRAIT = "INSERT INTO RETRAITS (no_article, rue, code_postal, ville) VALUES (?, ?, ?, ? )";
	
	private static final String UPDATE_RETRAIT = "UPDATE RETRAITS SET rue = ?, code_postal = ?, ville = ? WHERE no_article = ?";
	
	private static final String UPDATE_PRIX_DE_VENTE = "UPDATE ARTICLES_VENDUS SET prix_vente = ? WHERE no_article = ?";
	
	private static final String UPDATE_CREDIT = "UPDATE UTILISATEURS SET credit = ? WHERE no_utilisateur = ?";
	
	private static ResultSet rs;
	private static PreparedStatement pStmt = null;									
	private static Statement stmt;
	
	@Override
	public void insert (Article article, int idUser) throws DALException {
		
	//Etape 1 : se connecter la BD
		
	//try with resources 
		try (Connection conn = ConnectionProvider.getConnection()){
			
			pStmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
			
					
			//Valoriser les parametres 
						
			pStmt.setString(1, article.getNomArticle());
			pStmt.setString(2, article.getDescription());
			pStmt.setDate(3, article.getDateDebutEncheres());
			pStmt.setDate(4, article.getDateFinEncheres());
			pStmt.setInt(5, article.getMiseAPrix());
			pStmt.setInt(6, article.getPrixVente());
			pStmt.setInt(7, idUser);
			pStmt.setInt(8, article.getNoCategorie());
		
		
			//Etape : executer la requete
			
			pStmt.executeUpdate();
			
			
			rs = pStmt.getGeneratedKeys();
			if(rs.next()) {
				pStmt = conn.prepareStatement(INSERT_RETRAIT);
				
				pStmt.setInt(1, rs.getInt(1));
				pStmt.setString(2,article.getLieuRetrait().getRue());
				pStmt.setString(3,article.getLieuRetrait().getCode_postal());
				pStmt.setString(4,article.getLieuRetrait().getVille());
			
				pStmt.executeUpdate();	
				
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
				listeArticle.add(new Article(rs.getInt("no_article"), rs.getString("nom_article"), rs.getString("description"), rs.getDate("date_debut_encheres"), rs.getDate("date_fin_encheres"), rs.getInt("prix_initial"), rs.getInt("prix_vente") ,rs.getInt("no_categorie")));
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
			stmt.setInt(6, article.getNoCategorie());
			stmt.setInt(7, article.getNoArticle());
		
		
		//Etape : executer la requete
		
			stmt.executeUpdate();
		
			stmt = conn.prepareStatement(UPDATE_RETRAIT);
			
			stmt.setString(1, article.getLieuRetrait().getRue());
			stmt.setString(2, article.getLieuRetrait().getCode_postal());
			stmt.setString(3, article.getLieuRetrait().getVille());
			stmt.setInt(4, article.getNoArticle());

			stmt.executeUpdate();
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
				
			return new Article(rs.getInt("no_article"), rs.getString("nom_article"), rs.getString("description"), rs.getDate("date_debut_encheres"), rs.getDate("date_fin_encheres"), rs.getInt("prix_initial"), rs.getInt("prix_vente"), rs.getInt("no_categorie"));
			
			}else {
				throw new DALException ("Mauvaise Id ");
			}
			
		} catch (SQLException e) {
			
			throw new DALException ("erreur selectbyid",e);
		}	
	}
	
	public List<Utilisateur> selectAllArticle() throws DALException {
		
		try (Connection conn = ConnectionProvider.getConnection()) {
			List<Utilisateur> listeUser = new ArrayList<Utilisateur>();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_USER_CATALOGUE);
			
			while (rs.next()) {
				Utilisateur newUser = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"),rs.getString("mot_de_passe") ,rs.getInt("credit"), rs.getBoolean("administrateur"));
				newUser.setListeArticle(selectByNoUtilisateur(rs.getInt("no_utilisateur")));
				newUser.setListeEnchere(selectEnchereByUser(rs.getInt("no_utilisateur")));
				listeUser.add(newUser);
			}
			return listeUser;
		} catch (SQLException e){
			throw new DALException("erreur selection Catalogue", e);
		}
		
	}
	
	public List<Article> selectByNoUtilisateur(int idUser) throws DALException {
		
		try (Connection conn = ConnectionProvider.getConnection()) {
			List<Article> articleUser = new ArrayList<Article>();
			PreparedStatement pStmt = conn.prepareStatement(SELECT_BY_USER);
			
			pStmt.setInt(1, idUser);
			
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				Article newArticle = new Article(rs.getInt("no_article"),rs.getString("nom_article") , rs.getString("description"), rs.getDate("date_debut_encheres"), rs.getDate("date_fin_encheres"), rs.getInt("prix_initial"), rs.getInt("prix_vente"), rs.getInt("no_categorie"));
				newArticle.setListeEnchere(selectEnchereByArticle(rs.getInt("no_article")));
				newArticle.setLieuRetrait(selectRetraitByArticle(rs.getInt("no_article")));
				articleUser.add(newArticle);
			}
			return articleUser;
		} catch (SQLException e){
			throw new DALException("erreur selection Catalogue", e);
		}
		
	}
	
	public List<Enchere> selectEnchereByArticle(int idArticle) throws DALException {
		try (Connection conn = ConnectionProvider.getConnection()) {
			List<Enchere> enchereArticle = new ArrayList<Enchere>();
			PreparedStatement pStmt = conn.prepareStatement(SELECT_ENCHERE_BY_ARTICLE);
			
			pStmt.setInt(1, idArticle);
			
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				enchereArticle.add(new Enchere(rs.getTimestamp("date_enchere"), rs.getInt("montant_enchere"), rs.getInt("no_enchere")));
			}
			return enchereArticle;
		} catch (SQLException e){
			throw new DALException("erreur selection Catalogue", e);
		}
	}
	
	public Retrait selectRetraitByArticle(int idArticle) throws DALException {
		try (Connection conn = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = conn.prepareStatement(SELECT_RETRAIT_BY_ARTICLE);
			
			pStmt.setInt(1, idArticle);
			
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return new Retrait(rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"));
			} else {
				return null;
			}
			
		} catch (SQLException e){
			throw new DALException("erreur selection Catalogue", e);
		}
	}
	
	public List<Enchere> selectEnchereByUser(int idUser) throws DALException {
		try (Connection conn = ConnectionProvider.getConnection()) {
			List<Enchere> enchereUser = new ArrayList<Enchere>();
			PreparedStatement pStmt = conn.prepareStatement(SELECT_ENCHERE_BY_USER);
			
			pStmt.setInt(1, idUser);
			
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				enchereUser.add(new Enchere(rs.getTimestamp("date_enchere"), rs.getInt("montant_enchere"), rs.getInt("no_enchere") ));
			}
			return enchereUser;
		} catch (SQLException e){
			throw new DALException("erreur selection Catalogue", e);
		}
	}
	
	public List<Categorie> selectCategorie() throws DALException {
		try (Connection conn = ConnectionProvider.getConnection()) {
			List<Categorie> listeCategorie = new ArrayList<Categorie>();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_CATEGORIE);
			while (rs.next()) {
				listeCategorie.add(new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"))) ;
			}
			return listeCategorie;
		} catch (SQLException e) {
			throw new DALException("Erreur select categorie", e);
		}
		
	}

	public void encherir(int idArticle, int idUser, Enchere enchere,int credit) throws DALException {
		try (Connection conn = ConnectionProvider.getConnection()){
			pStmt = conn.prepareStatement(INSERT_ENCHERE);
			
			pStmt.setTimestamp(1, enchere.getDateEnchere());
			pStmt.setInt(2, enchere.getMontant_Enchere());
			pStmt.setInt(3, idArticle);
			pStmt.setInt(4, idUser);
			
			pStmt.executeUpdate();
			
			modifPrixDeVente(enchere.getMontant_Enchere(),idArticle);
			updateCredit(idUser,credit-enchere.getMontant_Enchere());
		} catch (SQLException e) {
			throw new DALException ("erreur insert enchère", e);
		}
	}
	
	public void modifPrixDeVente (int prixVente, int numeroArticle) throws DALException {
		
		try (Connection conn = ConnectionProvider.getConnection()){
			pStmt = conn.prepareStatement(UPDATE_PRIX_DE_VENTE);
			
			pStmt.setInt(1, prixVente);
			pStmt.setInt(2, numeroArticle);
			
		
			pStmt.executeUpdate();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DALException("erreur modifPrixDeVente");
			}
		
	}
	
	public List<Article> filterClassique(String query) throws DALException {
		try (Connection conn = ConnectionProvider.getConnection()){
			List<Article> listeArticle = new ArrayList<Article>();	
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Article newArticle = new Article(rs.getInt("no_article"),rs.getString("nom_article") , rs.getString("description"), rs.getDate("date_debut_encheres"), rs.getDate("date_fin_encheres"), rs.getInt("prix_initial"), rs.getInt("prix_vente"), rs.getInt("no_categorie"));
				newArticle.setListeEnchere(selectEnchereByArticle(rs.getInt("no_article")));
				newArticle.setLieuRetrait(selectRetraitByArticle(rs.getInt("no_article")));
				listeArticle.add(newArticle);
			}
			return listeArticle;
		} catch (SQLException e) {
			throw new DALException("erreur filtre", e);
		}
	}
	
	@Override
	public void updateCredit(int noUtilisateur,int credit) throws DALException {
		
		try (Connection conn = ConnectionProvider.getConnection();){
			pStmt = conn.prepareStatement(UPDATE_CREDIT);
			
			pStmt.setInt(1,(credit));
			pStmt.setInt(2,noUtilisateur);
			
			pStmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DALException ("erreur updateCredit", e);

		}
		
	}

	
}

		

