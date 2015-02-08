package twyszomirski.biddings.beans;

import twyszomirski.biddings.representations.BiddingRepresentation;

import java.util.List;

/**
 * Created by tomasz on 1/13/15.
 */
public interface IStorage {

    /**
     * Fetches the list of all biddings
     * @return
     */
    List<BiddingRepresentation> getCurrentBiddings();

    /**
     * Creates a new bidding
     * @param name The name assigned to the newly created object
     * @return
     */
    BiddingRepresentation createBidding(String name);


}
