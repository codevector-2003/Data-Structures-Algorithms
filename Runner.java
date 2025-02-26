
class Node{
    int data;
    Node next;

    public Node(int data)
    {
        this.data=data;
        this.next=null;
    }        
}


 class Linkedlist {
    Node head;

    public void insert(int data){
        Node node= new Node(data);
        node.next=null;

        if (head==null){
            head=node;
        }
        else{
            Node n =head;
            while(n.next!=null){
                n=n.next;
            }
            n.next =node;
        }
    }

    public void show(){
        Node node=head;

        while(node.next!=null){
            System.out.println(node.data);
            node=node.next;
        }
        System.out.println(node.data);
    }
    
    
}

public class Runner{
    public static void main(String[] args){

    }
}