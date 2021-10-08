class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> returnResult = new LinkedList<>();
        Map<String, Integer> mp = new LinkedHashMap<>();
        // 滑动窗口+hashmap
        for (int i = 0; i < s.length() - 9; i++) {
            String temp = s.substring(i, i + 10);

            int fingFlag = mp.getOrDefault(temp, 0);
            if (fingFlag == 0) {
                mp.put(temp, 1);
            } else if (fingFlag == 1){ // 第二次出现了
                returnResult.add(temp);
                mp.put(temp, 2);
            }
        }
        // System.out.println("returnResult: " + returnResult);
        return returnResult;
    }
}