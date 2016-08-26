package org.minerpg.lib.bukkit.item;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Map;

/**
 * Created by yzh on 16-8-26.
 */
public class MineRPGItem extends ItemStack {
    public MineRPGItem(Material material,String name,List<String> lores){
        this.getItemMeta().setDisplayName(name);
        this.getItemMeta().setLore(lores);
    }
    public MineRPGItem(Material material, String name, List<String> lores, Enchantment en,int level){
        this.getItemMeta().setDisplayName(name);
        this.getItemMeta().setLore(lores);
        this.addEnchantment(en,level);


    }
    public MineRPGItem(Material material, String name, List<String> lores, Map<Enchantment,Integer> ens){
        this.getItemMeta().setDisplayName(name);
        this.getItemMeta().setLore(lores);
        for(Enchantment e:ens.keySet()){
            this.addEnchantment(e,ens.get(e));
        }


    }
}
