package com.myskdias.uhc;

import com.myskdias.api.MyskPlugin;
import com.myskdias.uhc.mechanic.UHC;
import com.myskdias.uhc.mechanic.UHCListener;
import com.myskdias.uhc.mechanic.data.UHCData;
import com.myskdias.uhc.mechanic.data.UHCDataManager;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.pool.TypePool;
import org.bukkit.Bukkit;

import java.lang.reflect.Modifier;
import java.util.logging.Level;

public class UHCMain extends MyskPlugin {

    private static UHCMain instance;

    private static final String dataVarName = "uhcData";

    private UHCDataManager uhcDataManager;
    private UHC uhc;

    @Override
    public void onLoad() {
        super.onLoad();
        instance = this;
        getLogger().setLevel(Level.ALL);
        setUpUHCData();
    }

    @Override
    public void onEnable() {
        super.onEnable();
        this.uhc = setUpUHC();
        Bukkit.getPluginManager().registerEvents(new UHCListener(), this);
    }

    /**
     * Inject the CraftPlayer class and create the UHCDataManager object.</br>
     * The purpose of injecting the CraftPlayer instead of creating a HashMap < Player, UHCData> is
     * to access the UHCData object in O(1) instead of O(n) where n is the number of player connected.
     *
     */
    private void setUpUHCData() {
        getLogger().info("Trying to inject a new field into the CraftPlayer class");
        try {
            injectPlayerClass();
        } catch (Exception e) {
            getLogger().info("It seems that the injection is already done");
        }
        getLogger().info("Successfully injected the CraftPlayer class !");
        this.uhcDataManager = new UHCDataManager(dataVarName);

    }

    /**
     * Modify the unloaded CraftPlayer class then loaded it with the {@link sun.misc.Launcher.AppClassLoader }
     * by bukkit. It s not possible to add a field with a type {@link UHCData } because this class is loaded with another
     * class loader ({@link org.bukkit.plugin.java.PluginClassLoader}. Hence if we used it the class will be loaded by
     * Bukkit class loader. This will prevent the {@link Class#getDeclaredField(String)} from working. Also the plugin will not be reloadable. </br>
     * Loading the CraftPlayer class with the {@link org.bukkit.plugin.java.PluginClassLoader} of this plugin will make changes useless because
     * Bukkit will still load it with its class loader, therefore the used CraftPlayer class will not be the modified one.
     */
    private void injectPlayerClass() {
        String craftPath = Bukkit.getServer().getClass().getCanonicalName().replace("CraftServer","");
        String path = craftPath + "entity.CraftPlayer";
        TypePool typePool = TypePool.Default.of(Bukkit.getServer().getClass().getClassLoader());

        getLogger().info(Bukkit.getServer().getClass().getClassLoader().toString());
        new ByteBuddy()
                .redefine(typePool.describe(path).resolve(),
                        ClassFileLocator.ForClassLoader.ofSystemLoader())
                .defineField(dataVarName, Object.class, Modifier.PUBLIC)
                .make()
                .load(Bukkit.getServer().getClass().getClassLoader(), ClassLoadingStrategy.Default.INJECTION)
                .getLoaded();
    }

    private UHC setUpUHC() {
        return new UHC();
    }

    public UHCDataManager getUhcDataManager() {
        return uhcDataManager;
    }

    public UHC getUhc() {
        return uhc;
    }

    public static UHCMain getInstance() {
        return instance;
    }

}
