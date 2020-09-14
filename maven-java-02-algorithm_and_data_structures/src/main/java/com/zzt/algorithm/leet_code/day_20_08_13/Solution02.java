package com.zzt.algorithm.leet_code.day_20_08_13;

/**
 * 描述：<br>题库 -- 算法 -- 12. 整数转罗马数字</>
 * <p>网页地址：https://leetcode-cn.com/problems/integer-to-roman/
 * 个人思路：贪心思想
 *      1. 将所有情况诺列，数值从大到小排列 data[] ;
 *      2. 从数值大的数值开始，判断 num>data[i] ,如果为true 则在字符串加上相应字符
 *      3. 重复步骤二，知道num==0;
 * @author 周志通
 * @version 1.0.0
 * @date 2020/8/13 17:52
 */
public class Solution02 {

    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        Data[] data = new Data[13];
        pre(data);
        int point = 0;
        int i;
        while (num > 0) {
            i = num / data[point].data;
            num -= data[point].data * i;
            while (i > 0) {
                builder.append(data[point].c);
                i-- ;
            }
            /*while (num >= data[point].data) {
                builder.append(data[point].c);
                num -= data[point].data;
            }*/
            point++;
        }
        return builder.toString();
    }

    private void pre(Data[] data) {
        data[0] = new Data(1000, "M");
        data[1] = new Data(900, "CM");
        data[2] = new Data(500, "D");
        data[3] = new Data(400, "CD");
        data[4] = new Data(100, "C");
        data[5] = new Data(90, "XC");
        data[6] = new Data(50, "L");
        data[7] = new Data(40, "XL");
        data[8] = new Data(10, "X");
        data[9] = new Data(9, "IX");
        data[10] = new Data(5, "V");
        data[11] = new Data(4, "IV");
        data[12] = new Data(1, "I");
    }

    private static class Data {
        public int data;
        public String c;

        Data(int data, String c) {
            this.data = data;
            this.c = c;
        }
    }

    private String[] charMap = new String[]{"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
    private int[] intMap = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};

    /**
     * 他人思路：
     * @param num
     * @return
     */
    public String intToRoman2(int num) {
        StringBuilder sb = new StringBuilder();
        int index =charMap.length-1;
        while(num>0){
            if(num-intMap[index]>=0){
                sb.append(charMap[index]);
                num-=intMap[index];
            }else{
                index--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int num = 2354;
        String s = new Solution02().intToRoman(num);
        System.out.println(s);
    }

}
