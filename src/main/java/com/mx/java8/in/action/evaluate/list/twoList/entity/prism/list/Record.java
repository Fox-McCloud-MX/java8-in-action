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
public class Record {
    private Attribute attributes;
    private String accountId;
    private String id;
    private String contract_ID__c;
    private String name;
    private String startDate;
    private String contract_End_Date__c;
    private String status;
    private String account_Manager__c;
    private String tipo__c;
    private String legal_Notification__c;
    private String company_Legal_Notification__c;
    private String travel_Begin_Date__c;
    private String travel_End_Date__c;
    private String carrier__c;
    private String issue_Begin_Date__c;
    private String issue_End_Date__c;
    
    
    public Record(LinkedHashMap map) {
        this.attributes = new Attribute(MapUtil.getNode(map, "attributes"));
        this.accountId = MapUtil.getValue(map, "AccountId");
        this.id = MapUtil.getValue(map, "Id"); 
        this.contract_ID__c = MapUtil.getValue(map, "Contract_ID__c"); 
        this.name = MapUtil.getValue(map, "Name"); 
        this.startDate = MapUtil.getValue(map, "StartDate"); 
        this.contract_End_Date__c = MapUtil.getValue(map, "Contract_End_Date__c"); 
        this.status = MapUtil.getValue(map, "Status"); 
        this.account_Manager__c = MapUtil.getValue(map, "Account_Manager__c"); 
        this.tipo__c = MapUtil.getValue(map, "Tipo__c"); 
        this.legal_Notification__c = MapUtil.getValue(map, "Legal_Notification__c"); 
        this.company_Legal_Notification__c = MapUtil.getValue(map, "Company_Legal_Notification__c"); 
        this.travel_Begin_Date__c = MapUtil.getValue(map, "Travel_Begin_Date__c"); 
        this.travel_End_Date__c = MapUtil.getValue(map, "Travel_End_Date__c"); 
        this.carrier__c = MapUtil.getValue(map, "Carrier__c"); 
        this.issue_Begin_Date__c = MapUtil.getValue(map, "Issue_Begin_Date__c"); 
        this.issue_End_Date__c = MapUtil.getValue(map, "Issue_End_Date__c"); 
        
    }
}
