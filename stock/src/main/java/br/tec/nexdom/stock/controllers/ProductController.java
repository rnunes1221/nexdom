package br.tec.nexdom.stock.controllers;

import br.tec.nexdom.stock.core.entities.Product;
import br.tec.nexdom.stock.core.entities.ProductType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public String list(){
        return "oi";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id){
        return ResponseEntity.ok(new Product(
                id,
                "description",
                ProductType.ELECTRONIC,
                BigDecimal.valueOf(10),
                1L
                )) ;
    }

    @PostMapping
    public String create(){
        return "oi";
    }

    @PutMapping
    public String update(){
        return "oi";
    }

    @DeleteMapping
    public String delete(){
        return "oi";
    }

}
