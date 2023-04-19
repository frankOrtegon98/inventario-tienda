package com.api.inventariotienda.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
public class Product {

    private final String name;
    private final Integer inInventory;
    private final Boolean enabled;
    private final Integer min;
    private final Integer max;
}
