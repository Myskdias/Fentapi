package com.myskdias.uhc.mechanic.team;

import org.bukkit.ChatColor;

import java.util.ArrayList;

public class TeamsManager {


    private static final String[] lo = new String[] {"","\u2729", "\u25a1", "\u25b3","\u25ca","\u25cb"};

    /**
     * All the symbols available for the teams
     */
    private String[] symbols;

    /**
     * The teams existing
     */
    private Team[] teams = new Team[0];
    /**
     * The teams that have at least one player alive
     */
    private final ArrayList<Team> aliveTeams = new ArrayList<>();

    public TeamsManager() {
        ArrayList<String> tempList = new ArrayList<>();
        for(String s : lo) {
            for(ChatColor cc : ChatColor.values()) {
                if(!cc.isFormat()) {
                    tempList.add(cc+s);
                }
            }
        }
        symbols = tempList.toArray(new String[0]);
    }

    /**
     *
     * @param numberPerTeam
     * @param maxPlayer
     * @param maxSize
     * @return true if it s possible else false
     */
    public boolean setTeams(int numberPerTeam, int maxPlayer, int maxSize) {

        int m = maxPlayer % numberPerTeam;
        int n = maxPlayer / numberPerTeam;
        if(m != 0) {
            n++;
        }

        if(n > symbols.length) {
            return false;
        }
        teams = new Team[n];
        for (int i = 0; i < n; i++) {
            teams[i] = new Team(maxSize, symbols[i]);
        }
        return true;
    }



}
