package hu.bme.mit.sysml2autosar.cli;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

/**
 * Start and stop the application.
 */
public class Application implements IApplication {
    /**
     * Start the application.
     */
    @Override
    public Object start(final IApplicationContext appContext) {

        String[] arguments = null;

        if ((appContext != null) && (appContext.getArguments() != null)) {
            Object args = appContext.getArguments().get(IApplicationContext.APPLICATION_ARGS);
            if (args instanceof String[]) {
                arguments = (String[]) args;
            }
        }

        return new ApplicationStarter().start(arguments);
    }

    /**
     * Stop the application.
     */
    @Override
    public void stop() {
        // There is nothing to do as stop action
    }
}

