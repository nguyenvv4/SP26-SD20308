package com.example.sd20308.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    public Integer id;

    public String email;

    public String phone;

    public String fullName;

    public String password;

    public Boolean role;

    public Boolean active;
}
