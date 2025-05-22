package br.tec.nexdom.stock.database.repositories;

import br.tec.nexdom.stock.database.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
