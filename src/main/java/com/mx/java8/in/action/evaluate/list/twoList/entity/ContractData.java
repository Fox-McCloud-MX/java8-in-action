package com.mx.java8.in.action.evaluate.list.twoList.entity;

import com.mx.java8.in.action.evaluate.list.twoList.util.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ContractData {
    private String contractID;
    private String contractName;
    private String contractBeginDate;
    private String contractEndDate;
    private String contractStatus;
    private String accountManager;
    private String contractType;
    private String legalNotification;
    private String companyLegalNotification;
    private String companyName;
    private String legalName;
    private String address;
    private String city;
    private String stateProvince;
    private String zipCode;
    private String country;
    private String webSite;
    private String companyID;
    private String tourCode;
    private String ticketDesignator;
    private String travelBeginDate;
    private String travelEndDate;
    private String carrier;
    private String issueBeginDate;
    private String issueEndDate;
    private String contractTerm;    
    private String[] evaluation = {"","","",""};
    
    public void setEvaluation(String eval, int position) {
        this.evaluation[position] = eval;
    }
    
    public String getEvaluation() {
        return this.evaluation[Constants.CONTRACT_ID_INDEX]
                .concat(this.evaluation[Constants.TICKET_DESIGNATOR_INDEX])
                .concat(this.evaluation[Constants.COMPANY_ID_INDEX])
                .concat(this.evaluation[Constants.CONTRACT_ID_INDEX]);
    }
    
    public String getEvaluation(int index) {
        return this.evaluation[index];
    }
}
