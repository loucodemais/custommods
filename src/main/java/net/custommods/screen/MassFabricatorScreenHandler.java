package net.custommods.screen;

import net.custommods.block.custom.MassFabricatorBlockEntity;
import net.custommods.item.ModItems;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;

public class MassFabricatorScreenHandler extends ScreenHandler {

    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    public final MassFabricatorBlockEntity blockEntity;

    public MassFabricatorScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf) {
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(2));
    }

    public MassFabricatorScreenHandler(int syncId, PlayerInventory playerInventory,
                                     BlockEntity blockEntity, PropertyDelegate arrayPropertyDelegate) {
        super(ModScreenHandlers.MASS_FABRICATOR_SCREEN_HANDLER, syncId);
        checkSize(((Inventory) blockEntity), 2);
        this.inventory = ((Inventory) blockEntity);
        inventory.onOpen(playerInventory.player);
        this.propertyDelegate = arrayPropertyDelegate;
        this.blockEntity = ((MassFabricatorBlockEntity) blockEntity);

        this.addSlot(new OutputSlot(inventory, 0, 114, 17));
        this.addSlot(new InputSlot(inventory, 1, 114, 54));


        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        addProperties(arrayPropertyDelegate);
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int index) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();

            if (index == MassFabricatorBlockEntity.OUTPUT_SLOT) {
                if (!this.insertItem(originalStack, 2, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickTransfer(originalStack, newStack);
            }
            else if (index ==  MassFabricatorBlockEntity.INPUT_SLOT) {
                if (!originalStack.isOf(ModItems.STICKY_RESIN)) {
                    return ItemStack.EMPTY;
                }
                if (!this.insertItem(originalStack, 2, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            }
            else {
                if (originalStack.isOf(ModItems.STICKY_RESIN)) {
                    if (!this.insertItem(originalStack, MassFabricatorBlockEntity.INPUT_SLOT, MassFabricatorBlockEntity.INPUT_SLOT + 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else {
                    return ItemStack.EMPTY;  // Reject any other items
                }
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    private static class InputSlot extends Slot {
        public InputSlot(Inventory inventory, int index, int x, int y) {
            super(inventory, index, x, y);
        }
        @Override
        public boolean canInsert(ItemStack stack) {
            return stack.isOf(ModItems.STICKY_RESIN);
        }
    }

    private static class OutputSlot extends Slot {
        public OutputSlot(Inventory inventory, int index, int x, int y) {
            super(inventory, index, x, y);
        }
        @Override
        public boolean canInsert(ItemStack stack) {
            return false;
        }
    }
}
