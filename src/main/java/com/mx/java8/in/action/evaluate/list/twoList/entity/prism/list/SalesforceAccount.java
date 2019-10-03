package com.mx.java8.in.action.evaluate.list.twoList.entity.prism.list;

import com.mx.java8.in.action.evaluate.list.twoList.util.MapUtil;
import java.util.LinkedHashMap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SalesforceAccount {
    private Attribute attributes;
    private String name;
    private String website;
    private String tour_Code__c;
    private String billingStreet;
    private String billingCity;
    private String billingState;
    private String billingPostalCode;
    private String billingCountry;
    private String level__c;
    private String id;
    private Contract contract;
    private String ticket_Designator__c;
    private String company_ID__c;
    
    public SalesforceAccount(LinkedHashMap map) {
        attributes = new Attribute(MapUtil.getNode(map, "attributes"));
        this.name = MapUtil.getValue(map, "Name");
        this.website = MapUtil.getValue(map, "Website");
        this.tour_Code__c = MapUtil.getValue(map, "Tour_Code__c");
        this.billingStreet = MapUtil.getValue(map, "BillingStreet");
        this.billingCity = MapUtil.getValue(map, "BillingCity");
        this.billingState = MapUtil.getValue(map, "BillingState");
        this.billingPostalCode = MapUtil.getValue(map, "BillingPostalCode");
        this.billingCountry = MapUtil.getValue(map, "BillingCountry");
        this.level__c = MapUtil.getValue(map, "Level__c");
        this.id = MapUtil.getValue(map, "Id");
        this.contract = new Contract(MapUtil.getNode(map, "Contracts"));
        this.ticket_Designator__c = MapUtil.getValue(map, "Ticket_Designator__c");
        this.company_ID__c = MapUtil.getValue(map, "Company_ID__c");
    }
}
