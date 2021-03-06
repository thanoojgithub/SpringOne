package com.springone.ioc.asingletonhasbprototype.javadynamicproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ASingletonHasBPrototypeJavaDynamicProxyApp {

	final static Logger logger = LoggerFactory.getLogger(ASingletonHasBPrototypeJavaDynamicProxyApp.class);
	
	public static void main(String[] args) {

		try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("asingletonhasbprototype-javadynamicproxy-beans.xml")) {
			PassengerImpl passenger = (PassengerImpl)context.getBean("passenger");
			/**
			 * hashCode for 'passenger' instance is same, as it is a singleton scope by default Spring IOC.
			 * where as, for 'dayBusPass', hashCode is different for every time when we we call get instance of it.
			 */
			logger.info(passenger + " || "+passenger.getDayBusPass());
			logger.info(passenger + " || "+passenger.getDayBusPass());
			logger.info(passenger + " || "+passenger.getDayBusPass());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
