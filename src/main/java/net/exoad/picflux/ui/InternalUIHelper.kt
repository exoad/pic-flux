package net.exoad.picflux.ui

import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel
import java.awt.Color
import java.awt.Dimension

typealias ui_window=JFrame
typealias container=JPanel
typealias ui_text=JLabel
typealias ui_action=JButton
typealias MODAL=InternalUIHelper

object InternalUIHelper
{
	@JvmStatic
	fun dim(width:Int , height:Int):Dimension
	{
		return Dimension(width , height)
	}
	
	fun color(r:Int , g:Int , b:Int):Color
	{
		return Color(r , g , b)
	}
	
	fun color(r:Float , g:Float , b:Float , a:Float):Color
	{
		return Color(r , g , b , a)
	}
}
