package com.example.jetcoffee;

public class Orders {
    private String productName;
    private String customerName;
    private String customerCell;
    private String address;
    private String orderDate;

    public Orders() {
    }

    public Orders(String productName, String customerName, String address, String orderDate) {
        this.productName = productName;
        this.customerName = customerName;
        this.address = address;
        this.orderDate = orderDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerCell() {
        return customerCell;
    }

    public void setCustomerCell(String customerCell) {
        this.customerCell = customerCell;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Orders(String productName, String customerName, String customerCell, String address, String orderDate) {
        this.productName = productName;
        this.customerName = customerName;
        this.customerCell = customerCell;
        this.address = address;
        this.orderDate = orderDate;
    }
}
