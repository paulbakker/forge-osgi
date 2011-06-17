package forge.plugins;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;
import forge.core.Command;
import forge.core.Plugin;
import forge.shell.api.Shell;

@Component(properties="name=shell")
public class EchoPlugin implements Plugin {
	private Shell shell;
		
	@Command(name = "echo")
	public void echo(String message) {
		System.out.println(message);
	}
	
	@Reference
	public void setShell(Shell shell) {
		this.shell = shell;
	}
	
}
