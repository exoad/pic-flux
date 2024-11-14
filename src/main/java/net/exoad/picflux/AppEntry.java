package net.exoad.picflux;

import lombok.extern.log4j.Log4j2;
import net.exoad.picflux.core.SupportedFormats;
import net.exoad.picflux.shared.DevTool;
import net.exoad.picflux.ui.AppUI;

import java.util.Arrays;
@Log4j2
public final class AppEntry
{
	static
	{
		System.setProperty(
			"lombok.accessors.fluent",
			"true"
		);
	}
	
	private AppEntry()
	{
	}
	
	public static void main(String... args)
	{
		long r=DevTool.timeThis(AppUI::composeMain);
		log.info("UI compose took "+r+"ms");
		log.info("Supported inputs: "+Arrays.toString(
			SupportedFormats.getAllInputs()));
		log.info("Supported outputs: "+Arrays.toString(
			SupportedFormats.getAllOutputs()));
	}
}
