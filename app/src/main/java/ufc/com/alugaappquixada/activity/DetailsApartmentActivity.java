package ufc.com.alugaappquixada.activity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;
import java.util.logging.Logger;

import ufc.com.alugaappquixada.Model.Enterprise;
import ufc.com.alugaappquixada.R;
import ufc.com.alugaappquixada.presenter.EnterprisePresenter;
import ufc.com.alugaappquixada.presenter.EnterprisePresenterImpl;
import ufc.com.alugaappquixada.view.EnterpriseView;

public class DetailsApartmentActivity extends Activity implements EnterpriseView, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private Button buttonVisit;
    private CarouselView carouselView;
    private TextView textStreet;
    private TextView textNumber;
    private TextView textDistrict;
    private TextView textCity;
    private TextView textState;
    private TextView textOwner;
    private TextView textDescription;
    private Enterprise enterprise;
    private EnterprisePresenter enterprisePresenter;

    int[] sampleImages = {R.drawable.apart1, R.drawable.apart2, R.drawable.apart3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_apartment);
        int id = getIntent().getIntExtra("enterpriseId", 0);
        Toast.makeText(this, ""+id, Toast.LENGTH_SHORT).show();
        enterprisePresenter = new EnterprisePresenterImpl(this);
        enterprisePresenter.getEnterprise(id);

        textNumber = (TextView) findViewById(R.id.textNumber);
        textStreet = (TextView) findViewById(R.id.textStreet);
        textDistrict = (TextView) findViewById(R.id.textDistrict);
        textCity = (TextView) findViewById(R.id.textCity);
        textState = (TextView) findViewById(R.id.textState);
        textOwner = (TextView) findViewById(R.id.textOwner);
        textDescription = (TextView) findViewById(R.id.textDescription);

        carouselView = (CarouselView) findViewById(R.id.caroselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener((position, imageView) -> {
            imageView.setImageResource(sampleImages[position]);
        });

        buttonVisit = (Button) findViewById(R.id.buttonVisit);
        buttonVisit.setOnClickListener((view) -> {
            Calendar date = Calendar.getInstance();

            DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(DetailsApartmentActivity.this
                ,date.get(Calendar.YEAR)
                ,date.get(Calendar.MONTH)
                ,date.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.setTitle("Data da visita");
            datePickerDialog.show(getFragmentManager(), "DataPicker");
            datePickerDialog.setOnDismissListener( (dialogInterface) -> {
                TimePickerDialog timePickerDialog = TimePickerDialog.newInstance(DetailsApartmentActivity.this
                        ,date.get(Calendar.HOUR_OF_DAY)
                        ,date.get(Calendar.MINUTE)
                        ,true);
                timePickerDialog.setTitle("Horário da visita");

                timePickerDialog.show(getFragmentManager(), "TimePicker");
                timePickerDialog.setOnDismissListener( (timeInterface) -> {
                    startActivity(new Intent(this,HomeActivity.class));
                });
            });

        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_details_apartment, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item ) {

        switch(item.getItemId())
        {
            case R.id.actionLogout:
                startActivity(new Intent(this,LoginActivity.class));
                break;

        }
        return true;
    }



    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

    }

    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {

    }


    @Override
    public void getEnterprise(Enterprise enterprise) {
        textNumber.setText("" + enterprise.getAddress().getNumber());
        textStreet.setText(enterprise.getAddress().getStreet());
        textDistrict.setText(enterprise.getAddress().getDistrict());
        textCity.setText(enterprise.getAddress().getCity());
        textState.setText(enterprise.getAddress().getState());
        textOwner.setText(enterprise.getOwner().getName());
        textDescription.setText(enterprise.getDescription());
    }
}
