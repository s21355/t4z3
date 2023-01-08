package org.example;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.hamcrest.core.IsEqual;


    public class FreactionHemcrestTest {

        @Test
        public void testOfDenominatorIsZero() {
            try {
                Fraction.of(1, 0);
            } catch (IllegalArgumentException e) {
                assertThat(e.getMessage(), IsEqual.equalTo("Fraction denominator cannot be equal to 0"));
            }
        }

        @Test
        public void testOfNominatorIsZero() {
            Fraction fraction = Fraction.of(0, 0);
            assertThat(fraction, IsEqual.equalTo(Fraction.INDETERMINATE));
        }

        @Test
        public void testDoubleValue() {
            Fraction fraction = Fraction.of(1, 2);
            assertThat(fraction.doubleValue(), IsEqual.equalTo(0.5));
        }

        @Test
        public void testEquals() {
            Fraction fraction1 = Fraction.of(1, 2);
            Fraction fraction2 = Fraction.of(1, 2);
            assertThat(fraction1, IsEqual.equalTo(fraction2));
        }

        @Test
        public void testEquals_notEqual() {
            Fraction fraction1 = Fraction.of(1, 2);
            Fraction fraction2 = Fraction.of(2, 2);
            assertNotEquals(fraction1, fraction2);
        }

        @Test
        public void testHashCode() {
            Fraction fraction1 = Fraction.of(1, 2);
            Fraction fraction2 = Fraction.of(1, 2);
            assertThat(fraction1.hashCode(), IsEqual.equalTo(fraction2.hashCode()));
        }

        @Test
        public void testToString() {
            Fraction fraction = Fraction.of(1, 2);
            assertThat(fraction.toString(), IsEqual.equalTo("1/2"));
        }

        @Test
        public void testFractionOfFull() {
            assertThat(Fraction.of(1, 1), new IsEqual(Fraction.FULL));
        }

        @Test
        public void testFractionOfHalf() {
            assertThat(Fraction.of(1, 2), new IsEqual(Fraction.HALF));
        }

        @Test
        public void testFractionOfOnethird() {
            assertThat(Fraction.of(1, 3), new IsEqual(Fraction.ONE_THIRD));
        }
    }
