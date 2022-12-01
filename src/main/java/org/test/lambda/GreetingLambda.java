package org.test.lambda;

import com.amazonaws.services.lambda.runtime.LambdaLogger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GreetingLambda implements RequestHandler<Object, String> {
    private LambdaLogger log = null;
    private String response = null;

    @Override
    public String handleRequest(Object input, Context context) {
        log = context.getLogger();
        try {
            log.log(String.format("Called 'handleRequest': %s\n", new ObjectMapper().writeValueAsString(input)));
            generateResponse(input);
            return response;
        } catch (Exception e) {
            log.log(String.format("error: %s\n", e.getMessage()));
            return null;
        }
    }

    public void generateResponse(Object input) {
        log.log("Called 'generateResponse'\n");
        response = "Hello!";
    }
}
