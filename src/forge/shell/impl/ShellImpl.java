package forge.shell.impl;

import aQute.bnd.annotation.component.Component;
import forge.shell.api.Shell;

@Component
public class ShellImpl implements Shell {

	@Override
	public void println(String message) {
		System.out.println(message);
	} 

}
