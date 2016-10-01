

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServiceEntities.GroupeService;
import ServiceEntities.TelephoneService;

/**
 * Servlet implementation class CreateGroupServlet
 */
public class CreateGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateGroupServlet() {
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
		String groupe;
		groupe = request.getParameter("nomGroupe")!=null ? request.getParameter("nomGroupe") : "";

		if(groupe!="")
		{
			GroupeService gs = new GroupeService();
			
			if(!gs.exists(groupe))
				gs.createGroupe(groupe);
			else
			{
				request.setAttribute("errorNom", groupe);
				request.setAttribute("errorMessage", "Un groupe du même nom existe déjà !");
				request.setAttribute("errorType", "groupAlreadyExists");
				request.getRequestDispatcher("createGroup.jsp").forward(request,response);
			}
		}
		else
		{
			request.setAttribute("errorNom", groupe);
			request.setAttribute("errorMessage", "Veuillez remplir tous les champs ! ");
			request.setAttribute("errorType", "fillGroupForm");
			request.getRequestDispatcher("createGroup.jsp").forward(request,response);
		}
		response.sendRedirect("index.jsp");
	}

}
