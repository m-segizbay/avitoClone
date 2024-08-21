package kz.segizbay.buysell.Services;

import kz.segizbay.buysell.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<Product>();
    private Long ID = 0l;

    {
        products.add(new Product( ++ID,"PlayStation 5", "Simple", 250_000, "Almaty", "Thomas"));
        products.add(new Product(++ID, "Iphone 11", "Simple", 150_000, "Almaty", "John"));
    }

    public List<Product> getProducts() {
        return products;
    }

    public void saveProduct(Product product) {
        products.add(product);
        product.setId(ID++);
    }

    public void deleteProduct(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    public Product getProductById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .get();
    }
}
