package br.tec.nexdom.stock.requests;

import br.tec.nexdom.stock.core.entities.Product;
import br.tec.nexdom.stock.core.entities.ProductType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(
        @NotNull(message = "The field description is required")
        String description,
        @Pattern(regexp = "(ELECTRONIC|HOME|FURNITURE)", message = "Invalid value. Accepts ELECTRONIC|HOME|FURNITURE")
        @NotNull(message = "The field type is required")
        String type,
        @NotNull(message = "The field supplierValue is required")
        @Positive(message = "The value must be greater than 0")
        BigDecimal supplierValue,
        @NotNull(message = "The field amount is required")
        @Positive(message = "The value must be greater than 0")
        Long amount
) {
        public Product toEntity(){
                return new Product(
                        null,
                        this.description,
                        ProductType.valueOf(this.type),
                        this.supplierValue,
                        this.amount
                );
        }
}
