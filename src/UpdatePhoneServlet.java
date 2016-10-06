

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Adresse;
import Models.Telephone;
import ServiceEntities.AdresseService;
import ServiceEntities.TelephoneService;

/**
 * Servlet implementation class UpdatePhoneServlet
 */
public class UpdatePhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePhoneServlet() {
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
				String type,numero;

				numero = request.getParameter("numeroTel")!=null ? request.getParameter("numeroTel") : "";
				type = request.getParameter("type")!=null ? request.getParameter("type") : "";
				int idTelephone = request.getParameter("selectedId")!= null ? Integer.valueOf(request.getParameter("selectedId")) : 0;
				
				if(idTelephone!=0 && numero!=null && type!=null)
				{
					TelephoneService ts = new TelephoneService();
					if(!numero.isEmpty() && !type.isEmpty())
					{
						if(ts.telephoneExists(idTelephone))
						{
							Telephone t = ts.getTelephoneById(idTelephone);
							
							System.out.println(t.getNumber()+" "+t.getPhoneKind());
							boolean phoneHasChanged = !t.getNumber().equals(numero) || !t.getPhoneKind().equals(type) || (!t.getNumber().equals(numero) && !t.getPhoneKind().equals(type));
							System.out.println(phoneHasChanged);
							
							if(phoneHasChanged && !ts.telephoneExists(type, numero))// || !addressHasChanged)
							{
								ts.updateNumero(idTelephone,type,numero);
								response.sendRedirect("searchPhone.jsp");
							}
							else
							{
								request.setAttribute("errorId", idTelephone);
								request.setAttribute("errorMessage", "Le numéro existe déjà !");
								request.setAttribute("errorType", "numberAlreadyExists");
								request.getRequestDispatcher("searchPhone.jsp").forward(request,response);
							}
							
						}
						else
						{
							request.setAttribute("errorId", idTelephone);
							request.setAttribute("errorMessage", "Le numéro n'existe pas !");
							request.setAttribute("errorType", "numberDoesnotExists");
							request.getRequestDispatcher("searchPhone.jsp").forward(request,response);
						}
					}
					else
					{
						request.setAttribute("errorId", idTelephone);
						request.setAttribute("errorPhone", numero);
						request.setAttribute("errorPhoneType", type);
						request.setAttribute("errorMessage", "Veuillez remplir tous les champs! ");
						request.setAttribute("errorType", "fillPhoneForm");
						request.getRequestDispatcher("searchPhone.jsp").forward(request,response);
					}
				}
				else
				{
					request.setAttribute("errorId", idTelephone);
					request.setAttribute("errorPhone", numero);
					request.setAttribute("errorPhoneType", type);
					request.setAttribute("errorMessage", "Veuillez remplir tous les champs! ");
					request.setAttribute("errorType", "fillPhoneForm");
					request.getRequestDispatcher("searchPhone.jsp").forward(request,response);
				}
	}

}
