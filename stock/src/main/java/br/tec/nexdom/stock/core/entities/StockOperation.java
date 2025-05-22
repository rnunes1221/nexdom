package br.tec.nexdom.stock.core.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public record StockOperation(
        Product product,
        StockOperationType type,
        BigDecimal value,
        LocalDate date,
        Long amount
) {}
