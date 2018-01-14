package com.galley.larder.models;

import graphql.servlet.GenericGraphQLError;

import java.util.Objects;

public class CustomGraphQLError extends GenericGraphQLError {
    private int code;

    public CustomGraphQLError(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomGraphQLError customGraphQLError = (CustomGraphQLError) o;
        return code == customGraphQLError.code;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
