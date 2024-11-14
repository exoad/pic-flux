package net.exoad.picflux.core;

import com.leakyabstractions.result.api.Result;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import net.exoad.picflux.shared.CanonicalToString;

@Setter @Getter
@Log4j2
public class ConvertJob
	implements CanonicalToString
{
	private String inFilePath;
	private SupportedFormats input;
	private SupportedFormats output;
	private OrderingFunction outFile;
	
	private ConvertJob()
	{
	}
	
	public static ConvertJob make()
	{
		return new ConvertJob();
	}
	
	public ConvertJob withInFile(@NonNull String inFilePath)
	{
		this.inFilePath=inFilePath;
		return this;
	}
	
	public ConvertJob withAutodetectInputFormat()
	{
		Result<SupportedFormats,String> res=
			InfileHandler.detectFormat(
			this.getInFilePath());
		if(res.hasFailure()||res
			.getFailure()
			.isPresent())
		{
			log.error("Auto detect format cannot be used before the inputfile path has been set!");
			throw new RuntimeException("Auto detect format cannot be used before the inputfile path has been set!");
		}
		if(res.getSuccess().isEmpty())
		{
			// this honestly never happen lol
			log.error("Internal error AutodetectInputFormat:getSuccess returned false? when failure not encountered...");
			throw new RuntimeException("Internal error AutodetectInputFormat:getSuccess returned false? when failure not encountered...");
		}
		return withInputFormat(res.getSuccess().get());
	}
	
	public ConvertJob withInputFormat(
		@NonNull SupportedFormats input
	)
	{
		this.input=input;
		return this;
	}
	
	public ConvertJob withOutputFormat(
		@NonNull SupportedFormats output
	)
	{
		this.output=output;
		return this;
	}
	
	public ConvertJob withOutFile(
		@NonNull OrderingFunction outFileGenerator
	)
	{
		this.outFile=outFileGenerator;
		return this;
	}
	
	@Override public String toUserFriendlyString()
	{
		return "Convert_Job#"+hashCode()+"[\n"+
			   "\tinput_file="+
			   getInFilePath()+
			   "\n\tinput_format="+
			   getInput().name()+
			   "\n\toutput_format="+
			   getOutput().name()+
			   "\n\toutput_filename_gen="+
			   getOutFile().toUserFriendlyString();
	}
}
