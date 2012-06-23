/**
 * © PixelSimple 2011-2012.
 */
package com.pixelsimple.commons.test.appcore.init;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

import com.pixelsimple.appcore.init.AppInitializer;
import com.pixelsimple.appcore.init.BootstrapInitializer;
import com.pixelsimple.appcore.init.Initializable;
import com.pixelsimple.commons.test.util.TestUtil;
import com.pixelsimple.commons.util.OSUtils;

/**
 *
 * @author Akshay Sharma
 * Jan 18, 2012
 */
public class TestAppInitializer {
	public static final String TEST_ARTIFACT_DIR = TestUtil.getTestConfig().get(TestUtil.TEST_ARTIFACT_DIR_CONFIG);
	
	public static void bootStrapRegistryForTesting(Initializable ...initializables) {
		Map<String, String> configs = new HashMap<String, String>();
		
		if (OSUtils.isWindows()) {
			// Keep this path up to date with ffmpeg updates
			configs.put(BootstrapInitializer.JAVA_SYS_ARG_APP_HOME_DIR, "c:\\dev\\pixelsimple");
			configs.put("ffprobePath", "ffprobe\\32_bit\\1.0\\ffprobe.exe"); 
			configs.put("ffmpegPath", "ffmpeg\\32_bit\\1.0\\ffmpeg.exe"); 
		} else if (OSUtils.isMac()) {
			// Keep this path up to date with ffmpeg updates
			configs.put(BootstrapInitializer.JAVA_SYS_ARG_APP_HOME_DIR,  OSUtils.USER_SYSTEM_HOME_DIR + "/dev/pixelsimple");
			configs.put("ffprobePath",  "ffprobe/32_bit/1.0/ffprobe"); 
			configs.put("ffmpegPath",  "ffmpeg/32_bit/1.0/ffmpeg"); 
		}  else {
			// add linux based tests when ready :-)
		}
		System.setProperty(BootstrapInitializer.JAVA_SYS_ARG_APP_HOME_DIR, OSUtils.appendFolderSeparator(
				configs.get(BootstrapInitializer.JAVA_SYS_ARG_APP_HOME_DIR)));
		
		configs.put("tempDirectory", configs.get(BootstrapInitializer.JAVA_SYS_ARG_APP_HOME_DIR) + "/test/tmp");
		configs.put("configDirectory", "/test/config");
		
		AppInitializer initializer = new AppInitializer();
		
		for (Initializable i : initializables) {
			initializer.addModuleInitializable(i);
		}
		
		try {
			initializer.init(configs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	
	/**
	 * This test case is needed to ensure junit passes this class. 
	 */
	@Test
	public void alwaysTrue() {
		Assert.assertTrue(true);
	}
}
