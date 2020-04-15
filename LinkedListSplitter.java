package com.anz.linkedlists;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @author azemliankin
 */
public class LinkedListSplitter {

    public static void main(String[] args) {
        LinkedList<Integer> input = new LinkedList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);
        input.add(6);
        input.add(7);

        LinkedList<Integer>[] split = split(input);
        System.out.println("Input: " + input);
        System.out.println("Odd: " + split[0]);
        System.out.println("Even: " + split[1]);
    }


    public static <T> LinkedList<T>[] split(LinkedList<T> input) {
        Objects.requireNonNull(input, "Input linked list should not be null");

        LinkedList<T> odd = new LinkedList<>();
        LinkedList<T> even = new LinkedList<>();
        boolean addToEven = input.size() % 2 == 0;

        Iterator<T> iterator = input.descendingIterator();
        while (iterator.hasNext()) {
            if (addToEven) {
                even.addLast(iterator.next());
            } else {
                odd.addLast(iterator.next());
            }
            addToEven = !addToEven;
        }

        return new LinkedList[]{odd, even};
    }

}
