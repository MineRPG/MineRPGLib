package org.minerpg.lib.bukkit;

import org.bukkit.plugin.java.JavaPlugin;
import org.minerpg.lib.bukkit.updater.Updater;

import static org.minerpg.lib.bukkit.MineRPGLib.rpgPlugins;

/**
 * Created by yzh on 16-8-26.
 */
public class MineRPGPlugin extends JavaPlugin {
    private Updater up=null;
    protected void regPlugin(MineRPGPlugin plugin){
        rpgPlugins.add(plugin);
    }
    protected void setUpdater(Updater updater){
        this.up=updater;
    }
    protected Updater getUpdater(){
        return up;
    }
}
