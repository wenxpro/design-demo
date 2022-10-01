package com.example.designdemo.creation.fatory;

import lombok.Data;

@Data
public class Exporter03 implements Exporter{
    @Override
    public void out() {
        System.out.println("Exporter03 out");
    }
}
