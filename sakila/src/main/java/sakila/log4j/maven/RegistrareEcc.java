package sakila.log4j.maven;

import org.apache.log4j.Logger;

public class RegistrareEcc {
/*
 * come regitrare un eccezione
 */
	final static Logger logger = Logger.getLogger(RegistrareEcc.class);

	public static void main(String[] args) {

		RegistrareEcc obj = new RegistrareEcc();

		try {
			obj.divide();
		} catch (ArithmeticException ex) {
			logger.error("Sorry, something wrong!", ex);
		}

	}

	private void divide() {

		int i = 10 / 0;

	}

}
