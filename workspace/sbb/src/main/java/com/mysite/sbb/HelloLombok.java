package com.mysite.sbb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class HelloLombok {

	private String hello;
	private int lombok;
	
	public String getHello() {
		return hello;
	}
	public int getLombok() {
		return lombok;
	}
	
	public static void main(String[] args) {
		HelloLombok helloLombok = new HelloLombok();
		
		System.out.println(helloLombok.getHello());
		System.out.println(helloLombok.getLombok());
	}
	
}
