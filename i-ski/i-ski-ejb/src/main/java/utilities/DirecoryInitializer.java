package utilities;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
@LocalBean
public class DirecoryInitializer {
	public static final String JBOSS_HOME = System.getProperty("jboss.home.dir");
	public static final String SKI_DIR = JBOSS_HOME + "/welcome-content/iski";

	public static final String IMAGE_DIR = SKI_DIR + "/images";

	@PostConstruct
	public void init() {

		File openSkiDirectory = new File(SKI_DIR);
		File imageDir = new File(IMAGE_DIR);

		if (!openSkiDirectory.exists()) {

			try {
				openSkiDirectory.mkdir();

			} catch (SecurityException se) {
			}
		}
		if (!imageDir.exists()) {
			try {
				imageDir.mkdir();

			} catch (SecurityException se) {
			}

		}

	}
}
