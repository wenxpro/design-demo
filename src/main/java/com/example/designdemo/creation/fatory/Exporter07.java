package com.example.designdemo.creation.fatory;

import lombok.Data;

@Data
public class Exporter07 implements Exporter{
    @Override
    public void out() {
        System.out.println("Exporter07 out");
    }
}
