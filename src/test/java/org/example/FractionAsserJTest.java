package org.example;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
public class FractionAsserJTest {

    @Test
    public void testGetNominator() {
        Fraction fraction = Fraction.of(2, 3);
        assertThat(fraction.getNominator()).isEqualTo(3);
    }

    @Test
    public void testGetDenominator() {
        Fraction fraction = Fraction.of(2, 3);
        assertThat(fraction.getDenominator()).isEqualTo(2);
    }

    @Test
    public void testDoubleValue() {
        Fraction fraction = Fraction.of(2, 3);
        assertThat(fraction.doubleValue()).isEqualTo(2.0 / 3.0);
    }

    @Test
    public void testEquals_equalFractions() {
        Fraction fraction1 = Fraction.of(2, 3);
        Fraction fraction2 = Fraction.of(2, 3);
        assertThat(fraction1).isEqualTo(fraction2);
    }

    @Test
    public void testEquals_unequalFractions() {
        Fraction fraction1 = Fraction.of(2, 3);
        Fraction fraction2 = Fraction.of(3, 4);
        assertThat(fraction1).isNotEqualTo(fraction2);
    }

    @Test
    public void testFractionOfFull() {
        // Test that Fraction.of() returns the expected Fraction objects
        assertThat(Fraction.of(1, 1)).isEqualTo(Fraction.FULL);
    }

    @Test
    public void testFractionOfHalf() {
        assertThat(Fraction.of(1, 2)).isEqualTo(Fraction.HALF);
    }

    @Test
    public void testFractionOfOnethird() {
        assertThat(Fraction.of(1, 3)).isEqualTo(Fraction.ONE_THIRD);
    }
}