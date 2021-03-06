package com.rmd.personal.projecteuler;

public class P045 implements Problem {

    private static final int DEFAULT_START_INDEX = 143;

    private int startIndex;

    public P045() {
        this.setStartIndex(DEFAULT_START_INDEX);
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    @Override
    public String getDescription() {
        return "Triangle, pentagonal, and hexagonal numbers are generated by the following formulae:\n\n"
                + "Triangle\t \tTn=n(n+1)/2\t \t1, 3, 6, 10, 15, ...\n"
                + "Pentagonal\t \tPn=n(3n−1)/2\t \t1, 5, 12, 22, 35, ...\n"
                + "Hexagonal\t \tHn=n(2n−1)\t \t1, 6, 15, 28, 45, ...\n"
                + "It can be verified that T285 = P165 = H143 = 40755.\n\n"
                + "Find the next triangle number that is also pentagonal and hexagonal.";
    }

    @Override
    public String run() {
        int i = this.getStartIndex() + 1;

        long hexagonalNumber;
        do {
            hexagonalNumber = i * (2 * i - 1);
            i++;
        } while (!Common.isPentagonal(hexagonalNumber));

        return String.valueOf(hexagonalNumber);
    }
}
