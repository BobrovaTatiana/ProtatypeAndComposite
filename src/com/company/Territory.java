package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanusha on 08/03/2017.
 */
public class Territory implements Cloneable {
    private long countPpl;
    private long square;
    private long budget;
    private List<Territory> ChildTer;

    public Territory(long countPpl, long square, long budget) {
        this.countPpl = countPpl;
        this.square = square;
        this.budget = budget;
    }

    public Territory(){
        countPpl = 0;
        square = 0;
        budget = 0;
        ChildTer = new ArrayList<Territory>();
    }

    public long getCountPpl() {
        return countPpl;
    }

    public long getSquare() {
        return square;
    }

    public long getBudget() {
        return budget;
    }

    public void setCountPpl(long countPpl) {
        this.countPpl = countPpl;
    }

    public void setSquare(long square) {
        this.square = square;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    @Override
    public Territory clone() {
        Territory clone = new Territory();
        return clone;
    }

    public long sumPpl() {
        long sumppl = 0;
        for (Territory ter : ChildTer) {
            sumppl = sumppl + ter.getCountPpl();
            //System.out.println(sumppl);
        }
        setCountPpl(sumppl);
        return sumppl;
    }

    public long sumBudget() {
        long sumB = 0;
        for (Territory ter : ChildTer) {
            sumB = sumB + ter.getBudget();
            //System.out.println(sumB);
        }
        setBudget((int)sumB);
        return sumB;
    }

    public long sumSq() {
        long sumsq = 0;
        for (Territory ter : ChildTer) {
            sumsq = sumsq + ter.getSquare();
        }
        setSquare(sumsq);
        return sumsq;
    }

    public void add(Territory ter) {
        ChildTer.add(ter);
    }
}
