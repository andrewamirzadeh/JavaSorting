package chap13_Bijan;

//Bijan Amirzadehasl 10/7/2021

import java.util.LinkedList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bijan_chap13{
    
    public static void main(String[] args) throws Exception {

        
        MyLinkedList<String> list = new MyLinkedList<>();

        
        list.add("drop");
        list.add("goofy");
        list.add("Donald");
        list.add("Duck");
        list.add("Mouse");
        list.add("Kangaroo");
        list.add("Koala");
        
        // initialized list of MyLinkedListIterator
        Iterator<String> iter = list.iterator();
        
 
        
        while(iter.hasNext()) {
        	System.out.println(iter.next());
        }
    }

}

interface MyList<E>{
	
	public void insert (int index, E object) throws Exception;
	public void add (E object);
	public E get (int index ) throws Exception;
	public int indexOf (E object);
	public int lastIndexOf (E object);
	public E remove(int index) throws Exception;
	public E set(int index, E object) throws Exception;
	public int size();
	public MyLinkedListIterator iterator();
	
	
	
}



class Node<E> {
    E element;
    Node<E> next;

    public Node(E element) {
        this.element = element;
   
    }
    
}

class MyLinkedList<E> implements MyList<E>, Iterable<E> {
    Node<E> head, tail = null;
    int size = 0;

    public void insert(int index, E object) throws Exception {
        if (index < 0 || index > size - 1)
            throw new Exception("Invalid index.");

        Node<E> newNode = new Node<>(object);

        Node<E> current = head;
        int counter = 0;
        Node<E> previous = null;
        while (counter < index) {
            previous = current;
            current = current.next;
            counter++;
        } 

        if (previous != null)
            previous.next = newNode;
        newNode.next = current;

        size++;

        if (index == 0)
            head = newNode;
        if (index == size - 1)
            tail = newNode;

    }

   public void add(E object) {
        Node<E> newNode = new Node<E>(object);
        
        size++;

   
        if (head == null) {
        	head = newNode;
        }
            
        else {
        	tail.next = newNode;
        	
        }
        tail = newNode;

    }

    public E get(int index) throws Exception {
        if (index < 0 || index > size - 1)
            throw new Exception("Invalid index.");

        Node<E> current = head;
        int counter = 0;
        while (counter < index) {
            current = current.next;
            counter++;
        }

        return current.element;
    }

    public int indexOf(E object) {
        Node<E> current = head;
        int index = 0;
        while (current != null) {
            if (object.equals(current.element))
                return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public int lastIndexOf(E object) {

        int result = -1;
        Node<E> current = head;
        int index = 0;
        while (current != null) {
            if (object.equals(current.element))
                result = index;
            current = current.next;
            index++;
        }

        return result;
    }

    public E remove(int index) throws Exception {
        if (index < 0 || index > size - 1)
            throw new Exception("Invalid index.");

        Node<E> current = head;
        int counter = 0;
        Node<E> previous = null;
        while (counter < index) {

            previous = current;
            current = current.next;
            counter++;
        }

        if (previous != null)
            previous.next = current.next;
        E result = current.element;

        size--;

        if (index == 0)
            head = current.next;
        if (index == size - 1)
            tail = previous;

        return result;
    }

    public E set(int index, E object) throws Exception {
        if (index < 0 || index > size - 1)
            throw new Exception("Invalid index.");

        Node<E> current = head;
        int counter = 0;
        while (counter < index) {
            current = current.next;
            counter++;

        }

        E result = current.element;
        current.element = object;
        return result;

    }

    public int size() {
        // TODO Auto-generated method stub
        return size;
    }

    public MyLinkedListIterator iterator() {
        // TODO Auto-generated method stub
        return new MyLinkedListIterator<E>(this);
    }

    @Override
    public String toString() {

        String result = "[";
        Node<E> current = head;
        while (current != null) {

            result += current.element;
            if (current.next != null)
                result += ", ";

            current = current.next;
        }
        return result + "]";
    }
 /*   public void addAll(MyList<E> newItems) throws Exception{
    	for (int i = 0; i < newItems.size(); i++)
    		add(newItems.get(i));
    }*/
    public void clear() {
    	size = 0;
    	head = tail = null;
    }
    public Node<E> getHead()
    {
        return head;
    }
    
    public Node<E> getTail()
    {
        return tail;
    }

}

//Create the class MyLinkedListIterator<E>, which implements the Iterator<E> interface.

class MyLinkedListIterator<E> implements Iterator<E> {

   
    Node<E> currentNode;
    
    public MyLinkedListIterator(MyLinkedList<E> list)
    {
        currentNode = list.getHead();
    }

   

	// The hasNext() method should return true as long as currentNode is not null

    public boolean hasNext() {

        return currentNode != null;

    }

    // The next() method should return the list's data item at currentNode, and
    // advance currentNode
    
   

    public E next() {

        E element = currentNode.element;
        currentNode = currentNode.next;
        return element;

    }

}