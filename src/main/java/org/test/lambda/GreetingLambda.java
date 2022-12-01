package org.test.lambda;

import org.jboss.logging.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GreetingLambda implements RequestHandler<Object, String> {
    private static final Logger log = Logger.getLogger(GreetingLambda.class);
    private String response = null;

    @Override
    public String handleRequest(Object input, Context context) {
        log.info("Called 'handleReques'");
        generateResponse(input);
        return response;
    }

    public void generateResponse(Object input) {
        log.info("Called 'generateResponse'");
        response = "Hello!";
    }
}
