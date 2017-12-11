package io.zipcoder;

import java.util.HashMap;

public class CurrencyStringer {

    private HashMap<String, String> wordMap = new HashMap<String, String>(){{
        put("0","");
        put("1", "One");
        put("2", "Two");
        put("3", "Three");
        put("4", "Four");
        put("5", "Five");
        put("6", "Six");
        put("7", "Seven");
        put("8", "Eight");
        put("9", "Nine");
        put("10","Ten");
        put("11", "Eleven");
        put("12", "Twelve");
        put("13", "Thirteen");
        put("14", "Fourteen");
        put("15", "Fifteen");
        put("16", "Sixteen");
        put("17", "Seventeen");
        put("18", "Eighteen");
        put("19", "Nineteen");
        put("20", "Twenty");
        put("30", "Thirty");
        put("40", "Forty");
        put("50", "Fifty");
        put("60", "Sixty");
        put("70", "Seventy");
        put("80", "Eighty");
        put("90", "Ninety");
    }};

    private String[] places = {"", "Thousand", "Million", "Billion", "Trillion"};

    public String convertToString(String input) {
        String output = "";
        if(input.length() == 1 && "0".equals(input)){
            return "ZeroDollars";
        }
        int length = input.length();
        int count = (int)Math.ceil(((double)length)/3);
        int end = 0;
        for(int i = 1; i <= count; i++){
            end = input.length();
            String converted = convertHundred(input.substring( Math.max(0, end-3), end ));
            if(converted.length() != 0){
                output = converted + places[i-1] + output;
            }
            input = input.substring( 0, Math.max(1, input.length()-3));
        }
        return output+"Dollars";
    }

    private String convertHundred(String block) {
        String output = "";
        int value = Integer.parseInt(block);
        if(value == 0){
            return output;
        }
        if(value >= 100){
            output += wordMap.get((value/100)+"")+"Hundred";
        }

        value = value%100;

        if(value == 0){
            return output;
        }

        if(value < 20 && value >= 10){
            output += wordMap.get(value + "");
            return output;
        } else {
            if (value >= 20) {
                output += wordMap.get(((value/10)*10) + "");
            }
            if (value >= 1) {
                output += wordMap.get(value%10 + "");
            }
            return output;
        }
    }
}
