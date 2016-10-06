

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Adresse;
import Models.Contact;
import ServiceEntities.AdresseService;
import ServiceEntities.ContactService;

/**
 * Servlet implementation class UpdateAddressServlet
 */
public class UpdateAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAddressServlet() {
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
				String numero,rue,ville,codep,pays;
				
				numero = request.getParameter("numeroAdresse")!=null ? request.getParameter("numeroAdresse") : "";
				rue = request.getParameter("rue")!=null ? request.getParameter("rue") : "";
				ville = request.getParameter("ville")!=null ? request.getParameter("ville") : "";
				codep = request.getParameter("codep")!=null ? request.getParameter("codep") : "";
				pays = request.getParameter("pays")!=null ? request.getParameter("pays") : "";
				int idAddress = request.getParameter("idAddress").isEmpty() ? 0 : Integer.valueOf(request.getParameter("idAddress"));
				
				if(idAddress!=0 && numero!=null && rue!=null && ville!=null && codep!=null && pays!=null)
				{
					AdresseService as = new AdresseService();
					if(!numero.isEmpty() && !rue.isEmpty() && !ville.isEmpty() && !codep.isEmpty() && !pays.isEmpty())
					{
						if(as.addressExists(idAddress))
						{
							Adresse a = as.getAdresseById(idAddress);
							
							System.out.println(a.getRue());
							boolean addressHasChanged = !a.getRue().equals(numero+" "+rue) || !a.getVille().equals(ville) 
									 || !a.getCodePostal().equals(codep) || !a.getPays().equals(pays) ||
						(!a.getRue().equals(numero+" "+rue) && !a.getVille().equals(ville) && !a.getCodePostal().equals(codep) && !a.getPays().equals(pays));
							System.out.println(addressHasChanged);
							
							if(addressHasChanged && !as.addressExists(numero+" "+rue,ville,codep,pays))// || !addressHasChanged)
							{
								as.updateAdresse(idAddress,numero+" "+rue,ville,codep,pays);
								response.sendRedirect("searchAddress.jsp");
							}
							else
							{
								request.setAttribute("errorId", idAddress);
								request.setAttribute("errorMessage", "L'adresse existe déjà !");
								request.setAttribute("errorType", "addressAlreadyExists");
								request.getRequestDispatcher("searchContact.jsp").forward(request,response);
							}
							
						}
						else
						{
							request.setAttribute("errorId", idAddress);
							request.setAttribute("errorMessage", "L'adresse n'existe pas !");
							request.setAttribute("errorType", "addressDoesnotExists");
							request.getRequestDispatcher("searchAddress.jsp").forward(request,response);
						}
					}
					else
					{
						request.setAttribute("errorId", idAddress);
						request.setAttribute("errorNumero", numero);
						request.setAttribute("errorRue", rue);
						request.setAttribute("errorVille", ville);
						request.setAttribute("errorCodePostal", codep);
						request.setAttribute("errorPays", pays);
						request.setAttribute("errorMessage", "Veuillez remplir tous les champs! ");
						request.setAttribute("errorType", "fillAddressForm");
						request.getRequestDispatcher("searchAddress.jsp").forward(request,response);
					}
				}
				else
				{
					request.setAttribute("errorId", idAddress);
					request.setAttribute("errorNumero", numero);
					request.setAttribute("errorRue", rue);
					request.setAttribute("errorVille", ville);
					request.setAttribute("errorCodePostal", codep);
					request.setAttribute("errorPays", pays);
					request.setAttribute("errorMessage", "Veuillez remplir tous les champs! ");
					request.setAttribute("errorType", "fillAddressForm");
					request.getRequestDispatcher("searchAddress.jsp").forward(request,response);
				}
	}

}
