package com.example.empresa.service.internal;

import com.example.empresa.infrastructure.repository.SubDepartmentRepository;
import com.example.empresa.model.domain.SubDepartment;
import com.example.empresa.model.domain.dto.SubDepartmentDto;
import com.example.empresa.service.SubDepartmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class SubDepartmentServiceImp implements SubDepartmentService {

    @Autowired
    private SubDepartmentRepository subDepartmentRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public SubDepartmentDto save(SubDepartmentDto subDepartmentDto) {
        try{
            SubDepartment subDepartment = objectMapper.convertValue(subDepartmentDto, SubDepartment.class);
            subDepartmentRepository.save(subDepartment);
            return objectMapper.convertValue(subDepartment, SubDepartmentDto.class);
        }catch (Exception e){
            log.error(e.toString());
        }
        return null;
    }
    @Override
    public Long delete(Long id) {
        try{
            subDepartmentRepository.deleteById(id);
            return id;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<SubDepartmentDto> findByDepartment(Long id) {
        List<SubDepartment> subDepartments = subDepartmentRepository.findByDepartmentId(id);
        List<SubDepartmentDto> subDepartmentDtos = Arrays.asList(objectMapper.convertValue(subDepartments, SubDepartmentDto[].class));
        return subDepartmentDtos;
    }

    @Override
    public SubDepartmentDto update(SubDepartmentDto subDepartmentDto, Long id) {
        try{
            subDepartmentRepository.findById(id).get();
            subDepartmentDto.setId(id);
            SubDepartment subDepartment = objectMapper.convertValue(subDepartmentDto, SubDepartment.class);
            subDepartmentRepository.save(subDepartment);
            return objectMapper.convertValue(subDepartment, SubDepartmentDto.class);

        }catch(Exception e){
            log.error(e.toString());
        }
        return null;
    }
}
