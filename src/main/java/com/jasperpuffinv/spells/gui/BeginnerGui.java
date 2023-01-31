package com.jasperpuffinv.spells.gui;

import com.jasperpuffinv.spells.Main;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;



public class BeginnerGui extends LightweightGuiDescription {
    public static boolean isExplode = false;
    public static boolean isLaunch = true;

    public static boolean isGrav = false;
    public BeginnerGui() {
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(256, 240);
        root.setInsets(Insets.ROOT_PANEL);

        WSprite icon = new WSprite(new Identifier("minecraft:textures/item/redstone.png"));
        root.add(icon, 0, 2, 1, 1);

        WButton button = new WButton(Text.literal("Launch vs Explode vs Grav"));
        button.setOnClick(() -> {
            Main.LOGGER.info("switched");
            if (isExplode) {
                isExplode = false; isLaunch = true;
            } else if (isLaunch) {
                isLaunch = false; isGrav = true;
            } else if (isGrav) {
                isGrav = false; isExplode = true;
            }
        });
        root.add(button, 0, 3, 4, 1);

        root.validate(this);
    }

}
