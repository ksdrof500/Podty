package podcast.com.br.podtche.api;

import java.util.List;

import podcast.com.br.podtche.model.ChannelResponse;
import podcast.com.br.podtche.model.DefaultResponse;
import podcast.com.br.podtche.model.Podty;
import podcast.com.br.podtche.model.SimpleResponse;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by gholz on 2/9/16.
 */
public interface PodApi {

    @GET("/v1/feeds/top")
    Observable<DefaultResponse<List<Podty>>> getPodty();

//    @GET("/api/recipes/find/{id}")
//    Observable<Podty> getRecipe(@Path("id") long id);


//    @GET("/api/v1/subscription/{msisdn}")
//    Observable<SimpleResponse> getSubscriptionStatus(@Path("msisdn") String msisdn);
//
//    @PUT("/api/v1/subscription/{msisdn}")
//    Observable<SimpleResponse> subscribe(@Path("msisdn") String msisdn);
//
//    @DELETE("/api/v1/subscription/{msisdn}")
//    Observable<SimpleResponse> unsubscribe(@Path("msisdn") String msisdn);

//    @POST("/api/v1/verify/{msisdn}")
//    Observable<SendPinResponse> sendPin(@Path("msisdn") String msisdn);

//    @GET("/api/v1/channel")
//    Observable<ChannelResponse> getChannelInfo();
}
