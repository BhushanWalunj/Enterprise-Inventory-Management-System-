package com.jcg.spring.jdbctemplate;
class Stack
{
	int top;
	int[] arr;
	int capa;
	Stack(){
		this.top = -1;
		this.capa = 6;
		arr = new int[capa];
	}
	public boolean isFull() {
		return top==capa-1;
	}
	public boolean isEmpty() {
		return top==-1;
	}
	public void push(int data) {
		if(isFull()) {
			System.out.println("Stack is full");
		}
		else {
			arr[++top]=data;
		}
	}
	public void peek() {
		System.out.println(arr[top]);
	}
	public int  pop() {
		int c = -1;
		if(isEmpty())
		{
			System.out.println("Stack is Empty");
		}
		else {
		  System.out.println(arr[top]);
		  c =  arr[top--];
		}
		return c;
	}
	
	
}
public class DLL {

	public static void main(String[] args) {
	  Stack s = new Stack();
	  s.push(1);
	  s.push(3);
	  s.push(5);
	  s.push(6);
	  s.push(8);
	  s.peek();
	  System.out.println();
	  s.pop();
	  s.peek();
	}

}
