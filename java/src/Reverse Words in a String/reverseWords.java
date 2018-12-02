public class Solution {
    public String reverseWords(String s) {
        String[] res = s.trim().split(" +");
        Collections.reverse(Arrays.asList(res));
        return String.join(" ", res);
    }
}
