package com.example.demo.models;

public class MotorhomeDTO {
    private int motorhomeId;
    private String brand;
    private String model;
    private String type;
    private String description;
    private int price;

    public MotorhomeDTO(){

    }

    public MotorhomeDTO(int motorhomeId, String brand, String model, String type, String description, int price) {
        this.motorhomeId = motorhomeId;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.description = description;
        this.price = price;
    }

    public int getMotorhomeId() {
        return motorhomeId;
    }

    public void setMotorhomeId(int motorhomeId) {
        this.motorhomeId = motorhomeId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MotorhomeDTO{" +
                "motorhomeId=" + motorhomeId +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
