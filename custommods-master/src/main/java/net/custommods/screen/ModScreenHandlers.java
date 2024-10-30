package net.custommods.screen;

import net.custommods.CustomMods;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<MassFabricatorScreenHandler> MASS_FABRICATOR_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(CustomMods.MOD_ID, "mass_fabricator"),
                    new ExtendedScreenHandlerType<>(MassFabricatorScreenHandler::new));

    public static void registerScreenHandlers() {
        CustomMods.LOGGER.info("Registering Screen Handlers for " + CustomMods.MOD_ID);
    }
}