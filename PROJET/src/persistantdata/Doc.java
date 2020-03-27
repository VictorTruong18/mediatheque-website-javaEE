package persistantdata;

import mediatek2020.items.Document;
import mediatek2020.items.EmpruntException;
import mediatek2020.items.ReservationException;
import mediatek2020.items.RetourException;
import mediatek2020.items.Utilisateur;

public class Doc implements Document {

	private int id;
	private String titre;
	private String auteur;
	private boolean disponible;
	private String couverture;
	private String statut;
	private String pseudo;

	public Doc(int id, String titre, String auteur, boolean disponible, String couverture, String statut,
			String pseudo) {
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.disponible = disponible;
		this.couverture = couverture;
		this.statut = statut;
		this.pseudo = pseudo;
	}

	@Override
	public Object[] data() {
		Object[] obj = { id, titre, auteur, disponible, couverture, statut, pseudo };
		return obj;
	}

	@Override
	public void emprunter(Utilisateur user) throws EmpruntException {
		synchronized(this) {
			if (disponible && this.pseudo.equals("default")) {
				this.pseudo = user.name();
				MediathequeData.emprunter(this, user);
				this.disponible = false;
			} else {
				if (user.name().equals(this.pseudo)) {
					this.disponible = false;
					MediathequeData.emprunter(this, user);
				    
				}
				else
					throw new EmpruntException();
			}
		}
	}

	@Override
	public void rendre(Utilisateur user) throws RetourException {
		synchronized(this) {
			if (user.name().equals(this.pseudo) && !this.disponible) {
				this.pseudo = "default";
				this.disponible = true;
				MediathequeData.rendre(this, user);
			}
			else
				throw new RetourException();
		}
	}

	@Override
	public void reserver(Utilisateur user) throws ReservationException {
		synchronized(this) {
			if(disponible && pseudo.isEmpty())
				this.pseudo = user.name();
			else
				throw new ReservationException();
		}

	}

}
