import java.util.Scanner;

public class insert_data{
    public class node{
        int data;
        node next = null;
        public node(int data){
            this.data = data;
        }
    }

    static node head = null;
    static node tem = null;
    public void addNode(int d){
        node n = new node(d);
        if(head==null){
            head = n;
            return;
        }
        tem = head;
        while(tem.next!=null){
            tem=tem.next;
        }
        tem.next=n;
    }
    public static void main(String[] args) {
        int a[] = new int[3];
        insert_data it = new insert_data();
        for(int i=0;i<3;i++){
            Scanner input = new Scanner(System.in);
            a[i]=input.nextInt();
            it.addNode(a[i]);
        }
        tem = head;
        for(int j=0;j<3;j++){
            System.out.println(tem.data+" ");
            tem = tem.next;
        }
    }
}