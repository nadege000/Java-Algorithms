package com.company;

public class Main {                                                                                             // Class identifier 'Main'

    public static void main(String[] args) {
        
        /** Int to Char Conversions **/
        int i = 48;                                                                                             // Casting int values to char values
        char c = (char)i;

        int j = 65;
        char ch = (char)j;

        int k = 97;
        char chr = (char)k;

        /** Loop ASCII characters from 48 to 57. **/
        System.out.println("The ASCII characters with collating sequence values between 48 and 57 are as follows.");

        for(i = '0'; i<= '9'; i++) {
            System.out.println(i + ": " + (char)i);
        }                                                                                                      // Casting 'char' values to 'int' values.

        /** Loop ASCII characters from 65 to 90. **/
        System.out.println("\nThe ASCII characters with collating sequence values between 65 and 90 are as follows.");

        for(j = 'A'; j <= 'Z'; j++) {
            System.out.println(j + ": " + (char)j);
        }                                                                                                     // Casting 'char' values to 'int' values.

        /** Loop ASCII characters from 97 to 122. **/
        System.out.println("\nThe ASCII characters with collating sequence values between 97 and 122 are as follows.");

        for(k = 'a'; k <= 'z'; k++) {                                                                         // Casting 'char' values to 'int' values.
            System.out.println(k + ": " + (char)k);
            if (k >= 'z'){
                System.out.println("\nEnd of program output. Terminating normally. ");

                System.exit(0);                                                                         // To terminate Java Virtual Machine
            }
        }
    }
}
