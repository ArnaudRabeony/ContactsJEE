import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Contact;
import ServiceEntities.ContactService;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int contactId = request.getParameter("selectedId")!= null ? Integer.valueOf(request.getParameter("selectedId")) : -1;
		System.out.println(contactId);
			
		if(contactId != -1)
		{
			ContactService cs = new ContactService();
			Contact c = cs.searchContact(contactId);
			

			if(c != null)
			{
				System.out.println(c.getNom());
				request.setAttribute("idResult", c.getId());
				request.setAttribute("nomResult", c.getNom());
				request.setAttribute("prenomResult", c.getPrenom());
				request.setAttribute("emailResult", c.getEmail());
				request.getRequestDispatcher("searchContact.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("errorId",contactId);
				request.setAttribute("errorMessage", "Aucun résultat n'a été trouvé !");
				request.setAttribute("errorType", "noRecord");
				request.getRequestDispatcher("searchContact.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("errorId",contactId);
			request.setAttribute("errorMessage", "Veuillez remplir tous les champs ! ");
			request.setAttribute("errorType", "searchEmptyField");
			request.getRequestDispatcher("searchContact.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
