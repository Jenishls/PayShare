package api;

import java.util.List;

import model.Group;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface GroupAPI {
    @GET("api/groups")
    Call<List<Group>> getAllGroup();

}
