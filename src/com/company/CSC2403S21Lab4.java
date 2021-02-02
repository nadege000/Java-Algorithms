package com.company;

public class CSC2403S21Lab4 {

    /* Main method -- exercises SingLinked objects */
    public static void main (String[] args)
    {
        final int LISTSIZE = 499;      // Length of the linked list
        final int MAXELEMENT = 99999;  // Max value of the linked list elements
        final int ERROR_EXIT = -1;     // Exit status for abnormal test outcome

        int tempInt;

        System.out.println("******** Lab 4 test driver execution beginning ********");
        System.out.println("Testing enhancements to SingLinked Java class objects.");
        System.out.println("Modifications were implemented by <YOUR NAME HERE> for CSC 2403, Spring Semester, 2021");

        /* Create the head of the linked list of SingLinked objects */
        SingLinked head = new SingLinked((int) (Math.random() * MAXELEMENT));
        SingLinked newNode, currentNode;                  // Temp vars for list navigation, etc

        // Create a linked list of objects of the SingLinked class
        currentNode = head;
        for (int i = 1; i < LISTSIZE; i++) {                  // LISTSIZE elements in the list
            tempInt = (int) (Math.random() * MAXELEMENT); // Element value range 0..MAXELEMENT
            newNode = new SingLinked(tempInt);            // Create a new node
            currentNode.setNext(newNode);                 // Incrementally build the list [The addToList() method
            currentNode = currentNode.getNext();          // is not yet available... To be developed by the student]
        }
        /* ensure the baseline list of objects was built and contains LISTSIZE items */
        tempInt = 1; currentNode = head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
            tempInt++;
        }
        if (tempInt == LISTSIZE)
            System.out.println("\nBaseline linked list has been built. Node count checks out: " + tempInt);
        else {
            System.out.println("Problem: Baseline list build was wonky. Node count: " + tempInt);
            System.exit(ERROR_EXIT);
        }

        // Note to CSC2403 learners --
        // At this point, a linked list has been built against which the new methods
        // can be tested. The list has LISTSIZE entries, and its first object is
        // referenced by the instance variable named "head".

        /* **********************************************************/
        /* Lab 4 enhancements to SingLinked class are tested below  */
        /* **********************************************************/
        //* **************** Test of the findTail() method **********
        System.out.println("\nInitiating test of findTail() method...");
        SingLinked tail = head.findTail();

        // Validate by walking the list from head to the end and checking against the returned tail reference
        tempInt = 1; currentNode = head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
            tempInt++;
        }

        // If the last node of the list coincides with the returned tail reference and
        // the expected number of nodes are present in the list, the test is successful
        if ((currentNode == tail) && (tempInt == LISTSIZE)) {
            System.out.println("findTail() implementation verified -- "+LISTSIZE+" nodes were transited and tail references coincide.\n");
            System.out.println("***** Requirement 1 test result: Succeeded ****\n\n");
        }
        else {
            System.out.println("findTail() implementation verification failed.");
            System.exit(ERROR_EXIT);
        }

        // *******************countNodes() test ************************
        System.out.println("Initiating test of countNodes() method...");

        // Compare method return value to the known length of the list
        if (head.countNodes() == LISTSIZE) {
            System.out.println("countNodes() implementation verified -- method returned "+LISTSIZE+" (expected outcome).");
            System.out.println("***** Requirement 2 test result: Succeeded ****\n\n");
        }
        else {
            System.out.println("countNodes() implementation verification failed.");
            System.exit(ERROR_EXIT);
        }

        // *******************addToList() test *************************
        System.out.println("\nInitiating test of addToList() method...");
        tempInt = (int) (Math.random() * MAXELEMENT);
        head.addToList(tempInt);
        tail = head.findTail();

        // Test is successful if the list size increased by 1, its tail element contains the
        // specified value, and the tail reference is indeed the tail of the list
        if ((head.countNodes() == LISTSIZE+1) &&
                (tail.getElement() == tempInt) &&
                (tail.getNext() == null))
        {
            System.out.println("addToList() implementation verified.");
            System.out.println("List size successfully incremented, and tail node reference was verified.");
            System.out.println("***** Requirement 3 test result: Succeeded ****\n\n");
        }
        else {
            System.out.println("addToList() implementation verification failed.");
            System.exit(ERROR_EXIT);
        }
        System.out.println("\n***** All required tests executed successfully. *****");

        /* *****************************************************************************/
        /* Extra credit -- implementation checks for the convertToCirc() update method */
        /* *****************************************************************************/
        // Part 1 -- convert non-circular linked list to circular.  5 Extra credit lab points.
        System.out.println("\nInitiating test of singly linked to circularly linked list conversion method...");

        // Save list head and tail references for results validity checking
        System.out.println("Saving head and tail for subsequent reference check...");
        SingLinked savedHead = head;
        SingLinked savedTail = head.findTail();

        // Attempt the conversion
        SingLinked circTail = SingLinked.convertToCirc(head);
        System.out.println("Circular conversion attempt completed.");

        // Check for the circular structure -- tail points to head
        if ((circTail == savedTail) && (circTail.getNext() == savedHead)) {
            System.out.println("Tail and tail successor nodes match expected references.");
            System.out.println("Singly linked list conversion to circular list implementation verified.");
            System.out.println("***** Extra credit Requirement 1 test result: Succeeded ****\n\n");
        }
        else {
            System.out.println("circular list conversion could not be verified for extra credit");
            System.exit(ERROR_EXIT);
        }

        // Part 2 -- convert circular linked list back to non-circular.  3 Extra credit lab points.
        System.out.println("\nInitiating extra credit test of circ-linked list conversion back to non-circular linked list...");

        // Attempt the conversion
        SingLinked rebuiltHead = SingLinked.convertFromCirc(circTail);

        // Find the tail to verify the conversion worked
        tail = rebuiltHead.findTail();

        // The list is 'plus 1' in length because of the earlier requirement 3 test
        // The tail check is arguably overkill as findTail() used the same criterion. Treating abstractly, though.
        if ((rebuiltHead.countNodes() == LISTSIZE+1) && (tail.getNext() == null)) {
            System.out.println("Circular to non-circular conversion verified.");
            System.out.println("The size of the list matches the expected value and tail node termination was confirmed.");
            System.out.println("***** Extra credit Requirement 2 test result: Succeeded ****\n\n");
        }
        else {
            System.out.println("convertFromCirc() implementation extra credit verification failed.");
            System.exit(ERROR_EXIT);
        }
    }
}
