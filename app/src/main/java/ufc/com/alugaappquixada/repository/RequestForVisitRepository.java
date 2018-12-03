package ufc.com.alugaappquixada.repository;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import ufc.com.alugaappquixada.Model.RequestForVisit;

public interface RequestForVisitRepository {

    @POST("requestForVisits")
    Call<RequestForVisit> save(@Body RequestForVisit requestForVisit);
}
