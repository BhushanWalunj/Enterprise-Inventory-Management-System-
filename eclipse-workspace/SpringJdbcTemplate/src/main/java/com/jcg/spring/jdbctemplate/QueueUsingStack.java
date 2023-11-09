package com.jcg.spring.jdbctemplate;
import java.util.Stack;
import java.util.*;
public class QueueUsingStack {
	static Stack<Integer> stack1;
	static Stack<Integer> stack2;
	public static void main(String[]args) {
		stack1 = new Stack<>();
	    stack2 = new Stack<>();
	    Scanner s = new Scanner(System.in);
	    
	    QueueUsingStack q  = new QueueUsingStack();
	    System.out.println("TotalQueries:");
	    int Totalquery = s.nextInt();
	    for(int i=0;i<Totalquery;i++) {
	        System.out.println("1:Enqueue 2:Dequeue 3:displayFrontElement");
	    int count = s.nextInt();
	    
	    switch(count) 
	    {
	    case 1: 
	    	System.out.println("Element:");
	    	int num = s.nextInt();
	    	q.enqueue(num);
	    	break;
	    case 2:
	    	q.dequeue();
	    	
	    case 3:
	    	System.out.println(q.display());
	    	break;
	    default:
	    	System.out.println("operation expired");
	    	break;
	    }   
	     }
	}
	
	public void enqueue(int data) {
	
		stack1.push(data);
   
	}
	public int dequeue() {
		
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		
		return (int)stack2.pop();
	}
	
	public int display() {
		int frontElement = -1;
		
	    if (stack2.isEmpty()) {
	        if (stack1.isEmpty()) {
	            System.out.println("Queue is empty.");
	            return -1;
	        } else {
	            while (!stack1.isEmpty()) {
	                stack2.push(stack1.pop());
	            }
	        }
	    }
	    frontElement = stack2.peek();
	    return frontElement;
	}

}
