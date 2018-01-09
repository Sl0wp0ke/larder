package com.galley.larder.excaptions;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;

public class ProductNotFoundException extends RuntimeException implements GraphQLError {
    public ProductNotFoundException() {
        super("ololo");
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}
