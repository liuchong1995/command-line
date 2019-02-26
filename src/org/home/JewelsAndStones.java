package org.home;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        int aCount[] = new int[256];
        for(char oneChar : J.toCharArray()) {
            aCount[oneChar] = 1;
        }
        int count = 0;
        for(char oneChar : S.toCharArray()) {
            if( aCount[oneChar] == 1) count++;
        }
        return count;
    }
}
