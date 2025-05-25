package br.tec.nexdom.stock.core.exceptions;

public class ProductOutOfStockException extends CoreException {
    public ProductOutOfStockException() {
        super("Product out of stock");
    }
}
