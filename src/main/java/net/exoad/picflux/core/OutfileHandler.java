package net.exoad.picflux.core;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

@Log4j2
public final class OutfileHandler
{
	private OutfileHandler()
	{
	}
	
	public static OrderingFunction simpleRandom()
	{
		log.info(
			"Generated a "+
			"simple_random_ordered_outfile_handler");
		return OrderingFunction.Companion.conform(
			"simple_random_ordered_outfile_handler",
			(
				__ignore_inFileName__,__ignore_inFormat__,
				outFormat
			)->RandomStringUtils
				   .secure()
				   .next(
					   RandomUtils
						   .secure()
						   .randomInt(
							   CoreConstants.K_DEFAULT_RANDOM_FILE_NAME_LEN,
							   CoreConstants.K_DEFAULT_RANDOM_FILE_NAME_LEN+4
						   ),
					   CoreConstants.K_SALT
				   )+"."+outFormat.getExt()
		);
	}
	
	public static OrderingFunction simple()
	{
		return OrderingFunction.Companion.conform(
			"simple_ordered_outfile_handler",
			(
				inFileName,__ignore__inFormat__,
				outFormat
			)->inFileName+"."+outFormat.getExt()
		);
	}
	
	public static OrderingFunction prefix(
		String prefix
	)
	{
		log.info(
			"Generated a prefix_ordered_outfile_handler with {}",
			prefix
		);
		return OrderingFunction.Companion.conform(
			"prefix_ordered_outfile_handler",
			(inFileName,__ignore__inFormat__,outFormat)->handleFileName(
				prefix)+inFileName+"."+outFormat.getExt()
		);
	}
	
	public static String handleFileName(String fileName)
	{
		return fileName.replaceAll(
			"[^a-zA-Z0-9-_\\.]",
			"_"
		);
	}
	
	public static OrderingFunction suffix(
		String suffix
	)
	{
		log.info(
			"Generated a suffix_ordered_outfile_handler with {}",
			suffix
		);
		return OrderingFunction.Companion.conform(
			"suffix_ordered_outfile_handler",
			(inFileName,__ignore__inFormat__,outFormat)->inFileName+handleFileName(
				suffix)+"."+outFormat.getExt()
		);
	}
}
