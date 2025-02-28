class Node{
    int data;
    Node next;

    public Node(int data){
        this.data=data;
        this.next=null;

    }
}

class Stack{

    Node head;

    public void push(int x){
        if (head==null){
            Node n=new Node(x);
            head=n;
        }
        else{
            Node n=new Node(x);
            n.next=head;
            head=n;

        }
    }

    public int pop(){
        if (isEmpty()){
            System.out.println("stack is empty");
            return -1;

        }
        else{
            Node temp=head;
            Node n=head.next;
            head=n;
            return temp.data;
        }

    }

    public int size(){
        if (isEmpty()){
            System.out.println("This is empty stack");
            return -1;
        }
        else{
            int counter=0;
            Node n=head;
            while(n!=null){
                n=n.next;
                counter++;

            }
            return counter;
        }
    }
    
    public Boolean isEmpty(){
        if (head==null){
            return true;
        }
        else{
            return false;
        }
    }

    public void display(){
        if (isEmpty()){
            System.out.println("Stack is empty");

        }
        else{
        Node n=head;
        while(n!=null){
            System.out.print(n.data+" ");
            n=n.next;
        }
    }
    }
}