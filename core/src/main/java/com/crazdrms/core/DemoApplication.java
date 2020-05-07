package com.crazdrms.core;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Guess the number");
		int guessNumber = sc.nextInt();
		String result = guessNumber == 5 ? "Correct" : "Incorrect";
		System.out.println(result);
		sc.close();
	}
}
