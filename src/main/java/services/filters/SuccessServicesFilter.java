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

@WebFilter("/success.jsp")
public class SuccessServicesFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String zipCode = httpRequest.getParameter("zipCode");
	    String city = httpRequest.getParameter("city");
	    String street = httpRequest.getParameter("street");
	    String houseNumber = httpRequest.getParameter("houseNumber");
	    String localNumber = httpRequest.getParameter("localNumber");
	    System.out.println("zipCode = " + zipCode);
	    System.out.println("city = "+ city);
	    System.out.println("street = "+ street);
	    System.out.println("houseNumber = " + houseNumber);
	    System.out.println("localNumber = " + localNumber);
		
	    if(zipCode.isEmpty() || city.isEmpty() || houseNumber.isEmpty() || street.isEmpty()){
	    	System.out.println("zipCode, city, street or houseNumber parameters are not filled up, redirect to /index.jsp");
            httpResponse.sendRedirect("/index.jsp");	
	    }
	    
		chain.doFilter(request, response);	
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
