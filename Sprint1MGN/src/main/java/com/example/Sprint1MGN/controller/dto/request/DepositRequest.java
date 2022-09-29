package com.example.Sprint1MGN.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepositRequest {
    @NotBlank(message = "cmNo should not be blank")
    @Length(max = 7, message = "cmNo less than 7 characters")
    private String cmNo; //結算會員代號及名稱
    @NotBlank(message = "kacType should not be blank")
    @Length(min = 1, max = 1, message = "kacType should be 1 characters")
    private String kacType; //存入保管專戶別 1結算保證金 2交割結算基金專戶
    @NotBlank(message = "bankNo should not be blank")
    @Length(max = 3, message = "bankNo should less than 3 characters")
    private String bankNo; //存入結算銀行代號及名稱
    @NotBlank(message = "ccy should not be blank")
    @Length(max = 3, message = "ccy should less than 3 characters")
    private String ccy; //存入幣別 TWD
    @NotBlank(message = "pvType should not be blank")
    @Length(min = 1, max = 1, message = "pvType should less than 6 characters")
    private String pvType; //存入方式 1虛擬帳戶 2實體帳戶
    @NotBlank(message = "bicaccNo should not be blank")
    @Length(max = 21, message = "bicaccNo should less than 21 characters")
    private String bicaccNo; //實體帳號/虛擬帳號

    @NotNull(message = "clearingAccountList should not be blank")
    private List<ClearingAccount> clearingAccountList;//存入結算賬號
    @NotBlank(message = "ctName should not be blank")
    @Length(max = 120, message = "ctName should less than 120 characters")
    private String ctName; //聯絡人
    @NotBlank(message = "ctTel should not be blank")
    @Length(max = 30, message = "ctTel should less than 30 characters")
    private String ctTel; //電話

    //can be null
    @Length(min = 1, max = 1, message = "iType should less than 6 characters")
    @NotBlank(message = "ctTel should not be blank")
    private String iType; //存入類別 1開業 2續繳 3其他 4額外分擔金額
    @Length(max = 50, message = "pReason should less than 50 characters")
    private String pReason; //存入實體帳號原因



}
