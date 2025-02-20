import java.util.*;
public class ReverseaList{
    public static void main(String[] args){
        List<Integer> list1=new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        List<Integer> list2=new LinkedList<>();
        list2.add(10);
        list2.add(20);
        list2.add(30);
        list2.add(40);
        list2.add(50);
        System.out.println("List1  Before reversing:");
        System.out.println(list1);
        reverse(list1);
        System.out.println("List1  After reversing:");
        System.out.println(list1);

        System.out.println("List2  Before reversing:");
        System.out.println(list2);
        reverse(list2);
        System.out.println("List2  After reversing:");
        System.out.println(list2);
    }

    public static void reverse(List<Integer> list){
        int left=0;
        int right=list.size()-1;
        while(left<right){
            //swap start and end elements
            int temp=list.get(left);
            list.set(left,list.get(right));
            list.set(right,temp);
            left++;
            right--;
        }
    }
}



// while (left < right) {
//             // Swap elements
//             T temp = list.get(left);
//             list.set(left, list.get(right));
//             list.set(right, temp);
//             left++;
//             right--;
//         }