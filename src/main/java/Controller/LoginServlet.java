package Controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindtree.dto.User;
import com.mindtree.serviceimpl.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet(description="", urlPatterns="/LoginServlet")
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().println("<html><h1>ERROR PAGE</h1></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		PrintWriter out = response.getWriter();
		String username  = request.getParameter("user");
		String password  = request.getParameter("password");
		LoginServiceImpl loginServiceImpl = new LoginServiceImpl();
		//loginServiceImpl.saveUser(username.trim(), password.trim());
		List<User> userList = (List<User>) loginServiceImpl.getUser(username, password);
		if(userList.isEmpty())
		{
			System.out.println("---EMPTY---");
		}
		String user  = userList.get(0).getUserName();
		String pass = userList.get(0).getPassword();
		String output = "Authenticated User..Congrats..!!.\n\n"+"Username"+ user+ " Password:"+pass;
	//	String output = "User:"+username +" Pass: "+ password;
		out.println("<html>"+output+"</html>");
	}

}

