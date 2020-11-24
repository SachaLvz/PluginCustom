package fr.kinstone.spawners.utils.json;

import java.lang.reflect.Type;
import java.util.Map;

import net.minecraft.util.com.google.gson.TypeAdapter;
import net.minecraft.util.com.google.gson.reflect.TypeToken;

public abstract class GsonAdapter<T> extends TypeAdapter<T>{

protected static Type seriType = new TypeToken<Map<String, Object>>(){}.getType();

	public abstract String getRaw(T t);

	public abstract T fromRaw(String string);
	
}
