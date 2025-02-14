import java.util.*;
public class CountingSort{
    public static void countSort(int []ages){
        if(ages==null||ages.length<=1){
            return;
        }
        int max=ages[0];
        for(int i=0;i<ages.length;i++){
            if(ages[i]>max){
                max=ages[i];
            }
        }
        int []freqArray=new int[max+1];
        for(int num:ages){
            freqArray[num]++;
        }
        //freq array created now make changes in original array using frq array
        int index=0;
        for(int i=0;i<=max;i++){
            while(freqArray[i]>0){
                ages[index]=i;
                index++;
                freqArray[i]--;
            }
        }
    }
    public static void main(String[] args){
        int[] ages = {16, 10, 18, 14, 11, 12, 13, 11, 16};
        countSort(ages);
        System.out.println(Arrays.toString(ages));
    } 
}