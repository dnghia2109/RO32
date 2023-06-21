package com.example.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDemoApplication {
	public static void main(String[] args) {
		var ctx = SpringApplication.run(SpringDemoApplication.class, args);
		BinarySearchImpl binarySearch = ctx.getBean(BinarySearchImpl.class);
		BinarySearchImpl binarySearch1 = new BinarySearchImpl();
		int result = binarySearch.binarySearch(new int[] {0,1,2,3,4,5,6}, 5);
		System.out.println(result);

		//System.out.println("\n " + binarySearch1.binarySearch(new int[] {0,1,2,3,4,5,6}, 4));
	}
}
