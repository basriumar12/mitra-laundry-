package com.samyotech.laundrymitra.ui.activity.penjualan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.ActivityBookingPickDateTimeBinding;
import com.samyotech.laundrymitra.databinding.ActivityDateTimeBinding;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.model.layanan.LayananItemDto;
import com.samyotech.laundrymitra.model.layanan.ServiceItemDto;
import com.samyotech.laundrymitra.ui.activity.BookingPaymentActivity;
import com.samyotech.laundrymitra.ui.activity.BookingPickDateTimeActivity;
import com.samyotech.laundrymitra.ui.dialog.MyDatePickerDialog;
import com.samyotech.laundrymitra.ui.dialog.MyTimePickerDialog;
import com.samyotech.laundrymitra.utils.ProjectUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class DateTimeActivity extends AppCompatActivity implements View.OnClickListener {

    final Calendar myCalendar = Calendar.getInstance();
    final Calendar dateStart = Calendar.getInstance();
    final Calendar dateEnd = Calendar.getInstance();
    private final String TAG = DateTimeActivity.class.getSimpleName();
    private final Calendar time = Calendar.getInstance();
    Context mContext;
    int t = 123;
    DatePickerDialog datePickerDialogADp, datePickerDialogEnd;
    HashMap<String, String> hashMap;
    boolean checkCLick = true;
    ActivityDateTimeBinding binding;
    ArrayList<LayananItemDto> layananItemDtos;
    ServiceItemDto serviceItemDto;
    String price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_date_time);
        mContext = DateTimeActivity.this;

        hashMap = (HashMap<String, String>) getIntent().getSerializableExtra("map");
        layananItemDtos = getIntent().getParcelableArrayListExtra("LayananData");
        serviceItemDto = getIntent().getParcelableExtra("ServiceData");
        price = getIntent().getStringExtra(Consts.TOTAL_PRICE);
        binding.ctvPickupDate.setOnClickListener(this);
        binding.ctvPickupTime.setOnClickListener(this);
        binding.ctvDeliveryDate.setOnClickListener(this);
        binding.ctvDeliveryTime.setOnClickListener(this);
        binding.nextBtn.setOnClickListener(this);
        binding.back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                onBackPressed();
                break;
            case R.id.ctvPickupDate:
                t = 1;
                openDatePickerStart();
                break;
            case R.id.ctvPickupTime:
                t = 1;
                addtime();
                break;
            case R.id.ctvDeliveryDate:
                t = 2;
                openDatePickerEnd();
                break;
            case R.id.ctvDeliveryTime:
                t = 2;
                addtime();
                break;
            case R.id.next_btn:

                if (!ProjectUtils.isEditTextFilled(binding.ctvPickupDate)) {

                    showSickbar(getResources().getString(R.string.val_pdate));

                } else if (!ProjectUtils.isEditTextFilled(binding.ctvPickupTime)) {
                    showSickbar(getResources().getString(R.string.val_ptime));

                } else if (!ProjectUtils.isEditTextFilled(binding.ctvDeliveryDate)) {
                    showSickbar(getResources().getString(R.string.val_ddate));

                } else if (!ProjectUtils.isEditTextFilled(binding.ctvDeliveryTime)) {
                    showSickbar(getResources().getString(R.string.val_dtime));

                } else {
                    if (checkCLick) {
                        Intent in = new Intent(mContext, PaymentActivity.class);
                        in.putExtra(Consts.TOTAL_PRICE, String.valueOf(price));
                        in.putExtra("map", getParams());
                        in.putExtra("LayananData", layananItemDtos);
                        in.putExtra("ServiceData", serviceItemDto);
                        startActivity(in);
                        checkCLick = false;
                    }
                }
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkCLick = true;
    }

    private void addtime() {

        DialogFragment dialogFragment = new MyTimePickerDialog(new MyTimePickerDialog.TimeListener() {
            @Override
            public void onSelected(int hour, int minute) {
                time.set(Calendar.HOUR, hour);
                time.set(Calendar.MINUTE, minute);
                String myFormat = "hh:mm"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());

                if (t == 1) {
                    binding.ctvPickupTime.setText(sdf.format(time.getTime()));
                } else {
                    binding.ctvDeliveryTime.setText(sdf.format(time.getTime()));
                }
            }
        });
        dialogFragment.show(getSupportFragmentManager(), "tag");
    }


    public void openDatePickerStart() {

        DialogFragment datePickerDialog = new MyDatePickerDialog(new MyDatePickerDialog.DateListener() {
            @Override
            public void onSelected(int day, int month, int year) {
                dateStart.set(Calendar.YEAR, year);
                dateStart.set(Calendar.MONTH, month);
                dateStart.set(Calendar.DAY_OF_MONTH, day);
                String myFormat = "dd-MMM-yyyy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());
                binding.ctvPickupDate.setText(sdf.format(dateStart.getTime()));

            }
        });

        datePickerDialog.show(getSupportFragmentManager(), "tag");
    }

    public void openDatePickerEnd() {

        DialogFragment datePickerDialog = new MyDatePickerDialog(new MyDatePickerDialog.DateListener() {
            @Override
            public void onSelected(int day, int month, int year) {
                dateEnd.set(Calendar.YEAR, year);
                dateEnd.set(Calendar.MONTH, month);
                dateEnd.set(Calendar.DAY_OF_MONTH, day);
                String myFormat = "dd-MMM-yyyy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());
                binding.ctvDeliveryDate.setText(sdf.format(dateEnd.getTime()));
            }
        });

        datePickerDialog.show(getSupportFragmentManager(), "tag");
    }


    public void showSickbar(String msg) {
        Snackbar snackbar = Snackbar.make(binding.RRsncbar, msg, Snackbar.LENGTH_LONG);
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        snackbar.show();
    }


    private HashMap<String, String> getParams() {
        hashMap.put(Consts.PICKUP_DATE, ProjectUtils.getEditTextValue(binding.ctvPickupDate));
        hashMap.put(Consts.PICKUP_TIME, ProjectUtils.getEditTextValue(binding.ctvPickupTime));
        hashMap.put(Consts.DELIVERY_DATE, ProjectUtils.getEditTextValue(binding.ctvDeliveryDate));
        hashMap.put(Consts.DELIVERY_TIME, ProjectUtils.getEditTextValue(binding.ctvDeliveryTime));
        return hashMap;
    }
}