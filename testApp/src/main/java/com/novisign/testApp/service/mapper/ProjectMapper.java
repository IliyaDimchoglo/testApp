package com.novisign.testApp.service.mapper;

import com.novisign.testApp.domain.ProjectEntity;
import com.novisign.testApp.dto.CreateProjectRequest;
import com.novisign.testApp.dto.ProjectDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectEntity toEntity(CreateProjectRequest request);

    ProjectDto toDto(ProjectEntity entity);

}
