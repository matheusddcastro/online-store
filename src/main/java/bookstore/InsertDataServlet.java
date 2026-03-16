package bookstore;

import jakarta.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class InsertDataServlet
 */
@WebServlet("/InsertDataServlet")
public class InsertDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
       
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
PrintWriter out = response.getWriter();
		
		try{
			out.println( "Registering  JDBC driver");
			//STEP 1: Register JDBC driver. This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			out.println( "Seting up the connection with the DB");
			//STEP 2: Open a connection. Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/bookShop","root" ,"Rathmines_2026" );
            // STEP 3: Statements allow us to  issue SQL queries to the database
			statement = connect.createStatement();
			//STEP 4: declare a query
			String sql = "INSERT INTO books (id, book, author, price,qty) VALUES" +
		    		"(101,'Lord of the Rings: Fellowship of the Ring', 'JR Tolkien', 18.50,21),"+
		    		"(102,'Romeo & Juliet', 'William Shakespeare', 14.00,13),"+
		    		"(103,'Harry Potter: Chamber of Secrets', 'JK Rowling', 15.99,30),"+
		    		"(104,'Pride and Prejudice', 'Jane Austen', 10.99,7),"+
		    		 "(105,'To Kill a Mockingbird' , 'Harper Lee', 13.20,25)";
			//STEP 5: execute a query
			statement.executeUpdate(sql);
			out.println( "Data insert.....");
			
		}catch (Exception e){
			e.printStackTrace();
		}// Exception

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
