package rpc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import db.DBConnection;
import db.DBConnectionFactory;
import entity.Item;
import external.TicketMasterAPI;

/**
 * Servlet implementation class SearchItem
 */
@WebServlet("/search")
public class SearchItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		PrintWriter writer = response.getWriter();
//		writer.print("<html><body>");
//		writer.print("<h1>hello world</h1>");
//		if (request.getParameter("username") != null) {
//			String username = request.getParameter("username");
//			writer.print("<p>" + username + "</p>");
//		} else {
//			JSONArray array = new JSONArray();
//			JSONObject obj = new JSONObject();
//			try {
//				obj.put("key1", "value1");
//				array.put(obj);
//				array.put(new JSONObject().put("key2", "value2"));
//			} catch (JSONException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			writer.print(array);
//		}
//		writer.print("</body></html>");
//		writer.close();
		
		//29.682684, -95.295410
		double lat = Double.parseDouble(request.getParameter("lat"));
		double lon = Double.parseDouble(request.getParameter("lon"));
		String keyword = request.getParameter("keyword");
		
		DBConnection conn = DBConnectionFactory.getConnection();// get MySQL connection
		
//		TicketMasterAPI tmAPI = new TicketMasterAPI();
		List<Item> items = conn.searchItems(lat, lon, keyword);
		
		JSONArray array = new JSONArray();
		for (Item item : items) {
			array.put(item.toJSONObject());
		}
		RpcHelper.writeJsonArray(response, array);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
