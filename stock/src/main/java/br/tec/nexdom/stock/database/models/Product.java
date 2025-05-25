package br.tec.nexdom.stock.database.models;

import br.tec.nexdom.stock.database.models.ProductType;
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
    @Column(name="product_type")
    private ProductType type;
    @Column(name="supplier_value")
    private BigDecimal supplierValue;
    private Long stock;
    @OneToMany(mappedBy = "product")
    private List<StockOperation> operations;

    public Product() {}

    public Product(br.tec.nexdom.stock.core.entities.Product entity) {
        this.description = entity.description();
        this.type = ProductType.valueOf(entity.type().toString());
        this.supplierValue = entity.supplierValue();
        this.stock = entity.stock();
    }

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

    public br.tec.nexdom.stock.core.entities.Product toEntity() {
        return new br.tec.nexdom.stock.core.entities.Product(
                this.id,
                this.description,
                br.tec.nexdom.stock.core.entities.ProductType.valueOf(this.type.toString()),
                this.supplierValue,
                this.stock
        );
    }
}
