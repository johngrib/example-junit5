package com.johngrib.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Describe: ComplexNumber class")
class ComplexNumberTest {

    @Nested
    @DisplayName("Describe: of 메소드")
    class DescribeAdd {

        @Nested
        @DisplayName("Context: 실수부만 입력했다면")
        class Context_with_naturals {
            private final double givenNatual = 3d;
            private ComplexNumber given = ComplexNumber.of(givenNatual);

            @Test
            @DisplayName("It: i 값은 0 이어야 한다")
            void it_has_0_imagine_value() {
                assertThat(given.getImagine(), is((0d)));
            }
        }
    }

    @Nested
    @DisplayName("Describe: Sum 메소드")
    class DescribeSum {
        @Nested
        @DisplayName("Context: 실수부와 허수부가 있는 두 복소수가 있을 때")
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
            @DisplayName("It: 실수부는 실수부끼리 덧셈해야 한다")
            void it_returns_complex_has_each_real_sum() {
                final double expect = a.getReal() + b.getReal();
                final double result = subject().getReal();
                assertThat(result, is(expect));
            }

            @Test
            @DisplayName("It: 허수부는 허수부끼리 덧셈해야 한다")
            void it_returns_complex_has_each_imagine_sum() {
                final double expect = a.getImagine() + b.getImagine();
                final double result = subject().getImagine();
                assertThat(result, is(expect));
            }
        }
    }

    @Nested
    @DisplayName("Describe: toString 메소드")
    class GivenToString {
        @Nested
        @DisplayName("Context: 실수부만 있는 복소수라면")
        class Context_with_naturals {
            private final double givenNatual = 3d;
            private final String expectPattern = "^3(?:\\.0+)?$";
            private ComplexNumber given = ComplexNumber.of(givenNatual);

            @Test
            @DisplayName("It: 실수부만 표현해야 한다")
            void it_has_0_imagine_value() {
                assertTrue(given.toString().matches(expectPattern));
            }
        }

        @Nested
        @DisplayName("Context: 실수부와 허수부가 있는 복소수라면")
        class Context_with_imagine {
            private final double givenNatual = 3d;
            private final double givenImagine = 7d;
            private ComplexNumber given = ComplexNumber.of(givenNatual, givenImagine);
            private String expectPattern = "^3(?:\\.0+)?\\+7(?:\\.0+)?i$";

            @Test
            @DisplayName("It: 실수부 + 허수부i 형식으로 표현해야 한다")
            void it_has_0_imagine_value() {
                System.out.println(given);
                assertTrue(given.toString().matches(expectPattern));
            }
        }

    }
}