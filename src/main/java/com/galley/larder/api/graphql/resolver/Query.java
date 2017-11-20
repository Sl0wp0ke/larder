package com.galley.larder.api.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.galley.larder.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
    public List<User> allUser() {
        return new ArrayList<User>();
    }
}
