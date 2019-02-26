package org.home;

public class Main {

    public static void main(String[] args) {
	    testStackDepth();
    }

    static int deep = 1;
    static void testStackDepth(){
        System.out.println(++deep);
        testStackDepth();
    }
}
