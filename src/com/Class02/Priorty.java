package com.Class02;

import org.testng.annotations.Test;

public class Priorty {
	
	@Test(priority=0)
	public void first() {
		System.out.println("This is first test annotatioin");
	}
	@Test(priority=1)
	public void second() {
		System.out.println("This is first second annotatioin");
	}
	@Test(priority=2)
	public void third() {
		System.out.println("This is first third annotatioin");
	}
	@Test(priority=3)
	public void fourth() {
		System.out.println("This is first fourth annotatioin");
	}

}
