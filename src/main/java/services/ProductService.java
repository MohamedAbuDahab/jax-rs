package services;

import model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAll();
    Optional<Product> getById(int id);
   List< Product> getByName(String name);
    void add(Product product);
    void updatep(Product product);
    void deletep(int id);
}
