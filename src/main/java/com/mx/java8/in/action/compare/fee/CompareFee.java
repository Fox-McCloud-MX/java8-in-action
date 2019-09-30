package com.mx.java8.in.action.compare.fee;

import com.mx.java8.in.action.compare.fee.entity.BusinessRule;
import com.mx.java8.in.action.compare.fee.entity.TicketDocument;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CompareFee {

    private static List<BusinessRule> businessRules = Arrays.asList(
        new BusinessRule("MEX", "CUN", "NLNN6AEM", 100, 4000, "MXN", "AM"),
        new BusinessRule("MEX", "CUN", "ELNN6AEM", 220, 5000, "MXN", "AM"),
        new BusinessRule("MEX", "CUN", "TLNN6AEM", 240, 5000, "MXN", "AM"),
        new BusinessRule("MEX", "CUN", "QLNN6AEM", 300, 6000, "MXN", "AM"),
        new BusinessRule("MEX", "CUN", "LLNN6AEM", 320, 6500, "MXN", "AM"),
        new BusinessRule("MEX", "CUN", "HLNN6AEM", 340, 6500, "MXN", "AM"),
        new BusinessRule("MEX", "CUN", "KLNN6AEM", 400, 7000, "MXN", "AM"),
        new BusinessRule("MEX", "CUN", "ULNN6AEM", 420, 7000, "MXN", "AM"),
        new BusinessRule("MEX", "CUN", "QHNN0QFM", 700, 3000, "MXN", "AM"),
        new BusinessRule("JFK", "MEX", "Y9", 10000, 20000, "MXN", "AM"),
        new BusinessRule("MEX", "JFK", "Y9", 20000, 30000, "MXN", "AM")
    );

    public void compareFee(TicketDocument ticketDocument) {

        ticketDocument.getTicketCoupon().stream()
            .forEach(d -> businessRules.stream()
                .filter(c -> c.getOrigin().equals(d.getIssuedOriginAirport()))
                .filter(c -> c.getDestination().equals(d.getIssuedDestinationAirport()))
                .filter(c -> c.getFareBasis().equals(d.getFareBasisCode()))
                .forEach(f -> {
                    d.setCurrencyCode(f.getCurrency());
                    d.setAirlineCode(f.getAirline());
                    d.setFareAmmount(0);
                })
            );

        ticketDocument.getTicketCoupon().stream()
            .filter(d -> businessRules.stream()
                .anyMatch(c -> c.getOrigin().equals(d.getIssuedOriginAirport())
                    && c.getDestination().equals(d.getIssuedDestinationAirport())
                    && c.getFareBasis().equals(d.getFareBasisCode())
                    && d.getFareAmmount() > 0 && (c.getMinimumFee() > d.getFareAmmount()
                                               || c.getMaximumFee() < d.getFareAmmount())
                )
            )
            .collect(Collectors.toList());
    }
}
