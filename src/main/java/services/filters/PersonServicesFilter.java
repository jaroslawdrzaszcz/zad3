package services.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/person.jsp")
public class PersonServicesFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String amount = httpRequest.getParameter("amount");
	    String insllmentCount = httpRequest.getParameter("insllmentCount");
	    System.out.println("amount = " + amount);
	    System.out.println("insllmentCount = " +insllmentCount);
	    System.out.println("ServerName = " + request.getServerName());
	    System.out.println("QueryString = " + httpRequest.getQueryString());
	    System.out.println("PathInfo = " + httpRequest.getPathInfo());
	    
	    /*if (!request.getServerName().equals("localhost")) {  
	    	  //first read in the path  
	    	  String path = "/";  
	    	  if (httpRequest.getQueryString()==null) {  
	    	    path = httpRequest.getPathInfo();  
	    	  } else {  
	    	    path = httpRequest.getPathInfo()+"?"+httpRequest.getQueryString();  
	    	  }  
	    	  //now redirect to the right domain  
	    	  try {  
	    		  httpResponse.sendRedirect(request.getScheme()+"://"+"localhost:8080/index.jsp");  
	    	  } catch (IOException e) {e.printStackTrace();}  
	    	} */
	    
	    if(amount.isEmpty() || insllmentCount.isEmpty()){
	    	System.out.println("amount or insllmentCouns parameters are not filled up, redirect to /index.jsp");
            httpResponse.sendRedirect("/index.jsp");	
	    }
	    
		chain.doFilter(request, response);	
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
