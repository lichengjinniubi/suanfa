package com.example.demo.leetcode.linklist;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommonSingleNode {

    private String value;


    private CommonSingleNode next;

    private CommonSingleNode random;

    public CommonSingleNode(String value) {
        this.value = value;
    }
}
