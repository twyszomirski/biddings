package twyszomirski.biddings.resources;

import twyszomirski.biddings.beans.IStorage;
import twyszomirski.biddings.beans.Storage;
import twyszomirski.biddings.representations.BiddingRepresentation;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;
import java.util.Date;

/**
 * Created by tomasz on 12/21/14.
 */
@Path("/biddings")
public class BiddingsResource {

    @Inject
    IStorage storage;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BiddingRepresentation> getAllBiddings(){
        return storage.getCurrentBiddings();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public BiddingRepresentation createBidding(@FormParam("name") String name){
        return storage.createBidding(name);
    }

    @PUT
    @Path("{id}/participants")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public BiddingRepresentation addParticipant(@PathParam("id") int biddingId, @FormParam("participantName") String participantName){
        BiddingRepresentation bidding = storage.getById(biddingId);
        if(bidding == null){
            throw new NotFoundException();
        }

        return bidding.addParticipant(participantName);
    }

}
