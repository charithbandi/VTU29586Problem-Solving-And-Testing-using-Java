

import java.util.Comparator;

// Write your Checker class here
class Checker implements Comparator<Player> {
    @Override
    public int compare(Player a, Player b) {
        // If scores are the same, sort alphabetically by name (ascending)
        if (a.score == b.score) {
            return a.name.compareTo(b.name);
        }
        
        // Otherwise, sort by score in descending order (highest score first)
        return Integer.compare(b.score, a.score);
    }
}
