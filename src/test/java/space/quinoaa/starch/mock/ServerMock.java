/*
 * MIT License
 * Copyright (c)  quinoaa 2023.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package space.quinoaa.starch.mock;

import com.avaje.ebean.config.ServerConfig;
import org.bukkit.*;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.help.HelpMap;
import org.bukkit.inventory.*;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.CachedServerIcon;
import space.quinoaa.starch.mock.data.MockData;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import java.util.logging.Logger;

public class ServerMock implements Server {
	private final MockData data;

	public ServerMock(MockData data) {
		this.data = data;
	}


	@Override
	public String getName() {
		return "bukkit mock";
	}

	@Override
	public String getVersion() {
		return "stub";
	}

	@Override
	public String getBukkitVersion() {
		return "stub";
	}

	@Override
	public Player[] _INVALID_getOnlinePlayers() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Collection<? extends Player> getOnlinePlayers() {
		return data.getPlayerList().getPlayerList();
	}

	@Override
	public int getMaxPlayers() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int getPort() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int getViewDistance() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public String getIp() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public String getServerName() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public String getServerId() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public String getWorldType() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean getGenerateStructures() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean getAllowEnd() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean getAllowNether() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean hasWhitelist() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setWhitelist(boolean b) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Set<OfflinePlayer> getWhitelistedPlayers() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void reloadWhitelist() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int broadcastMessage(String s) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public String getUpdateFolder() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public File getUpdateFolderFile() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public long getConnectionThrottle() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int getTicksPerAnimalSpawns() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int getTicksPerMonsterSpawns() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Player getPlayer(String s) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Player getPlayerExact(String name) {
		return data.getPlayerList().getPlayer(name);
	}

	@Override
	public List<Player> matchPlayer(String s) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Player getPlayer(UUID uuid) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public PluginManager getPluginManager() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public BukkitScheduler getScheduler() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public ServicesManager getServicesManager() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public List<World> getWorlds() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public World createWorld(WorldCreator worldCreator) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean unloadWorld(String s, boolean b) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean unloadWorld(World world, boolean b) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public World getWorld(String s) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public World getWorld(UUID uuid) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public MapView getMap(short i) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public MapView createMap(World world) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void reload() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Logger getLogger() {
		return Logger.getLogger("bukkit mock");
	}

	@Override
	public PluginCommand getPluginCommand(String s) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void savePlayers() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean dispatchCommand(CommandSender commandSender, String s) throws CommandException {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void configureDbConfig(ServerConfig serverConfig) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean addRecipe(Recipe recipe) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public List<Recipe> getRecipesFor(ItemStack itemStack) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Iterator<Recipe> recipeIterator() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void clearRecipes() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void resetRecipes() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Map<String, String[]> getCommandAliases() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int getSpawnRadius() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setSpawnRadius(int i) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean getOnlineMode() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean getAllowFlight() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean isHardcore() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean useExactLoginLocation() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void shutdown() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int broadcast(String s, String s1) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public OfflinePlayer getOfflinePlayer(String s) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public OfflinePlayer getOfflinePlayer(UUID uuid) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Set<String> getIPBans() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void banIP(String s) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void unbanIP(String s) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Set<OfflinePlayer> getBannedPlayers() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public BanList getBanList(BanList.Type type) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Set<OfflinePlayer> getOperators() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public GameMode getDefaultGameMode() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setDefaultGameMode(GameMode gameMode) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public ConsoleCommandSender getConsoleSender() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public File getWorldContainer() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public OfflinePlayer[] getOfflinePlayers() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Messenger getMessenger() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public HelpMap getHelpMap() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Inventory createInventory(InventoryHolder inventoryHolder, InventoryType inventoryType) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Inventory createInventory(InventoryHolder inventoryHolder, InventoryType inventoryType, String s) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Inventory createInventory(InventoryHolder inventoryHolder, int i) throws IllegalArgumentException {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Inventory createInventory(InventoryHolder inventoryHolder, int i, String s) throws IllegalArgumentException {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int getMonsterSpawnLimit() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int getAnimalSpawnLimit() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int getWaterAnimalSpawnLimit() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int getAmbientSpawnLimit() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean isPrimaryThread() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public String getMotd() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public String getShutdownMessage() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Warning.WarningState getWarningState() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public ItemFactory getItemFactory() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public ScoreboardManager getScoreboardManager() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public CachedServerIcon getServerIcon() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public CachedServerIcon loadServerIcon(File file) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public CachedServerIcon loadServerIcon(BufferedImage bufferedImage) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setIdleTimeout(int i) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int getIdleTimeout() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public ChunkGenerator.ChunkData createChunkData(World world) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	@SuppressWarnings("all")
	public UnsafeValues getUnsafe() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Spigot spigot() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void sendPluginMessage(Plugin plugin, String s, byte[] bytes) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Set<String> getListeningPluginChannels() {
		throw new UnsupportedOperationException("STUB");
	}
}
