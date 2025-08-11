package com.example.demo.school;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }

    public SchoolDto saveSchool(SchoolDto schoolDto){
        School school = schoolMapper.toSchool(schoolDto);
        var savedSchool= schoolRepository.save(school);
        return schoolMapper.toSchoolDto(savedSchool);
    }

    public List<SchoolResponse> findAllSchools(){
        return schoolRepository.findAll()
                .stream()
                .map(schoolMapper::toSchoolResponse)
                .collect(Collectors.toList());
    }
}
