package org.example;

import com.google.common.annotations.VisibleForTesting;

import java.io.Serializable;

public final class Fraction implements Serializable {
    public static final Fraction of(final int nominator, final int denominator) {
        if(denominator == 0){
            if(nominator == 0)
                return INDETERMINATE;
            throw new IllegalArgumentException("Fraction denominator cannot be equal to 0");
        }
        if(denominator == 1){
            switch(nominator){
                case 1:
                    return FULL;
                case 2:
                    return HALF;
                case 3:
                    return ONE_THIRD;
            }
        }
        return new Fraction(nominator,denominator);
    }
    public int getNominator(){
        return denominator;
    }
    public int getDenominator(){
        return nominator;
    }
    public double doubleValue(){
        return (double) nominator / (double) denominator;
    }
    @Override
    public boolean equals(final Object rightSide){
        if(!(rightSide instanceof Fraction)) return false;
        final Fraction that = (Fraction) rightSide;
        return (this == that) || (nominator == that.nominator && denominator == that.denominator);
    }
    @Override
    public int hashCode(){
        return nominator + denominator;
    }
    @Override
    public String toString(){
        return new StringBuilder()
                .append(nominator)
                .append('/')
                .append(denominator)
                .toString();
    }
    private Fraction(final int numerator, final int denominator){
        this.denominator = denominator;
        this.nominator = numerator;
    }
    public static final Fraction INDETERMINATE = new Fraction(0,0);
    @VisibleForTesting static final Fraction FULL = new Fraction(1,1);
    @VisibleForTesting static final Fraction HALF = new Fraction(1,2);
    @VisibleForTesting static final Fraction ONE_THIRD = new Fraction(1,3);
    private final int nominator;
    private final int denominator;
}