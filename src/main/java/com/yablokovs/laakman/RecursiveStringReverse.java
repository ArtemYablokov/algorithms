package com.yablokovs.laakman;

public class RecursiveStringReverse {


    public static void main(String[] args) {

        System.out.println(recursive("abcdef"));

    }

    private static String recursive(String string) {

        int length = string.length();
        if (length == 1){
            return string;
        }

        char c = string.charAt(length - 1);
        string = string.substring(0,length - 1);

//        String res = 'c' + "";

        return c + recursive(string);

    }
}
