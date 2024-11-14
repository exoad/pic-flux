package net.exoad.picflux.ui;

import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;
import javax.swing.*;
import lombok.extern.log4j.Log4j2;
@Log4j2
public class AppUI
{
	private AppUI()
	{
	}
	
	public static final class PublicConstants
	{
		private PublicConstants()
		{
		}
		
		public static final String K_WINDOW_TITLE="PicFlux";
		public static final int K_WINDOW_WIDTH=650;
		public static final int K_WINDOW_HEIGHT=410;
	}
	
	static
	{
		System.setProperty("sun.java2d.opengl","True");
		try
		{
			UIManager.setLookAndFeel(new FlatArcDarkIJTheme());
		}
		catch(UnsupportedLookAndFeelException e)
		{
			log.fatal("Unable to set look and feel: "+FlatArcDarkIJTheme.class);
			throw new RuntimeException(e);
		}
	}
	
	public static void composeMain()
	{
		new UIWindow()
			.withTitle(PublicConstants.K_WINDOW_TITLE)
			.withSize(
				PublicConstants.K_WINDOW_WIDTH,
				PublicConstants.K_WINDOW_HEIGHT
			).compose();
	}
}
