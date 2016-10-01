



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServiceEntities.AdresseService;
import ServiceEntities.ContactService;
import ServiceEntities.TelephoneService;

/**
 * Servlet implementation class DeleteContact
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idContact = request.getParameter("selectedId").isEmpty() ? -1 : Integer.valueOf(request.getParameter("selectedId"));
		
		if(idContact != -1)
		{
			ContactService cs = new ContactService();
			boolean exists = cs.contactExists(idContact);

			//TODO : tester existence condition dynamique
			
			if(exists)
			{
				if(cs.deleteContact(idContact))
				{
					AdresseService as = new AdresseService();
					as.deleteAdressesByContactId(idContact);
					
					TelephoneService ts = new TelephoneService();
					ts.deleteTelephoneByContactId(idContact);
				}
					
				response.sendRedirect("index.jsp");
			}
			else
			{
				request.setAttribute("errorMessage", "Contact à supprimer inexistant !");
				request.setAttribute("errorType", "noRecord");
				request.getRequestDispatcher("deleteContact.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("errorMessage", "Veuillez remplir tous les champs ! ");
			request.setAttribute("errorType", "deleteEmptyField");
			request.getRequestDispatcher("deleteContact.jsp").forward(request, response);
		}
	}

}
