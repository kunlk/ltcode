class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            if(!map.containsKey(words[i])){
                map.put(words[i],1);
            }else{
                map.put(words[i],map.get(words[i]) + 1);
            }
        }
        
        List<String> list = new ArrayList<>(map.keySet());
        
        Collections.sort(list, new Comparator<String>(){
            public int compare(String s1, String s2){
                if(map.get(s1).equals(map.get(s2))){
                    return s1.compareTo(s2);
                }else{
                    return map.get(s2) - map.get(s1);
                }               
            }
        });
        
        return list.subList(0,k);
        
    }
}
