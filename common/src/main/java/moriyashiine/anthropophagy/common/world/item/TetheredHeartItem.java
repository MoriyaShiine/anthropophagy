package moriyashiine.anthropophagy.common.world.item;

import moriyashiine.anthropophagy.common.Anthropophagy;
import moriyashiine.anthropophagy.common.component.entity.CannibalComponent;
import moriyashiine.anthropophagy.common.init.AnthropophagyEntityComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TetheredHeartItem extends Item {
	public TetheredHeartItem(Properties properties) {
		super(properties);
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
		if (entity instanceof Player player) {
			CannibalComponent cannibal = AnthropophagyEntityComponents.CANNIBAL.get(player);
			if (!cannibal.isTethered()) {
				cannibal.setTethered(true);
				player.awardStat(Stats.ITEM_USED.get(this));
				if (!player.isCreative()) {
					stack.shrink(1);
				}
				player.sendOverlayMessage(Component.translatable(Anthropophagy.MOD_ID + ".message.tether"));
			}
		}
		return super.finishUsingItem(stack, level, entity);
	}

	@Override
	public void onUseTick(Level level, LivingEntity entity, ItemStack stack, int ticksRemaining) {
		if (ticksRemaining == getUseDuration(stack, entity) / 2 && entity instanceof Player player && AnthropophagyEntityComponents.CANNIBAL.get(player).isTethered()) {
			player.sendOverlayMessage(Component.translatable(Anthropophagy.MOD_ID + ".message.tethered"));
			player.releaseUsingItem();
		}
		super.onUseTick(level, entity, stack, ticksRemaining);
	}
}
