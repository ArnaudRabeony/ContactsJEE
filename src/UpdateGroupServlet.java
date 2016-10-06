

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Groupe;
import Models.Telephone;
import ServiceEntities.GroupeService;
import ServiceEntities.TelephoneService;

/**
 * Servlet implementation class UpdateGroupServlet
 */
public class UpdateGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateGroupServlet() {
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
		String nom;

		nom = request.getParameter("nomGroupe")!=null ? request.getParameter("nomGroupe") : "";
		int idGroupe = request.getParameter("selectedId")!= null ? Integer.valueOf(request.getParameter("selectedId")) : 0;
		
		if(idGroupe!=0 && nom!=null)
		{
			GroupeService gs = new GroupeService();
			if(!nom.isEmpty())
			{
				if(gs.groupExists(idGroupe))
				{
					Groupe g = new Groupe(idGroupe, gs.getGroupNameById(idGroupe));
					
					System.out.println(g.getNom());
					boolean nameHasChanged = !g.getNom().equals(nom);
					System.out.println(nameHasChanged);
					
					if(nameHasChanged && !gs.groupExists(nom))// || !addressHasChanged)
					{
						gs.updateGroupe(idGroupe, nom);
						response.sendRedirect("searchGroup.jsp");
					}
					else
					{
						request.setAttribute("errorId", idGroupe);
						request.setAttribute("errorMessage", "Le groupe existe déjà !");
						request.setAttribute("errorType", "groupAlreadyExists");
						request.getRequestDispatcher("searchGroup.jsp").forward(request,response);
					}
					
				}
				else
				{
					request.setAttribute("errorId", idGroupe);
					request.setAttribute("errorMessage", "Le groupe n'existe pas !");
					request.setAttribute("errorType", "groupDoesnotExists");
					request.getRequestDispatcher("searchGroup.jsp").forward(request,response);
				}
			}
			else
			{
				request.setAttribute("errorId", idGroupe);
				request.setAttribute("errorNomGroupe", nom);
				request.setAttribute("errorMessage", "Veuillez remplir tous les champs! ");
				request.setAttribute("errorType", "fillGroupForm");
				request.getRequestDispatcher("searchGroup.jsp").forward(request,response);
			}
		}
		else
		{
			request.setAttribute("errorId", idGroupe);
			request.setAttribute("errorNomGroupe", nom);
			request.setAttribute("errorMessage", "Veuillez remplir tous les champs! ");
			request.setAttribute("errorType", "fillGroupForm");
			request.getRequestDispatcher("searchGroup.jsp").forward(request,response);
			}
}

}
