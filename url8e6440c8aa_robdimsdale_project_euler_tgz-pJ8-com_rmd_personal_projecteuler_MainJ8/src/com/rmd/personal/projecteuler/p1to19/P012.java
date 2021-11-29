package com.rmd.personal.projecteuler.p1to19;

import com.rmd.personal.projecteuler.Common;
import com.rmd.personal.projecteuler.Problem;

public class P012 implements Problem {

    private static final int DEFAULT_NUMBER_OF_DIVISORS = 500;

    private int numberOfDivisors;

    public P012() {
        this.setNumberOfDivisors(DEFAULT_NUMBER_OF_DIVISORS);
    }

    public int getNumberOfDivisors() {
        return numberOfDivisors;
    }

    public void setNumberOfDivisors(int numberOfDivisors) {
        this.numberOfDivisors = numberOfDivisors;
    }

    @Override
    public String getDescription() {
        return "The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle "
                + "number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:\n\n"
                + "1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...\n\n"
                + "Let us list the factors of the first seven triangle numbers:\n\n"
                + " 1: 1\n"
                + " 3: 1,3\n"
                + " 6: 1,2,3,6\n"
                + "10: 1,2,5,10\n"
                + "15: 1,3,5,15\n"
                + "21: 1,3,7,21\n"
                + "28: 1,2,4,7,14,28\n"
                + "We can see that 28 is the first triangle number to have over five divisors.\n\n"
                + "What is the value of the first triangle number to have over five hundred divisors?";
    }

    @Override
    public String run() {
        int index = 0;

        int factorCount = 1;
        while (factorCount <= this.getNumberOfDivisors()) {
            index++;
            long firstValue;
            long secondValue;
            if (index % 2 == 0) {
                firstValue = index / 2;
                secondValue = index + 1;
            } else {
                firstValue = index;
                secondValue = (index + 1) / 2;
            }
            factorCount = this.getDivisorCountForValue(firstValue) * this.getDivisorCountForValue(secondValue);
        }
        return String.valueOf(Common.sum(index));
    }

    private int getDivisorCountForValue(long value) {
        int factorCount = 1;
        long triangleNumberTmp = value;

        for (long prime : Common.getPrimes()) {
            if (prime * prime > triangleNumberTmp) {
                factorCount = 2 * factorCount;
                break;
            }
            int exponent = 1;
            while (triangleNumberTmp % prime == 0) {
                exponent++;
                triangleNumberTmp = triangleNumberTmp / prime;
            }
            if (exponent > 1) {
                factorCount = factorCount * exponent;
            }
            if (triangleNumberTmp == 1) {
                break;
            }
        }
        return factorCount;
    }
}
