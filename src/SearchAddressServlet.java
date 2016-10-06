

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
 * Servlet implementation class SearchAddressServlet
 */
public class SearchAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int addressId = request.getParameter("selectedId")!= null ? Integer.valueOf(request.getParameter("selectedId")) : -1;
		System.out.println(addressId);
			
		if(addressId != -1)
		{
			AdresseService cs = new AdresseService();
			Adresse c = cs.getAdresseById(addressId);
			

			if(c != null)
			{
				System.out.println(c.getRue());
				
				String num = c.getRue().split(" ")[0];
				String rue = c.getRue().replace(num, "").substring(1);
				request.setAttribute("errorId",addressId);
				request.setAttribute("errorNumero", num);
				request.setAttribute("errorRue", rue);
				request.setAttribute("errorVille", c.getVille());
				request.setAttribute("errorCodePostal", c.getCodePostal());
				request.setAttribute("errorPays", c.getPays());
				request.getRequestDispatcher("searchAddress.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("errorId",addressId);
				request.setAttribute("errorMessage", "Aucun résultat n'a été trouvé !");
				request.setAttribute("errorType", "noRecord");
				request.getRequestDispatcher("searchAddress.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("errorId",addressId);
			request.setAttribute("errorMessage", "Veuillez remplir tous les champs! ");
			request.setAttribute("errorType", "fillAddressForm");
			request.getRequestDispatcher("searchAddress.jsp").forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
