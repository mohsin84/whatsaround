package mohsin.reza.whatsaround.api;

import java.util.List;

import mohsin.reza.whatsaround.vo.Venue;

/**
 * Created by mohsin on 10/5/2017.
 */

public class VenueSearchResponse {

    private List<Venue> items;
    public List<Venue> getItems(){
        return  items;
    }

    public void setItems(List<Venue> items)
    {
        this.items=items;
    }
}
