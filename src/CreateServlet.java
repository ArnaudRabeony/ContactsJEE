


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServiceEntities.ContactService;

/**
 * Servlet implementation class CreateServlet
 */
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
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
		
		nom = request.getParameter("nom");
		prenom = request.getParameter("prenom");
		email = request.getParameter("email");
		
		if(nom!=null && prenom!=null && email!=null)
		{
			if(!nom.isEmpty() && !prenom.isEmpty() && !email.isEmpty())
			{
				ContactService cs = new ContactService();
				
				if(!cs.contactExists(nom, prenom))
					cs.createContact(nom, prenom, email);
				else
				{
					request.setAttribute("errorNom", nom);
					request.setAttribute("errorPrenom", prenom);
					request.setAttribute("errorMessage", "Le contact existe déjà !");
					request.setAttribute("errorType", "contactExists");
					request.getRequestDispatcher("createContact.jsp").forward(request,response);
				}
			}
			else
			{
				request.setAttribute("errorNom", nom);
				request.setAttribute("errorPrenom", prenom);
				request.setAttribute("errorEmail", email);
				request.setAttribute("errorMessage", "Veuillez remplir tous les champs ! ");
				request.setAttribute("errorType", "emptyField");
				request.getRequestDispatcher("createContact.jsp").forward(request,response);
			}
			response.sendRedirect("index.jsp");
		}
		else
		{
			request.setAttribute("errorNom", nom);
			request.setAttribute("errorPrenom", prenom);
			request.setAttribute("errorEmail", email);
			request.setAttribute("errorMessage", "Veuillez remplir tous les champs ! ");
			request.setAttribute("errorType", "emptyField");
			request.getRequestDispatcher("createContact.jsp").forward(request,response);
		}
	}

}
