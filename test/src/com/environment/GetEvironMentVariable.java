package com.environment;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

public class GetEvironMentVariable {
	public static void main(String[] args) {
		/*
		 * Map map = System.getenv(); Iterator it = map.entrySet().iterator();
		 * while(it.hasNext()) { Entry entry = (Entry)it.next();
		 * System.out.print(entry.getKey()+"="); String key =
		 * (String)entry.getKey(); if(key.equals("CATALINA_HOME")) {
		 * System.out.println(entry.getValue()); }
		 * System.out.println(entry.getValue()); }
		 */
		Properties properties = System.getProperties();
		Iterator it = properties.entrySet().iterator();
		while (it.hasNext()) {
			Entry entry = (Entry) it.next();
			System.out.print(entry.getKey() + "=");
			System.out.println(entry.getValue());
		}

		System.setProperty("BBB", "AAA");
		String bb = System.getProperty("BBB");
		System.out.println(bb);
		
		
	}

	
}
