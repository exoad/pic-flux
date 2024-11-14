package net.exoad.picflux.ui

import java.awt.Color
import java.awt.Dimension

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
