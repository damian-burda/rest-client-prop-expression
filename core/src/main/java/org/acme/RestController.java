package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Path;

@ApplicationScoped
@Path("")
public class RestController implements RestService{
    @Override
    public String getHello() {
        return "Hello world";
    }
}
