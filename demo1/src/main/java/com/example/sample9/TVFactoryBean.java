package com.example.sample9;

import org.springframework.beans.factory.FactoryBean;

public class TVFactoryBean implements FactoryBean<TV> {
	
	private String type;
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public Class<?> getObjectType() {
		return TV.class;
	}
	
	@Override
	public TV getObject() throws Exception {
		if ("color".equals(type)) {
			return new ColorTV();
		} else if ("black".equals(type)) {
			return new BlackTV();
		} else {
			return null;
		}
	}
	
	@Override
	public boolean isSingleton() {
		return true;
	}
}
