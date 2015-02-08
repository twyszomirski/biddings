package twyszomirski.biddings.beans;

import twyszomirski.biddings.representations.BiddingRepresentation;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by tomasz on 12/21/14.
 */
@ApplicationScoped
public class Storage implements IStorage{

    /**
     * List of all biddings (alive untill next restart:))
     */
    private List<BiddingRepresentation> biddingsStore;

    private AtomicInteger nextId;

    @PostConstruct
    public void init(){
        biddingsStore = Collections.synchronizedList(new ArrayList<BiddingRepresentation>());
        nextId = new AtomicInteger(0);
    }

    @Override
    public List<BiddingRepresentation> getCurrentBiddings() {
        return  Collections.unmodifiableList(biddingsStore);
    }

    @Override
    public BiddingRepresentation createBidding(String name) {
        return new BiddingRepresentation(name, nextId.incrementAndGet());
    }

}
