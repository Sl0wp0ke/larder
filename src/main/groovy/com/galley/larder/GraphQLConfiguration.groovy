package com.galley.larder

import com.galley.larder.api.graphql.resolver.Query
import graphql.GraphQL
import graphql.schema.GraphQLSchema
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GraphQLConfiguration {
    @Autowired
    private Query query;

    @Bean
    public GraphQL graphQL() {
        return GraphQL.newGraphQL()
    }

    @Bean
    public GraphQLSchema graphQLSchema() {
        return
    }

}
