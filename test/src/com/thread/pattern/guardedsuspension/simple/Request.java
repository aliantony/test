package com.thread.pattern.guardedsuspension.simple;


public class Request {
    private String name;
	public Request(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String toString() {
        return "[ Request " + name + " ]";
    }
}
