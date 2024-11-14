package net.exoad.picflux.core;

import lombok.NonNull;
import lombok.extern.log4j.Log4j2;

import java.util.HashSet;
import java.util.Set;
@Log4j2
public abstract class JobProcessor
{
	private static final Set<Object> GLOBAL_PROCESSOR_POOL=new HashSet<>();
	
	public JobProcessor()
	{
		GLOBAL_PROCESSOR_POOL.add(this);
		log.info("JobProcessor inserts into GLOBAL_PROCESSOR_POOL");
	}
	
	public abstract String getProcessorCanonicalName();
	
	public abstract String getProcessorCanonicalDescription();
	
	public abstract boolean requiresScheduler();
}
