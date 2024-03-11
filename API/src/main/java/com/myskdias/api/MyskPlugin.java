package com.myskdias.api;

import com.myskdias.api.logging.CustomLogger;
import com.myskdias.api.logging.Color;
import org.bukkit.plugin.PluginLogger;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

import static com.myskdias.api.logging.Color.*;

public class MyskPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        //getLogger().log(Level.INFO, DARK_YELLOW+"<===[Enabling"+DARK_BLUE+"["+BRIGHT_BLUE+getName()+DARK_BLUE+"]"+BRIGHT_YELLOW+"]===>"+RESET);

    }

    @Override
    public void onLoad() {
        setUpCustomLogger();
        modifyPluginName(DARK_BLUE+"["+BRIGHT_BLUE+getName()+DARK_BLUE+"] ");
    }

    /**
     * change the pluginName var in the pluginLogger object of this plugin </br>
     * this change the name  that appear on the console</br>
     * if you want to change the color of the message appearing on the console use {@link CustomLogger#setColor(String color)}
     * @param name the new name (don't forget the space at the end)
     */
    protected void modifyPluginName(String name) {
        try {
            Field pName = PluginLogger.class.getDeclaredField("pluginName");
            pName.setAccessible(true);
            pName.set(getLogger(), name);
            pName.setAccessible(false);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * change the pluginLogger instance with a new one that add a {@link Color#RESET} string at the end of each log
     * so that the color of a message does not affect the following msg
     */
    private void setUpCustomLogger() {
        try {
            Field pLogger = JavaPlugin.class.getDeclaredField("logger");
            pLogger.setAccessible(true);
            pLogger.set(this, new CustomLogger(this));
            pLogger.setAccessible(false);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public CustomLogger getCustomLogger() {
        return (CustomLogger) getLogger();
    }

}
