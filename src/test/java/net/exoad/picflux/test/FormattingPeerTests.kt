package net.exoad.picflux.test

import net.exoad.picflux.core.ConvertJob
import net.exoad.picflux.core.FormattingPeer
import net.exoad.picflux.core.OutfileHandler
import net.exoad.picflux.core.SupportedFormats
import org.jetbrains.annotations.NotNull
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import java.lang.NullPointerException
import java.net.URL
import java.util.Objects

class FormattingPeerTests
private constructor()
{
	@Test
	@DisplayName(
		"Check if valid convert job is "+"valid"
	)
	fun test1()
	{
		Assertions.assertNotNull(
			javaClass.getResource(
				"/test_image.jpg"
			)
		)
		Assertions.assertTrue(
			FormattingPeer.checkConvertJobValidity(
				ConvertJob.make().withInFile(
					Objects.requireNonNull<URL?>(
						javaClass.getResource(
							"/test_image.jpg"
						)
					).file
				).withInputFormat(
					SupportedFormats.jpg
				).withOutputFormat(SupportedFormats.png).withOutFile(
					OutfileHandler.simple()
				)
			)
		)
	}
	
	@Test
	@DisplayName(
		"Check non-existent file is not "+"valid job"
	)
	fun test2()
	{
		Assertions.assertNull(
			javaClass.getResource(
				"/nonexistent12301899312.jpg"
			)
		)
		Assertions.assertFalse(
			FormattingPeer.checkConvertJobValidity(
				ConvertJob.make().withInFile("/nonexistent12301899312.jpg").withInputFormat(SupportedFormats.jpg)
					.withOutputFormat(SupportedFormats.png).withOutFile(OutfileHandler.simpleRandom())
			)
		)
	}
	
	@Test
	@DisplayName(
		"Check if unsupported input format "+"is not valid job"
	)
	fun test3()
	{
		Assertions.assertNotNull(
			javaClass.getResource(
				"/test_image.jpg"
			)
		)
		Assertions.assertFalse(
			FormattingPeer.checkConvertJobValidity(
				ConvertJob.make().withInFile(
					Objects.requireNonNull<URL?>(
						javaClass.getResource(
							"/test_image.jpg"
						)
					).file
				).withInputFormat(
					SupportedFormats.jpg
				).withOutputFormat(SupportedFormats.webp).withOutFile(
					OutfileHandler.simple()
				)
			)
		)
	}
	
	@Test
	@DisplayName(
		"Check if null outfile generator is"+" not valid (errn)"
	)
	fun test4()
	{
		Assertions.assertNotNull(
			javaClass.getResource(
				"/test_image.jpg"
			)
		)
		Assertions.assertThrows<NullPointerException?>(NullPointerException::class.java , Executable {
			FormattingPeer.checkConvertJobValidity(
				ConvertJob.make().withInFile(
					Objects.requireNonNull<URL?>(
						javaClass.getResource(
							"/test_image.jpg"
						)
					).file
				).withInputFormat(
					SupportedFormats.jpg
				).withOutputFormat(SupportedFormats.webp).withOutFile(
					
					
					
					@NotNull
					null!! // so funny
					
					
					
					
				)
			)
		})
	}
}
