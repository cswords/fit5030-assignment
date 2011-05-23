package fit5030.ass.two.searchclient.uiservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fit5030.ass.two.searchclient.webservice.SimpleAjax;
import org.apache.axis2.AxisFault;
import org.json.JSONException;
import com.google.code.p.fit5030assignment.UnifiedSearchAjaxServiceStub;
import com.google.code.p.fit5030assignment.UnifiedSearchAjaxServiceStub.*;

/**
 * Servlet implementation class Search
 */
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String query;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		query = request.getParameter("query");
		this.doResponseWS(response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		query = request.getParameter("query");
		this.doResponseWS(response);
	}

	UnifiedSearchAjaxResponse response;

	private void doResponseWS(HttpServletResponse response) {
		if (query == null)
			return;
		try {
			UnifiedSearchAjaxServiceStub stub = new UnifiedSearchAjaxServiceStub();
			UnifiedSearchAjaxRequest req = new UnifiedSearchAjaxRequest();
			req.setInput(query);
			this.response = stub.process(req);
			doResponse(response);
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private void doResponse(HttpServletResponse response) {
		if (query == null)
			return;
		try {
			PrintWriter writer = response.getWriter();
			try {
				SimpleAjax sa = new SimpleAjax();
				String result = sa.unifiedSearch(query);
				writer.print(result);
			} catch (JSONException e) {
				e.printStackTrace();
				writer.print("<h3>" + e.getMessage() + "</h3>");
			} catch (ParseException e) {
				e.printStackTrace();
				writer.print("<h3>" + e.getMessage() + "</h3>");
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
}
