package com.johngrib.example.math;

import com.johngrib.example.math.ComplexNumber;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings({"InnerClassMayBeStatic", "NonAsciiCharacters"})
@DisplayName("ComplexNumber 클래스")
class ComplexNumberKoTest {

  @Nested
  @DisplayName("of 메소드는")
  class Describe_of {
    private final double givenReal = 3d;
    private final double givenImagine = 3d;

    @Nested
    @DisplayName("만약 실수값만 주어지고 허수값은 없다면")
    class Context_with_real {
      @Test
      @DisplayName("i 값이 0 인 복소수를 리턴한다")
      void it_returns_a_valid_complex() {
        final ComplexNumber result = ComplexNumber.of(givenReal);

        Assertions.assertEquals(result.getImagine(), 0d, "리턴된 복소수는 허수 값으로 0 을 갖는다");
        Assertions.assertEquals(result.getReal(), givenReal, "리턴된 복소수는 실수 값으로 주어진 실수 값을 갖는다");
      }
    }

    @Nested
    @DisplayName("만약 실수값과 허수값이 주어진다면")
    class Context_with_real_and_i {
      @Test
      @DisplayName("주어진 실수값과 허수값을 갖는 복소수를 리턴한다")
      void it_returns_a_valid_complex() {
        final ComplexNumber result = ComplexNumber.of(givenReal, givenImagine);

        Assertions.assertEquals(result.getReal(), givenReal, "리턴된 복소수는 실수 값으로 주어진 실수 값을 갖는다");
        Assertions.assertEquals(result.getImagine(), givenImagine, "리턴된 복소수는 허수 값으로 주어진 허수 값을 갖는다");
      }
    }
  }

  @Nested
  @DisplayName("sum 메소드는")
  class Describe_sum {
    class TestSum {
      /** 주어진 복소수 A */
      ComplexNumber givenA() {
        return ComplexNumber.of(1d, 2d);
      }
      /** 주어진 복소수 B */
      ComplexNumber givenB() {
        return ComplexNumber.of(3d, 4d);
      }
      /** A와 B의 합 */
      ComplexNumber subject() {
        return ComplexNumber.sum(givenA(), givenB());
      }
    }

    @Nested
    @DisplayName("만약 실수부와 허수부가 있는 두 복소수가 주어진다면")
    class Context_with_two_complex extends TestSum {
      @Test
      @DisplayName("실수부와 허수부가 올바르게 계산된 복소수를 리턴한다")
      void it_returns_a_valid_complex() {
        Assertions.assertEquals(givenA().getReal() + givenB().getReal(), subject().getReal(),
                "리턴된 복소수는 두 실수 값의 합을 실수로 갖는다");
        Assertions.assertEquals(givenA().getImagine() + givenB().getImagine(), subject().getImagine(),
                "리턴된 복소수는 두 허수 값의 합을 허수로 갖는다");
      }
    }
    @Nested
    @DisplayName("만약 두 복소수 중 하나가 null 이라면")
    class Context_with_one_complex extends TestSum {
      @Override
      ComplexNumber givenA() {
        return null;
      }

      @Test
      @DisplayName("에외를 던진다")
      void it_returns_a_valid_complex() {
        Assertions.assertThrows(NullPointerException.class, this::subject);
      }
    }
  }

  @Nested
  @DisplayName("toString 메소드는")
  class Describe_toString {
    @Nested
    @DisplayName("만약 실수값만 있고 허수값이 없다면")
    class Context_with_real {
      private final double givenNatual = 3d;
      private final String expectPattern = "^3(?:\\.0+)?$";
      private ComplexNumber given = ComplexNumber.of(givenNatual);

      @Test
      @DisplayName("실수부만 표현한 문자열을 리턴한다")
      void it_returns_a_valid_string() {
        Assertions.assertTrue(given.toString().matches(expectPattern));
      }
    }

    @Nested
    @DisplayName("만약 실수값이 있고 허수값도 있다면")
    class Context_with_real_and_imagine {
      private final double givenNatual = 3d;
      private final double givenImagine = 7d;
      private ComplexNumber given = ComplexNumber.of(givenNatual, givenImagine);
      private String expectPattern = "^3(?:\\.0+)?\\+7(?:\\.0+)?i$";

      @Test
      @DisplayName("실수부 + 허수부i 형식으로 표현한 문자열을 리턴한다")
      void it_returns_a_valid_string() {
        assertTrue(given.toString().matches(expectPattern));
      }
    }
  }
}