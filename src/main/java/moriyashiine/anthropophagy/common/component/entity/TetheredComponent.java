/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.common.component.entity;

import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;

public class TetheredComponent implements AutoSyncedComponent {
	private boolean tethered = false;

	@Override
	public void readData(ValueInput input) {
		tethered = input.getBooleanOr("Tethered", false);
	}

	@Override
	public void writeData(ValueOutput output) {
		output.putBoolean("Tethered", tethered);
	}

	public boolean isTethered() {
		return tethered;
	}

	public void setTethered(boolean tethered) {
		this.tethered = tethered;
	}
}
