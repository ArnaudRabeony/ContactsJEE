

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServiceEntities.AdresseService;
import ServiceEntities.TelephoneService;

/**
 * Servlet implementation class DeletePhoneServlet
 */
public class DeletePhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePhoneServlet() {
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

		String[] idTelephones = request.getParameterValues("selectedId");
		int idTelephone = request.getParameter("selectedId").isEmpty() ? -1 : Integer.valueOf(request.getParameter("selectedId"));
		System.out.println("idTelephone "+idTelephones);
		if(idTelephones.length!=0)
		{
			TelephoneService ts = new TelephoneService();
			
			for(String id : idTelephones)
			{
				int toDelete = Integer.valueOf(id);
				boolean exists = ts.telephoneExists(toDelete);
				
				//TODO : tester existence condition dynamique
				
				if(exists)
					ts.deleteTelephone(toDelete);
				else
				{
					request.setAttribute("errorMessage", "Adresse à supprimer inexistante !");
					request.setAttribute("errorType", "noRecord");
					request.getRequestDispatcher("deletePhoneNumber.jsp").forward(request, response);
				}
			}
			response.sendRedirect("index.jsp");
		}
		else
		{
			request.setAttribute("errorMessage", "Veuillez remplir tous les champs ! ");
			request.setAttribute("errorType", "deleteEmptyField");
			request.getRequestDispatcher("deletePhoneNumber.jsp").forward(request, response);
		}
		
	}

}
