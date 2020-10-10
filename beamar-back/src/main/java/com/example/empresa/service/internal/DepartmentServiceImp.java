package com.example.empresa.service.internal;

import com.example.empresa.infrastructure.repository.DepartmentRepository;
import com.example.empresa.model.domain.Department;
import com.example.empresa.model.domain.dto.DepartmentDto;
import com.example.empresa.model.domain.dto.DptAndSubDptDto;
import com.example.empresa.service.DepartmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public DepartmentDto save(DepartmentDto departmentDto) {
        try{
            Department department = objectMapper.convertValue(departmentDto, Department.class);
            departmentRepository.save(department);
            return objectMapper.convertValue(department, DepartmentDto.class);
        } catch (Exception e){
            log.error(e.toString());
        }
        return null;
    }

    @Override
    public Long delete(Long id) {
        try{
            departmentRepository.deleteById(id);
            return id;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<DepartmentDto> findByCompanyIds(Long id) {
        List<Department> departments = departmentRepository.findByCompanyId(id);
        List<DepartmentDto> departmentDtos = Arrays.asList(objectMapper.convertValue(departments, DepartmentDto[].class));
        return departmentDtos;
    }

    @Override
    public DepartmentDto update(DepartmentDto departmentDto, Long id) {
        try{
            departmentRepository.findById(id).get();
            departmentDto.setId(id);
            Department department = objectMapper.convertValue(departmentDto, Department.class);
            departmentRepository.save(department);
            return objectMapper.convertValue(department, DepartmentDto.class);

        }catch(Exception e){
            log.error(e.toString());
        }

        return null;
    }

    @Override
    public List<DptAndSubDptDto> getAll(Long id) {
        List<Department> departments = departmentRepository.findByCompanyId(id);
        List<DptAndSubDptDto> dptAndSubDptDtos = new ArrayList<>();
        departments.stream().filter(dep -> dep.getIdPadre() == null).forEach(dpto -> match(dpto, dptAndSubDptDtos, departments, 1));

        return dptAndSubDptDtos;
    }

    private void match(Department department, List<DptAndSubDptDto> dptAndSubDptDtos, List<Department> departments, int nivel){
        DptAndSubDptDto dptAndSubDptDto = new DptAndSubDptDto();

        final Long id = department.getId();
        List<Department> departments1 = departments.stream()
                .filter(dep -> Optional.ofNullable(dep.getIdPadre()).orElse(0L).equals(id)).collect(Collectors.toList());
        dptAndSubDptDto.setDepartmentName(department.getDepartmentName());
        dptAndSubDptDto.setSubDepartments(departments1.stream().map(Department::getDepartmentName).collect(Collectors.toList()));
        dptAndSubDptDto.setNivel(nivel);
        dptAndSubDptDtos.add(dptAndSubDptDto);
        if(!departments1.isEmpty()){
            nivel ++;
            for (Department dpt: departments1) {
                match(dpt, dptAndSubDptDtos, departments, nivel);
            }

        }
    }

}
