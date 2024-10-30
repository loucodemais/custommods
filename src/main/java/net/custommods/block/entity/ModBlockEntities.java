package net.custommods.block.entity;

import net.custommods.CustomMods;
import net.custommods.block.ModBlocks;
import net.custommods.block.custom.MassFabricatorBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<MassFabricatorBlockEntity> MASS_FABRICATOR =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(CustomMods.MOD_ID, "mass_fabricator_be"),
                    FabricBlockEntityTypeBuilder.create(MassFabricatorBlockEntity::new,
                            ModBlocks.MASS_FABRICATOR).build());

    public static void registerBlockEntities() {
        CustomMods.LOGGER.info("Registering Block Entities for " + CustomMods.MOD_ID);
    }
}
