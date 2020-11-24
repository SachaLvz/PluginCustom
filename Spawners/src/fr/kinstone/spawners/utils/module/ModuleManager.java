package fr.kinstone.spawners.utils.module;

import java.util.List;


import com.google.common.collect.Lists;


public class ModuleManager {
	
	private List<Module> modules;
	
	public ModuleManager() {
        this.modules = Lists.newArrayList();      
	}
	
	public void enabledModule() {

		
		for(Module m : modules) 
			m.enable();

	}
	
	public void disabledModule() {
		
	}

}
