package com.myskdias.uhc.mechanic.data;

import com.myskdias.uhc.mechanic.team.Team;

import java.util.UUID;

public class UHCData {

    private Team team;
    private int killCount = 0;

    public UHCData() {
    }

    public Team setTeam(Team team) {
        Team oldTeam = this.team;
        this.team = team;
        return oldTeam;
    }

    public Team getTeam() {
        return team;
    }

    private void increaseKillCount() {
        killCount++;
    }

    public int getKillCount() {
        return killCount;
    }
}
