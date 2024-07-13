package services;

import jakarta.ejb.Singleton;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import model.Product;
import repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Singleton
public class ProductServicesImpl implements ProductService{

    @Inject
    private ProductRepository productRepository; // Inject the ProductRepository

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List< Product> getByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public void updatep(Product product) {
        productRepository.update(product);
    }

    @Override
    public void deletep(int id) {
        productRepository.delete(id);
    }
}
