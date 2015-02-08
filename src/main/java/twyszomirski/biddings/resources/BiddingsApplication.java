package twyszomirski.biddings.resources;


import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;
import org.glassfish.jersey.moxy.json.MoxyJsonConfig;
import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
import org.glassfish.jersey.moxy.xml.MoxyXmlFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.ext.ContextResolver;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by tomasz on 12/21/14.
 */
@ApplicationPath("/*")
public class BiddingsApplication extends ResourceConfig {

    public BiddingsApplication() {
        registerClasses(BiddingsResource.class);
        register(MoxyJsonFeature.class);
        register(createMoxyJsonResolver());
    }

    public static ContextResolver<MoxyJsonConfig> createMoxyJsonResolver() {
        final MoxyJsonConfig moxyJsonConfig = new MoxyJsonConfig()
                .setFormattedOutput(true)
                .setNamespaceSeparator(':');
        return moxyJsonConfig.resolver();
    }
}
