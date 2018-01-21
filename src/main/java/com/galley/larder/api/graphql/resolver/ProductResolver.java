package com.galley.larder.api.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.galley.larder.excaptions.ProductNotFoundException;
import com.galley.larder.models.Product;
import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Component
public class ProductResolver implements GraphQLQueryResolver {
    public Product getProdact(long barcode) {
        HttpClient httpClient = HttpClient.newHttpClient();

        URI uri = null;
        try {
            uri = new URI("http://ean13.info/4820017000277.htm");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandler.asString());
            Product product = new Product();
            product.setName(response.body());
            return product;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        throw new ProductNotFoundException();
    }
}
