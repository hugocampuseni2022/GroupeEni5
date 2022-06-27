package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.enchere.bo.Utilisateur;

public class UtilisateurDAOImpl implements UtilisateurDAO{

	private final String SQL_CONNECTION = "SELECT * FROM UTILISATEURS WHERE (pseudo=? OR email=?) AND mot_de_passe=?";
	
	private static ResultSet rs;
	private static PreparedStatement pStmt = null;
	private static final String INSERT = "insert into UTILISATEURS (noUtilisateur, credit, pseudo, nom, "
										+ "prenom, email, telephone, rue, codePostale, ville, motDePasse, administrateur) "
										+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	
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
			pStmt.setInt(1, utilisateur.getCredit()); // default = 100
			pStmt.setString(1, utilisateur.getPseudo());
			pStmt.setString(1, utilisateur.getNom());
			pStmt.setString(1, utilisateur.getPrenom());
			pStmt.setString(1, utilisateur.getNom());
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	
	
	
}
