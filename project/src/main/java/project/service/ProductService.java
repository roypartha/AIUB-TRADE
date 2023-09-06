package project.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import project.domain.Product;
import project.repository.ProductRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class ProductService {

    private Logger logger = Logger.getLogger(ProductService.class.getName());

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> list() {
        return productRepository.list();
    }
    public List<Product> postList() {
        Object loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
        String username = String.valueOf(loggedInUser);
        return productRepository.list(username);
    }

    public Product get(Long id) {
        return productRepository.get(id);
    }

    public boolean create(Product product) {
        Object loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
        product.setUsername(String.valueOf(loggedInUser));
        product.setCreatedOn(LocalDate.now());
        return productRepository.create(product);
    }

    public boolean update(Product product) {
        return productRepository.update(product);
    }

    public boolean delete(Long id) {
        return productRepository.delete(get(id));
    }
}
