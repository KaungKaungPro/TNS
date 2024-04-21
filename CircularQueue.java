class CQ
{
	//set up the required resource to analayze the circular queue
	int[] cQArray;
	int size;
	int front;
	int rear;
	
	//creation of circular queue, right now there is no element inside the queue
	public void createQueue(int maxSize)
	{
		cQArray = new int[maxSize];
		size = maxSize;
		front = -1;
		rear = -1;
	}
	
	public void enQueue(int value)
	{
		if(isFull())
			System.err.println("Queue Overflow problem!");
		else
		{
			if(front == -1)
			{
				front = 0;
			}
			
			rear = (rear + 1) % size;
			cQArray[rear] = value;
			System.out.printf("Inserted the value : %d inside the Circular queue %d%n", value, rear);
		}
	}
	
	public void deQueue()
	{
		if(isEmpty())
		{
			System.err.println("Queue Underflow problem!");
		}
		else if(front == rear)//by the time the element before the last element is extracted front will add +1.so, when we call the dequeue, the front element will be the same as rear, and empty list 
		{
			front = rear = -1;
		}
		else
		{
			front = (front + 1)% size;
		}
	}
	
	
	public boolean isFull()
	{
		if(front == 0 && rear == cQArray.length-1)
			return true;
		else if(front == rear + 1)
			return true;
		else
		{
			return false;
		}
		
	}
	
	public boolean isEmpty()
	{
		if(front == -1)
			return true;
		else
			return false;
	}
	
	public void printQueue()
	{
		for(int i = front; ; i =  (i + 1 ) % size)
		{
			System.out.println(cQArray[i]);
			if( i == rear)
			{
				break;
			}
		}
	}
	
}

class CircularQueue
{
	public static void main(String[]args)
	{
		CQ cq = new CQ();
		cq.createQueue(4);
		cq.enQueue(10);
		cq.enQueue(20);
		cq.enQueue(30);
		cq.enQueue(40);
		cq.deQueue();
		cq.deQueue();
		cq.enQueue(50);
		cq.enQueue(60);
		cq.deQueue();
		cq.printQueue();
		
		
	}
}