package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11497")
public class BenchmarkTest11497 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.addBatch( sql );
			int[] counts = statement.executeBatch();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a28142 = param; //assign
		StringBuilder b28142 = new StringBuilder(a28142);  // stick in stringbuilder
		b28142.append(" SafeStuff"); // append some safe content
		b28142.replace(b28142.length()-"Chars".length(),b28142.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map28142 = new java.util.HashMap<String,Object>();
		map28142.put("key28142", b28142.toString()); // put in a collection
		String c28142 = (String)map28142.get("key28142"); // get it back out
		String d28142 = c28142.substring(0,c28142.length()-1); // extract most of it
		String e28142 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d28142.getBytes() ) )); // B64 encode and decode it
		String f28142 = e28142.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f28142); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass