class Node
{
	int value;
	Node next;
	
	public Node(int value)
	{
		this.value = value;
		this.next = null;
	}
}

class StackLink
{
	Node head;
	int size;
	
	public void createStack()
	{
		Node head = null;
		size = 0;
	}
	
	//last in first out
	public void push(int value) 
	{
		Node newNode = new Node(value);
		if(head == null)
			head = newNode;
		else
		{
			newNode.next = head;
			head = newNode;
		}
		size++;
	}
	
	public void pop()
	{
		if(head == null)
		{
			System.out.println("Empty List");
		}
		else
		{
			System.out.printf("The head value wil be removed : %d%n", head.value);
			head = head.next;
			size--;
		}
	}
	
	public int peek()
	{
		if(head == null)
		{
			System.out.println("Empty list");
			return 0;
		}
		else
		{
			return head.value;
		}
		
	}
	
	public boolean isEmpty()
	{
		if(head == null)
			return true;
		else
			return false;
	}
	
	public void deleteStack()
	{
		head = null;
	}
}
	
class StackByLinkedList
{
	public static void main (String[]args)
	{
		StackLink sL = new StackLink();
		sL.createStack();
		sL.push(10);
		sL.push(20);
		sL.push(30);
		sL.pop();
		System.out.println(sL.peek());
	}
}