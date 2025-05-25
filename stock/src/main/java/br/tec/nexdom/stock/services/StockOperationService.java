package br.tec.nexdom.stock.services;

import br.tec.nexdom.stock.core.entities.Product;
import br.tec.nexdom.stock.core.entities.StockOperation;
import br.tec.nexdom.stock.core.entities.StockOperationType;
import br.tec.nexdom.stock.core.exceptions.NotFoundException;
import br.tec.nexdom.stock.core.exceptions.ProductOutOfStockException;
import br.tec.nexdom.stock.database.repositories.StockOperationRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StockOperationService {

    private final ProductService productService;
    private final StockOperationRepository stockOperationRepository;

    public StockOperationService(ProductService productService, StockOperationRepository stockOperationRepository) {
        this.productService = productService;
        this.stockOperationRepository = stockOperationRepository;
    }

    @Transactional
    public void create(StockOperation stockOperation) throws NotFoundException, ProductOutOfStockException {
        var product = this.productService.find(stockOperation.productId());
        this.productService.updateStock(product.id(), getNewStockAmount(product, stockOperation));
        this.stockOperationRepository.create(stockOperation);
    }

    private Long getNewStockAmount(Product product, StockOperation stockOperation) throws ProductOutOfStockException {
        Long newStockAmount;
        if (StockOperationType.OUT.equals(stockOperation.type())) {
            product.checkStock(stockOperation.amount());
            newStockAmount = product.decrementStock(stockOperation.amount());
            return newStockAmount;
        }
        newStockAmount = product.incrementStock(stockOperation.amount());
        return newStockAmount;
    }
}
