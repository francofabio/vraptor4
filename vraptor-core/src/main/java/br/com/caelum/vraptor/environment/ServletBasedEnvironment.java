package br.com.caelum.vraptor.environment;

import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;

/**
 * A default {@link Environment} implementation which loads the environment file
 * based on <i>VRAPTOR_ENVIRONMENT</i> system property or <i>br.com.caelum.vraptor
 * .environment</i> property in the context init parameter.
 * 
 * @author Alexandre Atoji
 * @author Andrew Kurauchi
 * @author Guilherme Silveira
 * @author Rodrigo Turini
 */
@ApplicationScoped
@Named("environment")
public class ServletBasedEnvironment extends DefaultEnvironment {

	public static final String ENVIRONMENT_PROPERTY = "br.com.caelum.vraptor.environment";

	/**
	 * @deprecated CDI eyes only
	 */
	public ServletBasedEnvironment() throws IOException {
	}

	@Inject
	public ServletBasedEnvironment(ServletContext context) throws IOException {
		super(EnvironmentType.of(env(context)));
	}

	private static String env(ServletContext context) {
		String contextEnv = context.getInitParameter(ENVIRONMENT_PROPERTY);
		if (contextEnv != null) {
			return contextEnv;
		}
		String systemProperty = System.getProperty(ENVIRONMENT_PROPERTY);
		if (systemProperty != null) {
			return systemProperty;
		}
		return System.getenv("VRAPTOR_ENVIRONMENT");
	}
}