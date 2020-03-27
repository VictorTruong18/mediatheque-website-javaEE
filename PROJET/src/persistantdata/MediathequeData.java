package persistantdata;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mediatek2020.*;
import mediatek2020.items.*;

// classe mono-instance  dont l'unique instance est inject�e dans Mediatheque
// via une auto-d�claration dans son bloc static

public class MediathequeData implements PersistentMediatheque {
	private static final int TYPE_DVD = 1;
	private static final int TYPE_LIVRE = 2;

	// Jean-Fran�ois Brette 01/01/2018
	static {
		Mediatheque.getInstance().setData(new MediathequeData());
	}

	private MediathequeData() {
	}

	private static Connection connection() {
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/jee", "root", "");
			return co;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	// renvoie la liste de tous les documents de la biblioth�que
	@Override
	public List<Document> tousLesDocuments() {
		try {
			Connection co = connection();
			String reqUser = "Select * from document";
			PreparedStatement state = co.prepareStatement(reqUser);
			ResultSet user = state.executeQuery();
			int id;
			String titre;
			String auteur;
			boolean disponible;
			String couverture;
			String statut;
			String pseudo;
			List<Document> documents = new ArrayList<>();
			while (user.next()) {
				id = user.getInt(1);
				titre = user.getString(2);
				auteur = user.getString(3);
				disponible = (user.getInt("Disponible") == 0 ? true : false);
				couverture = user.getString(5);
				statut = user.getString(6);
				pseudo = user.getString(7);

				documents.add(new Doc(id, titre, auteur, disponible, couverture, statut, pseudo));
			}
			state.close();
			user.close();
			co.close();
			return documents;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// va r�cup�rer le User dans la BD et le renvoie
	// si pas trouv�, renvoie null
	@Override
	public Utilisateur getUser(String login, String password) {
		try {
			Connection co = connection();
			String reqUser = "Select * from utilisateur where pseudo = ? and motdepasse = ?";
			
			PreparedStatement state = co.prepareStatement(reqUser);
			state.setString(1, login);
			state.setString(2, password);
			ResultSet user = state.executeQuery();
			

//			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
//			messageDigest.update(password.getBytes());
//			String encryptedPass = new String(messageDigest.digest());

			
			String log = "";
			String pass = "";
			String statut = "";
			while (user.next()) {
				log = user.getString("pseudo");// ou �res.getString(2)
				pass = user.getString("motdepasse");
				statut = user.getString("statut");
			}
			if (statut.equals("default"))
				statut = "";
			co.close();
			if (log.isEmpty() || pass.isEmpty() || statut.isEmpty())
				return null;
			return new Usager(log, pass, statut);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	// va r�cup�rer le document de num�ro numDocument dans la BD
	// et le renvoie
	// si pas trouv�, renvoie null
	@Override
	public Document getDocument(int numDocument) {
		try {
			Connection co = connection();
			String reqUser = "Select * from document where id = ?";
			PreparedStatement state = co.prepareStatement(reqUser);
			state.setInt(1, numDocument);
			ResultSet user = state.executeQuery();
			
			int id = -1;
			String titre = "";
			String auteur = "";
			boolean disponible = false;
			String couverture = "";
			String statut = "";
			String pseudo = "";
			while (user.next()) {
				id = user.getInt(1);
				titre = user.getString(2);
				auteur = user.getString(3);
				disponible = (user.getInt(4) == 0 ? true : false);
				couverture = user.getString(5);
				statut = user.getString(6);
				pseudo = user.getString(7);

			}
			state.close();
			user.close();
			co.close();
			return new Doc(id, titre, auteur, disponible, couverture, statut, pseudo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void nouveauDocument(int type, Object... args) {
		Connection co = connection();
		String titre = "";
		String auteur = "";
		String couverture = "";
		String reqUser = "";
		PreparedStatement state;
		switch (type) {
		case TYPE_DVD:
			titre = (String) args[0];
			auteur = (String) args[1];
			couverture = (String) args[2];
			reqUser = "Insert into document(Titre,Auteur,Disponible,Couverture,statut,pseudo) values (?, ?,0,?,'DVD','default')";
			try {
				state = co.prepareStatement(reqUser);
				state.setString(1, titre);
				state.setString(2, auteur);
				state.setString(3, couverture);
				state.executeUpdate();
				
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case TYPE_LIVRE:
			titre = (String) args[0];
			auteur = (String) args[1];
			couverture = (String) args[2];
			reqUser = "Insert into document(Id,Titre,Auteur,Disponible,Couverture,statut,pseudo) values (SEQ_DOCUMENT.nextVal,?, ?,0,?,'Livre','default')";
			try {
				state = co.prepareStatement(reqUser);
				state.setString(1, titre);
				state.setString(2, auteur);
				state.setString(3, couverture);
				state.executeQuery();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		}
		try {
			co.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void emprunter(Document d, Utilisateur u) {
		Connection co = connection();
		String req = "Update Document SET Pseudo = ?, Disponible = 1 Where Id = ? ";
		PreparedStatement state;
		try {
			
			state = co.prepareStatement(req);
			state.setString(1, u.name());
			state.setInt(2,(int) d.data()[0]);
			state.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void rendre(Document d, Utilisateur u) {
		Connection co = connection();
		String req = "Update Document SET Pseudo = 'default', Disponible = 0 Where Id = ? ";
		PreparedStatement state;
		try {
			state = co.prepareStatement(req);
			state.setInt(1,(int) d.data()[0]);
			state.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}
