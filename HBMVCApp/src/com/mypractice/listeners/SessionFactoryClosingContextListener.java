package com.mypractice.listeners;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.mypractice.utility.HibernateUtil;

public class SessionFactoryClosingContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Servltcomypracticeext obj destroyed");
		HibernateUtil.closeSessionFactory();

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Servletcomypracticeext obj is created");

	}

}
