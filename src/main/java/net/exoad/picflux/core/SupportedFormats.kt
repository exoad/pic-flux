package net.exoad.picflux.core

enum class SupportedFormats(val ext:String , val fmtName:String , val canWrite:Boolean = true , val canRead:Boolean = true)
{
	webp(ext="webp", fmtName="WebP", canWrite=false),
	png(ext="png",fmtName="PNG"),
	jpg(ext="jpg",fmtName="JPEG"),
	bmp(ext="bmp",fmtName="Bitmap");
	
	companion object
	{
		@JvmStatic
		fun getAllInputs():Array<SupportedFormats> = arrayOf(webp , png , jpg , bmp)
		
		@JvmStatic
		fun getAllOutputs():Array<SupportedFormats> = arrayOf(png , jpg , bmp)
		
		@JvmStatic
		fun getAllInputExt():Array<String> = arrayOf(webp.ext, png.ext, jpg.ext, bmp.ext)
		
		@JvmStatic
		fun getAllOutputExt():Array<String> = arrayOf(png.ext, jpg.ext, bmp.ext)
	}
}
