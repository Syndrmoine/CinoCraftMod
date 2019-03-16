package syn.cinocraft.machines.cinofurnace;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerCinoFurnace extends Container {

        private TileCinoFurnace te;

        private static final int PROGRESS_ID = 0;

        public ContainerCinoFurnace(IInventory playerInventory, TileCinoFurnace te) {
            this.te = te;

            // This container references items out of our own inventory (the 9 slots we hold ourselves)
            // as well as the slots from the player inventory so that the user can transfer items between
            // both inventories. The two calls below make sure that slots are defined for both inventories.
            addOwnSlots();
            addPlayerSlots(playerInventory);
        }

        private void addPlayerSlots(IInventory playerInventory) {
            // Slots for the main inventory
            for (int row = 0; row < 3; ++row) {
                for (int col = 0; col < 9; ++col) {
                    int x = 9 + col * 18;
                    int y = row * 18 + 70;
                    this.addSlotToContainer(new Slot(playerInventory, col + row * 9 + 10, x, y));
                }
            }

            // Slots for the hotbar
            for (int row = 0; row < 9; ++row) {
                int x = 9 + row * 18;
                int y = 58 + 70;
                this.addSlotToContainer(new Slot(playerInventory, row, x, y));
            }
        }

        private void addOwnSlots() {
            IItemHandler itemHandler = this.te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
            int x = 10;
            int y = 6;

            int slotIndex = 0;
            addSlotToContainer(new SlotItemHandler(itemHandler, slotIndex++, x, y)); x += 18;
            addSlotToContainer(new SlotItemHandler(itemHandler, slotIndex++, x, y)); x += 18;
            addSlotToContainer(new SlotItemHandler(itemHandler, slotIndex++, x, y)); x += 18;

            x = 119;
            y = 29;
            addSlotToContainer(new SlotItemHandler(itemHandler, slotIndex++, x, y)); x += 18;
            addSlotToContainer(new SlotItemHandler(itemHandler, slotIndex++, x, y)); x += 18;
            addSlotToContainer(new SlotItemHandler(itemHandler, slotIndex++, x, y));


        }

        @Override
        public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
            ItemStack itemstack = ItemStack.EMPTY;
            Slot slot = this.inventorySlots.get(index);

            if (slot != null && slot.getHasStack()) {
                ItemStack itemstack1 = slot.getStack();
                itemstack = itemstack1.copy();

                if (index < TileCinoFurnace.SIZE) {
                    if (!this.mergeItemStack(itemstack1, TileCinoFurnace.SIZE, this.inventorySlots.size(), true)) {
                        return ItemStack.EMPTY;
                    }
                } else if (!this.mergeItemStack(itemstack1, 0, TileCinoFurnace.SIZE, false)) {
                    return ItemStack.EMPTY;
                }

                if (itemstack1.isEmpty()) {
                    slot.putStack(ItemStack.EMPTY);
                } else {
                    slot.onSlotChanged();
                }
            }

            return itemstack;
        }

        @Override
        public boolean canInteractWith(EntityPlayer playerIn) {
            return te.canInteractWith(playerIn);
        }

        @Override
    public void detectAndSendChanges() {
            super.detectAndSendChanges();
            for (IContainerListener listener : listeners) {
                listener.sendWindowProperty(this, PROGRESS_ID,te.getProgress());
            }
        }

    @Override
    public void updateProgressBar(int id, int data) {
        if (id == 0);
        te.setProgress(data);
    }
}
