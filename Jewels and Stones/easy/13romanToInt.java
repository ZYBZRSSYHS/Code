class Solution {
    public int romanToInt(String s) {
        int result = 0;
        int len = s.length();
        for(int i = 0; i < len; i++) {
            switch(s.charAt(i)) {
                case 'I': 
                    result += 1;
                    break;
                case 'V': 
                    result += 5;
                    break;
                case 'X':
                    result += 10;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    result += 100;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
            }
        }
    for(int j=0;j<len-1;j++){
        switch(""+s.charAt(j)+s.charAt(j+1)){
            case "IV":
                case "IX":
                    result -= 2;
                    break;
                case "XL":
                case "XC":
                    result -= 20;
                    break;
                case "CD":
                case "CM":
                    result -= 200;
                    break;
            }
        }
        return result;
    }
}