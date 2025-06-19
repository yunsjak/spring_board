package com.mysite.sbb;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloLombok {

	private String hello;
	private int lombok;

	public static void main(String[] args) {
		HelloLombok helloLombok = new HelloLombok();

		// setter 호출
		helloLombok.setHello("헬로");
		helloLombok.setLombok(5);

		// getter 호출
		System.out.println(helloLombok.getHello());
		System.out.println(helloLombok.getLombok());
	}
}
