package bookstore;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;




/**
 * Servlet implementation class CreateDatabaseServlet
 */
@WebServlet("/CreateDatabaseServlet")
public class CreateDatabaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "Rathmines_2026";
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateDatabaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection connection = null;
	    Statement stmt=null;
		response.getWriter().append(" Served at: ").append(request.getContextPath());
		
        try {
            // Load the MySQL JDBC Driver (optional with newer versions of Java)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connected to the database successfully!");
            stmt = connection.createStatement();
            stmt.executeLargeUpdate("CREATE Database bookShop");
            
            

            
            		           
           
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Error connecting to the database!");
            e.printStackTrace();

        } finally {
            // Close the connection
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connection closed.");
                } catch (SQLException e) {
                    System.out.println("Error closing the connection!");
                    e.printStackTrace();
                }
            }
        }
    

		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
