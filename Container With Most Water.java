public class Solution {
    public int maxArea(int[] height) {
        int length=height.length;
        int left=0;
        int right=length-1;
        int minnum=0;
        int result=0;
        while(left<right)
        {
            int now=min(height[left],height[right]);
            if(now>minnum)
            {
                int nowresult=now*(right-left);
                if(nowresult>result)
                {
                    result=nowresult;
                }
            }
            if(height[left]>height[right])
            {
                right--;
            }else
            {
                left++;
            }
        }
        return result;
    }
    public int min(int a,int b)
    {
        if(a<b)
        {
            return a;
        }else
        {
            return b;
        }
    }
}