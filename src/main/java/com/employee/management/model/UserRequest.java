package com.employee.management.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserRequest {

    private String username;
    private String password;

    private Set<RoleDto> role;
}
