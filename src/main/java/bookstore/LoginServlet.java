package bookstore;

import jakarta.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
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
		 PrintWriter out = response.getWriter();
/*		 out.println("hello Servlet");
		 String email=request.getParameter("email");
		 String password=request.getParameter("password");
		 out.println("Email="+ ""+email);
		 out.println("password="+""+password);
		 
	*/	  
		 
		  if(LoginDatabaseConnector.validate(request.getParameter("name"),request.getParameter("pass"))){  
		        RequestDispatcher rd=request.getRequestDispatcher("ShopDisplay.html");  
		        rd.forward(request,response);  
		    }  
		    else{  
		         
		        RequestDispatcher rd=request.getRequestDispatcher("Index.html");  
		        rd.include(request,response);  
		        out.print("Sorry username or password error. Please try again");  
		    }  
		          
	      
		    out.close();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
