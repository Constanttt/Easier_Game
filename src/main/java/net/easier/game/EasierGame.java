package net.easier.game;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EasierGame implements ModInitializer {

    public static final ItemGroup ALL_ITEM_GROUP = FabricItemGroupBuilder.create(
            new Identifier("easiergame", "allitems"))
            .icon(() -> new ItemStack(EasierGame.BANDAGE_ITEM))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(EasierGame.BANDAGE_ITEM));
                stacks.add(new ItemStack(EasierGame.LEATHER_BLOCK));
            })
            .build();

    public static final BandageItem BANDAGE_ITEM = new BandageItem(new Item.Settings().group(EasierGame.ALL_ITEM_GROUP).maxCount(16));
    public static final LeatherBlock LEATHER_BLOCK = new LeatherBlock(FabricBlockSettings.of(Material.WOOL).hardness(1).build());

    @Override
    public void onInitialize()
    {
        Registry.register(Registry.ITEM, new Identifier("easiergame", "bandage_item"), BANDAGE_ITEM);
        Registry.register(Registry.BLOCK, new Identifier("easiergame", "leather_block"), LEATHER_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("easiergame", "leather_block"), new BlockItem(LEATHER_BLOCK, new Item.Settings().group(ALL_ITEM_GROUP)));
    }
}