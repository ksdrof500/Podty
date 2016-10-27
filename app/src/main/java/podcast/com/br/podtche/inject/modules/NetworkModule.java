package podcast.com.br.podtche.inject.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import javax.inject.Named;
import javax.inject.Singleton;


import dagger.Module;
import dagger.Provides;
import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import podcast.com.br.podtche.api.PodApi;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gholz on 2/13/16.
 */
@Module
public class NetworkModule {

    private static final String PODTY_AUTH_TOKEN = "Basic YnJuYnA6YnJuYnA=";
    private static final String HEADER_X_AUTH_TOKEN = "Authorization";


    @Provides
    @Singleton
    public PodApi providePodApi(GsonConverterFactory gsonConverterFactory,
                                   OkHttpClient client) {

        return new Retrofit.Builder()
                .baseUrl("http://brnapi.us-east-1.elasticbeanstalk.com")
                .client(client)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(PodApi.class);
    }


    @Provides
    @Singleton
    public OkHttpClient providePierContentClient() {
        String credential = Credentials.basic("brnbp", "brnbp");
        return new OkHttpClient.Builder()
                .authenticator((route, response) -> {
                    return response.
                    request().
                    newBuilder().
                    header("Authorization", credential).
                    build();
//;
                })
                .build();
    }
//
//    @Provides
//    @Singleton
//    public Interceptor providePierContentInterceptor() {
//
//        return chain -> {
//            Request request = chain.request().newBuilder()
//                    .addHeader(HEADER_X_AUTH_TOKEN, PODTY_AUTH_TOKEN)
//                    .build();
//
//            return chain.proceed(request);
//        };
//    }

//    @Provides
//    @Singleton
//    public Authenticator providePierContentAuthenticator() {
//        String credential = Credentials.basic("brnbp", "brnbp");
//
//        new Authenticator(){
//            @Override
//            public Request authenticate(Route route, Response response) throws IOException {
//                return response.
//                        request().
//                        newBuilder().
//                        header("Authorization", credential).
//                        build();
//            }
//        };
//        return null;
//    }


    @Provides
    @Singleton
    public GsonConverterFactory provideGsonFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    @Singleton
    public Gson provideGson() {
        return new GsonBuilder().setDateFormat("yyyy-mm-dd").create();
    }
}
