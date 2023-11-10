package com.employee.management.service.impl;

import com.employee.management.entity.Department;
import com.employee.management.model.DepartmentResponse;
import com.employee.management.repository.DepartmentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class DepartmentServiceImplTest {

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentServiceImpl departmentServiceImpl;


    @DisplayName("Finding the department according to the given id")
    @Test
    public void getDepartmentTest() {
        // given
        int id = 1;
        Department department = Department.builder().id(id).name("It Department").build();
        given(departmentRepository.findById(id)).willReturn(Optional.of(department));

        // when
        DepartmentResponse departmentResponse = departmentServiceImpl.getDepartment(id);

        // then

        assertThat(departmentResponse).isNotNull();
        assertEquals(1, departmentResponse.getId());
        assertEquals("It Department", departmentResponse.getName());

    }



}