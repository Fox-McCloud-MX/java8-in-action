package com.mx.java8.in.action.compare.fee.entity;

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
public class TicketCoupon {
    private String couponNumber;
    private String fareBasisCode;
    private String issuedDepartureDateTime;
    private String issuedDestinationAirport;
    private String issuedDestinationCity;
    private String issuedOriginAirport;
    private String issuedOriginCity;
    private String airlineCode;
    private String currencyCode;
    private double fareAmmount;
}
