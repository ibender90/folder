package leet_code;

public class LastAr {
    public static void main(String[] args) {
        removeElement(new int[]{2, 2, 3}, 2);
    }
    public static int removeElement(int[] nums, int val) {

        int deleted = 0;
        int aft = nums.length-1;

        for(int fwd = 0; fwd < nums.length; fwd++){
            if(fwd == aft){
                break;
            }
            if(nums[fwd] == val){
                while(nums[aft] == val){
                    aft--;
                    if(aft < 0){
                        aft = fwd;
                        break;
                    }
                }
                nums[fwd] = nums[aft];
                nums[aft] = val;
                //aft--;
            }
        }
        for(int i = nums.length-1; i >= 0; i--){
            if(nums[i] == val){
                deleted++;
            } else break;
        }
        return nums.length-deleted;


    }
}
