package org.minerpg.lib.bukkit;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yzh on 16-8-26.
 */
public class MineRPGLib extends MineRPGPlugin {
public static List<MineRPGPlugin> rpgPlugins;

    @Override
    public void onLoad(){
        rpgPlugins=new LinkedList<MineRPGPlugin>();
    }
    @Override
    public void onEnable(){
        regPlugin(this);
        for(MineRPGPlugin p:rpgPlugins){
            if(p.getUpdater()==null){
                continue;
            }
            System.out.println("开始更新插件"+p.getName());
            p.getUpdater().doUpdate();
        }
    }

}
