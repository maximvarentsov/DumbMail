/*******************************************************************************
 * Copyright (C) 2014 Travis Ralston (turt2live)
 *
 * This software is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/

package com.turt2live.dumbmail;

import com.turt2live.commonsense.DumbPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class DumbMail extends DumbPlugin {

    private static DumbMail instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        initCommonSense(84642);

        // TODO: Enable logic
    }

    @Override
    public void onDisable() {
        // TODO: Disable logic

        instance = null;
    }

    /**
     * Sends a message to a command sender using the configured prefix
     *
     * @param player  the sender, cannot be null
     * @param message the message, cannot be null
     */
    public void sendMessage(CommandSender player, String message) {
        if (player == null || message == null) throw new IllegalArgumentException();

        String prefix = getConfig().getString("prefix", "&7[DumbMail]");
        prefix = ChatColor.translateAlternateColorCodes('&', prefix);

        if (prefix.length() > 0 && !prefix.endsWith(" ")) prefix += " ";

        player.sendMessage(prefix + message);
    }

    /**
     * Gets the current instance of this plugin.
     *
     * @return the current instance, may be null
     */
    public static DumbMail getInstance() {
        return instance;
    }

}
