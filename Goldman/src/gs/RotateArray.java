package gs;

public class RotateArray {
    public void rotateArray(int[] nums,int k){
        int n =nums.length%k;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,n-1);
        reverse(nums,n,nums.length-1);

    }

    public void reverse (int[] nums,int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args){
        int[] arr= {1,2,3,4,5,6,7};
        int k=3;
    }
}
