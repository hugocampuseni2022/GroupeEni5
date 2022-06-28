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
	public void CreerCompteUtilisateur (Utilisateur utilisateur) throws BLLException {
		
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
	public void modifierUtilisateurByid(Utilisateur utilsateur, int noUtilisateur) throws BLLException {
		try {
			utilisateurDao.updateById(utilsateur, noUtilisateur);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			throw new BLLException(e.getMessage(),e);
		}
		
	}
	
	
	
	
	/*
	@Override
	public List<Utilisateur> getAllUtilisateur() {
		
		return null;
	}
	
	@Override
	public void enregistrerUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public Utilisateur getUtilisateurByNo(int noUtilisateur) {
		// TODO Auto-generated method stub
		return null;
	}*/
	

}
