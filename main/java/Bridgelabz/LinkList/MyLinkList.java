package Bridgelabz.LinkList;

public class MyLinkList {

	public INode head;
	public INode tail;

	public MyLinkList() {
		this.head=null;
		this.tail=null;
	}

	public void add(INode newNode) {
		if(this.tail==null) {
			this.tail=newNode;
		}
		if(this.head==null) {
			this.head=newNode;
		}
		else {
			INode tempNode=this.head;
			this.head=newNode;
			this.head.setNext(tempNode);
		}
	}
	public void append(INode myNode) {
		if(this.head == null) {
			this.head = myNode;
		}
		if(this.tail == null) {
			this.tail = myNode;
		}
		else {
			this.tail.setNext(myNode);
			this.tail = myNode;
		}
	}

	public void insert(INode myNode, INode newNode) {
		INode tempNode = myNode.getNext();
		myNode.setNext(newNode);
		newNode.setNext(tempNode);
	}

	public INode pop() {
		INode tempNode = this.head;
		this.head = head.getNext();
		return tempNode;
	}
	public INode popLast() {
		INode tempNode = head;
		while(!tempNode.getNext().equals(tail)) {
			tempNode = tempNode.getNext();
		}
		this.tail = tempNode;
		tempNode.setNext(null);
		return tempNode;
	}

	public boolean search(INode node) {
		INode tempNode = head;
		boolean found = false;
		while(tempNode.getNext() != null) {
			if(tempNode.getKey() == node.getKey()) {
				found = true;
			}
			tempNode = tempNode.getNext();
		}
		return found;
	}

	public void searchThenInsert(INode searchNode, INode insertNode) {
		MyLinkList n = new MyLinkList();
		INode tempNode = head;
		boolean inserted = false;
		while(tempNode.getNext() != null) {
			if(tempNode.getKey() == searchNode.getKey()) {
				n.insert(searchNode,insertNode);
			}
			tempNode = tempNode.getNext();
		}
	}

	public void searchThenDelete(INode deleteNode) {
		MyLinkList linkedList = new MyLinkList();
		INode tempNode = head;
		boolean inserted = false;
		while(tempNode.getNext() != null) {
			if(tempNode.getKey() == deleteNode.getKey()) {
				linkedList.pop();
			}
			tempNode = tempNode.getNext();
		}
	}

	public int size() {
		INode tempNode = head;
		int count = 1;
		while(tempNode.getNext() != null) {
			count++;
			tempNode = tempNode.getNext();
		}
		return count;
	}
	public void printMyNode() {
		StringBuffer myNode = new StringBuffer("My Node");
		INode tempNode = head;
		while(tempNode.getNext() != null) {
			myNode.append(tempNode.getKey());
			if(!tempNode.equals(tail)) myNode.append("->");
			tempNode= tempNode.getNext();
		}
		myNode.append(tempNode.getKey());
		System.out.println(myNode);
	}
}




