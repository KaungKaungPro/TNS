// Class for double linked list, addAtTail, addAtHead, Search(value) to get Index, deletion, printout
class DoubleLinked
{
	int value;
	DoubleLinked prev;
	DoubleLinked next;
	
	public DoubleLinked(int value)
	{
		this.value = value;
		this.prev = null;
		this.next = null;
	}
}

class DoubleLinkedL
{
	DoubleLinked head = null;
	DoubleLinked tail = null;
	
	int size = 0;
	
	public void addAtTail(int value)
	{
		DoubleLinked newNode = new DoubleLinked(value);
		
		if(head == null)
		{
			head = newNode;
			tail = newNode;
		}
		
		else
		{
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		size++;
	}
	
	public void addAtHead(int value)
	{
		DoubleLinked newNode = new DoubleLinked(value);
		
		if(head == null)
		{
			head = newNode;
			tail = newNode;
		}
		else
		{
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		size++;
		
	}
	
	public DoubleLinked getNode(int index)
	{
		DoubleLinked current = head;
		for(int i = 1; i <= index; i++)
		{
			current = current.next;
		}
		
		return current;
	}
	
	public void addAtIndex(int index, int value)
	{		
		if(index == 0)
		{
			addAtHead(value);
		}
		
		else if(index == size)
		{
			addAtTail(value);
		}
		else
		{
			DoubleLinked newDouble = new DoubleLinked(value);
			DoubleLinked prevNode = getNode(index - 1);
			
			newDouble.prev = prevNode;
			newDouble.next = prevNode.next;
			prevNode.next.prev = newDouble;
			prevNode.next = newDouble;
		}
		
		size++;
	}
	
	public void print()
	{
		if(head == null)
		{
			System.out.println("There is no element");
		}
		
		DoubleLinked current = head;
		while(current != null)
		{
			System.out.println(current.value);
			current = current.next;
		}
	}
	
	public void delete(int index)
	{
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("Index value is invalid");
		
		else if(index == 0)
		{
			head = head.next;
			head.prev = null;
		}
		else if(index == size)
		{
			tail = tail.prev;
			tail.next = null;
		}
		else
		{
			DoubleLinked prevNode = getNode(index - 1);
			prevNode.next = prevNode.next.next;
			if(prevNode.next != null)
			{
				prevNode.next.prev = prevNode;
			}
		}
		size--;
	}
	
	public void deleteEntire() //this method first get the head element, and increment the memory location of the element.In this process, create another temp element to point out the current element
		//memory location along the loop. THis temp varaible to point out the same memory location of current element is just to remove the next property even after the current variable gets //incremented
	{
		DoubleLinked current = head;
		while(current != null)
		{
			DoubleLinked  temp = current;
			current = current.next;
			temp.next = null;
		}
		
		size = 0;
		head = null;
		tail = null;
	}
	
	public int searchIndex(int data)
	{
		if(head == null)
			return -1;
		else 
		{
			DoubleLinked d = head;
			int index = 0;
			while(d != null)
			{
				if(d.value == data)
					return index;		
				index++;
				d = d.next;
			}
			return -2;
		}
	}
}

class DoubleLinkedList
{
	public static void main (String[]args)
	{
		DoubleLinkedL l = new DoubleLinkedL();
		l.addAtHead(10); //0
		l.addAtTail(20); //1
		l.addAtTail(30);//3
		l.addAtTail(40);//4
		l.addAtTail(50);//5
		l.addAtIndex(2, 100); //2
		l.print();
		System.out.println(l.getNode(4));
		System.out.println("After deleting the index number 5");	
		l.delete(5);
		l.print();
		l.deleteEntire();
		System.out.println("After deleting entirely");
		l.print();
	
	}
}

