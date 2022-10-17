package com.imjustdoom.hostilemobs.item;

import com.imjustdoom.hostilemobs.HostileMobs;
import net.minecraft.world.item.Item;

public class ItemBase extends Item {

    public ItemBase() {
        super(new Item.Properties().tab(HostileMobs.HostileMobsTab));
    }
}