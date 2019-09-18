package net.easier.game;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class BandageItem extends Item {
    public BandageItem(Settings settings)
    {
        super(settings);
    }

    public int getMaxUseTime(ItemStack itemStack) {
        return 32;
    }

    public UseAction getUseAction(ItemStack itemStack) {
        return UseAction.NONE;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.setCurrentHand(hand);
        playerEntity.playSound(SoundEvents.BLOCK_WOOL_BREAK, 1.0F, 1.0F);
        return new TypedActionResult(ActionResult.SUCCESS, playerEntity.getStackInHand(hand));
    }

    public ItemStack finishUsing(ItemStack itemStack, World world, LivingEntity livingEntity) {
        super.finishUsing(itemStack, world, livingEntity);
        livingEntity.addPotionEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20, 2));
        PlayerEntity playerEntity = livingEntity instanceof PlayerEntity ? (PlayerEntity)livingEntity : null;
        if (playerEntity == null || !playerEntity.abilities.creativeMode) {
            itemStack.decrement(1);
        }
        return itemStack;
    }

    public boolean useOnEntity(ItemStack itemStack, PlayerEntity playerEntity, LivingEntity livingEntity, Hand hand) {
        livingEntity.addPotionEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20, 2));
        itemStack.decrement(1);
        return true;
    }
}