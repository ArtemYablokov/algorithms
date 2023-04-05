package com.yablokovs.atlassian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BiggestPalindromeFromStringOfIntegers {

    public static void main(String[] args) {

        String maxPalindrome = findMaxPalindrome("090000000000000000000000000000000123451234567676767");
        System.out.println("123456677776654321".equals(maxPalindrome));
        System.out.println(maxPalindrome);

        maxPalindrome = findMaxPalindrome("000000089899");
        System.out.println("101".equals(maxPalindrome));
        System.out.println(maxPalindrome);

        maxPalindrome = findMaxPalindrome("00000");
        System.out.println(maxPalindrome);

        maxPalindrome = findMaxPalindrome("000400");
        System.out.println(maxPalindrome);

        maxPalindrome = findMaxPalindrome("00004400");
        System.out.println(maxPalindrome);

        maxPalindrome = solutionOleg("949");
        System.out.println(maxPalindrome);


    }

    private static String findMaxPalindrome(String stringOfNumbers) {
        char[] chars = stringOfNumbers.toCharArray();
        int[] ints = new int[10];
        for (char currChar : chars) {
            ints[currChar - '0']++;
        }
        StringBuilder firstHalf = new StringBuilder();

        int center = -1;
        for (int i = 9; i > -1; i--) {
            if (ints[i] % 2 != 0) {
                center = i;
                break;
            }
        }
        for (int i = 9; i > -1; i--) {
            int even = ints[i] & -2;
            firstHalf.append(String.valueOf(i).repeat((even / 2)));
        }

        StringBuilder result = new StringBuilder(firstHalf);

        if (result.charAt(0) == '0') {
            if (center > -1) {
                return String.valueOf(center);
            } else {
                return "0";
            }
        }
        if (center > -1) {
            result.append(center);
        }
        return result.append(firstHalf.reverse()).toString();
    }

            /*for (int j = 0; j < even / 2; j++) {
                firstHalf.append(i);
            }*/

    // Danil Temnikov
    public String solutionDanil(String S) {
        int[] numbers = new int[10];
        boolean hasZero = false;
        boolean hasBiggerThanZeroFromSides = false;
        boolean hasBiggerThanZeroInTheMiddle = false;

        for (int i = 0; i < S.length(); i++) {
            int currentNum = S.charAt(i) - '0';
            numbers[currentNum]++;
        }

        if (numbers[0] != 0) {
            hasZero = true;
        }

        for (int i = 1; i < 10; i++) {
            if (numbers[i] > 1) {
                hasBiggerThanZeroFromSides = true;
            }
            if (numbers[i] % 2 == 1) {
                hasBiggerThanZeroInTheMiddle = true;
            }
        }

        if (hasZero && !hasBiggerThanZeroFromSides && !hasBiggerThanZeroInTheMiddle) {
            return "0";
        }

        StringBuilder res = new StringBuilder();

        for (int j = 9; j >= 0; j--) {
            if ((numbers[j] > 0) && (numbers[j] % 2 == 1)) {
                res.append(j);
                numbers[j]--;
                break;
            }
        }

        for (int j = 9; j >= 0; j--) {
            if ((numbers[j] > 0) && (numbers[j] % 2 == 1)) {
                numbers[j]--;
            }
        }

        if (hasBiggerThanZeroFromSides) {
            for (int i = 0; i < 10; i++) {
                if (numbers[i] > 0) {
                    for (int j = 0; j < numbers[i] / 2; j++) {
                        res.append(i);
                        res.insert(0, i);
                    }
                }
            }
        }

        return res.toString();

    }

    // Roma Dubinin

    public static String solution(String S) {
        int[] digitCount = new int[10];
        for (char chr : S.toCharArray()) {
            digitCount[chr - '0']++;
        }
        String midDigit = "";
        for (int i = 9; i >= 0; i--) {
            if (digitCount[i] % 2 == 1) {
                midDigit = "" + i;
                break;
            }
        }
        StringBuilder str = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            for (int n = digitCount[i] / 2; n > 0; n--) {
                str.append(i);
            }
        }
        if ((str.length() > 0 && str.charAt(0) == '0') || str.length() == 0) {
            return midDigit.length() > 0 ? midDigit : "0";
        }
        return new StringBuilder(str).append(midDigit).append(str.reverse()).toString();
    }


    public static String solutionOleg(String S) {
        // write your code in Java SE 8
        char[] chars = S.toCharArray();
        int[] nums = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            nums[i] = chars[i] - '0';
        }

        Arrays.sort(nums);

        List<Integer> listWithDuplicates = new ArrayList<>();
        List<Integer> listWithoutDuplicates = new ArrayList<>();

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] == nums[i - 1]) {
                listWithDuplicates.add(nums[i]);
                i--;
            } else if (nums[i] != nums[i - 1]) {
                listWithoutDuplicates.add(nums[i]);
            }
        }

        listWithDuplicates.removeIf(i -> i == 0);

        List<Integer> toReturn = new ArrayList<>(listWithDuplicates);

        if (listWithoutDuplicates.size() != 0) {
            toReturn.add(listWithoutDuplicates.get(0));
        }

        Collections.reverse(listWithDuplicates);

        toReturn.addAll(listWithDuplicates);

        if (toReturn.size() == 0) {
            toReturn.add(0);
        }

        String finalValue = "";

        for (Integer i : toReturn) {
            finalValue = finalValue.concat(String.valueOf(i));
        }

        return finalValue;
    }


}
