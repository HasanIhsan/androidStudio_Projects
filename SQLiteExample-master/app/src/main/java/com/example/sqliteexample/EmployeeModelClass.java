package com.example.sqliteexample;

public class EmployeeModelClass {

    Integer id;
    String name;
    String email;
    String date = "asdfsdfds";

    public EmployeeModelClass(String name, String email, String date) {
        this.name = name;
        this.email = email;
        this.date = date;
    }

    public EmployeeModelClass(Integer id, String name, String email, String date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
