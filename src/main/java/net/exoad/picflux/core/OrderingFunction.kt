package net.exoad.picflux.core

import net.exoad.picflux.shared.CanonicalToString

abstract class OrderingFunction:CanonicalToString
{
	abstract fun compose(
			inFileName:String , inFormat:SupportedFormats , outFormat:SupportedFormats
	):String
	
	companion object
	{
		fun conform(
				canonicalName:String , fx:(inFile:String , inFormat:SupportedFormats , outFormat:SupportedFormats)->String
		):OrderingFunction
		{
			return object:OrderingFunction()
			{
				override fun compose(
						inFileName:String , inFormat:SupportedFormats , outFormat:SupportedFormats
				):String=fx(
					inFileName , inFormat , outFormat
				)
				
				override fun toUserFriendlyString():String=canonicalName
			}
		}
	}
}
