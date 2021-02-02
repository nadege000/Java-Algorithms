package com.company;

class QLink {
    int nodeVal;
    QLink nextNode;

    public QLink(int iVal) {
        nodeVal = iVal;
        nextNode = null;
    }      // constructor method

    public static void main(String[] args) {
        QLink head, temp;
        head = new QLink(0);
        temp = head;
        for (int i = 1; i < 5; i++) {
            temp.nextNode = new QLink(i);
            temp = temp.nextNode;
        }
    }
}
