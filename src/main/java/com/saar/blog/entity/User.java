package com.saar.blog.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password;
	private String about;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Post>posts=new ArrayList<>();
	/*जब हम Hibernate या JPA (Java Persistence API) का उपयोग करते हैं और किसी Entity में रिलेशनशिप (जैसे @OneToMany, @ManyToOne, @OneToOne, या @ManyToMany) पर CascadeType.ALL सेट करते हैं, तो इसका मतलब है कि पैरेंट (मूल) एंटिटी पर जो भी ऑपरेशन किया जाएगा, वही ऑपरेशन उसके जुड़े हुए चाइल्ड एंटिटी पर भी लागू होगा।*/


}
