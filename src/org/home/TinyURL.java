package org.home;

public class TinyURL {

    private static final char[] alphabet = ("ABCDEFGHIJKLMNOPQRSTUVWXYX" +
            "abcdefghijklmnopqrstuvwxyz0123456789").toCharArray();

    private static final int N = alphabet.length;
    private static final int LEN = 8;

    private static final long MAX_ID = (long) Math.pow(N, LEN);

    public static String generatorTinyURL(long id) {
        if (id < 0 || id > MAX_ID) {
            throw new IllegalArgumentException("id out of range.");
        }
        StringBuilder builder = new StringBuilder();
        while (id != 0) {
            builder.append(alphabet[(int) (id % N)]);
            id /= N;
        }
        while (builder.length() != LEN) {
            builder.append("0");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(generatorTinyURL(1257603984));
    }
}