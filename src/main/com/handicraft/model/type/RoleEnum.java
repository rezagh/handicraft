package com.handicraft.model.type;

public enum RoleEnum {
	ROLE_ADMIN("ROLE_ADMIN"),
	ROLE_SUPER_USER("ROLE_SUPER_USER"),		//manage things like articles
	ROLE_USER("ROLE_USER");		//normal authenticated user
	private RoleEnum(String role){}
}
