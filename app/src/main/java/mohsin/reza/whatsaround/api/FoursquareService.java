package mohsin.reza.whatsaround.api;

import android.arch.lifecycle.LiveData;

import java.util.List;

import mohsin.reza.whatsaround.vo.FoursquareJson;
import mohsin.reza.whatsaround.vo.FoursquareResponse;
import mohsin.reza.whatsaround.vo.Venue;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mohsin on 10/4/2017.
 */

public interface FoursquareService {

    @GET("venues/explore")
    LiveData<ApiResponse<FoursquareJson>> exploreVenueLL(@Query("ll") String ll, @Query("radius") String rad
            , @Query("client_id") String client_id, @Query("client_secret") String client_secret
            , @Query("v") String version );

    @GET("venues/explore")
    ApiResponse<List<Venue>> exploreVenueLLnormal(@Query("ll") String ll, @Query("radius") String rad
            , @Query("openNow") Boolean flag, @Query("client_id") String client_id, @Query("client_secret") String client_secret
            , @Query("v") String version );

    @GET("venues/explore")
    LiveData<ApiResponse<FoursquareJson>> exploreVenue_section(@Query("ll") String ll, @Query("radius") String rad
            ,@Query("section") String section
            , @Query("client_id") String client_id, @Query("client_secret") String client_secret
            , @Query("v") String version );

    @GET("venues/explore")
    LiveData<ApiResponse<FoursquareJson>> exploreVenue_section_query(@Query("ll") String ll, @Query("radius") String rad
            ,@Query("section") String section, @Query("query") String query
            , @Query("client_id") String client_id, @Query("client_secret") String client_secret
            , @Query("v") String version );
}
