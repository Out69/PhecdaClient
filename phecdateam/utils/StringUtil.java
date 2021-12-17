package pl.oucik.phecdateam.utils;

import java.util.ArrayList;

/*
Copyright Krypton
https://github.com/kkrypt0nn
*/

public class StringUtil {
    public static int convertToString(String lette) {
        Alphabet.LETTERS letter = null;
        for (int i = 0; i < Alphabet.LETTERS.values().length; i++) {
            if (Alphabet.get(i).equalsIgnoreCase(lette)) {
                letter = Alphabet.LETTERS.values()[i];
            }
        }
        int string = -1;
        if (letter == letter.A) {
            string = 1;
        } else if (letter == letter.B) {
            string = 2;
        } else if (letter == letter.C) {
            string = 3;
        } else if (letter == letter.D) {
            string = 4;
        } else if (letter == letter.E) {
            string = 5;
        } else if (letter == letter.F) {
            string = 6;
        } else if (letter == letter.G) {
            string = 7;
        } else if (letter == letter.H) {
            string = 8;
        } else if (letter == letter.I) {
            string = 9;
        } else if (letter == letter.J) {
            string = 10;
        } else if (letter == letter.K) {
            string = 11;
        } else if (letter == letter.L) {
            string = 12;
        } else if (letter == letter.M) {
            string = 13;
        } else if (letter == letter.N) {
            string = 14;
        } else if (letter == letter.O) {
            string = 15;
        } else if (letter == letter.P) {
            string = 16;
        } else if (letter == letter.Q) {
            string = 17;
        } else if (letter == letter.R) {
            string = 18;
        } else if (letter == letter.S) {
            string = 19;
        } else if (letter == letter.T) {
            string = 20;
        } else if (letter == letter.U) {
            string = 21;
        } else if (letter == letter.V) {
            string = 22;
        } else if (letter == letter.W) {
            string = 23;
        } else if (letter == letter.X) {
            string = 24;
        } else if (letter == letter.Y) {
            string = 25;
        } else if (letter == letter.Z) {
            string = 26;
        }
        return string;
    }
    public static ArrayList<String> getSubstrings(String s) {
        ArrayList<String> substrings = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            String substring = s.substring(i, i + 1);
            substrings.add(substring);
        }
        return substrings;
    }
}