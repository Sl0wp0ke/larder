package com.galley.larder.excaptions;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;

public class GeneralGraphQLException extends RuntimeException implements GraphQLError {
    private int code;

    public GeneralGraphQLException(String message, int code) {
        super(message);
        this.code = code;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
