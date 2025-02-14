import java.util.*;
public class SelectionSort{
    public static void selectionSort(int []examScores){
        for(int i=0;i<examScores.length;i++){
            int min_indx=i;
            for(int j=i+1;j<examScores.length;j++){
                if(examScores[j]<examScores[min_indx]){
                    min_indx=j;
                }
            }
            //swap ith element with min indxx value
            int temp=examScores[i];
            examScores[i]=examScores[min_indx];
            examScores[min_indx]=temp;
        }
    }
    public static void main(String[] args){
        int[] examScores = {99, 75, 97, 81, 90};
        selectionSort(examScores);
        System.out.println(Arrays.toString(examScores));
    }
}