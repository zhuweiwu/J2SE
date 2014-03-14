package com.log4j;

import org.apache.log4j.Logger;

public class Log4jTest {
	public static void main(String[] args){
		Logger logger = Logger.getLogger(Log4jTest.class);
		
		System.out.println("#################");
		try{
			String s = null;
			s.length();
		}catch (Exception e) {
			logger.trace("trace message");
			logger.debug("debug message");
			logger.info("info message");
			logger.warn("warn message");
			logger.error("error message");
			logger.fatal("fatal message");
		}
		
	} 
}
