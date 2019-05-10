var longestPalindrome = function(s){
    if(!s || !s.trim())
    return '';
    if(s.length === 1)
    return s;
    if(s.length ===2)
    return s[0] ===s[1]?s[0]+s[1]:s[0];

    var sArray = s.split('');
    var x = [...new Set(sArray)];
    var result;
    var result1;
    var result2;
    
    if(x.length === 1)
    return s;

    result1 = sArray.reduce(function(memo,item,idx,self){
        var ret;

        if(idx === 0)
        return memo;
        if(typeof self(idx - 1) !=='string' || self[idx - 1] !==self[idx +1])
        return memo;

        memo = (function(){
            var middle = idx;
            var i =1 ;
            var result = item;

            while(typeof self[middle +i] ==='string' && typeof self[middle-i]==='string' && self[middle+i]===self[middle-i]){
                ++i;
            }
            if (i === 1){
                return memo;
            }

            i=i-1;
            result = self.slice(middle-i,middle+i+1).join('');

            return result.length>(memo && memo.length || 1)? result:memo;
        })();
        return memo;

    },sArray[0]);

    result2 = sArray.reduce(function(memo,item,idx,self){
        if(item!=self(idx+1))
        return memo;

        memo = (function(){
            var left = idx;
            var right = idx +1;
            var i=1;
            var result = item+item;

            while(typeof self[right+i]==='string' &&typeof self[left-i]==='string' && self[left - i] === self[right + i]){
                ++i;
            }
            if (i===1)
            return result.length>(memo && memo.length||1)?result:memo;
        })();
        return memo;
    },sArray[0]);
    return result1.length>result2.length?result1:result2;
}