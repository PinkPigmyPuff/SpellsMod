package com.jasperpuffinv.spells.item;

import com.jasperpuffinv.spells.Main;
import com.jasperpuffinv.spells.item.custom.BeginnerStaff;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item BEGINNERS_STAFF = registerItem("beginners_staff",
            new BeginnerStaff(new FabricItemSettings().maxCount(1)));

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Main.MOD_ID, name), item);
    }

    public static void addItemsToItemGroups() {
        addToItemGroup(ModItemGroup.MAGIC, BEGINNERS_STAFF);
    }

    public static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        Main.LOGGER.debug("Registering Mod Items for " + Main.MOD_ID);

        addItemsToItemGroups();
    }
}
