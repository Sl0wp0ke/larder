package com.galley.larder.excaptions;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import org.springframework.http.HttpStatus;

import java.util.List;

public class ProductNotFoundException extends GeneralGraphQLException {
    public ProductNotFoundException() {
        super("", HttpStatus.NOT_FOUND.value());
    }

    public ProductNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND.value());
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
