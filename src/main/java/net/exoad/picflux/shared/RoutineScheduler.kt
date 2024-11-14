package net.exoad.picflux.shared

import java.util.Timer
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService

class RoutineScheduler
private constructor()
{
	var defaultPool:ScheduledExecutorService=Executors.newScheduledThreadPool(
		Runtime.getRuntime().availableProcessors()*2
	)
	var periodic:Timer=Timer(true)
	
	companion object
	{
		private var instance:RoutineScheduler?=null
		
		fun getInstance():RoutineScheduler
		{
			if (instance==null) instance=RoutineScheduler()
			return instance!!
		}
	}
}
