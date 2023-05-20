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

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.*;
import org.bukkit.map.MapView;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.Vector;

import java.net.InetSocketAddress;
import java.util.*;

public class MockPlayer implements Player {
	private final String name;

	public MockPlayer(String name) {
		this.name = name;
	}

	@Override
	public String getDisplayName() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setDisplayName(String s) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public String getPlayerListName() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setPlayerListName(String s) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setCompassTarget(Location location) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Location getCompassTarget() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public InetSocketAddress getAddress() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean isConversing() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void acceptConversationInput(String s) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean beginConversation(Conversation conversation) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void abandonConversation(Conversation conversation) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void abandonConversation(Conversation conversation, ConversationAbandonedEvent conversationAbandonedEvent) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void sendRawMessage(String s) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void kickPlayer(String s) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void chat(String s) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean performCommand(String s) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean isSneaking() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setSneaking(boolean b) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean isSprinting() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setSprinting(boolean b) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void saveData() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void loadData() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setSleepingIgnored(boolean b) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean isSleepingIgnored() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void playNote(Location location, byte b, byte b1) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void playNote(Location location, Instrument instrument, Note note) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void playSound(Location location, Sound sound, float v, float v1) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void playSound(Location location, String s, float v, float v1) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void playEffect(Location location, Effect effect, int i) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public <T> void playEffect(Location location, Effect effect, T t) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void sendBlockChange(Location location, Material material, byte b) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean sendChunkChange(Location location, int i, int i1, int i2, byte[] bytes) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void sendBlockChange(Location location, int i, byte b) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void sendSignChange(Location location, String[] strings) throws IllegalArgumentException {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void sendMap(MapView mapView) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void updateInventory() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void awardAchievement(Achievement achievement) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void removeAchievement(Achievement achievement) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean hasAchievement(Achievement achievement) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void incrementStatistic(Statistic statistic) throws IllegalArgumentException {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void decrementStatistic(Statistic statistic) throws IllegalArgumentException {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void incrementStatistic(Statistic statistic, int i) throws IllegalArgumentException {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void decrementStatistic(Statistic statistic, int i) throws IllegalArgumentException {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setStatistic(Statistic statistic, int i) throws IllegalArgumentException {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int getStatistic(Statistic statistic) throws IllegalArgumentException {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void incrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void decrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int getStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void incrementStatistic(Statistic statistic, Material material, int i) throws IllegalArgumentException {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void decrementStatistic(Statistic statistic, Material material, int i) throws IllegalArgumentException {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setStatistic(Statistic statistic, Material material, int i) throws IllegalArgumentException {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void incrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void decrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int getStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void incrementStatistic(Statistic statistic, EntityType entityType, int i) throws IllegalArgumentException {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void decrementStatistic(Statistic statistic, EntityType entityType, int i) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setStatistic(Statistic statistic, EntityType entityType, int i) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setPlayerTime(long l, boolean b) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public long getPlayerTime() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public long getPlayerTimeOffset() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean isPlayerTimeRelative() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void resetPlayerTime() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setPlayerWeather(WeatherType weatherType) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public WeatherType getPlayerWeather() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void resetPlayerWeather() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void giveExp(int i) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void giveExpLevels(int i) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public float getExp() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setExp(float v) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int getLevel() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setLevel(int i) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int getTotalExperience() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setTotalExperience(int i) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public float getExhaustion() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setExhaustion(float v) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public float getSaturation() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setSaturation(float v) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int getFoodLevel() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setFoodLevel(int i) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean isOnline() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean isBanned() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setBanned(boolean b) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean isWhitelisted() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setWhitelisted(boolean b) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Player getPlayer() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public long getFirstPlayed() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public long getLastPlayed() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean hasPlayedBefore() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Location getBedSpawnLocation() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setBedSpawnLocation(Location location) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setBedSpawnLocation(Location location, boolean b) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean getAllowFlight() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setAllowFlight(boolean b) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void hidePlayer(Player player) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void showPlayer(Player player) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean canSee(Player player) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Location getLocation() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Location getLocation(Location location) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setVelocity(Vector vector) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Vector getVelocity() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean isOnGround() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public World getWorld() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean teleport(Location location) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean teleport(Location location, PlayerTeleportEvent.TeleportCause teleportCause) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean teleport(Entity entity) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean teleport(Entity entity, PlayerTeleportEvent.TeleportCause teleportCause) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public List<Entity> getNearbyEntities(double v, double v1, double v2) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int getEntityId() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int getFireTicks() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int getMaxFireTicks() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setFireTicks(int i) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean isDead() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean isValid() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void sendMessage(String s) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void sendMessage(String[] strings) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Server getServer() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Entity getPassenger() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean setPassenger(Entity entity) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean isEmpty() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean eject() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public float getFallDistance() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setFallDistance(float v) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setLastDamageCause(EntityDamageEvent entityDamageEvent) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public EntityDamageEvent getLastDamageCause() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public UUID getUniqueId() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int getTicksLived() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setTicksLived(int i) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void playEffect(EntityEffect entityEffect) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public EntityType getType() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean isInsideVehicle() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean leaveVehicle() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Entity getVehicle() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setCustomName(String s) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public String getCustomName() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setCustomNameVisible(boolean b) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean isCustomNameVisible() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean isFlying() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setFlying(boolean b) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setFlySpeed(float v) throws IllegalArgumentException {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setWalkSpeed(float v) throws IllegalArgumentException {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public float getFlySpeed() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public float getWalkSpeed() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setTexturePack(String s) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setResourcePack(String s) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Scoreboard getScoreboard() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setScoreboard(Scoreboard scoreboard) throws IllegalArgumentException, IllegalStateException {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean isHealthScaled() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setHealthScaled(boolean b) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setHealthScale(double v) throws IllegalArgumentException {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public double getHealthScale() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Entity getSpectatorTarget() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setSpectatorTarget(Entity entity) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void sendTitle(String s, String s1) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void resetTitle() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Spigot spigot() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Map<String, Object> serialize() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public PlayerInventory getInventory() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Inventory getEnderChest() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean setWindowProperty(InventoryView.Property property, int i) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public InventoryView getOpenInventory() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public InventoryView openInventory(Inventory inventory) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public InventoryView openWorkbench(Location location, boolean b) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public InventoryView openEnchanting(Location location, boolean b) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void openInventory(InventoryView inventoryView) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void closeInventory() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public ItemStack getItemInHand() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setItemInHand(ItemStack itemStack) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public ItemStack getItemOnCursor() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setItemOnCursor(ItemStack itemStack) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean isSleeping() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int getSleepTicks() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public GameMode getGameMode() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setGameMode(GameMode gameMode) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean isBlocking() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int getExpToLevel() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public double getEyeHeight() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public double getEyeHeight(boolean b) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Location getEyeLocation() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public List<Block> getLineOfSight(HashSet<Byte> hashSet, int i) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public List<Block> getLineOfSight(Set<Material> set, int i) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Block getTargetBlock(HashSet<Byte> hashSet, int i) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Block getTargetBlock(Set<Material> set, int i) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public List<Block> getLastTwoTargetBlocks(HashSet<Byte> hashSet, int i) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public List<Block> getLastTwoTargetBlocks(Set<Material> set, int i) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Egg throwEgg() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Snowball throwSnowball() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Arrow shootArrow() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int getRemainingAir() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setRemainingAir(int i) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int getMaximumAir() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setMaximumAir(int i) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int getMaximumNoDamageTicks() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setMaximumNoDamageTicks(int i) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public double getLastDamage() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int _INVALID_getLastDamage() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setLastDamage(double v) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void _INVALID_setLastDamage(int i) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int getNoDamageTicks() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setNoDamageTicks(int i) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Player getKiller() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean addPotionEffect(PotionEffect potionEffect) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean addPotionEffect(PotionEffect potionEffect, boolean b) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean addPotionEffects(Collection<PotionEffect> collection) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean hasPotionEffect(PotionEffectType potionEffectType) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void removePotionEffect(PotionEffectType potionEffectType) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Collection<PotionEffect> getActivePotionEffects() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean hasLineOfSight(Entity entity) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean getRemoveWhenFarAway() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setRemoveWhenFarAway(boolean b) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public EntityEquipment getEquipment() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setCanPickupItems(boolean b) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean getCanPickupItems() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean isLeashed() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Entity getLeashHolder() throws IllegalStateException {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean setLeashHolder(Entity entity) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void damage(double v) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void _INVALID_damage(int i) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void damage(double v, Entity entity) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void _INVALID_damage(int i, Entity entity) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public double getHealth() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int _INVALID_getHealth() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setHealth(double v) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void _INVALID_setHealth(int i) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public double getMaxHealth() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public int _INVALID_getMaxHealth() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setMaxHealth(double v) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void _INVALID_setMaxHealth(int i) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void resetMaxHealth() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setMetadata(String s, MetadataValue metadataValue) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public List<MetadataValue> getMetadata(String s) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean hasMetadata(String s) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void removeMetadata(String s, Plugin plugin) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean isPermissionSet(String s) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean isPermissionSet(Permission permission) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean hasPermission(String s) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean hasPermission(Permission permission) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b, int i) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, int i) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void removeAttachment(PermissionAttachment permissionAttachment) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void recalculatePermissions() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public Set<PermissionAttachmentInfo> getEffectivePermissions() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public boolean isOp() {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public void setOp(boolean b) {
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

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> aClass) {
		throw new UnsupportedOperationException("STUB");
	}

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> aClass, Vector vector) {
		throw new UnsupportedOperationException("STUB");
	}
}