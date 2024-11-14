package net.exoad.picflux.core

import com.leakyabstractions.result.api.Result
import com.leakyabstractions.result.core.Results
import lombok.extern.log4j.Log4j2
import net.exoad.picflux.core.SupportedFormats.Companion.getAllInputs
import org.apache.commons.io.FilenameUtils
import java.util.Arrays
import java.util.function.Function
import java.util.function.Supplier

@Log4j2
object InfileHandler
{
	@JvmStatic
	fun detectFormat(
			inFile:String
	):Result<SupportedFormats? , String?>
	{
		return Arrays.stream<SupportedFormats>(getAllInputs()).filter { x:SupportedFormats?->
			(x!!.ext==FilenameUtils.getExtension(inFile))
		}.findAny()
			.map<Result<SupportedFormats? , String?>>(Function { success:SupportedFormats?-> Results.success(success) })
			.orElseGet(Supplier {
				Results.failure<SupportedFormats? , String?>(
					"Failed to detect extension for input "+inFile
				)
			})
	}
}
