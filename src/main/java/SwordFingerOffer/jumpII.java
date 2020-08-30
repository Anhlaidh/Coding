package SwordFingerOffer;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-14 13:27
 */
public class jumpII {
    public static void main(String[] args) {
        System.out.println(JumpFloorII(6));


    }
    public static  int JumpFloorII(int target) {
        if(target==1) {
            return 1;
        }
        int sum = 1;
        int[] arr = new int[target+1];
        for (int i = 2; i < arr.length; i++) {
            arr[i] = sum + 1;
            sum += arr[i];
        }
        return arr[target];


    }
}
