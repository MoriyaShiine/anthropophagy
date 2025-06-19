/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.common.component.entity;

import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;

public class TetheredComponent implements AutoSyncedComponent {
	private boolean tethered = false;

	@Override
	public void readData(ReadView readView) {
		tethered = readView.getBoolean("Tethered", false);
	}

	@Override
	public void writeData(WriteView writeView) {
		writeView.putBoolean("Tethered", tethered);
	}

	public boolean isTethered() {
		return tethered;
	}

	public void setTethered(boolean tethered) {
		this.tethered = tethered;
	}
}
