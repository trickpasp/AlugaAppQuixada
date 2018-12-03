package ufc.com.alugaappquixada.presenter;

import android.content.Context;

import ufc.com.alugaappquixada.Async.RequestForVisitAsync;
import ufc.com.alugaappquixada.Model.RequestForVisit;
import ufc.com.alugaappquixada.view.RequestForVisitView;

public class RequestForVisitPresenterImpl implements RequestForVisitPresenter {

    private Context ctx;
    private RequestForVisitView requestForVisitView;

    public RequestForVisitPresenterImpl(Context ctx, RequestForVisitView requestForVisitView) {
        this.ctx = ctx;
        this.requestForVisitView = requestForVisitView;
    }

    @Override
    public void saveRequestForVisit(RequestForVisit requestForVisit) {
        new RequestForVisitAsync(requestForVisitView).execute(requestForVisit);
    }
}
