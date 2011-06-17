package forge.core.impl;

import org.osgi.framework.BundleContext;

import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;

@Component
public class Forge{
	@Activate
	public void start(BundleContext bc) {		
		
		new ForgeUI(new CommandExecutor(bc)).setVisible(true);
	}
	
	
	
}
