package moriyashiine.anthropophagy.common;

import eu.midnightdust.lib.config.MidnightConfig;

public class AnthropophagyConfig extends MidnightConfig {
	@Entry
	public static boolean enablePiglutton = true;

	@Entry(min = 0)
	public static int damageNeededForGuaranteedFleshDrop = 8;
}
