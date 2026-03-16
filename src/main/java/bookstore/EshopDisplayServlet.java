package bookstore;

import jakarta.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;

/**
 * Servlet implementation class EshopDisplayServlet
 */
@WebServlet("/EshopDisplayServlet")
public class EshopDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet result= null;
       
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EshopDisplayServlet() {
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

		try {

			// STEP 1: Register JDBC driver. This will load the MySQL driver,
			// each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 2: Open a connection. Setup the connection with the DB
			connect = DriverManager.getConnection(
					"jdbc:mysql://localhost/bookShop", "root", "Rathmines_2026");
			// STEP 3: Statements allow us to issue SQL queries to the database
			statement = connect.createStatement();
			// STEP 4: declare a query
			String sql = "SELECT DISTINCT book FROM books WHERE qty > 0";
			// STEP 5: execute a query
			result = statement.executeQuery(sql);
			// Print html with CSS style sheet
			out.println("<!DOCTYPE html><html><head><link rel='stylesheet' href='css/style.css'/><head><body>");
			out.println("<div id='wrapper'> <!-- This wrapper centers the page--><header> <!-- This is HEADER--></header><nav><!-- This is the Navigation bar--> <ul><li><a href='index.html'>Home</a></li></ul><div id ='mainsection'> <!-- This is the main content bar--><div id='scr'></div><div id='main'><!-- This is the  form block--><div id='main-wrapper'<form action='LoginServlet' method='get' class='form'>  <!-- Start of form-->");

			// Begin an HTML form

			out.println("<form method='get' action='QueryServlet'>");

			out.println("<hr>");
			out.println("<h3>Login Success!</h3>");
			out.println("<hr>");
			out.println("<p> </p>");
			// A pull-down menu of all the genre with a no-selection option
			out.println("Choose a product: <select name='product' size='1'>");
			out.println("<option value=''>Select...</option>"); // no-selection
			while (result.next()) { // list all the genre
				String product = result.getString("product");
				out.println("<option value='" + product + "'>" + product
						+ "</option>");
			}
			out.println("</select><br />");
			// create a submit button
			out.println("<input type='submit' value='SEARCH' />");
			out.println("<p> </p>");
			out.println("</form>");

			out.println("</form> <!-- end of form--></div></div><!-- end of main--><p></p></div> <!-- end of mainsection --></div> <!-- end of wrapper --></body></html>");
			// end of form
			RequestDispatcher rd = request
					.getRequestDispatcher("ShopDisplay.html");
			rd.include(request, response);

		} catch (Exception e) {
			e.printStackTrace();
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
