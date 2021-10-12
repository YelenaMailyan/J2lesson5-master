package com.company;

public interface MyQueue<T> {

    void add(T obj);

    void addFirst(T obj);

    void addLast(T obj);

    void removeFirst();

    void removeLast();

    boolean offerFirst(T value);

    boolean offerLast(T value);

    T poll();

    T pollFirst();

    T pollLast();


//    public boolean offer(T value) {
//        if (add(value)) {
//            return true;
//        } else {
//            throw new IndexOutOfBoundsException();
//        }
//    }
//


    //        public T remove() {
//            Integer removed = myDeque.getFirst();
//            myDeque.removeFirst();
//            return removed;
//        }


//
//    public T peekFirst() {
//        if (myDeque.isEmpty()) {
//            return null;
//        }
//        return myDeque.getFirst();
//    }
//
//    public T peekLast() {
//        if (myDeque.isEmpty()) {
//            return null;
//        }
//        return myDeque.getLast();
//    }

//    public boolean offerLast(T value) {
////        if (addLast(value)) {
////            return true;
////        } else {
////            throw new IndexOutOfBoundsException();
////        }
//    }

//    @Override
//    public String toString() {
//        return "Queue{" +
//                "myDeque=" + myDeque +
//                '}';
//    }


}
