package com.example.dell.lianxi.bean;

import java.util.List;

public class Two {
    private List<One> result;

    public Two(List<One> result) {
        this.result = result;
    }

    public List<One> getResult() {
        return result;
    }

    public void setResult(List<One> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Two{" +
                "result=" + result +
                '}';
    }
}
