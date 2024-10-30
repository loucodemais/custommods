package net.custommods.item;

import net.custommods.CustomMods;
import net.custommods.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup OPENBLOCKS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(CustomMods.MOD_ID, "elevator"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.openblocks"))
                    .icon(() -> new ItemStack(ModBlocks.ELEVATOR)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.ELEVATOR);
                    }).build());

    public static final ItemGroup CARPENTERS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(CustomMods.MOD_ID, "carpenter"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.carpenters"))
                    .icon(() -> new ItemStack(ModBlocks.CARPENTER)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.CARPENTER);
                    }).build());

    public static final ItemGroup IC2 = Registry.register(Registries.ITEM_GROUP,
            new Identifier(CustomMods.MOD_ID, "laser_gun"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ic2"))
                    .icon(() -> new ItemStack(ModItems.LASER_GUN)).entries((displayContext, entries) -> {
                        entries.add(ModItems.UUMATTER);
                        entries.add(ModBlocks.MASS_FABRICATOR);
                        entries.add(ModItems.STICKY_RESIN);
                        entries.add(ModItems.LASER_GUN);
                    }).build());

    public static void registerItemGroups(){
        CustomMods.LOGGER.info("Registering Item Groups for " + CustomMods.MOD_ID);
    }
}
