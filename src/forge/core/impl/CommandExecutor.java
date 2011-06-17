package forge.core.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

import forge.core.Command;
import forge.core.Plugin;

public class CommandExecutor {
	private BundleContext bundleContext;
	
	public CommandExecutor(BundleContext bundleContext) {
		this.bundleContext = bundleContext;
	}
	
	public void executeCommand(String command) {		
		try {			 
			
			String[] commands = command.split(" ");
			ServiceReference[] allPlugins = bundleContext.getAllServiceReferences(Plugin.class.getName(), null);
			Plugin plugin = null;
			for (ServiceReference serviceReference : allPlugins) {
				if(commands[0].equals(serviceReference.getProperty("name"))) {
					plugin = (Plugin)bundleContext.getService(serviceReference);
					break;
				}
			}
			
			if(plugin != null) {
				Method[] methods = plugin.getClass().getMethods();
				for (Method method : methods) {
					
					if(method.isAnnotationPresent(Command.class)) {
						Command annotation = method.getAnnotation(Command.class);
						
						if(annotation.name().equals(commands[1])) {
							if(commands.length > 2) {
								method.invoke(plugin, commands[2]);
							}  else {
								method.invoke(plugin);
							}
							
							
						} 
						
					}
				}
			} else {
				throw new RuntimeException("Command not found");
			}
		} catch (InvalidSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
