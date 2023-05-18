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

package space.quinoaa.starch.util;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {
	private final ItemStack item;
	private final ItemMeta meta;
	private List<String> lore;

	public ItemBuilder(ItemStack item) {
		this.item = item.clone();
		meta = item.getItemMeta();
	}

	public ItemBuilder(Material material) {
		this.item = new ItemStack(material);
		meta = item.getItemMeta();
	}

	public ItemBuilder(Material material, int count) {
		this.item = new ItemStack(material, count);
		meta = item.getItemMeta();
	}

	public ItemBuilder(Material material, int count, short damage) {
		this.item = new ItemStack(material, count, damage);
		meta = item.getItemMeta();
	}


	public ItemBuilder setName(String name){
		meta.setDisplayName(name);
		return this;
	}

	public ItemBuilder setLore(List<String> lore){
		this.lore = new ArrayList<>(lore);
		return this;
	}

	public ItemBuilder appendLore(String line){
		if(lore == null) lore = meta.hasLore() ? new ArrayList<>(meta.getLore()) : new ArrayList<>();
		lore.add(line);
		return this;
	}

	public ItemBuilder setDurability(short durability){
		item.setDurability(durability);
		return this;
	}

	public ItemBuilder setAmount(int amount){
		item.setAmount(amount);
		return this;
	}

	public ItemBuilder addEnchant(Enchantment enchantment, int level, boolean force){
		meta.addEnchant(enchantment, level, force);
		return this;
	}
	public ItemBuilder addFlag(ItemFlag... flags){
		meta.addItemFlags(flags);
		return this;
	}


	public ItemStack build(){
		if(lore != null) meta.setLore(lore);
		item.setItemMeta(meta);
		return this.item.clone();
	}

}
