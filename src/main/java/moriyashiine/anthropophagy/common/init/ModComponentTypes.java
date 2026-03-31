/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.common.init;

import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;

import static moriyashiine.strawberrylib.api.module.SLibRegistries.registerComponentType;

public class ModComponentTypes {
	public static final DataComponentType<Boolean> FROM_PLAYER = registerComponentType("from_player", new DataComponentType.Builder<Boolean>().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL));
	public static final DataComponentType<String> OWNER_NAME = registerComponentType("owner_name", new DataComponentType.Builder<String>().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8));

	public static void init() {
	}
}
