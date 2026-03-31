/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.common.event;

import moriyashiine.anthropophagy.common.init.ModEntityComponents;
import net.fabricmc.fabric.api.entity.event.v1.EntitySleepEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import org.jspecify.annotations.Nullable;

import java.util.List;

public class CannibalSleepEvent implements EntitySleepEvents.AllowSleeping {
	@Override
	public Player.@Nullable BedSleepingProblem allowSleep(Player player, BlockPos sleepingPos) {
		List<Player> nearbyCannibals = player.level().getEntitiesOfClass(Player.class, new AABB(sleepingPos).inflate(8, 5, 8), foundPlayer -> foundPlayer != player && ModEntityComponents.CANNIBAL_LEVEL.get(foundPlayer).getCannibalLevel() >= 70);
		if (!nearbyCannibals.isEmpty()) {
			return Player.BedSleepingProblem.NOT_SAFE;
		}
		return null;
	}
}
