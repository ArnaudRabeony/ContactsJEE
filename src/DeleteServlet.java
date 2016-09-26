



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServiceEntities.ContactService;

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
		String condition = request.getParameter("condition");
		
		Object value;
		boolean notEmptyOrNull = true;
		
		if(condition.equals("id"))
		{
			value = request.getParameter("value").isEmpty() ? 0 : new Integer(request.getParameter("value"));
			notEmptyOrNull = (Integer)value!=0;
		}
		else
		{
			value = request.getParameter("value");
			notEmptyOrNull = !((String)value).isEmpty();
		}
			
		boolean exists = false;
		
		if(notEmptyOrNull)
		{
			ContactService cs = new ContactService();
			if(condition.equals("id"))
				exists = cs.contactExists((int)value);

			//TODO : tester existence condition dynamique
			
			if(exists)
			{
				cs.deleteContact(condition, value);
				response.sendRedirect("index.jsp");
			}
			else
			{
				request.setAttribute("errorValue", value);
				request.setAttribute("errorMessage", "Contact à supprimer inexistant !");
				request.setAttribute("errorType", "noRecord");
				request.getRequestDispatcher("deleteContact.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("errorValue", value);
			request.setAttribute("errorMessage", "Veuillez remplir tous les champs ! ");
			request.setAttribute("errorType", "deleteEmptyField");
			request.getRequestDispatcher("deleteContact.jsp").forward(request, response);
		}
	}

}
