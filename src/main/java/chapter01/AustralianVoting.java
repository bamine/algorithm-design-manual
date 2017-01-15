package main.java.chapter01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class AustralianVoting {
    public static Map<Integer, Long> countVotes(List<int[]> votes, Set<Integer> losers){
        Map<Integer, Long> m = votes
                .stream()
                .map(v -> getBest(v, losers))
                .filter(c -> c.isPresent())
                .collect(Collectors.groupingBy(c -> c.get(), Collectors.counting()));
        return m;
    }

    public static Optional<Integer> getBest(int[] votes, Set<Integer> losers){
        for(int vote: votes){
            if(!losers.contains(vote)) return Optional.of(vote);
        }
        return Optional.empty();
    }

    public static Optional<Integer> getWinner(Map<Integer, Long> counts){
        int sumVotes = 0;
        for(Integer c: counts.keySet()){
            sumVotes += counts.get(c);
        }

        for(Integer c: counts.keySet()){
            if(Math.round(((double) counts.get(c) / sumVotes)*100)>50){
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }

    public static Set<Integer> getLosers(Map<Integer, Long> counts){
        long minVotes = counts.entrySet().stream().map(e -> e.getValue()).min(Long::compareTo).orElse(0L);
        return counts.entrySet().stream().filter(e -> e.getValue() == minVotes).map(e -> e.getKey()).collect(Collectors.toSet());
    }

    public static boolean onlyTies(Map<Integer, Long> counts){
        long minVotes = counts.entrySet()
                .stream()
                .map(c -> c.getValue())
                .min(Long::compareTo)
                .get();
        long maxVotes = counts.entrySet()
                .stream()
                .map(c -> c.getValue())
                .max(Long::compareTo)
                .get();
        return minVotes == maxVotes;
    }

    public static String winner(List<int[]> votes, String[] candidates, Set<Integer> losers){
        Map<Integer, Long> counts = countVotes(votes, losers);
        if(onlyTies(counts)){
            return counts.entrySet()
                    .stream()
                    .map(e -> candidates[e.getKey()-1])
                    .filter(s -> !s.equals("None"))
                    .reduce((s1, s2) -> s1 + "\n" + s2).get();
        }
        Optional<Integer> winner = getWinner(counts);
        if(winner.isPresent()){
            return candidates[winner.get()-1];
        }
        else {
            losers.addAll(getLosers(counts));
            return winner(votes, candidates, losers);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int nCases = Integer.parseInt(in.readLine());
        in.readLine();
        for(int i=0; i<nCases; i++){
            int nCandidates = Integer.parseInt(in.readLine());
            String[] candidates = new String[nCandidates];
            for(int c=0; c<nCandidates; c++){
                String name = in.readLine();
                candidates[c] =name;
            }
            List<int[]> votes = new ArrayList<>();
            String line;
            while((line = in.readLine()) != null && !line.equals("")){
                int[] vs = Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                votes.add(vs);
            }
            System.out.println(winner(votes, candidates, new HashSet<>()));
            System.out.println();
        }
    }
}
