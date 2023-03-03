package com.example.demo1;

import jakarta.servlet.annotation.*;
import web.controller.HttpHandlerGeneric;
import web.urlmapping.Url;

import java.io.IOException;

@WebServlet(name = "helloServlet", value = "/hello-servlet/*")
public class Hello extends HttpHandlerGeneric {

    @Url(url = "test")
    public void test() throws IOException {
        getHttpServletResponse().getWriter().println("Mety");
    }
}