package net.exoad.picflux.shared;

import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
public final class RoutineScheduler
{
	private static RoutineScheduler instance;
	
	public static RoutineScheduler getInstance()
	{
		if(instance==null)
				instance=new RoutineScheduler();
		return instance;
	}
	
	public ScheduledExecutorService defaultPool;
	public Timer periodic;
	
	private RoutineScheduler()
	{
		defaultPool=
			Executors.newScheduledThreadPool(Runtime
														 .getRuntime()
														 .availableProcessors()*2);
		periodic=new Timer(true);
	}
}
