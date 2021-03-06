/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author PC
 */
class Node<T> {
	public T data;
	public Node<T> next;
	public Node (T val) {
		data = val;
		next = null;
	}
}
public class LinkedList<T> {
	private Node<T> head;
	private Node<T> current;
	public LinkedList () {
		head = current = null;
	}
	public boolean empty () {
		return head == null;
	}
	public boolean last () {
		return current.next == null;
	}
	public boolean full () {
		return false;
	}
	public void findFirst () {
		current = head;
	}
	public void findNext () {
		current = current.next;
	}
	public T retrieve () {
		return current.data;
	}
	public void update (T val) {
		current.data = val;
	}
	public void insert (T val) {
		Node<T> tmp;
		if (empty()) {
			current = head = new Node<T> (val);
		}
		else {
			tmp = current.next;
			current.next = new Node<T> (val);
			current = current.next;
			current.next = tmp;
		}
	}
	public void remove () {
		if (current == head) {
			head = head.next;
		}
		else {
			Node<T> tmp = head;
			while (tmp.next != current)
				tmp = tmp.next;
			tmp.next = current.next;
		}
		if (current.next == null)
			current = head;
		else
			current = current.next;
	}
        
        // helper method 
        public void display(){ 
            Node<T> p= head;
        
            if(p==null)
                System.out.println("Empty Linked List!");
            else 
                System.out.print("List: ");
                while(p!=null){
                    System.out.print(p.data+ " ");
                    p=p.next;
                    
        }
            System.out.println();
}
}