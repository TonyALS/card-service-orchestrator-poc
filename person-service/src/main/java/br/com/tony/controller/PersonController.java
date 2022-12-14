package br.com.tony.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller(value = "/v1/person")
public class PersonController {
    @Get
    public HttpResponse<HttpStatus> get() {
        return HttpResponse.ok();
    }
}
