package com.novisign.testApp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String loginName;

    @Column(nullable = false)
    private String password;

    @ManyToMany
    @JoinTable(name = "user_project",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "project_id"))
    private Set<ProjectEntity> projects = new HashSet<>();

    public void addProject(ProjectEntity project) {
        projects.add(project);
    }

    public void removeProject(ProjectEntity project) {
        projects.remove(project);
    }

    public void update(String fullName, String loginName, String password) {
        this.fullName = fullName;
        this.loginName = loginName;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserEntity that = (UserEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
