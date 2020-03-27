package services;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mediatek2020.Mediatheque;
import mediatek2020.PersistentMediatheque;
import mediatek2020.items.Utilisateur;
import persistantdata.MediathequeData;
import persistantdata.Usager;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String identifiant = request.getParameter("identifiant");
		String motDePasse = request.getParameter("motDePasse");
		
		try {
			Class.forName(MediathequeData.class.getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Mediatheque m = Mediatheque.getInstance();
		
		Utilisateur u = m.getUser(identifiant, motDePasse);
		boolean isBiblio;
		if(u == null) {
			this.getServletContext().getRequestDispatcher("/LoginInvalide.jsp").forward(request, response);
		}else {
			HttpSession session = request.getSession(true);
			session.setAttribute("userConnecte", u);
			isBiblio = u.isBibliothecaire();
			session.setAttribute("username", identifiant);
			
			if(isBiblio) {
				
				this.getServletContext().getRequestDispatcher("/ClientBibliothecaire.jsp").forward(request, response);
			}
			else {

				this.getServletContext().getRequestDispatcher("/ClientAbonne.jsp").forward(request, response);
				
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
