package com.sg.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Order
{
    private Integer orderNumber;
    private LocalDate localDate;
    private String customerName;
    private State state;
    private Product productType;
    private BigDecimal area;

    public Order(Integer orderNumber, LocalDate localDate, String customerName, State state, Product productType, BigDecimal area) {
        this.orderNumber = orderNumber;
        this.localDate = localDate;
        this.customerName = customerName;
        this.state = state;
        this.productType = productType;
        this.area = area;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Product getProductType() {
        return productType;
    }

    public void setProductType(Product productType) {
        this.productType = productType;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", localDate=" + localDate +
                ", customerName='" + customerName + '\'' +
                ", state=" + state +
                ", productType=" + productType +
                ", area=" + area +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (!orderNumber.equals(order.orderNumber)) return false;
        return localDate.equals(order.localDate);
    }

    @Override
    public int hashCode() {
        int result = orderNumber.hashCode();
        result = 31 * result + localDate.hashCode();
        return result;
    }
}
