



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nom = request.getParameter("nom");
		String password = request.getParameter("password");
		
		if(nom!=null && password!=null)
		{
			if(!nom.isEmpty() && !password.isEmpty())
			{
				if(!nom.equals(password))
				{
					request.setAttribute("errorNom", nom);
					request.setAttribute("errorMessage", "L'authentification a échoué");
					request.setAttribute("errorType", "loginMismatch");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				else
				{
//					if(request.getSession(false) ==null)
//					{
						HttpSession session = request.getSession();
						session.setAttribute("nom", nom);
//					}
						
					response.sendRedirect("index.jsp");
				}
			}
			else
			{
				request.setAttribute("errorNom", nom);
				request.setAttribute("errorMessage", "Veuillez remplir tous les champs ! ");
				request.setAttribute("errorType", "emptyLogin");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("errorNom", nom);
			request.setAttribute("errorMessage", "Veuillez remplir tous les champs ! ");
			request.setAttribute("errorType", "emptyLogin");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
