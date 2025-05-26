package br.tec.nexdom.stock.core.entities;

public record CurrentStock (
        Long id,
        String description,
        Long stock,
        Long sales
) {}
