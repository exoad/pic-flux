package net.exoad.picflux.core;

import com.leakyabstractions.result.api.Result;
import com.leakyabstractions.result.core.Results;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.io.File;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
@Log4j2
public class FormattingPeer
{
	private Queue<ConvertJob> jobs;
	
	public FormattingPeer(
		@NonNull ConvertJob... initialJobs
	)
	{
		jobs=new LinkedBlockingQueue<>();
	}
	
	public static boolean checkConvertJobValidity(
		@NonNull ConvertJob job
	)
	{
		Result<Boolean,String> res=
			internalCheckConvertJobValidity(
				job);
		if(res.hasFailure()||res
			.getFailure()
			.isPresent())
		{
			log.error("[STEP-ENCOUNTER]: "+res
				.getFailure()
				.get());
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("OptionalGetWithoutIsPresent") private static Result<Boolean,String> internalCheckConvertJobValidity(
		@NonNull ConvertJob job
	)
	{
		String inFileExt=
			FilenameUtils.getExtension(job.getInFilePath());
		File inFile=new File(job.getInFilePath());
		if(!inFile.exists()||!inFile.isFile())
			return Results.failure(
				"The provided input file of "+job.getInFilePath()+" does not exist!");
		if(!inFile.canRead())
			return Results.failure(
				"The provided input file of "+job.getInFilePath()+" could not be read from!");
		if(!ArrayUtils.contains(
			SupportedFormats.getAllInputExt(),
			inFileExt
		)||!ArrayUtils.contains(
			SupportedFormats.getAllInputs(),
			job.getInput()
		))
			return Results.failure(
				"The provided input file of \""+job.getInFilePath()+"\" has an extension of \""+inFileExt+"\" ("+job
					.getInput()
					.name()+") which is not supported"+
				".\nAll supported input "+
				"formats/extensions: "+Arrays.toString(
					SupportedFormats.getAllInputExt()));
		if(!ArrayUtils.contains(SupportedFormats.getAllOutputs(),
								job.getOutput()))
			return Results.failure(
				"The provided output format of "+job
					.getOutput()
					.name()+" is not supported as an " +
				"output format.\nAll supported output " +
				"(write) formats: "+Arrays.toString(
					SupportedFormats.getAllOutputs()));
		// this is unlikely to happen if used directly
		// through the gui (very unlikely)
		Result<SupportedFormats,String> check1=
			InfileHandler.detectFormat(
				job.getInFilePath());
		if(check1.hasFailure())
			return Results.failure(check1
									   .getFailure()
									   .get());
		if(!ArrayUtils.contains(
			SupportedFormats.getAllInputs(),
			check1
				.getSuccess()
				.get()
		))
			return Results.failure("The input file "+job.getInFilePath()+" has format "+check1
				.getSuccess()
				.get()+" which is not supported.");
		if(!check1
			.getSuccess()
			.get()
			.equals(job.getInput()))
			return Results.failure(
				"The auto detected format of "+check1
					.getSuccess()
					.get()+" conflicts with the input "+job.getInput());
		return Results.success(true);
	}
}