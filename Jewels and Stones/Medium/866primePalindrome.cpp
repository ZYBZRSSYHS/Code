class Solution {
public:

    bool Prime(int A){
        if(A==2)
        return true;
        if(A%2==0||A==1)
        return false;
        for(int i=3;i<=sqrt(A);i+=2){
            if(A%i==0)
            return false;
        }
        return true;
    }
    bool Palindrome(int B){
        string str1 = to_string(B);
        string str2(str1.rbegin(),str1.rend());
        if(str1==str2)return true;
        return false;
    }
    int primePalindrome(int N) {
        if(N>9989899)
        return 100030001;
        while(1){
            if(Palindrome(N))
            if(Prime(N))
            return N;
            N++;
        }
    }
};