package com.mx.java8.in.action.compare.fee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class BusinessRule {
    private String origin;
    private String destination;
    private String fareBasis;
    private int minimumFee;
    private int maximumFee;
    private String currency;
    private String airline;
}
