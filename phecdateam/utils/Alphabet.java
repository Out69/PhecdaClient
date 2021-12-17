package pl.oucik.phecdateam.utils;

/*
Copyright Krypton
https://github.com/kkrypt0nn
*/

public class Alphabet {
    public static enum LETTERS {
        A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z;
    }
    public static String get(int letter) {
        return LETTERS.values()[letter].name();
    }
}
