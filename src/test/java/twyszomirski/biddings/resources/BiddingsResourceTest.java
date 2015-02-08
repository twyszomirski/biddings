package twyszomirski.biddings.resources;



import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.message.MessageProperties;
import org.glassfish.jersey.moxy.xml.MoxyXmlFeature;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;

import org.jboss.weld.environment.se.Weld;
import org.junit.Test;
import twyszomirski.biddings.representations.BiddingRepresentation;

import java.util.List;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BiddingsResourceTest extends WeldEnabledTest {


    @Test
    public void testGetBiddings() {

        final WebTarget target = target().path("biddings");

        List<BiddingRepresentation> biddings = target.request().get(new GenericType<List<BiddingRepresentation>>(){});

        assertThat(biddings.size(), is(2));

        assertThat(biddings.get(0).getId(), is(1));
        assertThat(biddings.get(0).getName(), is("name_1"));
        assertThat(biddings.get(0).getParticipants().size(), is(2));

        assertThat(biddings.get(1).getId(), is(2));
        assertThat(biddings.get(1).getName(), is("name_2"));
        assertThat(biddings.get(1).getParticipants().size(), is(2));

    }
}