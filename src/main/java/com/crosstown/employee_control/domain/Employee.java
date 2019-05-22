package com.crosstown.employee_control.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author F.S.(Crosstown)
 * @date 11/21/2017
 * @time 12:17 AM
 */
@Getter
@Setter
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String middleName;
    private String lastName;
    private String ssn;
    private String email;

    @OneToOne(fetch = FetchType.EAGER)
    private Category category;

    @OneToOne(fetch = FetchType.EAGER)
    private Location location;

    @OneToOne(fetch = FetchType.EAGER)
    private Supervisor supervisor;

    @OneToOne(fetch = FetchType.EAGER)
    private BU bu;

    @Override
    public String toString() {
        return "[" + this.firstName + " " + this.lastName + "]";
    }
}
