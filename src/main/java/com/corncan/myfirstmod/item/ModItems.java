package com.corncan.myfirstmod.item;

import com.corncan.myfirstmod.MyFirstMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {

    public static final Item RUBY = registerItem("ruby", new Item(new Item.Settings()));
    public static final Item STICKY_REDSTONE = registerItem("sticky_redstone", new Item(new Item.Settings()));


    //Item Register Helper 可以幫助我們註冊物品
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(MyFirstMod.MOD_ID, name), item);
    }


    //用一個方法來呼叫註冊物品
    public static void registerModItems(){
        MyFirstMod.LOGGER.info("Registering Items for "+ MyFirstMod.MOD_ID + " mod");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RUBY);
            entries.add(STICKY_REDSTONE);
        });
    }

}
