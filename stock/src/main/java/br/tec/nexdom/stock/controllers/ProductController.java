package br.tec.nexdom.stock.controllers;

import br.tec.nexdom.stock.core.entities.Product;
import br.tec.nexdom.stock.core.entities.ProductType;
import br.tec.nexdom.stock.core.exceptions.NotFoundException;
import br.tec.nexdom.stock.requests.ProductRequest;
import br.tec.nexdom.stock.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController extends BaseController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> list(){
        var list = this.productService.list();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id) throws NotFoundException {
        var product = this.productService.find(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ProductRequest request){
        var entity = request.toEntity();
        this.productService.create(entity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody ProductRequest request) throws NotFoundException {
        var entity = request.toEntity();
        this.productService.update(id, entity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws NotFoundException {
        this.productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
