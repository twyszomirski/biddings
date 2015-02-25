package twyszomirski.biddings.beans;

import twyszomirski.biddings.representations.BiddingRepresentation;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tomasz on 12/21/14.
 */
@Alternative
@ApplicationScoped
public class MockedStorage extends Storage{

    @Override
    public List<BiddingRepresentation> getCurrentBiddings() {
        return  Arrays.asList(new BiddingRepresentation(1, "name_1", "part1", "part2"), new BiddingRepresentation(2, "name_2", "part1", "part2"));
    }

}
