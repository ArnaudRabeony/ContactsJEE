

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Contact;
import Models.Groupe;
import ServiceEntities.ContactService;
import ServiceEntities.GroupeService;

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
		String[] addToGroup = request.getParameterValues("addToGroup");
		
		int i=0;
		
		if(groupe!="")
		{
			GroupeService gs = new GroupeService();
			
			if(!gs.exists(groupe))
			{
				Groupe newGroup = gs.createGroupe(groupe);
				
				if(addToGroup!=null && addToGroup.length!=0)
				{
					ContactService cs = new ContactService();
					int idGroupe = gs.getGroupIdByName(newGroup.getNom());
					
					for(i=0;i<addToGroup.length;i++)
						cs.addContactToGroup(Integer.valueOf(addToGroup[i]), idGroupe);
				}
			}
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
