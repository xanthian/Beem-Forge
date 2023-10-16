package net.xanthian.beem_forge;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY_BEEM = "key.category.beem";
    public static final String KEY_TOGGLE_BEEM = "key.beem.toggle_beem";

    public static final KeyMapping TOGGLE_BEEM = new KeyMapping(KEY_TOGGLE_BEEM, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_B, KEY_CATEGORY_BEEM);
}