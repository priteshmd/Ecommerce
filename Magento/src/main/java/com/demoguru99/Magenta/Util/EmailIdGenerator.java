package com.demoguru99.Magenta.Util;

import net.bytebuddy.utility.RandomString;

public class EmailIdGenerator {

	public static String fname = RandomString.make(4);
	public static String lname = RandomString.make(4);
	public static String mail = fname +"_"+ lname.concat("@mail.com");

	
	
}
