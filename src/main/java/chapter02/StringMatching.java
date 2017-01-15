package main.java.chapter02;

import java.util.Optional;

public class StringMatching {
    public static Optional<Integer> findMatch(String s1, String s2){
        for(int i=0; i<s1.length(); i++){
            int j = 0;
            while(j<s2.length() && s1.charAt(i+j) == s2.charAt(j)){
                j++;
            }
            if(j == s2.length()) return Optional.of(i);
        }
        return Optional.empty();
    }
}
