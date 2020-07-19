package com.company.task2;

import java.math.BigDecimal;
import java.time.Year;
import java.util.List;

public class Car {

    private String name;
    private String model;
    private BigDecimal price;
    private Year productionYear;
    private List<Manualfacturer> manualfacturerList;
    EngineType engineType;

    public Car() {
    }

    public Car(String name, String model, BigDecimal price,
               Year productionYear/*, List<Manualfacturer> manualfacturerList*/,
               EngineType engineType) {
        this.name = name;
        this.model = model;
        this.price = price;
        this.productionYear = productionYear;
//        this.manualfacturerList = manualfacturerList;
        this.engineType = engineType;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Year getProductionYear() {
        return productionYear;
    }

    public List<Manualfacturer> getManualfacturerList() {
        return manualfacturerList;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", productionYear=" + productionYear +
                ", engineType=" + engineType;
    }
}
