package com.galley.larder.api.graphql.resolver;

import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;

import java.util.List;

public class DefaultErrorHandler implements GraphQLErrorHandler {
    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> errors) {
        return errors;
    }
}
