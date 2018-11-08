class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;       
        Map<Character,Integer> map = new HashMap<Character,Integer>();

        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                i = map.get(s.charAt(i));      
                map.clear();
            }else{
                map.put(s.charAt(i),i);                
            }           
            res = Math.max(res, map.size());
        }

        return res;
    }
    
    //Solution 2 - Sliding Window
    public int lengthOfLongestSubstring(String s) {
        int res = 0, p = 0, q = 0;
        Set<Character> set = new HashSet<Character>();
        
        while(q < s.length()){
            if(set.contains(s.charAt(q))){
                set.remove(s.charAt(p++));
            }else{
                set.add(s.charAt(q++));
                res = Math.max(res, q-p);
            }
        }
        return res;
    }
    
    //Solution 3 - Sliding Window optimized
    public int lengthOfLongestSubstring(String s) {
	int res = 0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        
	for(int i = 0, j = 0; j < s.length(); j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(i,map.get(s.charAt(j)));
            }
            map.put(s.charAt(j),j+1);
	    res = Math.max(res, j-i+1);
        }
        return res;
    }
}
