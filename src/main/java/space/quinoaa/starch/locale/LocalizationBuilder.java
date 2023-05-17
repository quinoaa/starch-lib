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

package space.quinoaa.starch.locale;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LocalizationBuilder {

	public Localization handleConfig(JavaPlugin plugin, String configName) throws IOException {
		File datas = plugin.getDataFolder();
		if(!datas.exists()&&!datas.mkdirs()) throw new IOException("Could not create configuration folder");

		return load(
				loadOrCreateConfig(plugin, configName),
				loadDefaultConfig(plugin, configName)
		);
	}

	public final Localization load(Map<?, ?> config, Map<?, ?>... fallbacks){
		Map<String, String> messages = new HashMap<>();

		for (int i = fallbacks.length - 1; i >=0; i--) {
			putAllKeys(messages, fallbacks[i]);
		}
		putAllKeys(messages, config);

		return new Localization(messages);
	}

	public Localization load(ConfigurationSection config, ConfigurationSection... fallbacks){
		return load(
				config.getValues(true),
				Arrays.stream(fallbacks)
						.map(cfg->cfg.getValues(true))
						.toArray(Map[]::new)
		);
	}



	private static void putAllKeys(Map<String, String> target, Map<?, ?> source){
		source.forEach((str, obj)->target.put(String.valueOf(str), String.valueOf(obj)));
	}




	private static InputStream getDefaultConfigData(JavaPlugin plugin, String configName) throws IOException{
		InputStream is = plugin.getResource(configName);
		if(is == null) throw new IOException("Could not find " + configName + " in the plugin resources.");
		return is;
	}

	private static YamlConfiguration loadDefaultConfig(JavaPlugin plugin, String configName) throws IOException {
		return loadConfig(getDefaultConfigData(plugin, configName));
	}

	private static YamlConfiguration loadOrCreateConfig(JavaPlugin plugin, String configName) throws IOException {
		saveDefaultIfNotExist(plugin, configName);
		Path path = plugin.getDataFolder().toPath().resolve(configName);

		return loadConfig(Files.newInputStream(path));
	}


	private static void saveDefaultIfNotExist(JavaPlugin plugin, String configName) throws IOException {
		File data = plugin.getDataFolder();
		if(!data.exists()&&!data.mkdirs()) throw new IOException("Could not create configuration folder");

		Path configPath = data.toPath().resolve(configName);
		if(Files.exists(configPath)) return;

		Files.copy(getDefaultConfigData(plugin, configName), configPath);
	}

	private static YamlConfiguration loadConfig(InputStream is) {
		return YamlConfiguration.loadConfiguration(new InputStreamReader(is));
	}

}
