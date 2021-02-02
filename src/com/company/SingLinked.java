package com.company;

public class SingLinked {

    /*****************/
    /* Constants     */
    /*****************/
    final int DEFAULT_VALUE = -1;

    /**********************/
    /* Instance variables */
    /**********************/
    protected int nodeElement;	                                  // The data element
    protected SingLinked nextNode;	                              // Reference to the next list node

    /***********************/
    /* Constructor methods */
    /***********************/
    public SingLinked() {
        nodeElement = DEFAULT_VALUE;
        nextNode = null;
    }

    public SingLinked(int elVal) {
        nodeElement = elVal;
        nextNode = null;
    }

    public SingLinked (int elVal, SingLinked nxt) {
        nodeElement = elVal;
        nextNode = nxt;
    }

    /**********************/
    /* Set/Update methods */
    /**********************/
    // Sets the value of the data element in the linked list node
    public void setElement (int elVal) {
        nodeElement = elVal;
    }

    // Sets the reference to the next node in the linked list
    public void setNext (SingLinked nxt) {
        nextNode = nxt;
    }

    /* Stubbed addToList() -- to be implemented as Lab 4 requirement #3 */
    // Creates a new list node, sets its value to that of the argument,
    // and appends the new node to the end of the linked list.
    public void addToList(int elVal) {
        SingLinked currentNode = nextNode;                       // set starter node of current LinkedList
        currentNode = currentNode.findTail();                    // set current node as tail after finding tail
        SingLinked newNode = new SingLinked(elVal);              // create new node
        currentNode.setNext(newNode);                            // set next node of linked list as new node
    }

    /******************************************************/
    /* Extra credit set/update placeholders for Lab 4     */
    /* If you take this on, don't overlook getting rid of */
    /* the null return from two following stubbed methods */
    /******************************************************/

    /************************************************************************/
    /* Conversion of a singly linked list to a circular singly linked list. */
    /* Implemented as a static method since it is intended for use as a     */
    /* conversion utility and not as a method used for processing linked 	*/
    /* lists in real-time.							                        */
    /************************************************************************/
    public static SingLinked convertToCirc(SingLinked listHead) {
        SingLinked listTail = listHead.findTail();              // converts to circularly Linked list
        listTail.setNext(listHead);                             // sets reference to the head of linked list
        return listTail;
    }

    /************************************************************************/
    /* Conversion of a circular singly linked list to a non-circular singly */
    /* linked list. This method is implemented as a static method since it  */
    /* is intended for use as a conversion utility and not as a method used */
    /* for processing linked lists in real-time.				            */
    /************************************************************************/
    public static SingLinked convertFromCirc(SingLinked listTail) {
        SingLinked listHead = listTail.getNext();              // converts from circularly to singly linked list
        listTail.setNext(null);                                // remove reference of the head
        return listHead;
    }

    /***********************/
    /* Access/Get methods  */
    /***********************/
    // Obtain the value of the data element
    public int getElement() {
        return nodeElement;
    }

    // Obtain the link to the next node in the list
    public SingLinked getNext() {
        return (nextNode);
    }

    /* Stubbed findTail() -- to be implemented as Lab 4 requirement #1   */
    public SingLinked findTail() {
        SingLinked currentNode = nextNode;                     // set current node as head of Linked list
        while (currentNode != null) {                          // locates the tail
            if (currentNode.getNext() == null) {               // if while loop reaches a nextNode that is null
                break;                                         // that means tail has been reached and while loop ends.
            } else {
                currentNode = currentNode.getNext();           // else null gets nextNode
            }
        }
        return currentNode;
    }

    /* Stubbed countNodes() -- to be implemented as Lab 4 requirement #2 */
    public int countNodes() {
        SingLinked currentNode = nextNode;                    // works similarly as tail
        int nodeCount = 1;                                    // counter value
        while (currentNode != null) {
            currentNode = currentNode.getNext();
            ++nodeCount;
        }
        return (nodeCount);                                   // returns the count of elements from current through tail
    }
}


