package com.example.sonnt.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "major_facility")
public class MajorFacility {
    @Id
    @Size(max = 36)
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "status")
    private Byte status;

    @Column(name = "created_date")
    private Long createdDate;

    @Column(name = "last_modified_date")
    private Long lastModifiedDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_department_facility")
    private DepartmentFacility idDepartmentFacility;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_major")
    private Major idMajor;

    @OneToMany(mappedBy = "idMajorFacility")
    private Set<StaffMajorFacility> staffMajorFacilities = new LinkedHashSet<>();

}