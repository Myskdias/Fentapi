package com.myskdias.uhc.mechanic.team;

import com.myskdias.uhc.UHCMain;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Team {

    private final int maxSize;
    private final List<Player> members;
    private final String symbol;

    public Team(int maxSize, String symbol) {
        this.maxSize = maxSize;
        this.members = new ArrayList<>();
        this.symbol = symbol;
    }

    public boolean addMember(Player p) {
        if(members.size() < maxSize) {
            members.add(p);
            UHCMain.getInstance().getUhcDataManager().getData(p).setTeam(this);
            return true;
        }
        return false;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public List<Player> getMembers() {
        return members;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(symbol, team.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxSize, members, symbol);
    }
}
