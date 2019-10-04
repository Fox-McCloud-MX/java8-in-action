package com.mx.java8.in.action.evaluate.list.twoList;

import com.mx.java8.in.action.evaluate.list.twoList.entity.ContractData;
import com.mx.java8.in.action.evaluate.list.twoList.entity.prism.list.SalesforceAccount;
import com.mx.java8.in.action.evaluate.list.twoList.util.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

@Slf4j
public class EvaluateListFields {
    
    List<ContractData> lContractDatas = new ArrayList<>();
    List<SalesforceAccount> lSalesforceAccounts = new ArrayList<>();
    
    public void filterActives() {
        lContractDatas = lContractDatas.stream()
                .filter(c -> c.getContractStatus().trim().equals(Constants.ACTIVE))
                .collect(Collectors.toList());
    }
    
    public void evaluateContractID(
            List<ContractData> lContractDatas, 
            List<SalesforceAccount> lSalesforceAccounts) {
        
        MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>();
        
        lSalesforceAccounts.forEach(s -> {
            s.getContract().getRecords().stream()
                    .filter(r -> r.getStatus().equals(Constants.ACTIVE))
                    .filter(r -> !r.getStatus().equals(Constants.EMPTY))
                    .forEach(r -> {
                        map.put(s.getId(), r.getContract_ID__c());
                    });
        });
        
        lContractDatas.stream().map(o -> {
            map.entries().forEach(t -> {
                if (t.getValue().equals(o.getContractID())) {
                    o.setEvaluation(Constants.Y, Constants.CONTRACT_ID_INDEX);
                }
            });
            return o;
        }).collect(Collectors.toList());
        
        lContractDatas.stream().map(o -> {
            if (o.getEvaluation(Constants.CONTRACT_ID_INDEX).equals(Constants.EMPTY)) {
                o.setEvaluation(Constants.N, Constants.CONTRACT_ID_INDEX);
            }
            return o;
        }).collect(Collectors.toList());
    }
    
    public void evaluateTicketDesignator(
            List<ContractData> lContractDatas, 
            List<SalesforceAccount> lSalesforceAccounts) {
        
        MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>();
        
        /*lSalesforceAccounts.forEach(s -> {
            s.getContract().getRecords().stream()
                    .filter(r -> r.getStatus().equals(Constants.ACTIVE))
                    .filter(r -> !r.getStatus().equals(Constants.EMPTY))
                    .forEach(r -> {
                        log.info(s.getId()+" "+r.getTicket_Designator__c());
                        map.put(s.getId(), r.getTicket_Designator__c());
                    });
        });*/
        
        lContractDatas.stream()
            .map(s -> {
                lSalesforceAccounts.stream().forEach(l -> {
                    if (l.getTicket_Designator__c().equals(s.getTicketDesignator())) {
                        s.setEvaluation(Constants.Y, Constants.TICKET_DESIGNATOR_INDEX);
                    }
                });
                return s;
        }).collect(Collectors.toList());
        
        lContractDatas.stream()
            .map(s -> {
                if(s.getEvaluation(Constants.TICKET_DESIGNATOR_INDEX).equals(Constants.EMPTY)) {
                    s.setEvaluation(Constants.N, Constants.TICKET_DESIGNATOR_INDEX);
                };
                return s;
            }).collect(Collectors.toList());
    }
    
    public void evaluateCompanyName(
            List<ContractData> lContractDatas, 
            List<SalesforceAccount> lSalesforceAccounts) {
        
        MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>();
        
        lContractDatas.stream()
            .map(s -> {
                lSalesforceAccounts.stream().forEach(l -> {
                    if (l.getName().equalsIgnoreCase(s.getCompanyName())) {
                        s.setEvaluation(Constants.Y, Constants.COMPANY_NAME_INDEX);
                    }
                });
                return s;
        }).collect(Collectors.toList());
        
        lContractDatas.stream()
            .map(s -> {
                if(s.getEvaluation(Constants.COMPANY_NAME_INDEX).equals(Constants.EMPTY)) {
                    s.setEvaluation(Constants.N, Constants.COMPANY_NAME_INDEX);
                };
                return s;
            }).collect(Collectors.toList());
    }
    
    public void evaluateCompanyID(
            List<ContractData> lContractDatas, 
            List<SalesforceAccount> lSalesforceAccounts) {
        
        MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>();
        
        lContractDatas.stream()
            .map(s -> {
                lSalesforceAccounts.stream().forEach(l -> {
                    if (l.getCompany_ID__c().equals(s.getCompanyID())) {
                        s.setEvaluation(Constants.Y, Constants.COMPANY_ID_INDEX);
                    }
                });
                return s;
        }).collect(Collectors.toList());
        
        lContractDatas.stream()
            .map(s -> {
                if(s.getEvaluation(Constants.COMPANY_ID_INDEX).equals(Constants.EMPTY)) {
                    s.setEvaluation(Constants.N, Constants.COMPANY_ID_INDEX);
                };
                return s;
            }).collect(Collectors.toList());
    }
    
    public void printResult(List<ContractData> lContractDatas) {
        
        log.info("TOTAL RESULT: ");
        Constants.EVALUATION.forEach((k,v) -> {
            long count = lContractDatas.stream()
                .filter(s -> s.getEvaluation().equals(k))
                .count();
            
            log.info(k + " " + count);
        });
        
        log.info("INTERNAL RESULT: ");
        lContractDatas.stream()
                .filter(distinctByKey(ContractData::getEvaluation))
                .collect(Collectors.toList())
                .stream()
                .forEach(s -> {
                    long count = lContractDatas.stream()
                        .filter(d -> d.getEvaluation().equals(s.getEvaluation()))
                        .count();

                    log.info(s.getEvaluation() + " " + count);
                });
    }
    
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}