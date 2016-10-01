

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServiceEntities.AdresseService;
import ServiceEntities.ContactService;

/**
 * Servlet implementation class CreateAddressServlet
 */
public class CreateAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAddressServlet() {
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
		String numero, rue, ville, codePostal,pays,contactId;
		numero = request.getParameter("numeroAdresse")!=null ? request.getParameter("numeroAdresse") : "";
		rue = request.getParameter("rue")!=null ? request.getParameter("rue") : "";
		ville = request.getParameter("ville")!=null ? request.getParameter("ville") : "";
		codePostal = request.getParameter("codep")!=null ? request.getParameter("codep") : "";
		pays = request.getParameter("pays")!=null ? request.getParameter("pays") : "";
		contactId = request.getParameter("contactId")!=null ? request.getParameter("contactId") : "";
		
		if(contactId!="" && !numero.isEmpty() &&!rue.isEmpty() &&!ville.isEmpty() &&!codePostal.isEmpty() &&!pays.isEmpty())
		{
			rue=numero+" "+rue;
			AdresseService as = new AdresseService();
			as.createAdresse(rue, ville, codePostal, pays,Integer.valueOf(contactId));
		}
		else
		{
			request.setAttribute("errorNumero", numero);
			request.setAttribute("errorRue", rue);
			request.setAttribute("errorVille", ville);
			request.setAttribute("errorCodePostal", codePostal);
			request.setAttribute("errorPays", pays);
			request.setAttribute("errorMessage", "Veuillez remplir tous les champs! ");
			request.setAttribute("errorType", "fillAddressForm");
			request.getRequestDispatcher("createAddress.jsp").forward(request,response);
		}
		response.sendRedirect("index.jsp");
	}

}
