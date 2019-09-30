package com.mx.java8.in.action.compare.fee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Header {
    private String message;
    private String dateSent;
}
