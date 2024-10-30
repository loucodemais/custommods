package net.custommods;

import net.custommods.screen.MassFabricatorScreen;
import net.custommods.screen.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.custommods.block.ModBlocks;
import net.custommods.block.custom.Elevator;
import net.custommods.custom.Waila;

public class CustomModsClient implements ClientModInitializer {

    private long lastTeleportTime = 0;
    private final long teleportCooldown = 500;

    @Override
    public void onInitializeClient() {
        CustomMods.LOGGER.info("Starting CustomMods Client");
        ScreenRegistry.register(ModScreenHandlers.MASS_FABRICATOR_SCREEN_HANDLER, MassFabricatorScreen::new);

        HudRenderCallback.EVENT.register(Waila::render);

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null && client.world != null) {
                Waila.waila(client);

                BlockPos playerPos = client.player.getBlockPos().down();
                if (client.world.getBlockState(playerPos).isOf(ModBlocks.ELEVATOR)) {
                    long currentTime = client.world.getTime();
                    if (client.player.input.jumping && currentTime - lastTeleportTime >= teleportCooldown) {
                        lastTeleportTime = Elevator.useElevator(client, playerPos, true);
                    } else if (client.player.isSneaking() && currentTime - lastTeleportTime >= teleportCooldown) {
                        lastTeleportTime = Elevator.useElevator(client, playerPos, false);
                    }
                }
            }
        });

    }
}
