/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.common.init;

import com.mojang.serialization.Codec;
import net.minecraft.component.ComponentType;
import net.minecraft.network.codec.PacketCodecs;

import static moriyashiine.strawberrylib.api.module.SLibRegistries.registerComponentType;

public class ModComponentTypes {
	public static final ComponentType<Boolean> FROM_PLAYER = registerComponentType("from_player", new ComponentType.Builder<Boolean>().codec(Codec.BOOL).packetCodec(PacketCodecs.BOOLEAN));
	public static final ComponentType<String> OWNER_NAME = registerComponentType("owner_name", new ComponentType.Builder<String>().codec(Codec.STRING).packetCodec(PacketCodecs.STRING));

	public static void init() {
	}
}
