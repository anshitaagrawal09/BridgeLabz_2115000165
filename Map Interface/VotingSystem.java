import java.util.*;
public class VotingSystem {
    private Map<String, Integer> voteMap = new HashMap<>();  // Stores votes (Candidate -> Votes)
    private LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>(); // Maintains vote order
    private TreeMap<String, Integer> sortedVotes = new TreeMap<>(); // Sorted results by candidate name
    // Method to cast a vote
    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteMap.get(candidate)); // Maintain vote order
        sortedVotes.put(candidate, voteMap.get(candidate)); // Maintain sorted order
    }
    // Get votes for a specific candidate
    public int getVotes(String candidate) {
        return voteMap.getOrDefault(candidate, 0);
    }
    // Display votes in insertion order
    public void displayVotesInOrder() {
        System.out.println("\nVotes in order of insertion:");
        for (Map.Entry<String, Integer> entry : voteOrder.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }
    // Display sorted results (by candidate name)
    public void displaySortedResults() {
        System.out.println("\nVotes in alphabetical order:");
        for (Map.Entry<String, Integer> entry : sortedVotes.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }
    // Find the winner
    public void displayWinner() {
        String winner = Collections.max(voteMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("\nWinner: " + winner + " with " + voteMap.get(winner) + " votes!");
    }
    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        // Casting votes
        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");
        system.castVote("Charlie");
        system.castVote("Bob");
        system.castVote("Alice");
        // Display results
        system.displayVotesInOrder();  // Order of voting
        system.displaySortedResults(); // Sorted by candidate name
        system.displayWinner();        // Winner
    }
}
