package services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mediatek2020.Mediatheque;
import mediatek2020.items.Document;

/**
 * Servlet implementation class ServicesAbonnes
 */
@WebServlet("/ServicesAbonnes")
public class ServicesAbonnes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServicesAbonnes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		Mediatheque m = Mediatheque.getInstance();
		switch(request.getParameter("choixAbonne")) {
		case "Reserver un document" :
			this.getServletContext().getRequestDispatcher("/ReserverDocument.jsp").forward(request, response);
			break;
		case "Emprunter un document" :
			List<Document> docDispo = new LinkedList<>();
			
			for(Document doc : m.tousLesDocuments()) {
				String pseudo = (String) doc.data()[6];
				boolean dispo = (boolean) doc.data()[3];
				if(!pseudo.isEmpty()) {
					if (dispo)
						docDispo.add(doc);
				}
			}
			
			request.setAttribute("docDispo", docDispo);
			this.getServletContext().getRequestDispatcher("/EmprunterDocument.jsp").forward(request, response);
			break;
		case "Rendre un document" :
			List<Document> docRendre = new LinkedList<>();
			for(Document doc : m.tousLesDocuments()) {
				String pseudo = (String) doc.data()[6];
				boolean dispo = (boolean) doc.data()[3];
				if(pseudo.equals(session.getAttribute("username") )) {
						docRendre.add(doc);
				}
			}
			request.setAttribute("docRendre", docRendre);
			this.getServletContext().getRequestDispatcher("/RendreDocument.jsp").forward(request, response);
			break;
		}
		
		
	}

}
