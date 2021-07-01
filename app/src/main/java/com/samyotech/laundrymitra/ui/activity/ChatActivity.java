package com.samyotech.laundrymitra.ui.activity;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.cocosw.bottomsheet.BottomSheet;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.https.HttpsRequest;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.interfaces.Helper;
import com.samyotech.laundrymitra.model.GetCommentDTO;
import com.samyotech.laundrymitra.model.UserDTO;
import com.samyotech.laundrymitra.network.ApiInterface;
import com.samyotech.laundrymitra.network.NetworkManager;
import com.samyotech.laundrymitra.network.ResponseOther;
import com.samyotech.laundrymitra.network.ServiceGenerator;
import com.samyotech.laundrymitra.preferences.SharedPrefrence;
import com.samyotech.laundrymitra.ui.adapter.ChatAdapter;
import com.samyotech.laundrymitra.utils.ProjectUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import hani.momanii.supernova_emoji_library.Helper.EmojiconEditText;
import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Call;
import retrofit2.Callback;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {
    private final String TAG = ChatActivity.class.getSimpleName();
    private final String id = "";
    private final HashMap<String, String> parmsGet = new HashMap<>();
    private final HashMap<String, File> paramsFile = new HashMap<>();
    boolean clickcheck = true;
    IntentFilter intentFilter = new IntentFilter();
    private final boolean actions_container_visible = false;
    BottomSheet.Builder builder;
    Uri picUri;
    int PICK_FROM_CAMERA = 1, PICK_FROM_GALLERY = 2;
    int CROP_CAMERA_IMAGE = 3, CROP_GALLERY_IMAGE = 4;
    String imageName;
    String pathOfImage;
    Bitmap bm;
    byte[] resultByteArray;
    File file;
    Bitmap bitmap = null;
    private ListView lvComment;
    private final boolean img_container_visible = false;
    HashMap<String, String> params = new HashMap<>();
    private ArrayList<GetCommentDTO> getCommentDTOList;
    private InputMethodManager inputManager;
    private SwipeRefreshLayout swipeRefreshLayout;
    private EmojiconEditText edittextMessage;
    private RelativeLayout relative;
    private Context mContext;
    private SharedPrefrence prefrence;
    private UserDTO userDTO;
    BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equalsIgnoreCase(Consts.BROADCAST)) {
                getComment();
                Log.e("BROADCAST", "BROADCAST");

            }
        }
    };
    private EditText etMessage;
    private ImageView buttonSendMessage, IVback;
    private ChatAdapter adapterViewComment;
    private FrameLayout mContainerImg;
    private TextView tvNameHedar;
    private ImageView mActionImage, mPreviewImg, mDeleteImg, mActionContainerImg;
    private String ar_id = "", ar_name = "", image = "";
    private ImageView galleryBtn;
    private ImageView cameraBtn;
    private ImageView closeImgBtn;
    private ImageView previewImg;
    File fileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        mContext = ChatActivity.this;
        prefrence = SharedPrefrence.getInstance(mContext);
        userDTO = prefrence.getParentUser(Consts.USER_DTO);

        inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        intentFilter.addAction(Consts.BROADCAST);
        LocalBroadcastManager.getInstance(this).registerReceiver(mBroadcastReceiver, intentFilter);

        if (getIntent().hasExtra(Consts.SHOP_ID)) {

            ar_id = getIntent().getStringExtra(Consts.SHOP_ID);
            ar_name = getIntent().getStringExtra(Consts.SHOP_NAME);

            parmsGet.put(Consts.TO_USER_ID, ar_id);
            parmsGet.put(Consts.USER_ID, userDTO.getUser_id());
            image = getIntent().getStringExtra(Consts.IMAGE);

            params.put(Consts.TO_USER_ID, ar_id);
        }
        if (getIntent().hasExtra(Consts.TO_USER_ID)) {

            ar_id = getIntent().getStringExtra(Consts.TO_USER_ID);
            ar_name = getIntent().getStringExtra(Consts.NAME);
            image = getIntent().getStringExtra(Consts.IMAGE);

            parmsGet.put(Consts.TO_USER_ID, ar_id);
            parmsGet.put(Consts.USER_ID, userDTO.getUser_id());
            params.put(Consts.TO_USER_ID, ar_id);
        }
        setUiAction();

    }

    public void setUiAction() {

        mContainerImg = findViewById(R.id.container_img);
        closeImgBtn = findViewById(R.id.close_img_btn);
        closeImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContainerImg.setVisibility(View.GONE);
                file = null;
            }
        });
        previewImg = findViewById(R.id.preview_img);
        mContainerImg.setVisibility(View.GONE);

        relative = findViewById(R.id.relative);
        tvNameHedar = findViewById(R.id.header_title);
        edittextMessage = findViewById(R.id.edittextMessage);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        lvComment = findViewById(R.id.lvComment);
        buttonSendMessage = findViewById(R.id.sendBtn);
        IVback = findViewById(R.id.back);
        galleryBtn = findViewById(R.id.gallery_btn);
        galleryBtn.setOnClickListener(this);
        cameraBtn = findViewById(R.id.camera_btn);
        cameraBtn.setOnClickListener(this);
        buttonSendMessage.setOnClickListener(this);
        IVback.setOnClickListener(this);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.post(
                new Runnable() {
                    @Override
                    public void run() {

                        Log.e("Runnable", "FIRST");
                        if (NetworkManager.isConnectToInternet(mContext)) {
                            swipeRefreshLayout.setRefreshing(true);
                            getComment();

                        } else {
                            ProjectUtils.showToast(mContext, getResources().getString(R.string.internet_concation));
                        }
                    }
                }
        );
        tvNameHedar.setText(getIntent().getStringExtra("NAME"));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            file = ImagePicker.Companion.getFile(data);
            paramsFile.put(Consts.IMAGE, file);
            mContainerImg.setVisibility(View.VISIBLE);
            Glide.with(this).load(file).into(previewImg);
        }
    }

    public boolean validateMessage() {
        if (edittextMessage.getText().toString().trim().length() <= 0) {
            edittextMessage.setError(getResources().getString(R.string.val_comment));
            edittextMessage.requestFocus();
            return false;
        } else {
            edittextMessage.setError(null);
            edittextMessage.clearFocus();
            return true;
        }
    }

    public void submit() {
        if (validateMessage()) {
            mContainerImg.setVisibility(View.GONE);
            try {
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (NetworkManager.isConnectToInternet(mContext)) {
                if (clickcheck) {
                    doComment();
                }
            } else {
                ProjectUtils.showToast(mContext, getResources().getString(R.string.internet_concation));
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sendBtn:
                submit();
                break;
            case R.id.back:
                finish();
                break;
            case R.id.camera_btn:
                ImagePicker.Companion.with(this)
                        .cameraOnly()
                        .crop()
                        .compress(512)
                        .start();
                break;
            case R.id.gallery_btn:
                ImagePicker.Companion.with(this)
                        .galleryOnly()
                        .crop()
                        .compress(512)
                        .start();
                break;
        }
    }

    @Override
    public void onRefresh() {
        Log.e("ONREFREST_Firls", "FIRS");
        getComment();
    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        finish();
    }

    public void getComment() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .authenticator(new Authenticator() {
                    @Override
                    public Request authenticate(Route route, Response response) throws IOException {
                        return response.request().newBuilder()
                                .header("Authorization", Credentials.basic(Consts.username, Consts.pass))
                                .build();
                    }
                })
                .build();
        final ANRequest request =
                AndroidNetworking.get(Consts.API_URL + Consts.messagedetail + "?message_head_id=" + getIntent().getStringExtra("ID") + "&" + "user_id=" + userDTO.getUser_id())
                        .setOkHttpClient(okHttpClient)
                        .setTag("test")
//                        .addQueryParameter("id_user", userid)
//                        .addQueryParameter("otp", otpSms)
                        .setPriority(Priority.HIGH)
                        .build();
        ProjectUtils.showLog("TAG", " url data --->" + request.getUrl());

        request.getAsJSONObject(new JSONObjectRequestListener() {
            @Override
            public void onResponse(JSONObject response) {

                swipeRefreshLayout.setRefreshing(false);
                try {
                    boolean flag = response.getBoolean("status");
                    String msg = response.getString("message");



                    ProjectUtils.showToast(getBaseContext(), msg);

                    if (flag) {
                        try {
                            getCommentDTOList = new ArrayList<>();
                            Type getpetDTO = new TypeToken<List<GetCommentDTO>>() {
                            }.getType();
                            clickcheck = true;
                            getCommentDTOList = new Gson().fromJson(response.getJSONArray("data").toString(), getpetDTO);
                            showData();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onError(ANError anError) {

                ProjectUtils.showToast(getBaseContext(), "Gagal dapatkan pesan");
                swipeRefreshLayout.setRefreshing(false);
            }
        });


    }

    public void showData() {
        adapterViewComment = new ChatAdapter(mContext, getCommentDTOList, userDTO, userDTO.getImage(), image);
        lvComment.setAdapter(adapterViewComment);
        lvComment.setSelection(getCommentDTOList.size() - 1);
    }

    public void doComment() {
        params.put(Consts.message_head, getIntent().getStringExtra("ID"));
        params.put(Consts.USER_ID, userDTO.getUser_id());
        params.put(Consts.MESSAGE, ProjectUtils.getEditTextValue(edittextMessage));

        if (file != null) {
            params.put(Consts.MEDIA, file.getPath());
        } else {
            params.put(Consts.MEDIA, "");


        }

        ApiInterface api = ServiceGenerator.createService(
                ApiInterface.class,
                Consts.username,
                Consts.pass
        );

        MultipartBody.Part filePart = MultipartBody.Part.createFormData("media",
                fileImage.getName(), RequestBody.create(MediaType.parse("image/*"), file));


        RequestBody userId = RequestBody.create(MediaType.parse("text/plain"),
                userDTO.getUser_id());

        RequestBody message = RequestBody.create(MediaType.parse("text/plain"),
                ProjectUtils.getEditTextValue(edittextMessage));

        RequestBody messageId = RequestBody.create(MediaType.parse("text/plain"),
                getIntent().getStringExtra("ID"));

        final ProgressDialog progressDialog = new ProgressDialog(getBaseContext(), R.style.CustomAlertDialog);
        progressDialog.setMessage("loading");
        progressDialog.show();
        api.sendMessage(userId,messageId,message,filePart).enqueue(new Callback<ResponseOther>() {
            @Override
            public void onResponse(Call<ResponseOther> call, retrofit2.Response<ResponseOther> response) {
                progressDialog.dismiss();
                if (response.isSuccessful()) {
                    if (response.body().isStatus()) {
                        ProjectUtils.showToast(getBaseContext(), "Berhasil Kirm");

                    } else {
                        ProjectUtils.showToast(getBaseContext(), "Gagal Kirim");
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseOther> call, Throwable t) {
                progressDialog.dismiss();
                ProjectUtils.showToast(getBaseContext(), "Gagal Kirim");
            }
        });



//        new HttpsRequest(Consts.SETMESSAGE, params, paramsFile, mContext)
//                .imagePost(TAG, new Helper() {
//                    @Override
//                    public void backResponse(boolean flag, String msg, JSONObject response) {
//                        ProjectUtils.pauseProgressDialog();
//                        if (flag) {
//                            edittextMessage.setText("");
////                    hideImageContainer();
//                            getComment();
//
//                            file = null;
//                            pathOfImage = "";
//                        } else {
//                            ProjectUtils.showToast(getBaseContext(),"Gagal kirim");
//                        }
//                    }
//                });
    }
}