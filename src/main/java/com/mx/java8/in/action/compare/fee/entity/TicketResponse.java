package com.mx.java8.in.action.compare.fee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class TicketResponse {
    private Header header;
    private Content content;
}
