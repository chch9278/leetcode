import java.lang.*;
public class Solution {
    public int threeSumClosest(int[] nums, int target) {//类似于3sum问题
        int length=nums.length;
        int left=0;
        int right=length-1;
        Arrays.sort(nums);
        int i=left;
        int result=nums[0]+nums[1]+nums[2];
        while(i<right-1)
        {
            int nowleft=nums[i];
            int j=right;
            int x=i+1;
            while(x<j)
            {
                int sum=nums[x]+nums[j]+nowleft;
                if(sum-target==0)
                {
                    return target;
                }
                if(Math.abs(target-sum)<Math.abs(target-result))
                {
                        result=sum;
                }

                if(sum<target)
                {
                    x++;
                }else
                {
                    j--;
                }
            }
            i++;
        }
        return result;
    }
}