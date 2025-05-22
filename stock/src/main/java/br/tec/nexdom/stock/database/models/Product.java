package br.tec.nexdom.stock.database.models;

import br.tec.nexdom.stock.core.entities.ProductType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @Enumerated(EnumType.STRING)
    private ProductType type;
    @Column(name="supplier_value")
    private BigDecimal supplierValue;
    private Long stock;
    @OneToMany(mappedBy = "product")
    private List<StockOperation> operations;

    public List<StockOperation> getOperations() {
        return operations;
    }

    public void setOperations(List<StockOperation> operations) {
        this.operations = operations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public BigDecimal getSupplierValue() {
        return supplierValue;
    }

    public void setSupplierValue(BigDecimal supplierValue) {
        this.supplierValue = supplierValue;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }
}
