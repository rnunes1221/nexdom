package br.tec.nexdom.stock.services;

import br.tec.nexdom.stock.core.entities.Product;
import br.tec.nexdom.stock.core.exceptions.NotFoundException;
import br.tec.nexdom.stock.database.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product find(Long id) throws NotFoundException {
        return this.repository.find(id);
    }

    public List<Product> list() {
        return this.repository.list();
    }

    @Transactional
    public void create(Product product) {
        this.repository.create(product);
    }

    @Transactional
    public void update(Long id, Product product) throws NotFoundException {
        this.repository.update(id, product);
    }

    @Transactional
    public void delete(Long id) throws NotFoundException {
       this.repository.delete(id);
    }

    @Transactional
    public void updateStock(Long id, Long amount) throws NotFoundException {
        this.repository.updateStock(id, amount);
    }
}
