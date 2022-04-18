package com.novisign.testApp.service.mapper;

import com.novisign.testApp.domain.ProjectEntity;
import com.novisign.testApp.dto.CreateProjectRequest;
import com.novisign.testApp.dto.ProjectDto;
import java.time.Instant;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-18T19:22:21+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public ProjectEntity toEntity(CreateProjectRequest request) {
        if ( request == null ) {
            return null;
        }

        ProjectEntity projectEntity = new ProjectEntity();

        projectEntity.setName( request.getName() );
        projectEntity.setStatus( request.getStatus() );

        projectEntity.setCreatedTime( Instant.now() );
        projectEntity.setUpdatedTime( Instant.now() );

        return projectEntity;
    }

    @Override
    public ProjectDto toDto(ProjectEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ProjectDto projectDto = new ProjectDto();

        projectDto.setName( entity.getName() );
        projectDto.setStatus( entity.getStatus() );

        return projectDto;
    }
}
