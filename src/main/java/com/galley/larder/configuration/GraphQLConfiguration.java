package com.galley.larder.configuration;

import com.galley.larder.api.graphql.resolver.ProductResolver;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.coxautodev.graphql.tools.SchemaParser.newParser;

@Configuration
public class GraphQLConfiguration {
    @Autowired
    private ProductResolver productResolver;

    @Bean
    public GraphQL graphQL() {
        return GraphQL.newGraphQL(graphQLSchema())
                .build();
    }

    @Bean
    public GraphQLSchema graphQLSchema() {
        return newParser()
                .file("schema.graphqls")
                .resolvers(productResolver)
                .build()
                .makeExecutableSchema();
    }
}
