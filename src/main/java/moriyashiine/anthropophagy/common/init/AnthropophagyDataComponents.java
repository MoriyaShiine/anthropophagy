/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.common.init;

import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;

import static moriyashiine.strawberrylib.api.module.SLibRegistries.registerDataComponentType;

public class AnthropophagyDataComponents {
	public static final DataComponentType<Boolean> FROM_PLAYER = registerDataComponentType("from_player", new DataComponentType.Builder<Boolean>().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL));
	public static final DataComponentType<String> OWNER_NAME = registerDataComponentType("owner_name", new DataComponentType.Builder<String>().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8));

	public static void init() {
	}
}
