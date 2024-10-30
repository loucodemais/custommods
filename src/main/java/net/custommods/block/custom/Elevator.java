package net.custommods.block.custom;

import net.custommods.block.ModBlocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;

public class Elevator {


    public static long useElevator(MinecraftClient client, BlockPos elevatorPos, boolean going_up){
        for (int i = 1; i <= 20; i++){
            BlockPos checkPos = elevatorPos.down(i);
            if (going_up) {
                checkPos = elevatorPos.up(i);
            }

            if (client.world.getBlockState(checkPos).isOf(ModBlocks.ELEVATOR)) {
                BlockPos teleportPos = checkPos.up(1);
                client.player.setPos(teleportPos.getX() + 0.5, teleportPos.getY() + 0.2, teleportPos.getZ() + 0.5);

                break;
            }
        }
        return System.currentTimeMillis();
    }
}
