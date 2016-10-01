

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServiceEntities.TelephoneService;

/**
 * Servlet implementation class CreatePhoneServlet
 */
public class CreatePhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePhoneServlet() {
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
		String numeroTel, type, contactId;
		numeroTel = request.getParameter("numeroTel")!=null ? request.getParameter("numeroTel") : "";
		type = request.getParameter("type")!=null ? request.getParameter("type") : "";
		contactId = request.getParameter("contactId")!=null ? request.getParameter("contactId") : "";

		if(contactId!="" && !numeroTel.isEmpty() &&!type.isEmpty())
		{
			TelephoneService ts = new TelephoneService();
			ts.createTelephone(type, numeroTel,Integer.valueOf(contactId));
		}
		else
		{
			request.setAttribute("errorPhoneType", type);
			request.setAttribute("errorPhone", numeroTel);
			request.setAttribute("errorMessage", "Veuillez remplir les champs de téléphone ! ");
			request.setAttribute("errorType", "fillPhoneForm");
			request.getRequestDispatcher("createPhoneNumber.jsp").forward(request,response);
		}
		response.sendRedirect("index.jsp");
	}

}
