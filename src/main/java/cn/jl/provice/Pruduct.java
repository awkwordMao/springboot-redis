package cn.jl.provice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Pruduct {

    private Integer id;
    private String name;
    private String capacity;

    public Pruduct() {
    }

    public Pruduct(Integer id, String name, String capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
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

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Pruduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity='" + capacity + '\'' +
                '}';
    }
}
