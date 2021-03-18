package com.serverbitboxer2.serverbitboxer2.entities;

import com.serverbitboxer2.serverbitboxer2.globaldata.UserRoleEnum;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private UserRoleEnum name;

    public Role() {}

    public Role(UserRoleEnum name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserRoleEnum getName() {
        return name;
    }

    public void setName(UserRoleEnum name) {
        this.name = name;
    }
}