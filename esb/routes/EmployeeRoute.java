package routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:getEmployees")
            .to("http://localhost:8081/employees")
            .log("Employees Fetched: ${body}");
    }
}
