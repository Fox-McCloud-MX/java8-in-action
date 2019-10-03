package com.mx.java8.in.action.evaluate.list.twoList.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public interface Constants {
    
    public static String ACTIVE = "Active";
    public static String N = "N";
    public static String Y = "Y";
    public static String EMPTY = "";
    
    public int CONTRACT_ID_INDEX = 0;
    public int TICKET_DESIGNATOR_INDEX = 1;
    public int COMPANY_NAME_INDEX = 2;
    public int COMPANY_ID_INDEX = 3;

    public static List<String> HEADERS = Arrays.asList(
            "ContractID",
            "ContractName",
            "ContractBeginDate",
            "ContractEndDate",
            "ContractStatus",
            "AccountManager",
            "ContractType",
            "LegalNotification",
            "CompanyLegalNotification",
            "CompanyName",
            "LegalName",
            "Address",
            "City",
            "StateProvince",
            "ZipCode",
            "Country",
            "WebSite",
            "CompanyID",
            "TourCode",
            "TicketDesignator",
            "TravelBeginDate",
            "TravelEndDate",
            "Carrier",
            "IssueBeginDate",
            "IssueEndDate",
            "ContractTerm",
            "Evaluation",
            "Operation"
    );
    
    public HashMap<String, Integer> EVALUATION = new LinkedHashMap(){{
        this.put("NNNN", 1);
        this.put("NNNY", 2);
        this.put("NNYN", 3);
        this.put("NNYY", 4);
        this.put("NYYY", 5);
        this.put("NYYN", 6);
        this.put("YNNN", 7);
        this.put("YYYN", 8);
        this.put("YYNN", 9);
        this.put("YYNY", 10);
        this.put("YYYY", 11);
        this.put("YYYN", 12);
    }};
    
    public static int getEvaluation(String eval) {
        return (EVALUATION.containsKey(eval)) ? EVALUATION.get(eval) : -1;
    }
}
