package com.company;

public class Main {                                                                     // class identifier Main
    /*********** Static main method ***********/
    public static void main(String[] args) {

        /*************************/
        /* Constructor methods	 */
        /*************************/

        try {

            int sizeVal = Integer.parseInt(args[0]);                                    // represents a positive integer value

            if (sizeVal <= 0) {                                                         // represents less or equal to zero integer value
                System.out.println("The input argument must be an integer greater than zero. Exiting.");
                System.exit(0);                                                   // exits JVM
            } else {

                if (args.length > 1) {                                                  // array contains more than 1 element
                    System.out.println("More than one argument was provided to the program. No processing will occur for any item other than the first arguments.");
                }

                System.out.println(sizeVal + " was specified as the array size.");      // prints the args[0] String

                double[] numArray = new double[sizeVal];                                // a single dimensional array of double values
                System.out.println("Array created.");                                   // print message after initialization of the array

                for (int i = 0; i < sizeVal; ++i) {                                     // initialize element of numArray to obtain random values
                    numArray[i] = Math.random();                                        // via Math.random method
                }
                System.out.println("Array initialized with random values.");

                /*************************/
                /* Update Methods        */
                /*************************/

                int counter = 0;

                for (int i = 0; i < sizeVal; ++i) {                                     // this method sorts the elements of numArray
                    for (int j = i + 1; j < sizeVal; ++j) {                             // scans the elements to find the smallest
                        if (numArray[i] > numArray[j]) {                                // and swaps it with the second element
                            double temp = numArray[i];
                            numArray[i] = numArray[j];
                            numArray[j] = temp;
                        }
                        ++counter;                                                      // return a counter value
                    }
                }

                for (int i = 1; i < sizeVal; ++i) {                                     // verifies the sorting operation was effective
                    if (numArray[i - 1] > numArray[i]) {
                        System.out.println("Something went wrong here.");
                        System.exit(0);
                    }
                }
                System.out.println("Array sort confirmed.");

                System.out.print("Elements of the sorted array:");
                for (int i = 0; i < sizeVal; ++i) {                                     // outputs the elements of the sorted array
                    if (i % 10 == 0) {                                                  // max ten values per line
                        System.out.print("\n" + i + ": ");
                    } System.out.print(numArray[i] + " ");
                }
                // Comparison total in numArray
                System.out.println("\n\n" + counter + " comparisons were performed during the brute force sort operation.\n");

                System.out.println("Processing completed. Exiting.");
            }

        } catch (ArrayIndexOutOfBoundsException e) {                                    // array contains no elements
            System.out.println("No arguments were provided to the program. Exiting.");
            System.exit(0);                                                       // exits JVM

        } catch (NumberFormatException e) {                                             // catches the exception
            System.out.println("An invalid integer argument value was provided to the program. Exiting");
            System.exit(0);                                                       // exits JVM
        }
    }
}