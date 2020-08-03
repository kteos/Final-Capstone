package com.techelevator.harvest;

import org.springframework.stereotype.Component;

@Component
public class Path {
	String path;
	
	public Path () {
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
