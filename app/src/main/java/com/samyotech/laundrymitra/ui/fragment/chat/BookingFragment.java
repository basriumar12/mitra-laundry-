package com.samyotech.laundrymitra.ui.fragment.chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.FragmentBookingBinding;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.model.BookingDTO;
import com.samyotech.laundrymitra.model.CurrencyDTO;
import com.samyotech.laundrymitra.model.UserDTO;
import com.samyotech.laundrymitra.model.chat.ChatDto;
import com.samyotech.laundrymitra.model.home.KhususUntukmuListDto;
import com.samyotech.laundrymitra.network.ApiInterface;
import com.samyotech.laundrymitra.network.ServiceGenerator;
import com.samyotech.laundrymitra.preferences.SharedPrefrence;
import com.samyotech.laundrymitra.ui.activity.NotificationActivity;
import com.samyotech.laundrymitra.ui.activity.SearchActivity;
import com.samyotech.laundrymitra.ui.adapter.BookingAdapter;
import com.samyotech.laundrymitra.ui.adapter.ChatAdapter;
import com.samyotech.laundrymitra.ui.adapter.chat.ChatAdapterNew;
import com.samyotech.laundrymitra.ui.adapter.home.KhususUntukmuAdapter;
import com.samyotech.laundrymitra.utils.ProjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookingFragment extends Fragment {

    String TAG = BookingFragment.class.getSimpleName();
    FragmentBookingBinding binding;
    LinearLayoutManager linearLayoutManager;
    BookingAdapter bookingAdapter;
    ChatAdapterNew chatAdapter;
    ArrayList<BookingDTO> bookingDTOS = new ArrayList<>();
    HashMap<String, String> params = new HashMap<>();
    BookingDTO bookingDTO;
    UserDTO userDTO;
    CurrencyDTO currencyDTO;
    int i = 0;
    private SharedPrefrence prefrence;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_booking, container, false);

        prefrence = SharedPrefrence.getInstance(getActivity());
        userDTO = prefrence.getParentUser(Consts.USER_DTO);
        binding.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                setData();
            }
        });
        setData();

        binding.ivNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in4 = new Intent(getActivity(), NotificationActivity.class);
                startActivity(in4);
            }
        });

        binding.ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in4 = new Intent(getActivity(), SearchActivity.class);
                startActivity(in4);
            }
        });
        return binding.getRoot();
    }


    private void setData() {


        ApiInterface api = ServiceGenerator.createService(
                ApiInterface.class,
                Consts.username,
                Consts.pass
        );

        //wxde17
        api.getChat(  userDTO.getUser_id()
        ).enqueue(new Callback<ChatDto>() {
            @Override
            public void onResponse(Call<ChatDto> call, Response<ChatDto> response) {
                binding.swipeRefreshLayout.setRefreshing(false);
                ProjectUtils.cancelDialog();
                ProjectUtils.pauseProgressDialog();
                if (response.isSuccessful()) {
                    if (response.body().isStatus()) {
                        binding.tvKosongChat.setText(response.body().getMessage());
                        binding.tvKosongChat.setVisibility(View.GONE);
                        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                        binding.rvChat.setLayoutManager(linearLayoutManager);
                        chatAdapter = new ChatAdapterNew(getActivity(), response.body().getData());

                        binding.rvChat.setAdapter(chatAdapter);
                        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(binding.rvChat.getContext(),
                                linearLayoutManager.getOrientation());
                        binding.rvChat.addItemDecoration(dividerItemDecoration);
                    } else {

                        binding.tvKosongChat.setText(response.body().getMessage());
                        binding.tvKosongChat.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void onFailure(Call<ChatDto> call, Throwable t) {
                binding.tvKosongChat.setVisibility(View.VISIBLE);
                ProjectUtils.cancelDialog();
                ProjectUtils.pauseProgressDialog();
                binding.swipeRefreshLayout.setRefreshing(false);
            }
        });


    }


}
