package br.tec.nexdom.stock.core.entities;

import java.math.BigDecimal;

public record Profit (
        Long id,
        String description,
        Long sales,
        BigDecimal profit
) {}
