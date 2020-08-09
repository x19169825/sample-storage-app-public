package com.compproject.samplestorageapp.model.users;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
public class EndUser {

    @Id
    private String username;
    private String role;
    private String password;


    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }


}
