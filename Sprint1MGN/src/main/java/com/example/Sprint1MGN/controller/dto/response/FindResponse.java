package com.example.Sprint1MGN.controller.dto.response;

import com.example.Sprint1MGN.model.entity.Mgni;
import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement()
@Builder
public class FindResponse {
    private String message;
    private List<Mgni> mgniList;
}
