package twyszomirski.biddings.resources;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.message.MessageProperties;
import org.glassfish.jersey.moxy.xml.MoxyXmlFeature;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.jboss.weld.environment.se.Weld;

import javax.ws.rs.core.Application;
import java.util.Properties;

/**
 * Created by tomasz on 1/27/15.
 */
public class WeldEnabledTest extends JerseyTest {

    Weld weld;

    @Override
    public void setUp() throws Exception {
        Properties props = System.getProperties();
        props.setProperty("org.jboss.weld.se.archive.isolation", "false");

        weld = new Weld();
        weld.initialize();
        super.setUp();
    }

    @Override
    public void tearDown() throws Exception {
        weld.shutdown();
        super.tearDown();
    }

    @Override
    protected Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        return new BiddingsApplication();
    }

    @Override
    protected void configureClient(ClientConfig config) {
        // XML
        config.register(MoxyXmlFeature.class);
        config.property(MessageProperties.XML_FORMAT_OUTPUT, true);
        // JSON
        config.register(BiddingsApplication.createMoxyJsonResolver());
    }
}
