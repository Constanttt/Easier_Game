package net.easier.game;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EasierGame implements ModInitializer {

    private static final ItemGroup ALL_ITEM_GROUP = FabricItemGroupBuilder.create(
            new Identifier("easiergame", "allitems"))
            .icon(() -> new ItemStack(EasierGame.FABRIC_ITEM))
            .appendItems(stacks ->
                    stacks.add(new ItemStack(EasierGame.FABRIC_ITEM)))
            .build();

    private static final BandageItem FABRIC_ITEM = new BandageItem(new Item.Settings().group(EasierGame.ALL_ITEM_GROUP).maxCount(16));

    @Override
    public void onInitialize()
    {
        Registry.register(Registry.ITEM, new Identifier("easiergame", "bandage_item"), FABRIC_ITEM);
    }
}