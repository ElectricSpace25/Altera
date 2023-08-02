package cyanite.altera.screen;

import cyanite.altera.AlteraMod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class MirrorScreenHandler extends ScreenHandler {

    public MirrorScreenHandler(@Nullable ScreenHandlerType<?> type, int syncId) {
        super(ModScreenHandlers.MIRROR_SCREEN_HANDLER, syncId);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return null;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return false;
    }
}
