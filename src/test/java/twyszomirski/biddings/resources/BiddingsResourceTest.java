package twyszomirski.biddings.resources;



import org.junit.Test;
import twyszomirski.biddings.representations.BiddingRepresentation;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

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

    @Test
    public void testCreateBidding(){
        Form form = new Form("name", "bidding_1");

        final WebTarget target = target().path("biddings");
        BiddingRepresentation bidding1 = target.request().post(Entity.form(form), BiddingRepresentation.class);
        assertThat(bidding1, notNullValue());
        assertThat(bidding1.getName(), is("bidding_1"));
        assertThat(bidding1.getId(),is(1));

        form = new Form("name", "bidding_2");
        BiddingRepresentation bidding2 = target.request().post(Entity.form(form), BiddingRepresentation.class);
        assertThat(bidding2, notNullValue());
        assertThat(bidding2.getName(), is("bidding_2"));
        assertThat(bidding2.getId(),is(2));
    }

    @Test
    public void testAddParticipant(){

        Form form = new Form("name", "bidding_1");

        WebTarget target = target().path("biddings");
        BiddingRepresentation bidding1 = target.request().post(Entity.form(form), BiddingRepresentation.class);
        assertThat(bidding1, notNullValue());
        assertThat(bidding1.getName(), is("bidding_1"));
        assertThat(bidding1.getId(),is(1));

        target = target().path("biddings/1/participants");
        form = new Form("participantName", "part_1");

        BiddingRepresentation bidding = target.request().put(Entity.form(form), BiddingRepresentation.class);

    }
}