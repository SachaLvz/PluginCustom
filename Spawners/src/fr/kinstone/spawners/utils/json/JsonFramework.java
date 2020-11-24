package fr.kinstone.spawners.utils.json;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;

import lombok.Getter;
import net.minecraft.server.v1_7_R4.ItemStack;
import net.minecraft.util.com.google.gson.Gson;
import net.minecraft.util.com.google.gson.GsonBuilder;

public class JsonFramework {

	@Getter public static JsonFramework jsonFramework;
	private List<JsonPersist> persist = new ArrayList<>();
	@Getter private Gson gson;
	
	public JsonFramework(JavaPlugin plugin) {
		this.jsonFramework = this;
		this.gson = getGsonBuilder().create();
	}
	
	public void addPersist(JsonPersist persist) {
		this.persist.add(persist);
	}
	
	public void loadAllData() {
		for(JsonPersist persist : persist) {
			persist.loadData();
		}
	}
	
	public void saveAllData(boolean sync) {
		for(JsonPersist persist : persist) {
			persist.saveData(sync);
		}
	}

	public GsonBuilder getGsonBuilder() {
		return new GsonBuilder()
				.setPrettyPrinting()
				.disableHtmlEscaping()
				.serializeNulls()
				.excludeFieldsWithModifiers(Modifier.TRANSIENT, Modifier.VOLATILE)
				.setDateFormat("dd/MM/yyyy HH:mm")
				.registerTypeHierarchyAdapter(ItemStack.class, new ItemStackAdapter())
				.registerTypeAdapter(PotionEffect.class, new PotionEffectAdapter())
				.registerTypeAdapter(Location.class, new LocationAdapter());
	}

}
