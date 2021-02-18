/*   Created by IntelliJ IDEA.
 *   Author: Prajjwal Pachauri (cypher)
 *   Date: 18-02-2021
 *   Time: 4:04 PM
 *   File: MySinglyCircularLinkedList.java
 */

package implementation;

import myinterface.SinglyCircularLinkedListADT;

public class MySinglyCircularLinkedList implements SinglyCircularLinkedListADT {
    private Node tail;
    private int size;

    public MySinglyCircularLinkedList() {
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return tail == null;
    }

    @Override
    public void addFirst(int element) {
        Node node = new Node(element);
        if (isEmpty()) {
            tail = node;
            node.setNext(tail);
        }
        else {
            node.setNext(tail.getNext());
            tail.setNext(node);
        }
        size++;
    }

    @Override
    public int removeFirst() {
        int response = 0;
        if (!isEmpty()) {
            if (tail.getNext() == tail) {
                response = tail.getData();
                tail = null;
            }
            else {
                response = tail.getNext().getData();
                tail.setNext(tail.getNext().getNext());
            }
            size--;
        }
        return response;
    }

    @Override
    public void addLast(int element) {
        Node node = new Node(element);
        if (!isEmpty()) {
            node.setNext(tail.getNext());
            tail = node;
        }
        else {
            tail = node;
            node.setNext(tail);
        }
        size++;
    }
}
