package org.softserveinc.java_be_genai_plgrnd.configs;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class RequestLoggingFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(RequestLoggingFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

        long startTime = System.currentTimeMillis();
        
        try {
            filterChain.doFilter(requestWrapper, responseWrapper);
        } finally {
            long duration = System.currentTimeMillis() - startTime;
            logRequest(requestWrapper, responseWrapper, duration);
            responseWrapper.copyBodyToResponse();
        }
    }

    private void logRequest(ContentCachingRequestWrapper request, ContentCachingResponseWrapper response, long duration) {
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String query = request.getQueryString();
        int status = response.getStatus();
        
        String fullPath = query != null ? uri + "?" + query : uri;
        
        String requestBody = "";
        if ("POST".equals(method) || "PUT".equals(method) || "PATCH".equals(method)) {
            byte[] content = request.getContentAsByteArray();
            if (content.length > 0) {
                requestBody = new String(content, StandardCharsets.UTF_8);
                requestBody = requestBody.replaceAll("\"password\"\\s*:\\s*\"[^\"]*\"", "\"password\":\"***\"");
                requestBody = requestBody.replaceAll("\"password_confirmation\"\\s*:\\s*\"[^\"]*\"", "\"password_confirmation\":\"***\"");
            }
        }
        
        String responseBody = "";
        byte[] responseContent = response.getContentAsByteArray();
        if (responseContent.length > 0 && responseContent.length < 1000) {
            responseBody = new String(responseContent, StandardCharsets.UTF_8);
        } else if (responseContent.length >= 1000) {
            responseBody = "[" + responseContent.length + " bytes]";
        }
        String statusIcon = status >= 200 && status < 300 ? "✓" : status >= 400 ? "✗" : "→";
        
        log.info("{} {} {} {} [{}ms]", statusIcon, method, fullPath, status, duration);
        
        if (!requestBody.isEmpty()) {
            log.debug("  Request:  {}", requestBody);
        }
        if (!responseBody.isEmpty() && status >= 400) {
            log.debug("  Response: {}", responseBody);
        }
    }
}
