package pl.qc.spring.rest.filter;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class LoggingFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) {
        log.info("Request URL: {}", requestContext.getUriInfo().getRequestUri());
        log.info("HTTP Method: {}", requestContext.getMethod());
        log.info("Headers: {}", requestContext.getHeaders());
    }
}