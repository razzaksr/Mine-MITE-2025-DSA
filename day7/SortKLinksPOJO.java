package day7;

import java.util.PriorityQueue;

public class SortKLinksPOJO {
    public static MyLink merge(MyLink[] arr){
        PriorityQueue<Integer> queues = new PriorityQueue<>();

        for(MyLink each:arr){
            while(each!=null){
                queues.add(each.data);
                each=each.next;
            }
        }

        MyLink head = new MyLink(0);
        MyLink tail = head;

        while(!queues.isEmpty()){
            // System.out.print(queues.poll()+"-> ");
            MyLink temp = new MyLink(queues.poll());
            tail.next = temp;
            tail = tail.next;
        }

        return head.next;
    }
    public static void readAll(MyLink obj){
        while (obj!=null) {
            System.out.print(obj.data+" -> ");
            obj=obj.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        MyLink[] lists = new MyLink[3];
        
        lists[0] = new MyLink(90);
        lists[0].next = new MyLink(11);
        lists[0].next.next = new MyLink(30);

        lists[1] = new MyLink(3);
        lists[1].next = new MyLink(20);
        lists[1].next.next = new MyLink(10);
        lists[1].next.next.next = new MyLink(11);

        lists[2] = new MyLink(9);
        lists[2].next = new MyLink(31);

        MyLink merged = merge(lists);
        readAll(merged);
    }
}
class MyLink{
    int data;
    MyLink next;
    public MyLink(){}
    public MyLink(int d){this.data=d;this.next=null;}
}