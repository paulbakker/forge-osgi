package forge.plugins;

import forge.core.Command;
import forge.core.Plugin;
import forge.shell.api.Shell;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;

@Component(properties="name=greeting")
public class GreetingPlugin implements Plugin{
	private Shell shell;
	
	@Command(name = "sayHello")
	public void sayHello() {
		shell.println("Hi!");
	}
	
	
	
	@Reference
	public void setShell(Shell shell) {
		this.shell = shell;
	}
	
}
