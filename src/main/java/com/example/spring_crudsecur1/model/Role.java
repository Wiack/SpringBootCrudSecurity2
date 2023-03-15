package com.example.spring_crudsecur1.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data//@ToString, @EqualsAndHashCode, @Getter @Setter и @RequiredArgsConstructor
@NoArgsConstructor

public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Role(String name) {
        this.name = name;
    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getShortName() {
        return name.substring(5);
    }



    @Override
    public String getAuthority() {
        return getName();
    }

    //@NoArgsConstructor
//    public Role() {
//    }
    //@DATA
//    public Role(String name) {
//        this.name = name;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

}
