package com.johngrib.example.math;

import static org.junit.jupiter.api.Assertions.*;

import com.johngrib.example.math.ComplexNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Describe: ComplexNumber class")
class ComplexNumberTest {

    @Nested
    @DisplayName("Describe: of method")
    class DescribeAdd {

        @Nested
        @DisplayName("Context: with a real number")
        class Context_with_naturals {
            private final double givenNatual = 3d;
            private ComplexNumber given = ComplexNumber.of(givenNatual);

            @Test
            @DisplayName("It returns a complex number with 0i.")
            void it_has_0_imagine_value() {
                assertThat(given.getImagine(), is((0d)));
            }
        }
    }

    @Nested
    @DisplayName("Describe: sum method")
    class DescribeSum {
        @Nested
        @DisplayName("Context: with two complex numbers with real and i parts")
        class Context_with_naturals {
            private ComplexNumber a, b;

            @BeforeEach
            void prePareNumbers() {
                a = ComplexNumber.of(1d, 2d);
                b = ComplexNumber.of(32d, 175d);
            }

            ComplexNumber subject() {
                return ComplexNumber.sum(a, b);
            }

            @Test
            @DisplayName("It returns a complex number with the sum of the two real values.")
            void it_returns_complex_has_each_real_sum() {
                final double expect = a.getReal() + b.getReal();
                final double result = subject().getReal();
                assertThat(result, is(expect));
            }

            @Test
            @DisplayName("It returns a complex number with the sum of the two i values")
            void it_returns_complex_has_each_imagine_sum() {
                final double expect = a.getImagine() + b.getImagine();
                final double result = subject().getImagine();
                assertThat(result, is(expect));
            }
        }
    }

    @Nested
    @DisplayName("Describe: toString")
    class GivenToString {
        @Nested
        @DisplayName("Context: with only real value")
        class Context_with_naturals {
            private final double givenNatual = 3d;
            private final String expectPattern = "^3(?:\\.0+)?$";
            private ComplexNumber given = ComplexNumber.of(givenNatual);

            @Test
            @DisplayName("It returns a string that represents only real value")
            void it_has_0_imagine_value() {
                assertTrue(given.toString().matches(expectPattern));
            }
        }

        @Nested
        @DisplayName("Context: with a real value and an imagine value")
        class Context_with_imagine {
            private final double givenNatual = 3d;
            private final double givenImagine = 7d;
            private ComplexNumber given = ComplexNumber.of(givenNatual, givenImagine);
            private String expectPattern = "^3(?:\\.0+)?\\+7(?:\\.0+)?i$";

            @Test
            @DisplayName("It returns a string in the form of real and i addition.")
            void it_has_0_imagine_value() {
                System.out.println(given);
                assertTrue(given.toString().matches(expectPattern));
            }
        }

    }
}