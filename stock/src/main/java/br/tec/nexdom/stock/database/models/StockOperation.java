package br.tec.nexdom.stock.database.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="stock_operations")
public class StockOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    @Enumerated(EnumType.STRING)
    @Column(name = "stock_operation_type")
    private StockOperationType type;
    @Column(name = "sale_value")
    private BigDecimal value;
    @Column(name = "sale_date")
    private LocalDate date;
    private Long amount;

    public StockOperation(br.tec.nexdom.stock.core.entities.StockOperation stockOperation, Product product) {
        this.product = product;
        this.type = StockOperationType.valueOf(stockOperation.type().toString());
        this.amount = stockOperation.amount();
        this.date = stockOperation.date();
        this.value = stockOperation.value();
    }

    public StockOperation() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public StockOperationType getType() {
        return type;
    }

    public void setType(StockOperationType type) {
        this.type = type;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
