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


@WebFilter("/address.jsp")
public class AdsressServicesFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String firstName = httpRequest.getParameter("firstName");
	    String surname = httpRequest.getParameter("surname");
	    String pesel = httpRequest.getParameter("pesel");
	    System.out.println("firstName = " + firstName);
	    System.out.println("surname = " + surname);
	    System.out.println("pesel = "+ pesel);
		
	    if( firstName.isEmpty() || surname.isEmpty() || pesel.isEmpty()){
	    	System.out.println("name, surname or pesel parameters are not filled up, redirect to /index.jsp");
            httpResponse.sendRedirect("/index.jsp");	
	    }
		chain.doFilter(request, response);	
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
