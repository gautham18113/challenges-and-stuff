package core.datastructure;

import java.util.List;

public class SinglyLinkedList<T>{

    public SinglyLinkedList<T> next;
    public T  value;

    /**
     *
     * Compares every element in the current linked list to
     * the linked list being compared to. <p>
     *
     * If values mismatch when being checked, return false. <p>
     *
     * After checking, both this list and compared list should be
     * at the leaf node i.e. null. If any one of the lists reach the
     * leaf node before the other does, then it is a mismatch in length
     * and we return false.<p>
     *
     * @param o {@link Object}
     * @return {@link Boolean} True or False
     */
    @Override
    @SuppressWarnings({"unchecked"})
    public boolean equals(Object o) {

        if(o == this) return true;
        if(!(o instanceof SinglyLinkedList)) return false;

        SinglyLinkedList<T> thisList = this;
        SinglyLinkedList<T> toCompareList = (SinglyLinkedList<T>) o;

        while(thisList != null) {

            if(toCompareList == null) return false;

            if(thisList.value != toCompareList.value) return false;

            thisList = thisList.next;
            toCompareList = toCompareList.next;

        }

        return toCompareList == null;

    }


    public SinglyLinkedList<T> buildSinglyLinkedList(List<T> items) {
       SinglyLinkedList<T> root = new SinglyLinkedList<>();
       SinglyLinkedList<T> curr = root;
       for(T item: items) {
           curr.value = item;
           curr.next = new SinglyLinkedList<>();
           curr = curr.next;
       }
       return root;
    }

}
