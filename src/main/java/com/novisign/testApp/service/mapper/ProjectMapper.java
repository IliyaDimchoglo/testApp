package com.novisign.testApp.service.mapper;

import com.novisign.testApp.domain.ProjectEntity;
import com.novisign.testApp.dto.CreateProjectRequest;
import com.novisign.testApp.dto.ProjectDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Instant;

@Mapper(componentModel = "spring", imports = Instant.class)
public interface ProjectMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdTime", expression = "java(Instant.now())")
    @Mapping(target = "updatedTime", expression = "java(Instant.now())")
    ProjectEntity toEntity(CreateProjectRequest request);

    ProjectDto toDto(ProjectEntity entity);

}
