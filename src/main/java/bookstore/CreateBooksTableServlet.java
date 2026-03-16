package bookstore;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Servlet implementation class CreateProductsTableServlet
 */
@WebServlet("/CreateBooksTableServlet")
public class CreateBooksTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateBooksTableServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
        PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		Statement stmt;
		Connection conn = null;
		try {
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//STEP 3: Open a connection
		      out.println("Connecting to database...");
		      conn = DriverManager.getConnection("jdbc:mysql://localhost/bookShop","root" ,"Rathmines_2026" ); 
			   // change databse name to localhost/YournameShop
		    //STEP 4: Execute a query
		      out.println("Creating ..");
		      stmt = conn.createStatement();
		      
		      out.println("Creating table in given database...");
			    stmt = conn.createStatement();
			    
			    String sql = "CREATE TABLE  books"+
			                 "(id INTEGER not NULL, " +
			                 " book VARCHAR(50), " + 
			                 " author VARCHAR(50), " +
			                 " price FLOAT, " +
			                 " qty INTEGER, " +
			                 " PRIMARY KEY ( id ))"; 

			    stmt.executeUpdate(sql);
			    out.println("Created table in given database...");
		      
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		out.println( "</body>");
		out.println( "</html>");

		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
