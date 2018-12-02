class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        
        int len = Math.max(ver1.length,ver2.length);
        for(int i = 0; i < len; i++){
            Integer v1 = i < ver1.length ? Integer.parseInt(ver1[i]) : 0;
            Integer v2 = i < ver2.length ? Integer.parseInt(ver2[i]) : 0;
                
            int compare = v1.compareTo(v2);
            if(compare != 0)
                return compare;
        }
        return 0;
    }
}
