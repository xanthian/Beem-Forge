package net.noobnarb;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Style;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class Beem implements ClientModInitializer {
	private static final KeyBinding TOGGLE_BEEM = new KeyBinding(
			"beem:toggle_beem",
			InputUtil.Type.KEYSYM,
			GLFW.GLFW_KEY_B,
			"key.categories.misc"
	);
	static boolean beem = true;

	@Override
	public void onInitializeClient() {
		BlockEntityRendererRegistry.register(BlockEntityType.BEEHIVE, d -> new BeeNestBlockEntityRenderer());

		KeyBindingHelper.registerKeyBinding(TOGGLE_BEEM);

		ClientTickEvents.START_CLIENT_TICK.register(e -> {
			while (TOGGLE_BEEM.wasPressed()) {
				beem = !beem;

				if (MinecraftClient.getInstance().player != null) {
					MinecraftClient.getInstance().player.sendMessage(new TranslatableText("message.beem.toggled." + beem).setStyle(Style.EMPTY.withColor(Formatting.GOLD)), false);
				}
			}
		});
	}
}