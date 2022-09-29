package com.example.Sprint1MGN.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(CashiId.class)
@Table(name = "CASHI")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cashi {
    @Id
    @Column(name = "CASHI_MGNI_ID", nullable = false, length = 20)
    private String Id;
    @Id
    @Column(name = "CASHI_ACC_NO", nullable = false,length = 7)
    private String accNo;
    @Id
    @Column(name = "CASHI_CCY", nullable = false,length = 3)
    private String ccy;
    @Column(name = "CASHI_AMT", nullable = false)
    private BigDecimal amt;


}
