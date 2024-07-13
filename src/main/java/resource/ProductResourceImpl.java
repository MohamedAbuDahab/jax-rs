package resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import model.Product;
import services.ProductService;

import java.util.List;


@Path("/products")
@Produces({MediaType.APPLICATION_JSON})
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResourceImpl{
    @Inject
    private ProductService productService;

    @GET
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    @GET
    @Path("/{id}")
    public Product getProductById(@PathParam("id") int id) {
        return productService.getById(id).orElseThrow(() -> new NotFoundException("Product not found with id: " + id));
    }


    @GET
    @Path("/")
    public List<Product> searchProductsByName(@QueryParam("name") String name) {
        return productService.getByName(name);
    }

    @POST
    public Product createProduct(Product product) {
        productService.add(product);
        return product;
    }

    @PUT
    @Path("/{id}")
    public Product updateProduct(@PathParam("id") int id, Product product) {
        product.setId(id);
        productService.updatep(product);
        return product;
    }

    @DELETE
    @Path("/{id}")
    public void deleteProduct(@PathParam("id")int id) {
        productService.deletep(id);

    }
}
