package ufc.com.alugaappquixada.Async;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ufc.com.alugaappquixada.Config.ConfigRetrofit;
import ufc.com.alugaappquixada.Model.RequestForVisit;
import ufc.com.alugaappquixada.repository.RequestForVisitRepository;
import ufc.com.alugaappquixada.view.RequestForVisitView;

public class RequestForVisitAsync extends AsyncTask<RequestForVisit, Void, Boolean> {

    private RequestForVisitRepository requestForVisitRepository;
    private RequestForVisitView requestForVisitView;
    public RequestForVisitAsync(RequestForVisitView requestForVisitView) {
        this.requestForVisitRepository = ConfigRetrofit.getRetrofitConfig().create(RequestForVisitRepository.class);
        this.requestForVisitView = requestForVisitView;
    }

    @Override
    protected Boolean doInBackground(RequestForVisit... requestForVisits) {
        boolean void1 = false;
        Call<RequestForVisit> callBack = requestForVisitRepository.save(requestForVisits[0]);
        callBack.enqueue(new Callback<RequestForVisit>() {

            @Override
            public void onResponse(Call<RequestForVisit> call, Response<RequestForVisit> response) {
                if (response.isSuccessful()){
//                    Toast.makeText(ctx, "Aqui", Toast.LENGTH_SHORT).show();
                    requestForVisitView.onCheckVisit(true);
                }
            }

            @Override
            public void onFailure(Call<RequestForVisit> call, Throwable t) {
                requestForVisitView.onCheckVisit(false);
            }
        });
        return null;
    }
}
