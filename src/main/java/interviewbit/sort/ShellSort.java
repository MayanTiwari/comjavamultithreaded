package interviewbit.sort;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {21,2,12,4,6,3,7,8,22,35};
        int N = arr.length;
        int h = 1;
        while ( h < N/3 ){
            h = h*3 + 1;
        }
        while (h >=1){
            for(int i =h ; i < N ;i++){
                for(int j = i; j >=h && arr[j] < arr[j-h];j-=h){
                    int k = arr[j-h];
                    arr[j-h] = arr[j];
                    arr[j] = k;
                }
            }
            h = h/3;
        }
        for(int i : arr){
            System.out.println(i);
        }
    }
    private static void insertionSort(){
        int[] arr = {21,2,12,4,6,3,7,8,22,35};
        int n = arr.length;
        for(int i =1 ; i < n ; i++){
            for(int j = i ; j > 0 && arr[j] < arr[j-1]; j--){
                int k = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = k;
            }
        }
        for(int i : arr){
            System.out.println(i);
        }
    }
}
