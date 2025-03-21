class Node {
    int data;
    Node next;

    public Node(int data) 
    {
        this.data = data;
        this.next = null;
    }
    
}


class Queue {
    
    Node head;

    public void Insert(int data) {

        Node node = new Node(data);
        node.next = null;

        if (head == null) {
            head = node;
        }
        
        else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }
    
    public int Pop()
    {
        if (head == null) {
            throw new RuntimeException("Queue is empty!");
        }

        int data = head.data;
        head = head.next;
        return data;
    }
    
    public boolean is_Empty() {
        return (head == null);
    }
    
    public void Display() {
        Node node = head;

        while (node != null) {
            int data = node.data;
            System.out.print(data + " ");
        }
    }

    public int Length() {
        int count = 0;
        Node node = head;
        while (node != null) {
            count++;
        }

        return count;
    }
    

}

public class Runner_queue_linkedlist {
    public static void main(String[] args) {
        Queue q = new Queue();
        
        // Inserting elements
        q.Insert(10);
        q.Insert(20);
        q.Insert(30);
        q.Insert(40);
        
        // Displaying elements
        System.out.print("Queue elements: ");
        q.Display();

        // Queue length
        System.out.println("Queue length: " + q.Length());

        // Dequeuing elements
        System.out.println("Dequeued: " + q.Pop());
        System.out.println("Dequeued: " + q.Pop());

        // Display after dequeue
        System.out.print("Queue after dequeue: ");
        q.Display();

        // Checking if queue is empty
        System.out.println("Is queue empty? " + q.is_Empty());

        // Final queue length
        System.out.println("Final queue length: " + q.Length());
    }
}