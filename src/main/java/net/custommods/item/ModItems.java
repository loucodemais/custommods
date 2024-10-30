package net.custommods.item;

import net.custommods.CustomMods;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item UUMATTER = registerItem("uumatter", new Item(new FabricItemSettings()));
    public static final Item STICKY_RESIN = registerItem("sticky_resin", new Item(new FabricItemSettings()));
    public static final Item LASER_GUN = registerItem("laser_gun", new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(CustomMods.MOD_ID, name), item);
    }

    public static void registerModItems(){
        CustomMods.LOGGER.info("Registering Items for " + CustomMods.MOD_ID);
    }

}
