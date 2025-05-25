package br.tec.nexdom.stock.core.entities;

import br.tec.nexdom.stock.core.exceptions.ProductOutOfStockException;

import java.math.BigDecimal;

public record Product(
        Long id,
        String description,
        ProductType type,
        BigDecimal supplierValue,
        Long stock
) {
    public void checkStock(Long amount) throws ProductOutOfStockException {
        if (this.stock < amount) {
           throw new ProductOutOfStockException();
        }
    }

    public Long incrementStock(Long amount) {
        return amount + this.stock;
    }

    public Long decrementStock(Long amount) {
        return this.stock - amount;
    }
}
