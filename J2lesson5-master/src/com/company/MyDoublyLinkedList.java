package com.company;

public class MyDoublyLinkedList<T> implements MyList<T>, MyQueue<T> {
    private Node<T> first = null;
    private Node<T> last = null;
    private int size;


    public void add(T obj) {
        Node<T> node = new Node(obj);
        if (first == null) {
            first = node;
           // last = node;
            //first.next = null;
            //  last.next = null;
        } else {
            node.prev = last;
            last.next = node;

        }last = node;
        size++;
    }

    public void addFirst(T obj) {
        if (first == null) {
            add(obj);
        } else {
            Node<T> node = new Node(obj);
            node.next = first;
            first = node;
            size++;
        }

    }

    public void addLast(T obj) {
        add(obj);
    }

    public T get(int index) {
        try {
            Node<T> current = first;
            int i = 0;
            if (index == 0) {
                //System.out.println("The first value of MyDoublyLinkedList is");
                return first.value;
            } else {
                do {
                    current = current.next;
                    i++;
                }
                while (i < index);
                // System.out.println("Return value by index " + i + " is");
                return current.value;
            }

        } catch (NullPointerException ex) {
            System.out.println("There is no such Node by this index");
            return null;
        }

    }

    public T getFirst() {
        try {
            //  Node<T> current = first;
            return first.value;
        } catch (NullPointerException ex) {
            System.out.println("There is no such Node by this index");
            return null;
        }

    }

    public T getLast() {
        try {
            return last.value;
        } catch (NullPointerException ex) {
            System.out.println("There is no such Node by this index");
            return null;
        }

    }

    public boolean remove(T obj) {
        if (first == null) {
            System.out.println("There is no element");
            return false;
        }
        if (first.value == obj) {
            //  first.next.prev = null;
            first = first.next;
            size--;
            return true;
        }
        Node<T> current = first;
        while (current.next != null) {
            if (current.next.value == obj) {
                if (current.next != last) {
                    current.next = current.next.next;
                } else {
                    current.next = null;
                    last = current;

                }
                size--;
                return true;
            } else {
                current = current.next;
            }

        }
        return false;
    }

    public void removeByIndex(int index) {
        T value = get(index);
        remove(value);
    }

    public void removeFirst() {
        removeByIndex(0);
    }

    public void removeLast() {
        removeByIndex(size() - 1);
    }


    public boolean offerFirst(T value) {
        addFirst(value);
        return true;
    }

    public boolean offerLast(T value) {
        addLast(value);
        return true;
    }

    public T poll() {
        if (isEmpty()) {
            return null;
        }
        T removed = getFirst();
        removeFirst();
        return removed;
    }


    public T pollFirst() {
        return poll();
    }


    public T pollLast() {
        if (isEmpty()) {
            return null;
        }
        T removed = getLast();
        removeLast();
        return removed;
    }

    public boolean isEmpty() {
        //Node<T> current = first;
        if (first == null) {
            return true;
        }
        return false;
    }

    public boolean contains(T obj) {
        Node<T> current = first;
        for (int i = 0; i < size(); i++) {
            if (current == null) {
                return false;
            } else if (current.value == obj) {
                return true;
            } else {
                current = current.next;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<T> current = first;
        while (current != null) {
            result.append(current.value);
            if (current.next != null) {
                result.append(", ");
            }
            current = current.next;
        }
        result.append("]");
        return result.toString();
    }


    static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;


        public Node(T value) {
            this.value = value;
        }
    }

}
