package leetcode;

/*
1013. Partition Array Into Three Parts With Equal Sum
双指针探测法，两边都达到sum的三分之一时，即可
 */
public class PartitionArrayIntoThreePartsWithEqualSum {
    public static boolean canThreePartsEqualSum(int[] A) {
        int leftPoint = 0;
        int rightPoint = A.length - 1;
        int leftSum = A[leftPoint];
        int rightSum = A[rightPoint];
        int sum = 0;
        for (int a : A) {
            sum += a;
        }
        while (leftPoint + 1 < rightPoint) {
            if (leftSum == sum / 3 && rightSum == sum / 3) {
                return true;
            }else if(leftSum==sum/3){
                rightPoint--;
                rightSum+=A[rightPoint];
            }else if(rightSum==sum/3){
                leftPoint++;
                leftSum+=A[leftPoint];
            }else{
                leftPoint++;
                rightPoint--;
                leftSum+=A[leftPoint];
                rightSum+=A[rightPoint];
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[] A={1,-1,1,-1,1,-1};
        System.out.println(canThreePartsEqualSum(A));
    }
}
