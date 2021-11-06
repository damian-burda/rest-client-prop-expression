package org.acme;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class ClientFilter implements ClientRequestFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientFilter.class);

    @Override
    public void filter(ClientRequestContext requestContext) {
        if (requestContext != null) {
            LOGGER.info("Request URI: {}", requestContext.getUri());
        }
    }
}
