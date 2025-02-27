
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


    public void show() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node node = head;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }
    //jggkhkjkjk
    public void search(int data){
        Node node=head;

        while(node.next!=null){
            if (node.data==data){
                System.out.println("element is found ");
                break;
            }
            node=node.next;


        }
        if (node.data==data){
            System.out.println("element is found ");

        }
        else{
            System.out.println("element is not found");
        }
    }

    public int length() {
        int counter = 0;
        Node current = head;
        while (current != null) {
            counter++;
            current = current.next;
        }
        return counter;
    }

    public void delete() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }
    

    public void reverse(){
        //reverse the linked list
        Node current=head;
        Node prev=null;
        Node next=null;

        while(current.next!=null){
        next=current.next;
        prev=current;

        next.next=prev;
        current=current.next;
        
        

    }
    current.next=head;
    head.next=current;
    }
}

public class Runner_linkedlist {
    public static void main(String[] args) {
        Linkedlist list = new Linkedlist();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        System.out.println("Original list:");
        list.show();

        System.out.println("Reversed list:");
        list.reverse();
        list.show();

        System.out.println("Length of list: " + list.length());

        list.search(20);
        list.search(40);

        list.delete();
        System.out.println("After deleting last element:");
        list.show();
    }
}
