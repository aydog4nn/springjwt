package com.aydog4nn.dto;

import com.aydog4nn.model.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoEmployee {

    private Long id;

    private String lastName;

    private String firstName;

    private DtoDepartment department;

}
