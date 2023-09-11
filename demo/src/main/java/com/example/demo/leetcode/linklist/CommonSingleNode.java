package com.example.demo.leetcode.linklist;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommonSingleNode {

    private String value;


    private CommonSingleNode next;

    private CommonSingleNode random;

    private Boolean isTail = false;

    public CommonSingleNode(String value) {
        this.value = value;
    }

    public CommonSingleNode(String value, boolean isTail) {
        this.value = value;
        this.isTail = isTail;
    }


    @Override
    public String toString() {
        return "CommonSingleNode [value=" + value + ", isTail =" + isTail  + "]";
    }
}
