package ca.sambaexpress.business;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class SambaApp extends Application {
	
	@Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(SambaWS.class);
        return s;
    }

}
