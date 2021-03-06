public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        int length=nums.length;
        int left=0;
        int right=length-1;
        if(length==0)
        {
            List<List<Integer>> result=new ArrayList<List<Integer>>();
            return result;
        }
        //quick_sort(nums,left,right);
        Arrays.sort(nums);//使用排序解决重复问题。使用Arrays类中sort方法比自己写的快排快一倍左右
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        int i=left;
        /*
        此注释方法为i从最左边取起，j从最右边取起，x从i之后到j之间循环，但此方法会超时
        */
        /*while(i<right-1 && nums[i]<=0)
        {
            while(i>0 && i<right-1 && nums[i]==nums[i-1])
            {
                i++;
            }
            int j=right;

            while(j>i+1 && nums[j]>=0)
            {
                while(j<right && j>i+1 && nums[j]==nums[j+1])
                {
                    j--;
                }
                int x=i+1;
                while(x<j && nums[x]<=nums[j])
                {
                    while(x>i+1 && x<j && nums[x]==nums[x-1])
                    {
                        x++;
                    }
                    if(nums[i]+nums[j]+nums[x]==0 && x<j)
                    {
                        List<Integer> now=new ArrayList<Integer>();
                        now.add(nums[i]);
                        now.add(nums[x]);
                        now.add(nums[j]);
                        result.add(now);
                    }
                    if(nums[i]+nums[j]+nums[x]>0)
                    {
                        break;
                    }
                    x++;
                }
                j--;
            }
            i++;
        }*/
        while(nums[i]<=0 && i<right-1)//此方法先循环i，之后x和j变为求2sum问题
        {
            while(i>0 && i<right-1 && nums[i]==nums[i-1])
            {
                i++;
            }
            int nowleft=-nums[i];
            int j=right;
            int x=i+1;
            while(x<j)
            {
                if(nums[x]+nums[j]==nowleft)
                {
                        List<Integer> now=new ArrayList<Integer>();
                        now.add(nums[i]);
                        now.add(nums[x]);
                        now.add(nums[j]);
                        result.add(now);
                        x++;
                        j--;
                        while(x<j && nums[x]==nums[x-1])
                        {
                            x++;
                        }
                        while(x<j && nums[j]==nums[j+1])
                        {
                            j--;
                        }
                }else if(nums[x]+nums[j]<nowleft)
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