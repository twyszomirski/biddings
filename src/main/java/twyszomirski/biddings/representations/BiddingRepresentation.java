package twyszomirski.biddings.representations;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tomasz on 12/21/14.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BiddingRepresentation {
    private int id;
    private String name;
    private List<String> participants = new ArrayList<>();

    public BiddingRepresentation() {
    }

    public BiddingRepresentation(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public BiddingRepresentation(int id,String name,String ... participants) {
        this.name = name;
        this.id = id;
        this.participants = Arrays.asList(participants);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public BiddingRepresentation addParticipant(String name){
        participants.add(name);
        return this;
    }
}
