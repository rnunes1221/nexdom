package br.tec.nexdom.stock.database.repositories;

import br.tec.nexdom.stock.core.entities.ProductType;
import br.tec.nexdom.stock.core.exceptions.NotFoundException;
import br.tec.nexdom.stock.database.models.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private final EntityManager entityManager;

    public ProductRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(br.tec.nexdom.stock.core.entities.Product entity) {
        var model = new Product(entity);
        this.entityManager.persist(model);
    }

    public List<br.tec.nexdom.stock.core.entities.Product> list() {
        return this.entityManager.createQuery("SELECT p FROM Product p", Product.class)
                .getResultStream()
                .map(p -> new br.tec.nexdom.stock.core.entities.Product(
                        p.getId(),
                        p.getDescription(),
                        ProductType.valueOf(p.getType().toString()),
                        p.getSupplierValue(),
                        p.getStock()
                ))
                .toList();
    }

    public br.tec.nexdom.stock.core.entities.Product find(Long id) throws NotFoundException {
        var result = findProductById(id);
        return result.toEntity();
    }

    public void update(Long id, br.tec.nexdom.stock.core.entities.Product entity) throws NotFoundException {
        var result = findProductById(id);
        result.setDescription(entity.description());
        result.setType(br.tec.nexdom.stock.database.models.ProductType.valueOf(entity.type().toString()));
        result.setStock(entity.stock());
        result.setSupplierValue(entity.supplierValue());
        this.entityManager.merge(result);
    }

    public void delete(Long id) throws NotFoundException {
        var result = findProductById(id);
        this.entityManager.remove(result);
    }

    public void updateStock(Long id, Long amount) throws NotFoundException {
        var result = findProductById(id);
        result.setStock(amount);
        this.entityManager.merge(result);
    }

    public Product findProductById(Long id) throws NotFoundException {
        var model = this.entityManager.find(Product.class, id);
        return Optional.ofNullable(model).orElseThrow(() -> new NotFoundException("Product not found"));
    }
}
