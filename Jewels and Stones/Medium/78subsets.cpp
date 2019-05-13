class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>>res;
        vector<int> t;
        if(nums.size()<1){
            res.push_back(t);
            return res;
        }
        t.push_back(nums[0]);
        res.push_back(t);
        for(int i=1;i<nums.size();i++){
            int n=res.size();
            for(int k=0;k<n;k++){
                res.push_back(res[k]);
            }
            for(int j=0;j<res.size()/2;j++){
                res[j].push_back(nums[i]);
            }
            vector<int>tem;
            tem.push_back(nums[i]);
            res.push_back(tem);
        }
        vector<int>tem;
        res.push_back(tem);
        return res;
    }
};