package com.example.designdemo.creation.builder;

import lombok.Data;

@Data
public class Student {

    private Integer id;
    private String name;
    private Integer age;

    public Student(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
    }

    public static class Builder{
        private Integer id;
        private String name;
        private Integer age;

        public Builder id(Integer id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder age(Integer age){
            this.age = age;
            return this;
        }

        public Student build(){
            return new Student(this);
        }
    }
}
