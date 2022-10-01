package com.example.designdemo.creation.prototype;

import lombok.Data;
import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

@Data
public class Employee1 implements Cloneable, Serializable {
    private Integer id;
    private String name;
    private Integer age;

    public Employee1(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return SerializationUtils.clone(this);
    }
}
