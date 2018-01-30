package com.galley.larder.repositories;

import com.galley.larder.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, Integer> {
    public Product findByBarcode(long barcode);

}
