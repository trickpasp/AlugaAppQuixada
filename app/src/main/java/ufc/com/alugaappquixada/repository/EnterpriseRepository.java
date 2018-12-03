package ufc.com.alugaappquixada.repository;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ufc.com.alugaappquixada.Model.Owner;
import ufc.com.alugaappquixada.Model.User;

public interface EnterpriseRepository {
    @GET("owner")
    Call<Owner> getUserByEmail(@Path("_embed") String email);
}
