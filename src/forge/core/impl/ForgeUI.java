package forge.core.impl;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ForgeUI extends JFrame {
	public ForgeUI(final CommandExecutor executor) {
		JPanel panel = new JPanel();
		final JTextField commandField = new JTextField(20);
		commandField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent event) {
				
				if(event.getKeyCode() == KeyEvent.VK_ENTER) {
					executor.executeCommand(commandField.getText());
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		panel.add(commandField);
		
		
		add(panel);
		setTitle("Forge");
		setSize(800, 600);
	}
}
