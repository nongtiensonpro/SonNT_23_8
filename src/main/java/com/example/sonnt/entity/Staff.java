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
@Table(name = "staff")
public class Staff {
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

    @Size(max = 255)
    @Column(name = "account_fe")
    private String accountFe;

    @Size(max = 255)
    @Column(name = "account_fpt")
    private String accountFpt;

    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @Size(max = 255)
    @Column(name = "staff_code")
    private String staffCode;

    @OneToMany(mappedBy = "idStaff",fetch = FetchType.LAZY)
    private Set<DepartmentFacility> departmentFacilities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idStaff")
    private Set<StaffMajorFacility> staffMajorFacilities = new LinkedHashSet<>();

}