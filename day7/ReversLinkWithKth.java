package day7;

import java.util.ArrayList;
import java.util.List;

public class ReversLinkWithKth {

    public static MyLink doReverseK(MyLink list, int swap){
        List<Integer> temp = new ArrayList<>();
        int current = 0;
        while(list!=null){
            temp.add(list.data);
            list=list.next;
        }
        for(int index=0;index<temp.size();index++){
            current++;
            if(current==swap){
                int yek = temp.get(index);
                int tho = temp.get(index-1);
                temp.set(index,tho);
                temp.set(index-1, yek);
                current-=swap;
            }
        }
        // System.out.println(temp.size());
        list = new MyLink(temp.get(0));
        MyLink chain = list;
        for(int point = 1;point<temp.size();point++){
            MyLink newOne = new MyLink(temp.get(point));
            chain.next = newOne;
            chain = newOne;
        }
        // System.out.println(temp);
        return list;
    }

    public static void main(String[] args) {
        MyLink lists = new MyLink(3);
        lists.next = new MyLink(20);
        lists.next.next = new MyLink(10);
        lists.next.next.next = new MyLink(11);
        lists.next.next.next.next = new MyLink(9);
        int shift = 2;
        MyLink got = doReverseK(lists, shift);
        SortKLinksPOJO.readAll(got);
    }
}
