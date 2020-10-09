package com.example.empresa.service.internal;

import com.example.empresa.infrastructure.repository.CompanyRepository;
import com.example.empresa.infrastructure.repository.DepartmentRepository;
import com.example.empresa.model.domain.Company;
import com.example.empresa.model.domain.dto.CompanyDto;
import com.example.empresa.service.CompanyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CompanyServiceImp implements CompanyService {

    @Autowired
    public CompanyRepository companyRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public CompanyDto save(CompanyDto companyDto) {
        try{
            Company company = objectMapper.convertValue(companyDto, Company.class);
            companyRepository.save(company);
            return objectMapper.convertValue(company, CompanyDto.class);
        }catch (Exception e){
            log.error(e.toString());
        }
        return null;
    }

    @Override
    public List<CompanyDto> findAll() {
        String stringList = "";
        List<CompanyDto> companyDtos = null;
        try {
            stringList = objectMapper.writeValueAsString(companyRepository.findAll());
            companyDtos = objectMapper.readValue(stringList, new TypeReference<List<CompanyDto>>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return companyDtos;
    }

    @Override
    public CompanyDto findById(Long id) {
        try{
            Company company = companyRepository.findById(id).get();
            return objectMapper.convertValue(company, CompanyDto.class);
        }catch (Exception e){
            log.error(e.toString());

        }
        return null;
    }

    @Override
    public Long delete(Long id) {
        try{
            companyRepository.deleteById(id);
            return id;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public CompanyDto update(CompanyDto companyDto, Long id) {
        try{
            companyRepository.findById(id).get();
            companyDto.setId(id);
            Company company = objectMapper.convertValue(companyDto, Company.class);
            companyRepository.save(company);
            return objectMapper.convertValue(company, CompanyDto.class);

        }catch(Exception e){
            log.error(e.toString());
        }

        return null;
    }
}
