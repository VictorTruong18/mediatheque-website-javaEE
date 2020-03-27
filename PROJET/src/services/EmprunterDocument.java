package services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mediatek2020.Mediatheque;
import mediatek2020.items.EmpruntException;
import mediatek2020.items.Utilisateur;
import persistantdata.MediathequeData;

/**
 * Servlet implementation class EmprunterDocument
 */
@WebServlet("/EmprunterDocument")
public class EmprunterDocument extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmprunterDocument() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		Mediatheque m = Mediatheque.getInstance();
	
		try {
			m.emprunter(m.getDocument(Integer.parseInt(request.getParameter("iddoc"))), (Utilisateur)session.getAttribute("userConnecte"));
			session.invalidate();
		} catch (NumberFormatException | EmpruntException e) {
			// TODO Auto-generated catch block
			session.invalidate();
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
	}

}
