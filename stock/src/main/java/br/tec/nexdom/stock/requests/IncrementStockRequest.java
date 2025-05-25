package br.tec.nexdom.stock.requests;

import br.tec.nexdom.stock.core.entities.StockOperation;
import br.tec.nexdom.stock.core.entities.StockOperationType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.time.LocalDate;

public record IncrementStockRequest(
    @NotNull(message = "The field productId is required")
    Long productId,
    @NotNull(message = "The field amount is required")
    @Positive(message = "The value must be greater than 0")
    Long amount
) {
    public StockOperation toEntity() {
        return new StockOperation(
                this.productId,
                StockOperationType.IN,
                BigDecimal.valueOf(0),
                LocalDate.now(),
                this.amount
        );
    }
}
