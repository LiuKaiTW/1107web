

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class FilterA
 */
@WebFilter(filterName = "FilterA", urlPatterns = {"/FAServlet","/product.jsp"})
public class FilterA extends HttpFilter implements Filter {
	FilterConfig filterConfig;
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Pre-Process Start");
        System.out.println("Pre-Process==>"+filterConfig.getFilterName());
        long start=System.currentTimeMillis();
		chain.doFilter(request, response);
		 long end=System.currentTimeMillis();
	     System.out.println("執行時間:"+(end-start)+"ms");
	     System.out.println("Post-Process==>"+filterConfig.getFilterName());
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig = fConfig;
	}
    public FilterA() {
        super();
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		// TODO Auto-generated method stub
	}




}
