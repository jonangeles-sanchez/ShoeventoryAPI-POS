package com.shoeventory.posapi.DTOs;

public record ShoeDto (
        Long id,
        String manufacturer,
        String type,
        String name,
        String color,
        double size,
        int quantity,
        double price
){

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShoeDto[id=").append(id())
                .append(", manufacturer=").append(manufacturer())
                .append(", type=").append(type())
                .append(", name=").append(name())
                .append(", color=").append(color())
                .append(", size=").append(size())
                .append(", quantity=").append(quantity())
                .append(", price=").append(price());
        sb.append("]");
        return sb.toString();
    }
}
