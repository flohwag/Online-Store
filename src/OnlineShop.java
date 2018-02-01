
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OnlineShop
 */
@WebServlet("/OnlineShop")
public class OnlineShop extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, String> didorder = new HashMap<String, String>();

	public OnlineShop() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String Bestellung = request.getParameter("Bestellung");
		String Name = request.getParameter("Name");
		System.out.println("Name:" + Name);
		System.out.println("Bestellung:" + Bestellung);
		out.print("<html>\"<head><link href=\"https://afeld.github.io/emoji-css/emoji.css\" rel=\"stylesheet\"></head><body>");
		if (didorder.get(Name) == null) {
			didorder.put(Name, Bestellung);
			out.print("<h1 style=\"font-family:\"new century schoolbook\";text-align:center;\">"+
			  "Die Bestellung war erfolgreich!&nbsp;<i class=\"em em-smiley\"></i></h1>");
		} else {
			String Oldorder = didorder.get(Name);
			didorder.put(Name, Bestellung);

			out.print("<h3 style=\"font-family: helvetica;\">Vielen Dank</h3>");
			out.print("<p style=\"font-family: verdana;\" >Alte Bestellung: " + Oldorder
					+ " Neue Bestellung: " + Bestellung + "</p>");

		}
		out.print("</body></html>");
		FileWriter writer = new FileWriter("C:\\Users\\praktikant\\eclipse-workspace\\Online Shop\\Data.csv");

		writer.append(Name);
		writer.append(',');
		writer.append(Bestellung);
		writer.append('\n');

		writer.flush();
		writer.close();

	}
}
