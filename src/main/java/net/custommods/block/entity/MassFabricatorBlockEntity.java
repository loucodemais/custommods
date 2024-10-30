package net.custommods.block.custom;

import net.custommods.block.entity.ModBlockEntities;
import net.custommods.item.ModItems;
import net.custommods.screen.MassFabricatorScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.custommods.block.entity.ImplementedInventory;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MassFabricatorBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);

    public static final int OUTPUT_SLOT = 0;
    public static final int INPUT_SLOT = 1;

    protected final PropertyDelegate propertyDelegate;
    private int energy = 0;
    private int maxEnergy = 72;
    private int tickCounter = 0;

    public MassFabricatorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.MASS_FABRICATOR, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index){
                    case 0 -> MassFabricatorBlockEntity.this.energy;
                    case 1 -> MassFabricatorBlockEntity.this.maxEnergy;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index){
                    case 0 -> MassFabricatorBlockEntity.this.energy = value;
                    case 1 -> MassFabricatorBlockEntity.this.maxEnergy = value;
                };
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity serverPlayerEntity, PacketByteBuf packetByteBuf) {
        packetByteBuf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Mass Fabricator");
    }

    @Override
    public DefaultedList<ItemStack> getItems(){
        return inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("mass_fabricator.energy", energy);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        energy = nbt.getInt("mass_fabricator.energy");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new MassFabricatorScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    public static void tick(World world, BlockPos pos, BlockState state, MassFabricatorBlockEntity entity) {
        if (!world.isClient()) {
            entity.tickCounter++;

            if (entity.tickCounter >= 20) {
                entity.tickCounter = 0;

                ItemStack uuMatter = new ItemStack(ModItems.UUMATTER, 1);
                ItemStack currentStack = entity.getItems().get(0);

                if (currentStack.isEmpty()) {
                    entity.getItems().set(0, uuMatter);
                } else if (currentStack.getCount() < 64) {
                    currentStack.increment(1);
                }
            }
        }
    }
}
