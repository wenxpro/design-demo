package com.example.designdemo.creation.prototype;

import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class Employee2 {
    private Integer id;
    private String name;
    private Integer age;

    public Employee2() {
    }

    public Employee2(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Employee2 employee2 = new Employee2();
        BeanUtils.copyProperties(this,employee2);
        return employee2;
    }
}
