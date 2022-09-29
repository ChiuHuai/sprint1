package com.example.demo0926.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String id;

    // 基礎檢核 : name 不可為空
    @NotBlank(message = "名字不可為空")
    @Length(min = 2,message = "name should be more than 2 characters")
    private String name;

    // 基礎檢核 : age 不可為 null
    @NotNull(message = "年齡不可為空")
    private Integer age;

}
