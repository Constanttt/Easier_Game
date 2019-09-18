package net.easier.game;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.List;

public class EasierGame implements ModInitializer {

    public static final ItemGroup ALL_ITEM_GROUP = FabricItemGroupBuilder.create(
            new Identifier("easiergame", "allitems"))
            .icon(() -> new ItemStack(EasierGame.FABRIC_ITEM))
            .appendItems(stacks ->
            {
                stacks.add(new ItemStack(EasierGame.FABRIC_ITEM));
            })
            .build();

    public static final BandageItem FABRIC_ITEM = new BandageItem(new Item.Settings().group(EasierGame.ALL_ITEM_GROUP).maxCount(16));

    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.easiergame.bandage.tooltip"));
    }

    @Override
    public void onInitialize()
    {
        Registry.register(Registry.ITEM, new Identifier("easiergame", "bandage"), FABRIC_ITEM);
    }
}