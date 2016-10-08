

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Groupe;
import ServiceEntities.GroupeService;

/**
 * Servlet implementation class SearchGroupServlet
 */
public class SearchGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchGroupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int groupId = request.getParameter("selectedId")!= null ? Integer.valueOf(request.getParameter("selectedId")) : -1;
		System.out.println(groupId);
			
		if(groupId != -1)
		{
			GroupeService gs = new GroupeService();
			Groupe g = gs.getGroupById(groupId);

			if(g != null)
			{
				System.out.println(g.getNom());
				request.setAttribute("errorId", groupId);
				request.setAttribute("errorNomGroupe", g.getNom());
				request.getRequestDispatcher("searchGroup.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("errorId", groupId);
				request.setAttribute("errorMessage", "Aucun résultat n'a été trouvé !");
				request.setAttribute("errorType", "noRecord");
				request.getRequestDispatcher("searchGroup.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("errorId", groupId);
			request.setAttribute("errorMessage", "Veuillez remplir tous les champs ! ");
			request.setAttribute("errorType", "searchEmptyField");
			request.getRequestDispatcher("searchGroup.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
