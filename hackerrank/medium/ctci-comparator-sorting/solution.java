

class Checker implements Comparator<Player> {
    @Override
    public int compare(Player a, Player b) {
        if (a.score != b.score) {
            // Sort descending by score
            return b.score - a.score;
        }
        // If scores are equal, sort ascending by name
        return a.name.compareTo(b.name);
    }
}

