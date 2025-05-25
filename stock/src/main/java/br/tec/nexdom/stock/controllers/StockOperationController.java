package br.tec.nexdom.stock.controllers;

import br.tec.nexdom.stock.core.exceptions.NotFoundException;
import br.tec.nexdom.stock.core.exceptions.ProductOutOfStockException;
import br.tec.nexdom.stock.requests.IncrementStockRequest;
import br.tec.nexdom.stock.requests.SaleRequest;
import br.tec.nexdom.stock.services.StockOperationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock-operations")
public class StockOperationController extends BaseController {

    private final StockOperationService stockOperationService;

    public StockOperationController(StockOperationService stockOperationService) {
        this.stockOperationService = stockOperationService;
    }

    @PostMapping("/sale")
    public ResponseEntity<?> createSale(@Valid @RequestBody SaleRequest request) throws ProductOutOfStockException, NotFoundException {
        var entity = request.toEntity();
        this.stockOperationService.create(entity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/increment-stock")
    public ResponseEntity<?> incrementStock(@Valid @RequestBody IncrementStockRequest request) throws ProductOutOfStockException, NotFoundException {
        var entity = request.toEntity();
        this.stockOperationService.create(entity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
