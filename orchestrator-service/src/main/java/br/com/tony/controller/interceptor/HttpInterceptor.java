package br.com.tony.controller.interceptor;

import br.com.tony.domain.HeaderName;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.filter.FilterChain;
import io.micronaut.http.filter.HttpFilter;
import io.micronaut.http.netty.NettyHttpHeaders;
import org.reactivestreams.Publisher;

import java.util.UUID;

@Filter(value = "/**")
public class HttpInterceptor implements HttpFilter {

    @Override
    public Publisher<? extends HttpResponse<?>> doFilter(HttpRequest<?> request, FilterChain chain) {
        return chain.proceed(addCorrelationId(request));
    }

    private HttpRequest<?> addCorrelationId(HttpRequest<?> request) {
        String correlationId = UUID.randomUUID().toString();
        NettyHttpHeaders headers = (NettyHttpHeaders) request.getHeaders();
        headers.add(HeaderName.CORRELATION_ID_HEADER_NAME, correlationId);
        return request;
    }
}
