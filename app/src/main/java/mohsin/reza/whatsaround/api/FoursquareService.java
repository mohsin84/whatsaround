package mohsin.reza.whatsaround.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mohsin on 10/4/2017.
 */

public interface FoursquareService {

    @GET("explore")
    Call<VenueSearchResponse> exploreVenueLL(@Query("ll") String ll, @Query("radius") Integer rad, @Query("openNow") Boolean flag);

    @GET("explore")
    Call<VenueSearchResponse> exploreVenueNear(@Query("near") String near, @Query("radius") Integer rad, @Query("openNow") Boolean flag);

}
