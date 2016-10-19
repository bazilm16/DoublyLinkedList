public class DoublyLinkedList<T> {
	
	private class Node<T>{
		Node next;
		Node prev;
		T value;
		
		public Node(){
			next = null;
		}
		
		public Node(T val){
			next = null;
			value = val;
		}
		
	}

	private Node root;
	private int size;//this is the size of the linked list
	private Node last;//the last element in the list
	
	/**
	 * Singly linked list constructor without initial value
	 */
	public DoublyLinkedList(){
		root = null;
		last = null;
		size = 0;
	}
	
	/**
	 * Singly linked list constructor with initial value
	 * @param val
	 */
	public DoublyLinkedList(T val){
		root = new Node<T>(val);
		size = 1;
		last = root;
	}
	
	/**
	 * deletes the last element of the linked list
	 * @return, the last element deleted from the linked list
	 */
	public T delete(T val){
		T lastElem = null;
		if(root.value == val){
			root = root.next;
		}else{
			Node<T> curr = root;
			while(curr.next != null){
				if(curr.next.value == val){
					curr.next = curr.next.next;
					break;
				}
				curr = curr.next;
			}
		}
		return val;
	}//pop
	
	/**
	 * adds the element to the end of the linked list
	 * @param val, the value to be added to the linked list
	 */
	public void add(T val){
		//start from the last of the list and add the element at constant time
		Node<T> newNode = new Node(val);
		newNode.prev = last;
		last.next = newNode;
		last = last.next;
		size++;
	}//push
	
	/**
	 * gets the size of the list
	 * @return, the size of the list
	 */
	public int size(){
		return this.size;
	}//size
	
	public void print(){
		Node<T> curr = root;
		int i = 0;
		while(curr != null){
			//System.out.println(++i + "j");
			System.out.println(curr.value);
			curr = curr.next;
		}
	}//prints the elements of the list
	
	public static void main(String args[]){
		DoublyLinkedList list = new DoublyLinkedList(27);
		list.add(24);
		list.add(78);
		list.add(57);
		list.delete(78);
		list.add(43);
		//list.push(57);
		list.print();
		System.out.println("size = " + list.size());
	}
	
}

