package com.example.Sprint1MGN.model.entity;

import com.example.Sprint1MGN.service.DateAdapter;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "MGNI")
public class Mgni {
    @Id
    @Column(name = "MGNI_ID", nullable = false, length = 20)
    private String Id;
    @Column(name = "MGNI_TIME", nullable = false)
    @XmlJavaTypeAdapter(DateAdapter.class)
    private LocalDateTime time;
    @Column(name = "MGNI_TYPE", nullable = false, length = 1)
    private String type;
    @Column(name = "MGNI_CM_NO", nullable = false, length = 7)
    private String cmNo;
    @Column(name = "MGNI_KAC_TYPE", nullable = false, length = 1)
    private String kacType;
    @Column(name = "MGNI_BANK_NO", nullable = false, length = 3)
    private String bankNo;
    @Column(name = "MGNI_CCY", nullable = false, length = 3)
    private String ccy;
    @Column(name = "MGNI_PV_TYPE", nullable = false, length = 1)
    private String pvType;
    @Column(name = "MGNI_BICACC_NO", nullable = false, length = 21)
    private String bicaccNo;
    @Column(name = "MGNI_I_TYPE", nullable = true, length = 1)
    private String iType;
    @Column(name = "MGNI_P_REASON", nullable = true, length = 50)
    private String pReason;
    @Column(name = "MGNI_AMT", nullable = false)
    private BigDecimal amt;
    @Column(name = "MGNI_CT_NAME", nullable = false, length = 120)
    private String ctName;
    @Column(name = "MGNI_CT_TEL", nullable = false, length = 30)
    private String ctTel;
    @Column(name = "MGNI_STATUS", nullable = false, length = 1)
    private String status;
    @Column(name = "MGNI_U_TIME", nullable = false)
    @XmlJavaTypeAdapter(DateAdapter.class)
    private LocalDateTime uTime;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "Id")  //mappedBy = "employee" //cascade = CascadeType.ALL,
//    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Cashi> cashiList;

//    @OneToMany(fetch= FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinColumn(name = "MGNI_ID")
//    private List<Cashi> cashiList;

}
