package com.myskdias.uhc.mechanic.data;

import com.myskdias.uhc.UHCMain;
import com.myskdias.uhc.mechanic.UHC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Logger;

public class UHCDataManager {

    private final String dataVarName;
    private final Field uhcDataField;

    /**
     * This field is in charge of keeping the data of player leaving mid-game
     */
    private final HashMap<UUID,UHCData> dataMap = new HashMap<>();

    public UHCDataManager(String dataVarName) {
        this.dataVarName = dataVarName;

        this.uhcDataField = getField();

    }

    public Logger getLogger() {
        return UHCMain.getInstance().getLogger();
    }

    private Field getField() {
        getLogger().fine("Retrieving newly created field...");
        String craftPath = Bukkit.getServer().getClass().getCanonicalName().replace("CraftServer","");
        String path = craftPath + "entity.CraftPlayer";
        try {
            return Class.forName(path).getDeclaredField(dataVarName);
        } catch (ClassNotFoundException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public UHCData getData(Player p) {

        try {
            UHCData uhcData = (UHCData) uhcDataField.get(p);
            if(uhcData == null) {
                uhcData = dataMap.remove(p.getUniqueId());
                if(uhcData == null) {
                    uhcData = new UHCData();
                    uhcDataField.set(p, uhcData);
                } else {
                    uhcDataField.set(p, uhcData);
                }
            }
            return uhcData;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    private UHCData getData0(Player p) {
        try {
            return (UHCData) uhcDataField.get(p);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    public void playerQuit(Player p) {
        dataMap.put(p.getUniqueId(), getData0(p));

    }

}
