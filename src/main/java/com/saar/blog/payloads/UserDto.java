package com.saar.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;
	
//	@NotNull
	@NotEmpty // this annotation is combination of @NotNull and also check of empty() means @NotEmpty
	@Size(min=3, message="Username must be min of 4 character")
	private String name;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	@Size(min=3,max=10, message="Username must be min of 4 character and max 10 character")
	private String password;
	
	@Size(min=10, message="Write atleast 10 letter in about ")
	private String about;

}
