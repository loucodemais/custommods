package net.custommods.custom;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Text;
import net.minecraft.util.hit.BlockHitResult;

public class Waila {

    private static boolean shouldRender = false;
    private static String blockName = "";

    public static void waila(MinecraftClient client) {
        if (client.world != null && client.crosshairTarget instanceof BlockHitResult blockHit) {
            var blockPos = blockHit.getBlockPos();
            var blockState = client.world.getBlockState(blockPos);

            if (blockState != null) {
                String newBlockName = blockState.getBlock().getName().getString();
                if (!newBlockName.equals(blockName)) {
                    blockName = newBlockName;
                    shouldRender = !blockName.equals("Air");
                }
            } else {
                shouldRender = false;
            }
        } else {
            shouldRender = false;
        }
    }

    public static void render(DrawContext context, float tickDelta) {
        if (shouldRender && !blockName.isEmpty()) {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.player != null) {
                TextRenderer textRenderer = client.textRenderer;
                int windowWidth = client.getWindow().getScaledWidth();
                int x = (windowWidth - textRenderer.getWidth(blockName)) / 2;
                int y = 3;

                context.drawTextWithShadow(textRenderer, Text.of(blockName), x, y, 0xFFFFFF);
            }
        }
    }
}
