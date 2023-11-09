package com.jcg.spring.jdbctemplate;

import java.util.*;

class LinkedList
{
	class Node
	{
		int data;
		Node next;
		Node prev;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		
		}
	}
	public Node head = null;
	public Node tail = null;
	
	public void addNode(int data) {
		Node newNode  = new Node(data);
		if(head==null) {
			head = newNode;
			tail = newNode;
			newNode.next = null;
			newNode.prev = null;
		}
		else {
			tail.next = newNode;
			tail = newNode;
			newNode.prev = tail;
			tail.next = null;
		}
	}
	public void display() {
		Node temp = head;
		while(temp!=null) {
	      System.out.print(temp.data+"-->");
          temp = temp.next;
		}
	}
	public void middleNode2() {
		Node slow = head;
		Node fast = head;
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
	      if(slow==fast) {
	    	  System.out.println("Cycle Loop Found");
	    	  break;
	      }
		}
		System.out.println("Middle Element of LinkedList :"+slow.data);
	}
	public void middleNode() {
		Node temp = head;
		int count = 0;
		while(temp!=null) {
		      count++;
	          temp = temp.next;
	    }
		Node loc = head;
		for(int i=0;i<count/2;i++) {
			loc = loc.next;
		}
		System.out.println("Middle Element of LinkedList :"+loc.data);
	}
	public void reverse() {
		Node pointer = head;
		Node current = null;
		Node previous = null;
		while(pointer!=null) {
			current = pointer;
			pointer = pointer.next;
			current.next = previous;
			previous = current;
			head = current;
		}
	}
	public void deleteNode(int index) {
		int pos =index;
		if(pos==0) {
			head = head.next;
			return;
		}
		Node tem = head;
	    for(int i=0;i<pos-2;i++) {
	    	tem = tem.next;
	    }
	    Node n = tem.next.next;
	    tem.next = n;
	}
	
              
}
public class DoublyLinkedList {

	public static void main(String[] args) {
		 LinkedList l = new LinkedList();
		 l.addNode(1);
		 l.addNode(3);
		 l.addNode(5);
		 l.addNode(31);
		 l.addNode(54);
         l.addNode(23);
         l.addNode(15);
         l.display();
         System.out.println(" ");
         l.middleNode();
         System.out.println(" ");
         l.middleNode();
         System.out.println(" ");
         l.reverse();
         l.display();
         System.out.println(" ");
         l.deleteNode(3);
         l.display();
         
	}

}
