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
	public Utilisateur afficherUtilisateurByPseudo(String pseudo) throws BLLException {
		try {
			return utilisateurDao.selectByPseudo(pseudo);
		} catch (DALException e) {
			throw new BLLException(e.getMessage(), e);
		}
	}
	
	
	
	/*
	@Override
	public List<Utilisateur> getAllUtilisateur() {
		
		return null;
	}
	*/
	

}
