package com.galley.larder.api.graphql.resolver;

import com.galley.larder.excaptions.GeneralGraphQLException;
import com.galley.larder.models.CustomGraphQLError;
import graphql.GraphQLError;
import graphql.servlet.GenericGraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultErrorHandler implements GraphQLErrorHandler {
    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> errors) {
        List<GraphQLError> clientErrors = errors.stream()
                .filter(this::IsGeneralGraphQLException)
                .collect(Collectors.toList());

        if (clientErrors.size() < errors.size()) {
            clientErrors.add(new CustomGraphQLError("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
        return clientErrors;
    }

    private boolean IsGeneralGraphQLException(GraphQLError error) {
        return error instanceof GeneralGraphQLException;
    }
}
