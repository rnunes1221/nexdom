package br.tec.nexdom.stock.core.entities;

import java.math.BigDecimal;

public record Product(
        Long id,
        String description,
        ProductType type,
        BigDecimal supplierValue,
        Long stock
) {}
