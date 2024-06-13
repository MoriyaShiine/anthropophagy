/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.common.init;

import com.mojang.serialization.Codec;
import moriyashiine.anthropophagy.common.Anthropophagy;
import net.minecraft.component.ComponentType;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModComponentTypes {
	public static final ComponentType<Boolean> FROM_PLAYER = new ComponentType.Builder<Boolean>().codec(Codec.BOOL).packetCodec(PacketCodecs.BOOL).build();
	public static final ComponentType<String> OWNER_NAME = new ComponentType.Builder<String>().codec(Codec.STRING).packetCodec(PacketCodecs.STRING).build();

	public static void init() {
		Registry.register(Registries.DATA_COMPONENT_TYPE, Anthropophagy.id("from_player"), FROM_PLAYER);
		Registry.register(Registries.DATA_COMPONENT_TYPE, Anthropophagy.id("owner_name"), OWNER_NAME);
	}
}
