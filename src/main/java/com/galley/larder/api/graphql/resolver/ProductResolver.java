package com.galley.larder.api.graphql.resolver;

//import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.galley.larder.excaptions.ProductNotFoundException;
import com.galley.larder.models.Product;
import org.springframework.stereotype.Component;

@Component
//public class Query implements GraphQLRootResolver {
public class ProductResolver implements GraphQLQueryResolver {
    public Product getProdact(long barcode) {
//        Product product = new Product();
//        product.setName("loshara");
//        return product;
        throw new ProductNotFoundException();
    }
}
