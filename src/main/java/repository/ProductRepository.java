package repository;

import model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();
    Optional<Product> findById(int id);
    List<Product> findByName(String name);
    void add(Product product);
    void update(Product product);
    void delete(int id);
}
