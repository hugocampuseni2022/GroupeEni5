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
	private static final String INSERT = "insert into UTILISATEURS (credit, pseudo, nom, prenom, "
										+ "email, telephone, rue, codePostale, ville, motDePasse, administrateur) "
										+ "values (100, ?, ?, ?, ?, ?, ?, ?, ?, ?, membre)";
	
	
	@Override
	public Utilisateur connection(String login, String mdp) throws DALException {
		try (Connection connection= ConnectionProvider.getConnection()){
			pStmt = connection.prepareStatement(SQL_CONNECTION);
			
			pStmt.setString(1, login);
			pStmt.setString(2, login);
			pStmt.setString(3, mdp);
			
			rs = pStmt.executeQuery();
			
			if (rs.next()) {
				return new Utilisateur(rs.getInt("no_utilisateur"), rs.getInt("credit"), rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"), rs.getBoolean("administrateur"));
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
			
			PreparedStatement pStmt = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			
			pStmt.setInt(1, utilisateur.getNoUtilisateur());
			
			pStmt.setInt(2, utilisateur.getCredit());
			
			pStmt.setString(3, utilisateur.getPseudo());
			pStmt.setString(4, utilisateur.getNom());
			pStmt.setString(5, utilisateur.getPrenom());
			pStmt.setString(6, utilisateur.getEmail());
			if (utilisateur.getTelephone().isBlank()) { // ***************************** //
				pStmt.setString(7, null);
			}else {
				pStmt.setString(7, utilisateur.getTelephone());
			}
			pStmt.setString(8, utilisateur.getRue());
			pStmt.setString(9, utilisateur.getCodePostale());
			pStmt.setString(10, utilisateur.getVille());
			pStmt.setString(11, utilisateur.getMotDePasse());
			
			pStmt.setBoolean(12, utilisateur.isAdministrateur());
			
			pStmt.executeUpdate();
			
			ResultSet rs = pStmt.getGeneratedKeys();
			if(rs.next()){
				utilisateur.setNoUtilisateur(rs.getInt(1));
			}
			
			
		} catch (SQLException e) {
			throw new DALException("erreur sur l'insertion d'un utilisateur ",e);
		}
		
	}
	
	
	
	
	
}
