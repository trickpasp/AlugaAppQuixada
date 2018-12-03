package ufc.com.alugaappquixada.presenter;

import ufc.com.alugaappquixada.Async.EnterpriseAsync;
import ufc.com.alugaappquixada.Model.Enterprise;
import ufc.com.alugaappquixada.view.EnterpriseView;

public class EnterprisePresenterImpl implements EnterprisePresenter {

    private EnterpriseView enterpriseView;
    public EnterprisePresenterImpl(EnterpriseView enterpriseView) {
        this.enterpriseView = enterpriseView;
    }

    @Override
    public void getEnterprise(Integer id) {
        new EnterpriseAsync(null, enterpriseView).execute(id);
    }

}
