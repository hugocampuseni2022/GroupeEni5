package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.UtilisateurDAO;


public class UtilisateurImpl implements UtilisateurManager{

	private UtilisateurDAO utilisateurDao;

	public UtilisateurImpl() {
		utilisateurDao = DAOFactory.getDaoUtilisateur();
	}


	@Override
	public Utilisateur connectionUtilisateur(String login, String mdp) throws BLLException {
		
		try {
			return utilisateurDao.connection(login, mdp);
		} catch (DALException e) {
			throw new BLLException(e.getMessage(),e);
		}
	}
	
	@Override
	public void creerCompteUtilisateur (Utilisateur utilisateur) throws BLLException {
		
		try {
			utilisateurDao.insert(utilisateur);
		} catch (DALException e) {
			throw new BLLException(e.getMessage(),e);
		}
	}
	
	
	@Override
	public void supprimerUtilisateur(int noUtilisateur) throws BLLException {
		
		try {
			utilisateurDao.delete(noUtilisateur);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			throw new BLLException(e.getMessage(),e);
		}
		
	}


	@Override
	public void modifierUtilisateurById(Utilisateur utilisateur, int noUtilisateur) throws BLLException {
		try {
			utilisateurDao.updateById(utilisateur, noUtilisateur);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			throw new BLLException(e.getMessage(),e);
		}
		
	}

	@Override
	public void supprimerArticle(int noUtilisateur) throws BLLException {
		try {
			utilisateurDao.deleteArticle(noUtilisateur);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			throw new BLLException(e.getMessage(),e);
		}
		
	}
	


	@Override
	public Utilisateur afficherUtilisateurByPseudo(String pseudo) throws BLLException {
		try {
			return utilisateurDao.selectByPseudo(pseudo);
		} catch (DALException e) {
			throw new BLLException(e.getMessage(), e);
		}
	}
	
	
	public void validerUtilisateur (Utilisateur utilisateur) throws BLLException{
		
		StringBuilder res = new StringBuilder();
		res.append("Les champs suivant ne sont pas correctement renseignés :\n");
		boolean error = false;
	
		if(utilisateur.getPseudo().isBlank() || "".equals(utilisateur.getPseudo())){
			res.append(" -Le pseudo\n -");
			error= true;
		}
		
		if(utilisateur.getNom().isBlank() || "".equals(utilisateur.getNom())) {
			res.append(" -Le nom\n ");
			error = true;
		}
		
		if(utilisateur.getPrenom().isBlank()||"".equals(utilisateur.getPrenom())) {
			res.append(" -Le Prénom\n ");
			error = true;
		}
		
		if(utilisateur.getEmail().isBlank()||"".equals(utilisateur.getEmail())) {
			res.append(" -L'email\n ");
			error = true;
		}
		
		if(utilisateur.getTelephone().isBlank()||"".equals(utilisateur.getTelephone())) {
			res.append(" -Le numero de téléphone\n ");
			error = true;
		}
		
		if(utilisateur.getRue().isBlank()|| "".equals(utilisateur.getRue())) {
			res.append(" -La rue\n ");
			error = true;
		}
	
		if(utilisateur.getCodePostale().isBlank()||"".equals(utilisateur.getCodePostale())) {
			res.append(" -Le code postale\n ");
			error = true;
		}
		
		if (utilisateur.getVille().isBlank()||"".equals(utilisateur.getVille())) {
			res.append(" -La ville\n ");
			error = true;
		}
		
		if (utilisateur.getMotDePasse().isBlank()||"".equals(utilisateur.getMotDePasse())) {
			res.append(" -Le mot de passe ");
			error = true;
		}
		
		if (error) {
			throw new BLLException (res.toString());
		}
	
		
	}


	

}
