package br.tec.nexdom.stock.services;

import br.tec.nexdom.stock.core.entities.Product;
import br.tec.nexdom.stock.database.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product find(Long id){
        var model = this.repository.findById(id).orElse(null);

    }
}
