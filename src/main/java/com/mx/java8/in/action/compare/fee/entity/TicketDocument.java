package com.mx.java8.in.action.compare.fee.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TicketDocument {
    private float baseFareAmount;
    private String rloc;
    private String ticketNumber;
    private List<TicketCoupon> ticketCoupon;
}
