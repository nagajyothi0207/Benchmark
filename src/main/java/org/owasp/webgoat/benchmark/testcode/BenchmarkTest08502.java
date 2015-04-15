package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08502")
public class BenchmarkTest08502 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		java.io.File file = new java.io.File(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map81967 = new java.util.HashMap<String,Object>();
		map81967.put("keyA-81967", "a Value"); // put some stuff in the collection
		map81967.put("keyB-81967", param.toString()); // put it in a collection
		map81967.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map81967.get("keyB-81967"); // get it back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass