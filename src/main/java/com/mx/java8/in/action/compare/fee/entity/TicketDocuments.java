package com.mx.java8.in.action.compare.fee.entity;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class TicketDocuments {
    private String count;
    private TicketDocument ticketDocument;
}
