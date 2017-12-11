package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CurrencyStringerTest {

    CurrencyStringer converter;

    @Before
    public void setUp(){
        converter = new CurrencyStringer();
    }

    @Test
    public void convertToStringZeroTest(){
        String input = "0";

        String actual = converter.convertToString(input);
        String expected = "ZeroDollars";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void convertToStringOneTest(){
        String input = "1";

        String actual = converter.convertToString(input);
        String expected = "OneDollars";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void convertToStringTwelveTest(){
        String input = "12";

        String actual = converter.convertToString(input);
        String expected = "TwelveDollars";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void convertToStringHundredWithoutFillerTest(){
        String input = "600";

        String actual = converter.convertToString(input);
        String expected = "SixHundredDollars";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void convertToStringHundredWithOnesFillerTest(){
        String input = "102";

        String actual = converter.convertToString(input);
        String expected = "OneHundredTwoDollars";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void convertToStringHundredWithAllFillerTest(){
        String input = "122";

        String actual = converter.convertToString(input);
        String expected = "OneHundredTwentyTwoDollars";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void convertToStringThousandWithoutFillerTest(){
        String input = "1000";

        String actual = converter.convertToString(input);
        String expected = "OneThousandDollars";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void convertToStringThousandWithTensAndOnesFillerTest(){
        String input = "1034";

        String actual = converter.convertToString(input);
        String expected = "OneThousandThirtyFourDollars";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void convertToStringThousandWithAllFillerTest(){
        String input = "1234";

        String actual = converter.convertToString(input);
        String expected = "OneThousandTwoHundredThirtyFourDollars";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void convertToStringMillionsWithoutFillerTest(){
        String input = "100000000";

        String actual = converter.convertToString(input);
        String expected = "OneHundredMillionDollars";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void convertToStringMillionsWithAllFillerTest(){
        String input = "123456789";

        String actual = converter.convertToString(input);
        String expected = "OneHundredTwentyThreeMillionFourHundredFiftySixThousandSevenHundredEightyNineDollars";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void convertToStringBillionsWithoutFillerTest(){
        String input = "100000000000";

        String actual = converter.convertToString(input);
        String expected = "OneHundredBillionDollars";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void convertToStringTrillionsWithoutFillerTest(){
        String input = "100000000000000";

        String actual = converter.convertToString(input);
        String expected = "OneHundredTrillionDollars";

        Assert.assertEquals(expected, actual);
    }

}
