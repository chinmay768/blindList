import java.util.*;

public class WordLadder_127 {

    private class Pair {
        String word;
        int steps;

        Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
//        set.addAll(wordList);

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        set.remove(beginWord);
        while (!q.isEmpty()){
            Pair curr = q.poll();
            String word = curr.word;
            int steps = curr.steps;
            System.out.println(word);

            if(word.equals(endWord)) return steps;

            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] charArr = word.toCharArray();
                    charArr[i] = ch;
                    String replacedWord = new String(charArr);
                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        // After removing we don't need to add it back because there is no point of
                        // reaching a point which was already visited with lower path size
                        q.offer(new Pair(replacedWord, steps + 1));
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {

    }
}

/*
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.



Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.


Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
 */