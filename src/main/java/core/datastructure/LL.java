package core.datastructure;

import java.util.List;

public class LL<T>{

    public LL<T> next;
    public T  value;

    public LL(List<T> items) {
        LL<T> current = buildLinkedList(items);
        this.value = current.value;
        this.next = current.next;
    }

    public LL(T value) {
       this.value = value;
    }

    private LL() {
        this.value = null;
        this.next = null;
    }

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
        if(!(o instanceof LL)) return false;

        LL<T> thisList = this;
        LL<T> toCompareList = (LL<T>) o;

        while(thisList != null) {

            if(toCompareList == null) return false;

            if(thisList.value != toCompareList.value) return false;

            thisList = thisList.next;
            toCompareList = toCompareList.next;

        }

        return toCompareList == null;

    }


    public LL<T> buildLinkedList(List<T> items) {
       LL<T> root = new LL<>();
       LL<T> curr = root;
       for(T item: items) {
           curr.next = new LL<>(item);
           curr = curr.next;
       }
       return root.next;
    }

}
