class Solution {
    public String[] findWords(String[] words) {
        // Define the three keyboard rows
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";
        
        // Map each character to its row number
        int[] charToRow = new int[26];
        for (char c : row1.toCharArray()) charToRow[c - 'a'] = 1;
        for (char c : row2.toCharArray()) charToRow[c - 'a'] = 2;
        for (char c : row3.toCharArray()) charToRow[c - 'a'] = 3;
        
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            if (word.isEmpty()) continue;
            
            char firstChar = Character.toLowerCase(word.charAt(0));
            int rowNum = charToRow[firstChar - 'a'];
            boolean sameRow = true;
            
            for (char c : word.toCharArray()) {
                char lower = Character.toLowerCase(c);
                if (charToRow[lower - 'a'] != rowNum) {
                    sameRow = false;
                    break;
                }
            }
            
            if (sameRow) {
                result.add(word);
            }
        }
        
        return result.toArray(new String[0]);
    }
}
