import java.util.*;
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<String>();
        int length=digits.length();
        if(length==0)
        {
            return result;
        }
        Hashtable<Character,char[]> phonenumber=new Hashtable<Character,char[]>();
        phonenumber.put('0',new char[] {});
        phonenumber.put('1',new char[] {});
        phonenumber.put('2',new char[] {'a','b','c'});
        phonenumber.put('3',new char[] {'d','e','f'});
        phonenumber.put('4',new char[] {'g','h','i'});
        phonenumber.put('5',new char[] {'j','k','l'});
        phonenumber.put('6',new char[] {'m','n','o'});
        phonenumber.put('7',new char[] {'p','q','r','s'});
        phonenumber.put('8',new char[] {'t','u','v'});
        phonenumber.put('9',new char[] {'w','x','y','z'});
        StringBuffer re=new StringBuffer();
        drawphone(result,re,phonenumber,digits);
        return result;
    }
    public void drawphone(List<String> result,StringBuffer now,Hashtable<Character,char[]> phone,String digits)
    {
        if(digits.length()==now.length())
        {
            result.add(now.toString());
            return;
        }
        System.out.println(now.length());
        char nowphonenumber=digits.charAt(now.length());
        if(nowphonenumber=='7' || nowphonenumber=='9')
        {
            char[] nowchar=new char[4];
            nowchar=phone.get(nowphonenumber);
            int size=nowchar.length;
            for(int i=0;i<size;i++)
            {
                now.append(nowchar[i]);
                drawphone(result,now,phone,digits);
                now.deleteCharAt(now.length()-1);
            }
        }else
        {
            char[] nowchar=new char[3];
            nowchar=phone.get(nowphonenumber);
            int size=nowchar.length;
            for(int i=0;i<size;i++)
            {
                now.append(nowchar[i]);
                drawphone(result,now,phone,digits);
                now.deleteCharAt(now.length()-1);
            }
        }

    }
}