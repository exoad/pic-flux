package net.exoad.picflux.shared

object DevTool
{
	@JvmStatic
	fun timeThis(r:Runnable):Long
	{
		val start=System.currentTimeMillis()
		r.run()
		return System.currentTimeMillis()-start
	}
}
