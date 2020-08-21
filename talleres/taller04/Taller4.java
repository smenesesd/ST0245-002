
/**
 *  Taller4
 * 
 * @author Neller Pellegrino , Samuel Meneses 
 */
public class Taller4{
    /**
     *  This function calls a ArrayMax 
     *  punto 1
     * @params nums array , n is size of array
     * @return number maximun 
     */
    public static int arrayMax(int [] nums,int  n){
        return arrayMax(nums, nums[n - 1], n -1);
    }

    /**
     *  This function ArrayMax choose the maximum number in the array
     * punto 1 
     * @params array of integers , maximun number and index
     * @return number maximun  
     */
    public static int arrayMax(int [] nums, int max, int start){
        if(start<0){
            return max;
        } else {
            if(nums[start]>=max){
                return arrayMax(nums, nums[start], start-1);
            } else return arrayMax(nums, max, start-1);
        }
    }

    /**
     *  This function ArrayMax decide if it is possible to have the sum, 
     *  given a set of elements of the array
     * punto 2
     * @params array of integers , sum to search , index 
     * @return boolean , decision of search 
     */
    public static boolean groupSum(int start, int[] nums, int target){
        if (start == nums.length) return target == 0;
        return groupSum(start + 1, nums, target - nums[start])||  groupSum(start + 1, nums, target);
    }
}
