class Pair{
    String word;
    int steps;
    Pair(String word,int steps){
        this.word = word;
        this.steps = steps;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        Set<String> hs = new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            hs.add(wordList.get(i));
        }
        hs.remove(beginWord);
        while(!q.isEmpty()){
            Pair p = q.poll();
            String word = p.word;
            int steps = p.steps;
            if(word.equals(endWord)){
                return steps;
            }
            for(int i=0;i<word.length();i++){
                for(char ch = 'a';ch<='z';ch++){
                    char[] wordArr = word.toCharArray();
                    wordArr[i] = ch;
                    String replacedWord = new String(wordArr);
                    if(hs.contains(replacedWord)){
                        hs.remove(replacedWord);
                        q.add(new Pair(replacedWord,steps+1));
                    }
                }
            }
        }
        return 0;
        
    }
}