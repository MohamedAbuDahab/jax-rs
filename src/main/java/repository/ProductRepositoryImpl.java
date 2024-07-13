package repository;

import jakarta.ejb.Singleton;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
public class ProductRepositoryImpl implements ProductRepository{

    private final List<Product> products = new ArrayList<>();

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Optional<Product> findById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findAny();
    }


    @Override
    public List< Product> findByName(String name) {
        return  products.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    @Override
    public void add(Product product) {
        products.add(product);

    }

    @Override
    public void update(Product product) {
        for (Product product1 : products) {
            if (product1.getId()==(product.getId())) {
                product1.setName(product.getName());
                product1.setPrice(product.getPrice());
                product1.setQuantity(product.getQuantity());
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        products.removeIf(p -> p.getId()==(id));
    }
}
