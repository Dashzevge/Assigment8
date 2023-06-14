package assignment8;

import java.util.LinkedList;


public class DoublyLinkedList {
	
	Node header;
	DoublyLinkedList(){
		header = new Node();
	}
	//adds to the end of the list
	public void addLast(String item){
		Node pred = header;
    	Node succ = header.next;
    
    	Node newNode = new Node();
    	newNode.value = item;
    	newNode.next = succ;
    	newNode.previous = pred;
    	pred.next = newNode;
    	//succ.previous = newNode; 	
	}
	public boolean remove(String item){
        if(item == null || item == "") return false;
        
        Node pred = header.next;
        while(!pred.value.equals(item)) {
        	 
        	 pred = pred.next; 
        }
        Node succ = pred.next;
    	pred.next = succ;
    	pred.previous = pred; 	
		return true;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		toString(sb, header);
		return sb.toString();
		
	}
	private void toString(StringBuilder sb, Node n) {
		if(n==null) return;
		if(n.value != null) sb.append(" " + n.value);
		toString(sb, n.next);
	}
	
	class Node {
		String value;
		Node next;
		Node previous;
		
		public String toString() {
			return value == null ? "null" : value;
		}
	}

	public static void main(String[] args){
		DoublyLinkedList list = new DoublyLinkedList();
		list.addLast("Bob");
		list.addLast("Bill");
		list.addLast("Tom");
		list.addLast("Carol");

		list.remove("Bill");
		System.out.println(list.toString());
	}

}
