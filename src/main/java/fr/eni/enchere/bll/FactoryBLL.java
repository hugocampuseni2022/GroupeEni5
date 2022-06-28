package fr.eni.enchere.bll;

public class FactoryBLL {
	
	public static UtilisateurManager getManagerUtilisateur() {
		return new UtilisateurImpl();
	}

}
