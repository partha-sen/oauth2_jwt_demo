package com.codinggate.auth.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
	private String username;
    private String password;
    private List<String> roles = new ArrayList<>(); 

}
