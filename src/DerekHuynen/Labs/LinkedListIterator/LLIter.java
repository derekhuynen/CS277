package DerekHuynen.Labs.LinkedListIterator;

import java.util.NoSuchElementException;
import java.util.Stack;

public class LLIter implements Iterator {
    LinkedList.Node current;
    LinkedList ll;						//The Linked List that we're servicing
    Stack <LinkedList.Node> trail = new Stack <>();

    /**
     * The constructor might be able to get along with just the ll parameter
     * (that's short for Linked List by the way), but then I would have had
     * to have a getter for the Linked List for the head.  That would have
     * broken the encapsulation of the linked list.  The head that we pass
     * in is just a pointer to the first node (if any) of the linked list,
     * not the pointer to the pointer to the head of the linked list, so changing
     * the passed in head is not going to change the head in the linked list.
     *
     * We could have made LLIter a nested class under LinkedList, but the book
     * chose to do it this way, with an independent class, and I wanted to
     * mimic the book's approach as best as I could.
     * @param ll	The LinkedList that we are iterating over.
     * @param head	A reference to the head of that linked list.
     */
    public LLIter (LinkedList ll, LinkedList.Node head) {
        this.current = head;				//Start the iterator off at the front of the LinkedList.
        this.ll = ll;
    }

    @Override
    public String next() {
        if (! this.hasNext()) {
            throw new NoSuchElementException ("Call hasNext first.  No next!");
        } else {
            String result = current.getValue();
            trail.push(current);
            current = current.getNext();
            return result;
        }
    }

    @Override
    public String previous() {
        if (! this.hasPrevious()) {
            throw new NoSuchElementException ("Call hasPrevious first.  No previous!");
        } else {
            LinkedList.Node previous = trail.pop();
            this.current = previous;
            return previous.getValue();
        }
    }


    /**
     * Delete node from linked link
     */
    @Override
    public void delete(){
        if(this.hasPrevious()){
            LinkedList.Node previous = trail.pop();

            if(trail.empty()){
                ll.head = current;

            }else{
                LinkedList.Node temp = trail.peek();
                temp.setNext(current);
            }
        }
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        if (this.current != null) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean hasPrevious() {
        return (trail.size() > 0);
    }

    @Override
    public void insert(String value) {
        if (this.trail.size() > 0) {						//We are in the middle of the list
            LinkedList.Node newNode = new LinkedList.Node(value, null);
            trail.peek().setNext(newNode);
            newNode.setNext(this.current);
            this.trail.push(newNode);						//Pretend that we iterated past this new node
        } else {
            this.ll.front(value);
            this.trail.push(this.ll.head);					//Pretend that we iterated past this new head
        }
    }

}