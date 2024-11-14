package net.exoad.picflux.ui

import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme
import javax.swing.JFrame
import javax.swing.UIManager
import javax.swing.UnsupportedLookAndFeelException
import jdk.vm.ci.hotspot.JFR
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import java.lang.RuntimeException

object AppUI
{
	private val log:Logger=LogManager.getLogger(AppUI::class.java)
	
	init
	{
		System.setProperty("sun.java2d.opengl" , "True")
		try
		{
			UIManager.setLookAndFeel(FlatArcDarkIJTheme())
		} catch (e:UnsupportedLookAndFeelException)
		{
			log.fatal(
				"Unable to set look and feel: {}" , FlatArcDarkIJTheme::class.java
			)
			throw RuntimeException(e)
		}
	}
	
	@JvmStatic
	@Synchronized
	fun composeMain()
	{
		JFrame().apply {
			title=PublicConstants.K_WINDOW_TITLE
			preferredSize=InternalUIHelper.dim(PublicConstants.K_WINDOW_WIDTH , PublicConstants.K_WINDOW_HEIGHT)
			size=preferredSize
			minimumSize=preferredSize
			
		}.run {
			setLocationRelativeTo(null)
			pack()
			requestFocus()
		}
	}
	
	object PublicConstants
	{
		const val K_WINDOW_TITLE:String="PicFlux"
		const val K_WINDOW_WIDTH:Int=650
		const val K_WINDOW_HEIGHT:Int=410
	}
}
