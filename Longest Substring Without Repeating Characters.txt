public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] ch=new int[256];
        for(int i=0;i<256;i++)
        {
            ch[i]=-1;
        }
        int length=s.length();
        if(length==0)
        {
            return 0;
        }
        int first=0;
        int result=0;
        for(int i=0;i<length;i++)
        {
            int now=(int)s.charAt(i);
            if(ch[now]>=0)
            {
                if(i-first>result)
                {
                    result=i-first;
                }
                i=ch[now];
                first=ch[now]+1;
                for(int j=0;j<256;j++)
                {
                    ch[j]=-1;
                }
                continue;
            }
            ch[now]=i;
        }
        if(result<(length-first))
        {
            result=length-first;
        }
        return result;
    }
}