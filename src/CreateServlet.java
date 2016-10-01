


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Contact;
import ServiceEntities.AdresseService;
import ServiceEntities.ContactService;
import ServiceEntities.TelephoneService;

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
		Contact newContact = null;
		
		nom = request.getParameter("nom");
		prenom = request.getParameter("prenom");
		email = request.getParameter("email");
		
		
		if(nom!=null && prenom!=null && email!=null)
		{
			if(!nom.isEmpty() && !prenom.isEmpty() && !email.isEmpty())
			{
				ContactService cs = new ContactService();
				
				if(!cs.contactExists(nom, prenom))
				{
					newContact=cs.createContact(nom, prenom, email);
					newContact.setId(cs.getIdByContact(newContact));
				}
				else
				{
					request.setAttribute("errorNom", nom);
					request.setAttribute("errorPrenom", prenom);
					request.setAttribute("errorMessage", "Le contact existe déjà ! ");
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
				request.setAttribute("errorType", "createEmptyField");
				request.getRequestDispatcher("createContact.jsp").forward(request,response);
			}

				String numero, rue, ville, codePostal,pays;
				numero = request.getParameter("numeroAdresse")!=null ? request.getParameter("numeroAdresse") : "";
				rue = request.getParameter("rue")!=null ? request.getParameter("rue") : "";
				ville = request.getParameter("ville")!=null ? request.getParameter("ville") : "";
				codePostal = request.getParameter("codep")!=null ? request.getParameter("codep") : "";
				pays = request.getParameter("pays")!=null ? request.getParameter("pays") : "";
				
				if(newContact!=null && !numero.isEmpty() &&!rue.isEmpty() &&!ville.isEmpty() &&!codePostal.isEmpty() &&!pays.isEmpty())
				{
					rue=numero+" "+rue;
					AdresseService as = new AdresseService();
					as.createAdresse(rue, ville, codePostal, pays,newContact.getId());
				}
				else
				{
					request.setAttribute("errorNom", nom);
					request.setAttribute("errorPrenom", prenom);
					request.setAttribute("errorMessage", "Veuillez remplir les champs d'adresse ! ");
					request.setAttribute("errorType", "fillAddressForm");
					request.getRequestDispatcher("createContact.jsp").forward(request,response);
				}
				
				String numeroTel, type;
				numeroTel = request.getParameter("numeroTel")!=null ? request.getParameter("numeroTel") : "";
				type = request.getParameter("type")!=null ? request.getParameter("type") : "";
				
				if(newContact!=null && !numeroTel.isEmpty() &&!type.isEmpty())
				{
					TelephoneService ts = new TelephoneService();
					ts.createTelephone(type, numeroTel,newContact.getId());
				}
				else
				{
					request.setAttribute("errorPhoneType", type);
					request.setAttribute("errorPhone", numeroTel);
					request.setAttribute("errorMessage", "Veuillez remplir les champs de téléphone ! ");
					request.setAttribute("errorType", "fillPhoneForm");
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
