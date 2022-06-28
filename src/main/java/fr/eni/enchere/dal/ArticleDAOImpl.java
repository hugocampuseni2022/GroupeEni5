package fr.eni.enchere.dal;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;
	import fr.eni.enchere.bo.Article;
	
public class ArticleDAOImpl implements ArticleDAO{

	
		
		private static final String INSERT = "insert Into Article (nom_article, description, date_debut_encheres, date_fin_encheres, prix _initial, no_utilisateur, no_categorie )"
												+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		//private static final String SELECT_ALL = "Select id, nom, description, image, prix from Pizza";
		
		//private static final String DELETE = "Delete FROM Pizza Where identifiant = ?";
		
		//private static final String SELECT_ID = "SELECT id, nom, description, image , prix From PIZZA Where identifiant = ?";
		
		//private static final String UPDATE = "UPDATE PIZZA SET nom = ? ,description = ? ,image = ? ,prix = ?";
		
													
		
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
			stmt.setString(7, utilisateur.());
			stmt.setString(8, article.getDescription());
			
			
			//Etape : executer la requete
			
			stmt.executeUpdate();
			
			//ResultSet un tableau 
			
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				pizza.setId(rs.getInt(1));
			}
				
			} catch (SQLException e) {
				
				
				throw new DALException ("erreur insert",e);
				
			}	
		
		}
		/*
		@Override

		public List<Pizza> selectAll() throws DALException {
			
			//Etape 1 : se connecter la BD
			
			//try with resources 
				try (Connection conn = ConnectionProvider.getConnection()){
					
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(SELECT_ALL);

					List<Pizza> listePizza = new ArrayList<Pizza>();

					while (rs.next()) {
					listePizza.add(new Pizza(rs.getInt("id"), rs.getString("nom"), rs.getString("description"), rs.getString("image"), rs.getFloat("prix")));
					}
					return listePizza;
						
					} catch (SQLException e) {
						
						
						throw new DALException ("erreur Select All",e);
						
					}	
				
				}

		@Override
		public void delete(Integer id ) throws DALException {
			
			//Etape 1 : se connecter la BD
			
					//try with resources 
						try (Connection conn = ConnectionProvider.getConnection()){
							
							PreparedStatement stmt = conn.prepareStatement(DELETE);
							
							//Valoriser les parametres 
							
							stmt.setInt(1,id);
							
							//Etape : executer la requete
							
							stmt.executeUpdate();
							
								
							} catch (SQLException e) {
								
								
								throw new DALException ("erreur delete",e);
								
							}	
						
						}
			
		@Override
		public void update(Pizza pizza) throws DALException {
			
			
			//Etape 1 : se connecter la BD
				
			//try with resources 
				try (Connection conn = ConnectionProvider.getConnection()){
					
					PreparedStatement stmt = conn.prepareStatement(UPDATE);
					
							
				//Valoriser les parametres 
					
				stmt.setInt(1, pizza.getId());			
				stmt.setString(2, pizza.getNom());
				stmt.setString(3, pizza.getDescription());
				stmt.setString(4, pizza.getImageUrl());
				stmt.setFloat(5, pizza.getPrix());
			
				
				
				//Etape : executer la requete
				
				stmt.executeUpdate();
				
				//ResultSet un tableau 

				} catch (SQLException e) {
					
					
					throw new DALException ("erreur update",e);
				}	
			}

		@Override
		public Pizza selectById(Integer id) throws DALException {
			
			//Etape 1 : se connecter la BD
			
					//try with resources 
						try (Connection conn = ConnectionProvider.getConnection()){
							
							PreparedStatement stmt = conn.prepareStatement(SELECT_ID);
						
							stmt.setInt(1,id);
							
							ResultSet rs = stmt.executeQuery();
							
							if(rs.next()) {
								
							return new Pizza (rs.getInt("id"),rs.getString("nom"),rs.getString("description"),rs.getString("image"),rs.getFloat("prix"));	
							
							}else {
								throw new DALException ("Mauvaise Id ");
							}
								
							} catch (SQLException e) {
								
								throw new DALException ("erreur selectbyid",e);
							}	
			                                            
			
						}*/

		
		}

