package sakila.log4j.maven;

import org.apache.log4j.Logger;

public class ProvaLogger {
	
/*
 * per registrare un messaggio di errore o di debug in un  app java 
 */

		final static Logger logger = Logger.getLogger(ProvaLogger.class);

		public static void main(String[] args) {

			ProvaLogger obj = new ProvaLogger();
			obj.runMe("mkyong");

		}

		private void runMe(String parameter){

			if(logger.isDebugEnabled()){ //la priorità loggata è data dalla riga nel file log (in questo caso è debug)
				logger.debug("This is debug : " + parameter);//stamperà dal debug in giù
			}

			if(logger.isInfoEnabled()){
				logger.info("This is info : " + parameter);
			}

			logger.warn("This is warn : " + parameter);
			logger.error("This is error : " + parameter);
			logger.fatal("This is fatal : " + parameter);

		}

	}

