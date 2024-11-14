package net.exoad.picflux.ui

import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme
import javax.swing.UIManager
import javax.swing.UnsupportedLookAndFeelException
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import java.awt.BorderLayout
import java.awt.Font
import java.awt.Graphics
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
				"Unable to set look and feel: ${FlatArcDarkIJTheme::class.java}"
			)
			throw RuntimeException(e)
		}
	}
	
	@JvmStatic
	@Synchronized
	fun composeMain()
	{
		log.info("K_WINDOW_TITLE ${PublicConstants.K_WINDOW_TITLE}")
		log.info("K_WINDOW_SIZE ${PublicConstants.K_WINDOW_WIDTH}x${PublicConstants.K_WINDOW_HEIGHT}")
		ui_window().apply window@{
			title=PublicConstants.K_WINDOW_TITLE
			preferredSize=MODAL.dim(PublicConstants.K_WINDOW_WIDTH , PublicConstants.K_WINDOW_HEIGHT)
			size=preferredSize
			minimumSize=preferredSize
			contentPane=object:container()
			{
				override fun paintComponent(g:Graphics)
				{
					super.paintComponents(g) //					(g as Graphics2D).apply {
					//						color=InternalUIHelper.color(255 , 255 , 255)
					//						stroke=BasicStroke(2f)
					//						setRenderingHint(RenderingHints.KEY_INTERPOLATION , RenderingHints.VALUE_INTERPOLATION_BILINEAR)
					//						setRenderingHint(RenderingHints.KEY_ANTIALIASING , RenderingHints.VALUE_ANTIALIAS_ON)
					//						setRenderingHint(RenderingHints.KEY_STROKE_CONTROL , RenderingHints.VALUE_STROKE_NORMALIZE)
					//						fillRect(0 , 0 , width , height)
					//						dispose()
					//					}
				}
			}.apply contentRoot@{
				preferredSize=this@window.preferredSize
				size=this@window.size
				isOpaque=true
				layout=BorderLayout()
				add(ui_text().apply titleLabel@{
					foreground=MODAL.color(255 , 255 , 255)
					font=Font(font.name , Font.PLAIN , 18)
				}, BorderLayout.NORTH)
			}
		}.run {
			isVisible=true
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
