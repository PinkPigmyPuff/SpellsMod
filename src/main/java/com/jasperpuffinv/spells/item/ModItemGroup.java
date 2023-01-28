package com.jasperpuffinv.spells.item;

import com.jasperpuffinv.spells.Main;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static ItemGroup MAGIC;

    public static void registerItemGroup() {
        MAGIC = FabricItemGroup.builder(new Identifier(Main.MOD_ID, "magic"))
                .displayName(Text.literal("Magic Item Group"))
                .icon(() -> new ItemStack(ModItems.BEGINNERS_STAFF)).build();
    }
}
