package dev.entringer.operator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CompoundTest {

    @ParameterizedTest
    @CsvSource({
            "-1000000000000001, false",
            "-1000000000000000.00, true",
            "-1000000000000000.01, false",
            "-1000000000000000, true",
            "-5000.678, false",
            "-5000.67, true",
            "0, true",
            "1234.56, true",
            "1000000000000000, true",
            "1000000000000000.01, false",
            "1000000000000000.00, true",
            "1000000000000001.00, false",
            "1000000000000001, false",
            "999999999999999, true",
    })
    void testRangeValidator(String input, boolean expectedResult) {
        assertTrue(RangeValidator.isValid(input) == expectedResult);
    }

    public class RangeValidator {

        private static final String REGEX = "-?(?:1000000000000000(?:\\.00?)?|(?:[1-9]\\d{0,14}|0)(?:\\.\\d{1,2})?)";

        public static boolean isValid(String input) {
            return input.matches(REGEX);
        }
    }

}