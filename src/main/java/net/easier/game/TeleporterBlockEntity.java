package net.easier.game;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.CompoundTag;

public class TeleporterBlockEntity extends BlockEntity {

    // Store the current value of the number
    private int number = 7;

    public TeleporterBlockEntity(){
        super(EasierGame.TELEPORTER_BLOCK_ENTITY);
    }

    // Serialize the BlockEntity
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);

        // Save the current value of the number to the tag
        tag.putInt("number", number);

        return tag;
    }

    // Deserialize the BlockEntity
    public void fromTag(CompoundTag tag) {
        super.fromTag(tag);
        number = tag.getInt("number");
    }
}
