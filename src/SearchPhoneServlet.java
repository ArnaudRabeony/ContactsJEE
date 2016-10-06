

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Contact;
import Models.Telephone;
import ServiceEntities.ContactService;
import ServiceEntities.TelephoneService;

/**
 * Servlet implementation class SearchPhoneServlet
 */
public class SearchPhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPhoneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int phoneId = request.getParameter("selectedId")!= null ? Integer.valueOf(request.getParameter("selectedId")) : -1;
		System.out.println(phoneId);
			
		if(phoneId != -1)
		{
			TelephoneService ts = new TelephoneService();
			Telephone t = ts.getTelephoneById(phoneId);

			if(t != null)
			{
				System.out.println(t.getNumber());
				request.setAttribute("errorPhoneType", t.getPhoneKind());
				request.setAttribute("errorPhone", t.getNumber());
				request.getRequestDispatcher("searchPhone.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("errorId",phoneId);
				request.setAttribute("errorMessage", "Aucun résultat n'a été trouvé !");
				request.setAttribute("errorType", "noRecord");
				request.getRequestDispatcher("searchPhone.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("errorId",phoneId);
			request.setAttribute("errorMessage", "Veuillez remplir tous les champs ! ");
			request.setAttribute("errorType", "searchEmptyField");
			request.getRequestDispatcher("searchPhone.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
