package org.pdfsam.module;


public class ModuleDescriptorBuilderProduct {
	private int priority = ModulePriority.DEFAULT.getPriority();

	public int getPriority() {
		return priority;
	}

	public ModuleDescriptorBuilder priority(int priority, ModuleDescriptorBuilder moduleDescriptorBuilder) {
		this.priority = priority;
		return moduleDescriptorBuilder;
	}

	public ModuleDescriptorBuilder priority(ModulePriority priority, ModuleDescriptorBuilder moduleDescriptorBuilder) {
		this.priority = priority.getPriority();
		return moduleDescriptorBuilder;
	}
}