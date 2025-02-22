package com.example.esb.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:getEmployees")
            .to("http://localhost:8081/employees?bridgeEndpoint=true");

        from("direct:getEmployeeById")
            .toD("http://localhost:8081/employees/${header.id}?bridgeEndpoint=true");

        from("direct:createEmployee")
            .to("http://localhost:8081/employees?bridgeEndpoint=true&httpMethod=POST");

        from("direct:deleteEmployee")
            .toD("http://localhost:8081/employees/${header.id}?bridgeEndpoint=true&httpMethod=DELETE");
    }
}
