package com.csr.model;

public class JwtRequest {
    String employeeId;
    String password;

    public JwtRequest() {
    }

    public JwtRequest(String employeeId, String password) {
        this.employeeId = employeeId;
        this.password = password;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
