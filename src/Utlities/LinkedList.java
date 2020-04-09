package Utlities;

// Refer to here for Tutorial: https://www.youtube.com/watch?v=SMIq13-FZSE

import java.util.Iterator;

public class LinkedList<E> implements Iterator
{
    Node<E> head;

    public void insert(E data)
    {
        Node<E> node = new Node<E>();
        node.data = data;
        node.next = null;

        if (head == null) {
            head = node;
        }
        else {
            Node<E> n = head;
            while (n.next != null){
                n = n.next;
            }
            n.next = node;
        }
    }

    public void insertAt(int index, E data)
    {
        Node<E> node = new Node<E>();
        node.data = data;
        node.next = null;

        if (index == 0)
        {
            insertAtStart(data);
        }
        else {
            Node n = head;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            node.next = n.next;
            n.next = node;
        }
    }

    public void show()
    {
        Node node = head;
        while (node.next != null){
            System.out.println(node.data);
            node = node.next;
        }
    }

    public void insertAtStart(E data)
    {
        Node<E> node = new Node<E>();
        node.data = data;
        node.next = null;
        node.next = head;
        head = node;
    }

    public void deleteAt(int index)
    {
        if (index == 0)
        {
            head = head.next;
        }
        else
        {
            Node n = head;
            Node n1 = null;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            n1 = n.next;
            n.next = n1.next;
            n1 = null;
        }
    }

    public int lengthOfLinkedList() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    @Override
    public boolean hasNext() {
        return head != null;
    }

    @Override
    public E next() {
        if (hasNext()){
            E data = head.data;
            head = head.next;
            return data;
        }
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove not implemented.");
    }
}
