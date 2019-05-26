package api;

import java.util.List;
import java.util.Map;

import model.Group;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface GroupAPI {
    @GET("api/groups")
    Call<List<Group>> getAllGroup();

    @FormUrlEncoded
    @POST("api/groups")
    Call<Void> addGroup(@FieldMap Map<String, String> map);


}
