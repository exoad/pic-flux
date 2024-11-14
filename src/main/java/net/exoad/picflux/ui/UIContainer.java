package net.exoad.picflux.ui;

import javax.swing.*;
import net.exoad.picflux.shared.PeerObj;
public class UIContainer extends PeerObj<JPanel>
{
	private JPanel peer;
	
	
	
	@Override public JPanel acquire()
	{
		return peer;
	}
	
	@Override public void compose()
	{
		return; // no compose
	}
}
