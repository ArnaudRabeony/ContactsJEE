



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServiceEntities.ContactService;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		String nom,prenom,email;
		int id;
		
		nom = request.getParameter("nom");
		prenom = request.getParameter("prenom");
		id = request.getParameter("id").isEmpty() ? 0 : Integer.valueOf(request.getParameter("id"));
		email = request.getParameter("email");
		
		if(id!=0 && !nom.isEmpty() && !prenom.isEmpty() && !email.isEmpty())
		{
			ContactService cs = new ContactService();
		}
		
		if(id!=0 && nom!=null && prenom!=null && email!=null)
		{
			if(!nom.isEmpty() && !prenom.isEmpty() && !email.isEmpty())
			{
				ContactService cs = new ContactService();
				
				if(cs.contactExists(id))
				{
					if(!cs.contactExists(nom, prenom))
					{
						cs.updateContact(id, nom, prenom, email);
						response.sendRedirect("index.jsp");
					}
					else
					{
						request.setAttribute("errorId", id);
						request.setAttribute("errorMessage", "Le contact existe déjà !");
						request.setAttribute("errorType", "contactAlreadyExists");
						request.getRequestDispatcher("updateContact.jsp").forward(request,response);
					}
					
				}
				else
				{
					request.setAttribute("errorId", id);
					request.setAttribute("errorMessage", "Le contact n'existe pas !");
					request.setAttribute("errorType", "contactDoesnotExists");
					request.getRequestDispatcher("updateContact.jsp").forward(request,response);
				}
			}
			else
			{
				request.setAttribute("errorId", id);
				request.setAttribute("errorNom", nom);
				request.setAttribute("errorPrenom", prenom);
				request.setAttribute("errorEmail", email);
				request.setAttribute("errorMessage", "Veuillez remplir tous les champs ! ");
				request.setAttribute("errorType", "updateEmptyField");
				request.getRequestDispatcher("updateContact.jsp").forward(request,response);
			}
		}
		else
		{
			request.setAttribute("errorIdm", id);
			request.setAttribute("errorNom", nom);
			request.setAttribute("errorPrenom", prenom);
			request.setAttribute("errorEmail", email);
			request.setAttribute("errorMessage", "Veuillez remplir tous les champs ! ");
			request.setAttribute("errorType", "updateEmptyField");
			request.getRequestDispatcher("updateContact.jsp").forward(request,response);
		}
	}

}
