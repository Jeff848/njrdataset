package com.rmd.personal.projecteuler.p1to19;

import com.rmd.personal.projecteuler.Problem;

public class P002 implements Problem {

    private static final int DEFAULT_MAX_VALUE = 4000000;
    private int maxValue;

    public P002() {
        this.setMaxValue(DEFAULT_MAX_VALUE);
    }

    @Override
    public String getDescription() {
        return "Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting "
                + "with 1 and 2, the first 10 terms will be:\n\n"
                + "1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...\n\n"
                + "By considering the terms in the Fibonacci sequence whose values do not exceed four million, "
                + "find the sum of the even-valued terms..";
    }

    @Override
    public String run() {
        int sum = 0;

        int fprevious = 0;
        int fcurrent = 1;

        while (fcurrent < this.getMaxValue()) {
            if (fcurrent % 2 == 0) {
                sum += fcurrent;
            }

            int tmp = fcurrent + fprevious;

            fprevious = fcurrent;
            fcurrent = tmp;
        }

        return String.valueOf(sum);
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }
}
