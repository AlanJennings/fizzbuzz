package com.ajennings.fizzbuzz;

import org.junit.Test;
import static org.junit.Assert.*;

public class FizzBuzzGeneratorTest {

    private FizzBuzzGenerator fizzBuzzGenerator = new FizzBuzzGenerator();

    @Test
    public void constructIntegerRangeWithAStream()
    {
        //Given
        int streamStart = 0;
        int streamEnd = 20;

        //When
        int[] output = fizzBuzzGenerator.constructRange(streamStart, streamEnd);

        //Then
        assertEquals("20 items have been loaded into list",20, output.length);

    }

    @Test
    public void test_parseNumber()
    {
        //Given
        int shouldFizz = 6;
        int shouldBuzz = 5;
        int shouldFizzBuzz = 15;
        int shouldInteger = 2;
        int shouldLucky = 3;

        //When
        String fizzResult = fizzBuzzGenerator.parseNumber(shouldFizz);
        String buzzResult = fizzBuzzGenerator.parseNumber(shouldBuzz);
        String fizzBuzzResult = fizzBuzzGenerator.parseNumber(shouldFizzBuzz);
        String integerResult = fizzBuzzGenerator.parseNumber(shouldInteger);
        String luckyResult = fizzBuzzGenerator.parseNumber(shouldLucky);

        //Then
        assertEquals("fizz", fizzResult);
        assertEquals("buzz", buzzResult);
        assertEquals("fizzbuzz", fizzBuzzResult);
        assertEquals("2", integerResult);
        assertEquals("lucky", luckyResult);

    }

    @Test
    public void test_thatCanGenerateFizzBuzz()
    {
        //Given
        int start = 1;
        int end = 20;

        //When
        String fizzBuzzOutput = fizzBuzzGenerator.handleFizzBuzz(start,end);

        //Then
        assertEquals("1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz", fizzBuzzOutput);

    }

    @Test
    public void test_thatCanGenerateFizzBuzzWithReport()
    {
        //Given
        int start = 1;
        int end = 20;

        //When
        String fizzBuzzOutput = fizzBuzzGenerator.handleFizzBuzzWithReport(start,end);

        //Then
        assertEquals("1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz fizz : 4 buzz : 3 fizzbuzz : 1 lucky : 2 integer : 10", fizzBuzzOutput);

    }
}
