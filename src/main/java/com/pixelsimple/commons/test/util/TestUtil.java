/**
 * © PixelSimple 2011-2012.
 */
package com.pixelsimple.commons.test.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

import com.pixelsimple.commons.util.OSUtils;

/**
 *
 * @author Akshay Sharma
 * Mar 7, 2012
 */
public class TestUtil {
	public static final String HOME_DIR_CONFIG = "HOME_DIR_CONFIG"; 
	public static final String TEST_ARTIFACT_DIR_CONFIG = "TEST_DIR_CONFIG"; 
	public static final String FFPROBE_EXECUTABLE_CONFIG = "ffprobePath"; 
	public static final String FFMPEG_EXECUTABLE_CONFIG = "ffmpegPath"; 
	
	public static Map<String, String> getTestConfig() {
		Map<String, String> configs = new HashMap<String, String>();
		
		if (OSUtils.isWindows()) {
			String homeDir = "c:/dev/pixelsimple";
			configs.put(HOME_DIR_CONFIG, homeDir);
			configs.put(TEST_ARTIFACT_DIR_CONFIG, "c:/dev/pixelsimple/test/");
			configs.put(FFPROBE_EXECUTABLE_CONFIG, homeDir + "/ffprobe/32_bit/0.8/ffprobe.exe"); 
			configs.put(FFMPEG_EXECUTABLE_CONFIG, homeDir + "/ffmpeg/32_bit/0.8/ffmpeg.exe"); 
		} else if (OSUtils.isMac()) {
			String homeDir = OSUtils.USER_SYSTEM_HOME_DIR + "/dev/pixelsimple";
			configs.put(HOME_DIR_CONFIG, homeDir);
			configs.put(TEST_ARTIFACT_DIR_CONFIG,  OSUtils.USER_SYSTEM_HOME_DIR + "/dev/pixelsimple/test/");
			configs.put(FFPROBE_EXECUTABLE_CONFIG, homeDir + "/ffprobe/32_bit/0.7_beta2/ffprobe"); 
			configs.put(FFMPEG_EXECUTABLE_CONFIG,  homeDir + "/ffmpeg/32_bit/0.8.7/ffmpeg"); 
		}  else {
			// add linux based tests when ready :-)
		}
		
		return configs;
	}
	
	public static boolean fileExists(String path) {
		File file = new File(path);
		
		if (file != null && file.exists() && file.isFile()) {
			return true;
		}
		
		return false;
	}

	/**
	 * This test case is needed to ensure junit passes this class. 
	 */
	@Test
	public void alwaysTrue() {
		Assert.assertTrue(true);
	}
}
