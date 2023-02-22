package com.zos.dto;

public class UserDto {
	
	private Integer id;
	private String full_name;
	private String email;
	private String profile_picture;
	
	
	public UserDto() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDto(Integer id, String full_name, String email, String profile_picture) {
		super();
		this.id = id;
		this.full_name = full_name;
		this.email = email;
		this.profile_picture = profile_picture;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfile_picture() {
		return profile_picture;
	}

	public void setProfile_pic(String profile_picture) {
		this.profile_picture = profile_picture;
	}
	
	
	

}
