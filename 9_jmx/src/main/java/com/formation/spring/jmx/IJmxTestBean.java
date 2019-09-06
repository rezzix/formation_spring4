package com.formation.spring.jmx;

public interface IJmxTestBean {

    public void setAge(int age) ;

    public void setName(String name);

    public String getName();

    public int add(int x, int y);

    //public void dontExposeMe();

}
