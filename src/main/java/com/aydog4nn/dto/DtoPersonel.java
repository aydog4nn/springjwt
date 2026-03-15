package com.aydog4nn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoPersonel {

    private Long id;

    private String firstName;

    private String lastName;

    private DtoDepartment department;

}
