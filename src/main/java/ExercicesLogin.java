

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ExercicesLogin
 */
@WebServlet("/exerciceslogin")
public class ExercicesLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		String login = request.getParameter("txtLogin");
		String password = request.getParameter("txtPassword");
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		String login = request.getParameter("txtLogin");
		String password = request.getParameter("txtPassword");
		
		HttpSession s = request.getSession();
		
		s.setAttribute("login", login);
		s.setAttribute("password", password);
		var output = login.substring(0, 1).toUpperCase() + login.substring(1);
		s.setAttribute("output", output);
	
		
		System.out.println(output );
		System.out.println(password);

		if (!login.equals("") && !password.equals("") && hasCapitalLetter(password) ) {
			  request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}else {
			response.setStatus(500);
			request.getRequestDispatcher("login2.jsp").forward(request, response);
		
		}
		
	}
	public static boolean hasCapitalLetter(String password) {
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

}


