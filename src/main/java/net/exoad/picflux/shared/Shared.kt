package net.exoad.picflux.shared

import java.util.Random

object Shared
{
	private var random:Random?=null
	
	fun getRNGInstance():Random
	{
		if (random==null) random=Random(System.currentTimeMillis())
		return random!!
	}
}
