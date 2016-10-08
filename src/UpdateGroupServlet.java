

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Contact;
import Models.Groupe;
import ServiceEntities.ContactService;
import ServiceEntities.GroupeService;

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
		String[] membersIdList = request.getParameterValues("members");
		
		if(idGroupe!=0 && nom!=null)
		{
			GroupeService gs = new GroupeService();
			if(!nom.isEmpty())
			{
				if(gs.groupExists(idGroupe))
				{
					Groupe g = gs.getGroupById(idGroupe);
					
					ArrayList<Contact> previousList = gs.getContacts(idGroupe);
					
					System.out.println(g.getNom());
					boolean nameHasChanged = !g.getNom().equals(nom);
					
					int previousNumber = gs.getContacts(idGroupe).size();
					int newNumber = 0;
					boolean membersNumberHasChanged = false;
					
					System.out.println("membres avant "+previousNumber);
					
					if(membersIdList!=null)
						newNumber = membersIdList.length;

					System.out.println("membres apres "+ newNumber);
					if(previousNumber != newNumber)
						membersNumberHasChanged=true;
					
					System.out.println("name has changed "+nameHasChanged);
					System.out.println("Members have changed "+membersNumberHasChanged);
					
					if(nameHasChanged && !gs.groupExists(nom) && !membersNumberHasChanged)// || !addressHasChanged)
					{
						gs.updateGroupe(idGroupe, nom);
						response.sendRedirect("searchGroup.jsp");
					}
					if(nameHasChanged && !gs.groupExists(nom) && membersNumberHasChanged)// || !addressHasChanged)
					{
						gs.updateGroupe(idGroupe, nom);
						if(membersIdList!=null)
						{
							ContactService cs = new ContactService();
							
							for(String member :membersIdList)
							{
								Contact c = cs.getContactById(Integer.valueOf(member));
								cs.addContactToGroup(c.getId(), idGroupe);
							}
						}
						response.sendRedirect("searchGroup.jsp");
					}
					else if(!nameHasChanged && membersNumberHasChanged)
					{
						if(membersIdList!=null)
						{
							ContactService cs = new ContactService();

							for(Contact c : cs.getContacts())
								if(c.getIdGroupe()==idGroupe)
									cs.addContactToGroup(c.getId(), 0);
							
							for(String newContactId : membersIdList)
							{
								Contact c = cs.getContactById(Integer.valueOf(newContactId));
								cs.addContactToGroup(c.getId(), idGroupe);
							}
						}
						else
						{
							ContactService cs = new ContactService();
							
							for(Contact c : cs.getContacts())
								if(c.getIdGroupe()==idGroupe)
									cs.addContactToGroup(c.getId(), 0);
						}
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
