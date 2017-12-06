package com.galley.larder.api.graphql.resolver;

//import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.galley.larder.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
//public class Query implements GraphQLRootResolver {
public class Query implements GraphQLQueryResolver {
    public List<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setName("gregory");
        user.setLastName("leps");
        user.setSex(false);
        users.add(user);
        return users;
    }
}
