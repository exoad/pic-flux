package net.exoad.picflux.ui;

import javax.swing.*;
import lombok.extern.log4j.Log4j2;
import net.exoad.picflux.shared.PeerObj;
@Log4j2
public class UIWindow
	extends PeerObj<JFrame>
{
	private JFrame peer;
	
	public UIWindow()
	{
		this.peer=new JFrame();
		log.info("Created a new peer: UIWindow#"+this.hashCode());
	}
	
	public UIWindow withTitle(String title)
	{
		this.peer.setTitle(title);
		log.info("UIWindow#"+this.hashCode()+" "+
				 "got "+
				 "setTitle:"+title);
		return this;
	}
	
	public UIWindow withSize(int width,int height)
	{
		this.peer.setSize(width,height);
		this.peer.setPreferredSize(InternalUIHelper.dim(
			width,
			height
		));
		log.info("UIWindow#"+this.hashCode()+" "+
				 "got "+
				 "setSize:"+width+","+height);
		return this;
	}
	
	public UIWindow withContainer(
		PeerObj<? extends JComponent> container
	)
	{
		this.peer.setContentPane(container.acquire());
		return this;
	}
	
	@Override public JFrame acquire()
	{
		return peer;
	}
	
	@Override public synchronized void compose()
	{
		peer.pack();
		peer.setLocationRelativeTo(null);
		peer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		peer.setVisible(true);
		peer.requestFocus();
		log.info("Composing this peer:UIWindow#"+this.hashCode()+"!");
	}
}
