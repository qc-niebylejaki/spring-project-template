package pl.qc.spring.rest.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        // Get the request URI
        log.info("Request URL: {}", httpRequest.getRequestURI());
        log.info("HTTP Method: {}", httpRequest.getMethod());
        log.info("HTTP Headers:");
        httpRequest.getHeaderNames()
                .asIterator()
                .forEachRemaining(headerName -> log.info(headerName + ": " + httpRequest.getHeader(headerName)));

        filterChain.doFilter(servletRequest, servletResponse);
    }
}

//public class LoggingFilter implements ContainerRequestFilter {
//
//    @Override
//    public void filter(ContainerRequestContext requestContext) {
//        log.info("Request URL: {}", requestContext.getUriInfo().getRequestUri());
//        log.info("HTTP Method: {}", requestContext.getMethod());
//        log.info("Headers: {}", requestContext.getHeaders());
//    }
//}