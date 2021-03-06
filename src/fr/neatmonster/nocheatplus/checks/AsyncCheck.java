package fr.neatmonster.nocheatplus.checks;

import org.bukkit.entity.Player;

import fr.neatmonster.nocheatplus.hooks.NCPExemptionManager;
import fr.neatmonster.nocheatplus.utilities.CheckUtils;

public abstract class AsyncCheck extends Check {

	public AsyncCheck(CheckType type) {
		super(type);
	}

	@Override
	public boolean isEnabled(Player player) {
		try {
            if (!type.isEnabled(player) || type.hasCachedPermission(player))
                return false;
        } catch (final Exception e) {
            CheckUtils.scheduleOutput(e);
        }
        return !NCPExemptionManager.isExempted(player, type);
	}
	
}
