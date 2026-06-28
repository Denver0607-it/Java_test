package com.example;

public class NumberComparator {
    public int compare(int a, int b) {
        if (a > b) return 1;
        if (a < b) return -1;
        return 0;
    }
    public int findMax(int a, int b) { return (a >= b) ? a : b; }
    public int findMin(int a, int b) { return (a <= b) ? a : b; }
}