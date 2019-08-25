package lanacion;

import java.io.IOException;
import java.net.URISyntaxException;

import org.osgi.service.component.annotations.Component;

import com.make.equo.application.api.IEquoApplication;
import com.make.equo.application.model.EquoApplicationBuilder;

@Component
public class LaNacionApplication implements IEquoApplication {

	@Override
	public EquoApplicationBuilder buildApp(EquoApplicationBuilder appBuilder) {
		try {
			return appBuilder
				.withSingleView("https://www.lanacion.com.ar")

				// Add custom scripts to modify the Web application
				.withCustomScript("js/actions.js")
				
				// Add main menues, menues, and menues items
				.withMainMenu("Equo menu")
					.addMenuItem("Equo menu item")
					// Functionality declared in actions.js
					.onClick("equoMenuItem")
					.addShortcut("M1+M")
					// Optional functionality before exiting
					.onBeforeExit(() -> {
						beforeExit();
					})
					.start();
			} catch (IOException | URISyntaxException e) {
				e.printStackTrace();
			}
		return null;
	}

	private void beforeExit() {
		// Your code goes here
	}

}
