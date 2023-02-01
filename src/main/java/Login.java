

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		String login = request.getParameter("txtLogin");
		String password = request.getParameter("txtPassword");
		
		if (login == null) login = "";
		if (password == null) password = "";
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
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
		var output = login.substring(0, 1).toUpperCase() + login.substring(1);
		s.setAttribute("output", output);
		s.setAttribute("password", password);
	
		System.out.println(password );
		System.out.println(output );

		//if (login.equals("nunu") && password.equals("1234")) {
		if (login != null && password != null) {
			  request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}else {
			doGet(request, response);
		}
		
	}

}
