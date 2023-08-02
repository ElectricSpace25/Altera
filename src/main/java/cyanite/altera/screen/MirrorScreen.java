package cyanite.altera.screen;

import cyanite.altera.AlteraMod;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MirrorScreen extends HandledScreen<MirrorScreenHandler> {
    private static final Identifier TEXTURE =
            new Identifier(AlteraMod.MOD_ID, "textures/gui/mirror_gui.png");

    public MirrorScreen(MirrorScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleX = backgroundWidth - textRenderer.getWidth(title) - 16;
    }

    //This might be mega sketchy
    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        context.drawTexture(TEXTURE, this.x, this.y, 0, 0, backgroundWidth, backgroundHeight);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
