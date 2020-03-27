package persistantdata;

import mediatek2020.items.Utilisateur;

public class Usager implements Utilisateur {
	private String pseudo;
	private String motDePasse;
	private String statut;
	
	public Usager(String pseudo, String mdp, String statut) {
		this.pseudo = pseudo;
		this.motDePasse = mdp;
		this.statut = statut;
	}
		
	@Override
	public Object[] data() {
		Object[] obj = {pseudo, motDePasse, statut};
		return obj;
	}

	@Override
	public boolean isBibliothecaire() {
		return statut.equals("bibliothecaire");
	}

	@Override
	public String name() {
		return this.pseudo;
	}

}
