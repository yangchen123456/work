package com.bh.jdbc.pojo;

public class Student {
    private Integer id;
    private String branch_name;
    private String location;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", branch_name='" + branch_name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
