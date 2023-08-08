package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;


    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster=new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if(this.roster.size()<this.capacity) {
            this.roster.add(player);
        }
    }
    public boolean removePlayer(String name) {
        return roster.removeIf(p->p.getName().equals(name));
    }
    public void promotePlayer(String name) {
        for (Player player : this.roster) {
            if(player.getName().equals(name)) {
                player.setRank("Member");
                break;
            }
        }
    }
    public void demotePlayer(String name) {
        for (Player player : this.roster) {
            if(player.getName().equals(name)) {
                player.setRank("Trial");
                break;
            }
        }
    }
    public int count() {
        return this.roster.size();
    }
    public Player[] kickPlayersByClass(String clazz) {
       Player [] players= this.roster.stream()
                .filter(p->p.getClazz().equals(clazz))
                .toArray(Player[]::new);
        for (Player player : players) {
            this.roster.removeIf(p->p.getName().equals(player.getName()));
        }
        return players;
    }
    public String report() {
        StringBuilder sb =new StringBuilder();
        sb.append(String.format("Players in the guild: %s:%n",name));
        for (Player player : roster) {
            sb.append(player).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}
