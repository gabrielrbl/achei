package filter;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

@WebFilter(filterName="encodingFilter", urlPatterns={"/*"})
public class EncodingFilter implements Filter {
	public EncodingFilter() { }

	@Override
	public void init(FilterConfig fConfig) throws ServletException { }

	@Override
	public void destroy() { }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response);
	}
}