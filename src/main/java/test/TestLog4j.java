package test;

import org.apache.log4j.Logger;

public class TestLog4j {

	public static void main(String[] args) {

		final Logger log = Logger.getLogger(TestLog4j.class);

		log.info("THis is Himananda");
		
		log.debug("Yet to start .... ");
	}

}
