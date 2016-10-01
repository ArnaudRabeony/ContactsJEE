



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Contact;
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
		int idContact;
		
		nom = request.getParameter("nom");
		prenom = request.getParameter("prenom");
		idContact = request.getParameter("idContact").isEmpty() ? 0 : Integer.valueOf(request.getParameter("idContact"));
		email = request.getParameter("email");
		
		if(idContact!=0 && !nom.isEmpty() && !prenom.isEmpty() && !email.isEmpty())
		{
			ContactService cs = new ContactService();
		}
		
		if(idContact!=0 && nom!=null && prenom!=null && email!=null)
		{
			if(!nom.isEmpty() && !prenom.isEmpty() && !email.isEmpty())
			{
				ContactService cs = new ContactService();
				
				if(cs.contactExists(idContact))
				{
					Contact c = cs.getContactById(idContact);
					
					System.out.println(c.getNom()+" "+nom);
					System.out.println(c.getPrenom()+" "+prenom);
					boolean nameHasChanged = !c.getNom().equals(nom) || !c.getPrenom().equals(prenom) || (!c.getNom().equals(nom) && !c.getPrenom().equals(prenom));
					System.out.println(nameHasChanged);
					if((nameHasChanged && !cs.contactExists(nom, prenom)) || !nameHasChanged)
					{
						cs.updateContact(idContact, nom, prenom, email);
						response.sendRedirect("searchContact.jsp");
					}
					else
					{
						request.setAttribute("idResult", idContact);
						request.setAttribute("errorMessage", "Le contact existe déjà !");
						request.setAttribute("errorType", "contactAlreadyExists");
						request.getRequestDispatcher("searchContact.jsp").forward(request,response);
					}
					
				}
				else
				{
					request.setAttribute("idResult", idContact);
					request.setAttribute("errorMessage", "Le contact n'existe pas !");
					request.setAttribute("errorType", "contactDoesnotExists");
					request.getRequestDispatcher("searchContact.jsp").forward(request,response);
				}
			}
			else
			{
				request.setAttribute("idResult", idContact);
				request.setAttribute("nomResult", nom);
				request.setAttribute("prenomResult", prenom);
				request.setAttribute("emailResult", email);
				request.setAttribute("errorMessage", "Veuillez remplir tous les champs ! ");
				request.setAttribute("errorType", "updateEmptyField");
				request.getRequestDispatcher("searchContact.jsp").forward(request,response);
			}
		}
		else
		{
			request.setAttribute("idResult", idContact);
			request.setAttribute("nomResult", nom);
			request.setAttribute("prenomResult", prenom);
			request.setAttribute("emailResult", email);
			request.setAttribute("errorMessage", "Veuillez remplir tous les champs ! ");
			request.setAttribute("errorType", "updateEmptyField");
			request.getRequestDispatcher("searchContact.jsp").forward(request,response);
		}
	}

}
