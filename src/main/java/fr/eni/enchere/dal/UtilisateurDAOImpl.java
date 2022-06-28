package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.enchere.bo.Utilisateur;

public class UtilisateurDAOImpl implements UtilisateurDAO{

	private final String SQL_CONNECTION = "SELECT * FROM UTILISATEURS WHERE (pseudo=? OR email=?) AND mot_de_passe=?";
	
	private static ResultSet rs;
	private static PreparedStatement pStmt = null;
	private static final String INSERT = "insert into UTILISATEURS (pseudo, nom, prenom, "
										+ "email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) "
										+ "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?,100, 0)";
	
	private static final String DELETE = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ? ";
	private static final String UPDATE = "UPDATE UTILISATEURS SET pseudo = ? , nom = ? , prenom = ?, "
											+ "email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ?)";
											
	
	@Override
	public Utilisateur connection(String login, String mdp) throws DALException {
		try (Connection connection= ConnectionProvider.getConnection()){
			pStmt = connection.prepareStatement(SQL_CONNECTION);
			
			pStmt.setString(1, login);
			pStmt.setString(2, login);
			pStmt.setString(3, mdp);
			
			rs = pStmt.executeQuery();
			
			if (rs.next()) {
				return new Utilisateur(rs.getInt("no_utilisateur"),rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getBoolean("administrateur"));
			} else {
				throw new DALException("Login ou Mot de passe incorrecte");
			}
			
		} catch (Exception e) {
			throw new DALException("", e);
		}
	}


	@Override
	public void insert(Utilisateur utilisateur) throws DALException {
		try (Connection connection = ConnectionProvider.getConnection()){
			
			pStmt = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			
			pStmt.setString(1,utilisateur.getPseudo());
			pStmt.setString(2, utilisateur.getNom());
			pStmt.setString(3, utilisateur.getPrenom());
			pStmt.setString(4, utilisateur.getEmail());
			if (utilisateur.getTelephone().isBlank()) { // ***************************** //
				pStmt.setString(5, null);
			}else {
				pStmt.setString(5, utilisateur.getTelephone());
			}
			pStmt.setString(6, utilisateur.getCodePostale());
			pStmt.setString(7, utilisateur.getVille());
			pStmt.setString(8, utilisateur.getMotDePasse());
			
			
			
			pStmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new DALException("erreur sur l'insertion d'un utilisateur ",e);
		}
	}
			
	
	public void delete(int noUtilisateur) throws DALException {
		
	
		try (Connection connection= ConnectionProvider.getConnection()){
			
					pStmt = connection.prepareStatement(DELETE);
				pStmt.setInt(1,noUtilisateur);
				 
	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new DALException ("erreur sur la suppression d'un utilisateur");
		}
		
	}
	
	@Override
	public void updateById(Utilisateur utilisateur, int noUtilisateur) throws DALException {
		
		try (Connection connection= ConnectionProvider.getConnection()){
			
			pStmt = connection.prepareStatement(DELETE);
			
		pStmt.setInt(1,noUtilisateur);
		pStmt.setString(2,utilisateur.getPseudo());
		pStmt.setString(3,utilisateur.getNom());
		pStmt.setString(4,utilisateur.getPrenom());
		pStmt.setString(5,utilisateur.getEmail());
		pStmt.setString(6,utilisateur.getTelephone());
		pStmt.setString(7,utilisateur.getRue());
		pStmt.setString(8,utilisateur.getCodePostale());
		pStmt.setString(9,utilisateur.getVille());
		pStmt.setString(10,utilisateur.getMotDePasse());
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DALException ("erreur sur la suppression d'un utilisateur");
}


		
	}
	
}
