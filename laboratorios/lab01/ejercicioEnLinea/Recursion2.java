/**
 *
 * @author Neller Pellegrino , Samuel Meneses
 */
public class Recursion2{
    public boolean groupSum5(int start, int[] nums, int target) {
  
  if(start >= nums.length)
        return target == 0;
          
    if(nums[start] % 5 == 0) {
        if(start <= nums.length - 2 && nums[start+1] == 1)
            return groupSum5(start+2, nums, target - nums[start]);
                            
        return groupSum5(start+1, nums, target - nums[start]);
    }
                                    
    if(groupSum5(start+1, nums, target - nums[start]))
        return true;
                                              
    if(groupSum5(start+1, nums, target))
        return true;
                                                        
    return false;
    
}

public boolean groupSum6(int start, int[] nums, int target) {
  
  if(start >= nums.length)
        return target == 0;
          
    if(nums[start] == 6)
        return groupSum6(start+1, nums, target - 6);
                    
    if(groupSum6(start+1, nums, target - nums[start]))
        return true;
                              
    if(groupSum6(start+1, nums, target))
        return true;
                                        
    return false;
    
}

public boolean groupNoAdj(int start, int[] nums, int target) {
  
  if(start >= nums.length)
        return target == 0;
          
    if(groupNoAdj(start+2, nums, target - nums[start]))
        return true;
                    
    if(groupNoAdj(start+1, nums, target))
        return true;
                              
    return false;
    
}

public boolean splitArray(int[] nums) {
   
        return splitArray2(nums, 0, 0, 0);
    }
    public boolean splitArray2(int[] nums, int i, int group1, int group2) {
        if((i>=0)&&(i<nums.length)) {
            return splitArray2(nums, i+1, group1+nums[i], group2)||splitArray2(nums, i+1, group1, group2+nums[i]);
        } else return group1==group2;
    
}

public boolean splitOdd10(int[] nums) {
  
  return splitOdd102(nums, 0, 0, 0);
    }
    public boolean splitOdd102(int[] nums, int i, int group1, int group2) {
        if((i>=0)&&(i<nums.length)) {
            return splitOdd102(nums, i+1, group1+nums[i], group2)||splitOdd102(nums, i+1, group1, group2+nums[i]);
        } else return (group1%10==0)&&(group2%2!=0);
    }
    
}
