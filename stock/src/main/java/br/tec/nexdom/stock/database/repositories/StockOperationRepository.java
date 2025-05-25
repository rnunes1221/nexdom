package br.tec.nexdom.stock.database.repositories;

import br.tec.nexdom.stock.core.exceptions.NotFoundException;
import br.tec.nexdom.stock.database.models.StockOperation;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class StockOperationRepository {

    private final EntityManager entityManager;
    private final ProductRepository productRepository;

    public StockOperationRepository(EntityManager entityManager, ProductRepository productRepository) {
        this.entityManager = entityManager;
        this.productRepository = productRepository;
    }

    public void create(br.tec.nexdom.stock.core.entities.StockOperation stockOperation) throws NotFoundException {
        var product = this.productRepository.findProductById(stockOperation.productId());
        var model = new StockOperation(stockOperation, product);
        this.entityManager.persist(model);
    }
}
