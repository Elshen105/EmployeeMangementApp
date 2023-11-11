package com.employee.management.service.impl;

import com.employee.management.entity.Department;
import com.employee.management.exception.NotFoundException;
import com.employee.management.model.DepartmentRequest;
import com.employee.management.model.DepartmentResponse;
import com.employee.management.repository.DepartmentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@SpringBootTest
class DepartmentServiceImplTest {

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentServiceImpl departmentServiceImpl;


    @DisplayName("Returning the department according to the given ID")
    @Test
    public void getDepartmentSuccessTest() {
        // given
        int id = 1;
        Department department = Department.builder().id(id).name("It Department").build();
        given(departmentRepository.findById(id)).willReturn(Optional.of(department));

        // when
        DepartmentResponse departmentResponse = departmentServiceImpl.getDepartment(id);

        // when & then

        assertThat(departmentResponse).isNotNull();
        assertEquals(1, departmentResponse.getId());
        assertEquals("It Department", departmentResponse.getName());

    }

    @DisplayName("Returning the department error according to the given ID")
    @Test
    public void getDepartmentErrorTest() {
        // given
        given(departmentRepository.findById(anyInt())).willReturn(Optional.empty());

        // when

        // when & then
        assertThrows(NotFoundException.class, () -> departmentServiceImpl.getDepartment(anyInt()));
    }





    @DisplayName("Saving the department according to the specified name")
    @Test
    public void saveDepartmentSuccessTest() {
        // given

        int id = 1;
        DepartmentRequest request = DepartmentRequest.builder().name("It Department").build();
        Department department = Department.builder().id(id).name("It Department").build();


        // when
        when(departmentRepository.save(any(Department.class))).thenReturn(department);
        DepartmentResponse departmentResponse = departmentServiceImpl.saveDepartment(request);

        // when & then

        assertThat(departmentResponse).isNotNull();

    }


    @DisplayName("JUnit test for getAllDepartments method ")
    @Test
    public void getAllDepartmentSuccessTest() {
        // given

        Department department1 = Department.builder().id(1).name("It Department").build();
        Department department2 = Department.builder().id(2).name("Software Department").build();


        // when
        when(departmentRepository.findAll()).thenReturn(Arrays.asList(department1, department2));
        List<DepartmentResponse> allDepartment = departmentServiceImpl.getAllDepartment();

        // then

        assertThat(allDepartment.size()).isEqualTo(2);

    }






    @DisplayName("JUnit test for deleteDepartment method")
    @Test
    public void deleteDepartmentSuccessTest() {
        // given
        int id = 1;
        Department department = Department.builder().id(id).name("It Department").build();

        given(departmentRepository.findById(id)).willReturn(Optional.of(department));
        willDoNothing().given(departmentRepository).delete(department);

        // when
        departmentServiceImpl.deleteDepartmentById(id);

        // then

        verify(departmentRepository, times(1)).findById(id);
        verify(departmentRepository, times(1)).delete(department);



    }



    @DisplayName("Returning the delete department error according to the given ID")
    @Test
    public void deleteDepartmentErrorTest() {
        // given
        given(departmentRepository.findById(anyInt())).willReturn(Optional.empty());

        // when

        // when & then
        assertThrows(NotFoundException.class, ()-> departmentServiceImpl.deleteDepartmentById(anyInt()));
    }







}