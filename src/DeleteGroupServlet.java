

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServiceEntities.GroupeService;
import ServiceEntities.TelephoneService;

/**
 * Servlet implementation class DeleteGroupServlet
 */
public class DeleteGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteGroupServlet() {
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
		int idGroupe = request.getParameter("selectedId").isEmpty() ? -1 : Integer.valueOf(request.getParameter("selectedId"));
		System.out.println("idGroupe "+idGroupe);
		if(idGroupe != -1)
		{
			GroupeService gs = new GroupeService();
			boolean exists = gs.groupExists(idGroupe);

			//TODO : tester existence condition dynamique
			
			if(exists)
			{
				gs.deleteGroup(idGroupe);
				response.sendRedirect("index.jsp");
			}
			else
			{
				request.setAttribute("errorMessage", "Adresse à supprimer inexistante !");
				request.setAttribute("errorType", "noRecord");
				request.getRequestDispatcher("deleteAddress.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("errorMessage", "Veuillez remplir tous les champs ! ");
			request.setAttribute("errorType", "deleteEmptyField");
			request.getRequestDispatcher("deleteAddress.jsp").forward(request, response);
		}
	}

}
