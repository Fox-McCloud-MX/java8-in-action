package com.mx.java8.in.action.evaluate.list.twoList;

import com.mx.java8.in.action.evaluate.list.twoList.entity.ContractData;
import com.mx.java8.in.action.evaluate.list.twoList.entity.prism.list.SalesforceAccount;
import com.mx.java8.in.action.evaluate.list.twoList.util.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EvaluateListFields {
    
    List<ContractData> lContractDatas = new ArrayList<>();
    List<SalesforceAccount> lSalesforceAccounts = new ArrayList<>();
    
    public void filterActives() {
        lContractDatas = lContractDatas.stream()
                .filter(c -> c.getContractStatus().trim().equals(Constants.ACTIVE))
                .collect(Collectors.toList());
    }
}