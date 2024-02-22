package com.myskdias.chat;

import com.myskdias.api.MyskPlugin;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

public class AdvancedChat extends MyskPlugin {

    static AdvancedChat instance;
    
    @Override
    public void onEnable() {
        super.onEnable();
        instance = this;
        saveDefaultConfig();
        FileConfiguration fc = getConfig();
        String format = fc.getString("format");
        Bukkit.getPluginManager().registerEvents(new ChatListener(format), this);
    }

    public static AdvancedChat getInstance() {
        return instance;
    }
    
}
