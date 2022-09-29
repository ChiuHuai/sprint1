package com.example.Sprint1MGN.service;

import com.example.Sprint1MGN.controller.dto.request.ClearingAccount;
import com.example.Sprint1MGN.controller.dto.request.DepositRequest;
import com.example.Sprint1MGN.controller.dto.response.DepositResponse;
import com.example.Sprint1MGN.model.CashiRepository;
import com.example.Sprint1MGN.model.MgniRepository;
import com.example.Sprint1MGN.model.entity.Cashi;
import com.example.Sprint1MGN.model.entity.Mgni;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepositService {
    @Autowired
    private MgniRepository mgniReository;

    @Autowired
    private CashiRepository cashiRepository;

    @Transactional(rollbackOn = Exception.class)
    public DepositResponse deposit(DepositRequest request) {
        Mgni mgni = addMgni(request);
        List<ClearingAccount> clearingAccountList = request.getClearingAccountList();

        List<String> distinctAccNos = clearingAccountList.stream().map(e -> e.getAccNo()).distinct()
                .collect(Collectors.toList()); //取出不同 AccNo

        for (String accNo : distinctAccNos) {
            BigDecimal tempTotalAmt = new BigDecimal(0);
            for (ClearingAccount clearingAccount : clearingAccountList) {
                if (accNo.equals(clearingAccount.getAccNo())) {
                    tempTotalAmt = tempTotalAmt.add(clearingAccount.getAmt());
                }
            }
            addCashi(tempTotalAmt, accNo, mgni.getId(), mgni.getCcy());
        }

        return new DepositResponse().builder().message("OK").build();
    }

    public Mgni addMgni(DepositRequest request) {
        Mgni mgni = new Mgni();
        mgni.setId(idCreater());
        mgni.setTime(LocalDateTime.now());
        mgni.setType("1"); //1入金
        mgni.setCmNo(request.getCmNo());
        mgni.setKacType(request.getKacType());
        mgni.setBankNo(request.getBankNo());
        mgni.setCcy(request.getCcy());
        mgni.setPvType(request.getPvType());
        mgni.setBicaccNo(request.getBicaccNo());
        mgni.setIType(request.getIType());
        mgni.setPReason(request.getPReason());
        BigDecimal totalAmt = request.getClearingAccountList().stream().map(e -> e.getAmt()).reduce(BigDecimal.ZERO, BigDecimal::add);
        mgni.setAmt(totalAmt);
        mgni.setCtName(request.getCtName());
        mgni.setCtTel(request.getCtTel());
        mgni.setStatus("0");
        mgni.setUTime(LocalDateTime.now());
        mgniReository.save(mgni);

        return mgni;
    }

    public void addCashi(BigDecimal amt, String accNo, String id, String ccy) { //ClearingAccount clearingAccount
        Cashi cashi = new Cashi();
        cashi.setAmt(amt);
        cashi.setAccNo(accNo);
        cashi.setId(id);
        cashi.setCcy(ccy);
        cashiRepository.save(cashi);
    }

    public String idCreater() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String now = "MGI" + LocalDateTime.now().format(formatter);
        return now;
    }

}
