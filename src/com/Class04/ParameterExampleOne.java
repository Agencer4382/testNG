package com.Class04;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterExampleOne {
	@Parameters({"userName1","userName2","userName3"})
	@Test
	public void userName(String user1, String user2, String user3) {
		
		System.out.println(user1);
		System.out.println(user2);
		System.out.println(user3);
		
		
	}

}
