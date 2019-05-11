package com.example.jobcard;

public class Customers {

    private String customerId;
    private String customerName;
    private String phoneNumber;
    private String fault;
    private String machineModel;
    private String specs;


    public Customers(){

    }

    public Customers(String customerId, String customerName, String phoneNumber,String fault, String machineModel, String specs) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.fault = fault;
        this.machineModel = machineModel;
        this.specs = specs;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFault() {
        return fault;
    }

    public String getMachineModel() {
        return machineModel;
    }

    public String getSpecs() {
        return specs;
    }
}
