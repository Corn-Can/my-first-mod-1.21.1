package com.corncan.myfirstmod.block;

import com.corncan.myfirstmod.MyFirstMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.VaultBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.OreFeature;

public class ModBlocks {

    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)                       //方塊硬度
                    .requiresTool()                     //方塊是否需要工具（更進階定義至LootTables）
                    .sounds(BlockSoundGroup.STONE)      //方塊聲音
            ));

    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            new Block(AbstractBlock.Settings.create()
                    .strength(3f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)
            ));

    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            new Block(AbstractBlock.Settings.create()
                    .strength(3.5f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE)
            ));

    // Helper 1, 註冊方塊本身
    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MyFirstMod.MOD_ID, name), block);
    }

    // Helper 2, 讓物品跟方塊連結起來
    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(MyFirstMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));

    }

    public static void registerModBlocks(){
        MyFirstMod.LOGGER.info("Registering Blocks for " + MyFirstMod.MOD_ID+ " mod");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.RUBY_BLOCK);
            entries.add(ModBlocks.RUBY_ORE);
            entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
        });
    }
}
