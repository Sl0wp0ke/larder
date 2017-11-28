package com.galley.larder.api.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.galley.larder.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Query implements GraphQLRootResolver {
    public List<User> getAllUsers() {
        return new ArrayList<User>();
    }
}
