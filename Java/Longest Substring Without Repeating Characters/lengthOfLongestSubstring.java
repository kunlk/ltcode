class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int res = 0, tmp = 0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();

        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                i = map.get(s.charAt(i));      
                map.clear();
            }else{
                map.put(s.charAt(i),i);                
            }
            
            tmp = map.size();
            res = Math.max(res, tmp);
        }

        return res;
    }
}
