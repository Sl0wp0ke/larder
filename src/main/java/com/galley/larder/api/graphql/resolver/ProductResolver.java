package com.galley.larder.api.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.galley.larder.excaptions.ProductNotFoundException;
import com.galley.larder.models.Product;
import com.galley.larder.repositories.ProductRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class ProductResolver implements GraphQLQueryResolver {
    @Autowired
    private ProductRepository productRepository;

    public Product getProdact(long barcode) {
        Product product = productRepository.findByBarcode(barcode);
        if (product != null) {
            return product;
        }

        String url = "http://ean13.info/" + barcode + ".htm";
        try {
            Document document = Jsoup.connect(url).get();
            Elements elements = document.getElementsByAttributeValue("class", "item-card");
            Element element = elements.get(0);
            Elements h1 = element.getElementsByTag("h1");
            Element nameNode = h1.get(0);
            product = new Product();
            product.setName(nameNode.text());
            if (product != null) {
                product.setBarcode(barcode);
                productRepository.save(product);
                return product;
            }
            return product;
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new ProductNotFoundException();
    }
}
