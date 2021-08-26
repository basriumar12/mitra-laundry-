package com.samyotech.laundrymitra;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.samyotech.laundrymitra.databinding.ActivityAboutBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityAddDetailLayananItemBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityAllServicesBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityBookingConfirmBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityBookingPaymentBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityBookingPickAddressBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityBookingPickDateTimeBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityChangPasswordBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityChatListBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityDashboardBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityDateTimeBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityDetailKhususUntukmuBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityDetailLayananItemBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityDetailPenjualanBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityEditServiceBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityForgotPasswordBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityIntroBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityListKhususUntukmuBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityLoginBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityManageBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityManageProfileAddressBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityManageProfileBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityManageProfileChatEmailBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityManageProfileMitraBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityManageProfileOperasionalBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityManageProfileRekeningBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityManagePromosiTokoBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityManageTarikRekeningBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityNotificationBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityOrderDetailsBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityOtpBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityPaymentBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityPickupBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityPreviewOrderBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityPusatEdukasiBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityRegisterBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityRegisterChooseBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityRegisterMitraBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityScheduleBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivitySearchBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityServiceAcitivityBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityServiceMenuBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityServicePenjualanBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityShopAcitivityBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivitySuccessPenjualanBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivitySuksesRegisterBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityTicketsBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityTopServicesBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityUlasanBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityUploadKtpBindingImpl;
import com.samyotech.laundrymitra.databinding.ActivityWelcomeScreensBindingImpl;
import com.samyotech.laundrymitra.databinding.AdapterAddressBindingImpl;
import com.samyotech.laundrymitra.databinding.AdapterAllservicesBindingImpl;
import com.samyotech.laundrymitra.databinding.AdapterBankBindingImpl;
import com.samyotech.laundrymitra.databinding.AdapterBookingBindingImpl;
import com.samyotech.laundrymitra.databinding.AdapterChatBindingImpl;
import com.samyotech.laundrymitra.databinding.AdapterDetailPenjualanBindingImpl;
import com.samyotech.laundrymitra.databinding.AdapterItemBindingImpl;
import com.samyotech.laundrymitra.databinding.AdapterKhususBindingImpl;
import com.samyotech.laundrymitra.databinding.AdapterKhususListBindingImpl;
import com.samyotech.laundrymitra.databinding.AdapterLayananItemBindingImpl;
import com.samyotech.laundrymitra.databinding.AdapterNearBindingImpl;
import com.samyotech.laundrymitra.databinding.AdapterNotificationBindingImpl;
import com.samyotech.laundrymitra.databinding.AdapterOffersBindingImpl;
import com.samyotech.laundrymitra.databinding.AdapterPelayananBindingImpl;
import com.samyotech.laundrymitra.databinding.AdapterPenjualanBindingImpl;
import com.samyotech.laundrymitra.databinding.AdapterPenjualanLayananItemBindingImpl;
import com.samyotech.laundrymitra.databinding.AdapterPentingBindingImpl;
import com.samyotech.laundrymitra.databinding.AdapterPopularLaundriesBindingImpl;
import com.samyotech.laundrymitra.databinding.AdapterPreviewBindingImpl;
import com.samyotech.laundrymitra.databinding.AdapterServiceMenuBindingImpl;
import com.samyotech.laundrymitra.databinding.AdapterServicesBindingImpl;
import com.samyotech.laundrymitra.databinding.AdapterTicketBindingImpl;
import com.samyotech.laundrymitra.databinding.AdapterTopservicesBindingImpl;
import com.samyotech.laundrymitra.databinding.AdapterUlasanListBindingImpl;
import com.samyotech.laundrymitra.databinding.AddAddressBottomsheetBindingImpl;
import com.samyotech.laundrymitra.databinding.DailogAddTicketBindingImpl;
import com.samyotech.laundrymitra.databinding.DailogCancelOrderBindingImpl;
import com.samyotech.laundrymitra.databinding.DailogRatingBindingImpl;
import com.samyotech.laundrymitra.databinding.DialogBuatTiketBindingImpl;
import com.samyotech.laundrymitra.databinding.FragmentAboutBindingImpl;
import com.samyotech.laundrymitra.databinding.FragmentBookingBindingImpl;
import com.samyotech.laundrymitra.databinding.FragmentDynamicBindingImpl;
import com.samyotech.laundrymitra.databinding.FragmentLayananBindingImpl;
import com.samyotech.laundrymitra.databinding.FragmentNearByBindingImpl;
import com.samyotech.laundrymitra.databinding.FragmentOfferShopBindingImpl;
import com.samyotech.laundrymitra.databinding.FragmentOffersBindingImpl;
import com.samyotech.laundrymitra.databinding.FragmentOutletBindingImpl;
import com.samyotech.laundrymitra.databinding.FragmentPenjualanBindingImpl;
import com.samyotech.laundrymitra.databinding.FragmentProfileBindingImpl;
import com.samyotech.laundrymitra.databinding.FragmentServicesBindingImpl;
import com.samyotech.laundrymitra.databinding.HomeFragmentBindingImpl;
import com.samyotech.laundrymitra.databinding.ServicesAdapterBindingImpl;
import com.samyotech.laundrymitra.databinding.SpecialOffersBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYABOUT = 1;

  private static final int LAYOUT_ACTIVITYADDDETAILLAYANANITEM = 2;

  private static final int LAYOUT_ACTIVITYALLSERVICES = 3;

  private static final int LAYOUT_ACTIVITYBOOKINGCONFIRM = 4;

  private static final int LAYOUT_ACTIVITYBOOKINGPAYMENT = 5;

  private static final int LAYOUT_ACTIVITYBOOKINGPICKADDRESS = 6;

  private static final int LAYOUT_ACTIVITYBOOKINGPICKDATETIME = 7;

  private static final int LAYOUT_ACTIVITYCHANGPASSWORD = 8;

  private static final int LAYOUT_ACTIVITYCHATLIST = 9;

  private static final int LAYOUT_ACTIVITYDASHBOARD = 10;

  private static final int LAYOUT_ACTIVITYDATETIME = 11;

  private static final int LAYOUT_ACTIVITYDETAILKHUSUSUNTUKMU = 12;

  private static final int LAYOUT_ACTIVITYDETAILLAYANANITEM = 13;

  private static final int LAYOUT_ACTIVITYDETAILPENJUALAN = 14;

  private static final int LAYOUT_ACTIVITYEDITSERVICE = 15;

  private static final int LAYOUT_ACTIVITYFORGOTPASSWORD = 16;

  private static final int LAYOUT_ACTIVITYINTRO = 17;

  private static final int LAYOUT_ACTIVITYLISTKHUSUSUNTUKMU = 18;

  private static final int LAYOUT_ACTIVITYLOGIN = 19;

  private static final int LAYOUT_ACTIVITYMANAGE = 20;

  private static final int LAYOUT_ACTIVITYMANAGEPROFILE = 21;

  private static final int LAYOUT_ACTIVITYMANAGEPROFILEADDRESS = 22;

  private static final int LAYOUT_ACTIVITYMANAGEPROFILECHATEMAIL = 23;

  private static final int LAYOUT_ACTIVITYMANAGEPROFILEMITRA = 24;

  private static final int LAYOUT_ACTIVITYMANAGEPROFILEOPERASIONAL = 25;

  private static final int LAYOUT_ACTIVITYMANAGEPROFILEREKENING = 26;

  private static final int LAYOUT_ACTIVITYMANAGEPROMOSITOKO = 27;

  private static final int LAYOUT_ACTIVITYMANAGETARIKREKENING = 28;

  private static final int LAYOUT_ACTIVITYNOTIFICATION = 29;

  private static final int LAYOUT_ACTIVITYORDERDETAILS = 30;

  private static final int LAYOUT_ACTIVITYOTP = 31;

  private static final int LAYOUT_ACTIVITYPAYMENT = 32;

  private static final int LAYOUT_ACTIVITYPICKUP = 33;

  private static final int LAYOUT_ACTIVITYPREVIEWORDER = 34;

  private static final int LAYOUT_ACTIVITYPUSATEDUKASI = 35;

  private static final int LAYOUT_ACTIVITYREGISTER = 36;

  private static final int LAYOUT_ACTIVITYREGISTERCHOOSE = 37;

  private static final int LAYOUT_ACTIVITYREGISTERMITRA = 38;

  private static final int LAYOUT_ACTIVITYSCHEDULE = 39;

  private static final int LAYOUT_ACTIVITYSEARCH = 40;

  private static final int LAYOUT_ACTIVITYSERVICEACITIVITY = 41;

  private static final int LAYOUT_ACTIVITYSERVICEMENU = 42;

  private static final int LAYOUT_ACTIVITYSERVICEPENJUALAN = 43;

  private static final int LAYOUT_ACTIVITYSHOPACITIVITY = 44;

  private static final int LAYOUT_ACTIVITYSUCCESSPENJUALAN = 45;

  private static final int LAYOUT_ACTIVITYSUKSESREGISTER = 46;

  private static final int LAYOUT_ACTIVITYTICKETS = 47;

  private static final int LAYOUT_ACTIVITYTOPSERVICES = 48;

  private static final int LAYOUT_ACTIVITYULASAN = 49;

  private static final int LAYOUT_ACTIVITYUPLOADKTP = 50;

  private static final int LAYOUT_ACTIVITYWELCOMESCREENS = 51;

  private static final int LAYOUT_ADAPTERADDRESS = 52;

  private static final int LAYOUT_ADAPTERALLSERVICES = 53;

  private static final int LAYOUT_ADAPTERBANK = 54;

  private static final int LAYOUT_ADAPTERBOOKING = 55;

  private static final int LAYOUT_ADAPTERCHAT = 56;

  private static final int LAYOUT_ADAPTERDETAILPENJUALAN = 57;

  private static final int LAYOUT_ADAPTERITEM = 58;

  private static final int LAYOUT_ADAPTERKHUSUS = 59;

  private static final int LAYOUT_ADAPTERKHUSUSLIST = 60;

  private static final int LAYOUT_ADAPTERLAYANANITEM = 61;

  private static final int LAYOUT_ADAPTERNEAR = 62;

  private static final int LAYOUT_ADAPTERNOTIFICATION = 63;

  private static final int LAYOUT_ADAPTEROFFERS = 64;

  private static final int LAYOUT_ADAPTERPELAYANAN = 65;

  private static final int LAYOUT_ADAPTERPENJUALAN = 66;

  private static final int LAYOUT_ADAPTERPENJUALANLAYANANITEM = 67;

  private static final int LAYOUT_ADAPTERPENTING = 68;

  private static final int LAYOUT_ADAPTERPOPULARLAUNDRIES = 69;

  private static final int LAYOUT_ADAPTERPREVIEW = 70;

  private static final int LAYOUT_ADAPTERSERVICEMENU = 71;

  private static final int LAYOUT_ADAPTERSERVICES = 72;

  private static final int LAYOUT_ADAPTERTICKET = 73;

  private static final int LAYOUT_ADAPTERTOPSERVICES = 74;

  private static final int LAYOUT_ADAPTERULASANLIST = 75;

  private static final int LAYOUT_ADDADDRESSBOTTOMSHEET = 76;

  private static final int LAYOUT_DAILOGADDTICKET = 77;

  private static final int LAYOUT_DAILOGCANCELORDER = 78;

  private static final int LAYOUT_DAILOGRATING = 79;

  private static final int LAYOUT_DIALOGBUATTIKET = 80;

  private static final int LAYOUT_FRAGMENTABOUT = 81;

  private static final int LAYOUT_FRAGMENTBOOKING = 82;

  private static final int LAYOUT_FRAGMENTDYNAMIC = 83;

  private static final int LAYOUT_FRAGMENTLAYANAN = 84;

  private static final int LAYOUT_FRAGMENTNEARBY = 85;

  private static final int LAYOUT_FRAGMENTOFFERSHOP = 86;

  private static final int LAYOUT_FRAGMENTOFFERS = 87;

  private static final int LAYOUT_FRAGMENTOUTLET = 88;

  private static final int LAYOUT_FRAGMENTPENJUALAN = 89;

  private static final int LAYOUT_FRAGMENTPROFILE = 90;

  private static final int LAYOUT_FRAGMENTSERVICES = 91;

  private static final int LAYOUT_HOMEFRAGMENT = 92;

  private static final int LAYOUT_SERVICESADAPTER = 93;

  private static final int LAYOUT_SPECIALOFFERS = 94;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(94);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_about, LAYOUT_ACTIVITYABOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_add_detail_layanan_item, LAYOUT_ACTIVITYADDDETAILLAYANANITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_all_services, LAYOUT_ACTIVITYALLSERVICES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_booking_confirm, LAYOUT_ACTIVITYBOOKINGCONFIRM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_booking_payment, LAYOUT_ACTIVITYBOOKINGPAYMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_booking_pick_address, LAYOUT_ACTIVITYBOOKINGPICKADDRESS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_booking_pick_date_time, LAYOUT_ACTIVITYBOOKINGPICKDATETIME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_chang_password, LAYOUT_ACTIVITYCHANGPASSWORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_chat_list, LAYOUT_ACTIVITYCHATLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_dashboard, LAYOUT_ACTIVITYDASHBOARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_date_time, LAYOUT_ACTIVITYDATETIME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_detail_khusus_untukmu, LAYOUT_ACTIVITYDETAILKHUSUSUNTUKMU);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_detail_layanan_item, LAYOUT_ACTIVITYDETAILLAYANANITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_detail_penjualan, LAYOUT_ACTIVITYDETAILPENJUALAN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_edit_service, LAYOUT_ACTIVITYEDITSERVICE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_forgot_password, LAYOUT_ACTIVITYFORGOTPASSWORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_intro, LAYOUT_ACTIVITYINTRO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_list_khusus_untukmu, LAYOUT_ACTIVITYLISTKHUSUSUNTUKMU);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_manage, LAYOUT_ACTIVITYMANAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_manage_profile, LAYOUT_ACTIVITYMANAGEPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_manage_profile_address, LAYOUT_ACTIVITYMANAGEPROFILEADDRESS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_manage_profile_chat_email, LAYOUT_ACTIVITYMANAGEPROFILECHATEMAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_manage_profile_mitra, LAYOUT_ACTIVITYMANAGEPROFILEMITRA);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_manage_profile_operasional, LAYOUT_ACTIVITYMANAGEPROFILEOPERASIONAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_manage_profile_rekening, LAYOUT_ACTIVITYMANAGEPROFILEREKENING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_manage_promosi_toko, LAYOUT_ACTIVITYMANAGEPROMOSITOKO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_manage_tarik_rekening, LAYOUT_ACTIVITYMANAGETARIKREKENING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_notification, LAYOUT_ACTIVITYNOTIFICATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_order_details, LAYOUT_ACTIVITYORDERDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_otp, LAYOUT_ACTIVITYOTP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_payment, LAYOUT_ACTIVITYPAYMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_pickup, LAYOUT_ACTIVITYPICKUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_preview_order, LAYOUT_ACTIVITYPREVIEWORDER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_pusat_edukasi, LAYOUT_ACTIVITYPUSATEDUKASI);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_register, LAYOUT_ACTIVITYREGISTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_register_choose, LAYOUT_ACTIVITYREGISTERCHOOSE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_register_mitra, LAYOUT_ACTIVITYREGISTERMITRA);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_schedule, LAYOUT_ACTIVITYSCHEDULE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_search, LAYOUT_ACTIVITYSEARCH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_service_acitivity, LAYOUT_ACTIVITYSERVICEACITIVITY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_service_menu, LAYOUT_ACTIVITYSERVICEMENU);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_service_penjualan, LAYOUT_ACTIVITYSERVICEPENJUALAN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_shop_acitivity, LAYOUT_ACTIVITYSHOPACITIVITY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_success_penjualan, LAYOUT_ACTIVITYSUCCESSPENJUALAN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_sukses_register, LAYOUT_ACTIVITYSUKSESREGISTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_tickets, LAYOUT_ACTIVITYTICKETS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_top_services, LAYOUT_ACTIVITYTOPSERVICES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_ulasan, LAYOUT_ACTIVITYULASAN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_upload_ktp, LAYOUT_ACTIVITYUPLOADKTP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.activity_welcome_screens, LAYOUT_ACTIVITYWELCOMESCREENS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.adapter_address, LAYOUT_ADAPTERADDRESS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.adapter_allservices, LAYOUT_ADAPTERALLSERVICES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.adapter_bank, LAYOUT_ADAPTERBANK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.adapter_booking, LAYOUT_ADAPTERBOOKING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.adapter_chat, LAYOUT_ADAPTERCHAT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.adapter_detail_penjualan, LAYOUT_ADAPTERDETAILPENJUALAN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.adapter_item, LAYOUT_ADAPTERITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.adapter_khusus, LAYOUT_ADAPTERKHUSUS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.adapter_khusus_list, LAYOUT_ADAPTERKHUSUSLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.adapter_layanan_item, LAYOUT_ADAPTERLAYANANITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.adapter_near, LAYOUT_ADAPTERNEAR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.adapter_notification, LAYOUT_ADAPTERNOTIFICATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.adapter_offers, LAYOUT_ADAPTEROFFERS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.adapter_pelayanan, LAYOUT_ADAPTERPELAYANAN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.adapter_penjualan, LAYOUT_ADAPTERPENJUALAN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.adapter_penjualan_layanan_item, LAYOUT_ADAPTERPENJUALANLAYANANITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.adapter_penting, LAYOUT_ADAPTERPENTING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.adapter_popular_laundries, LAYOUT_ADAPTERPOPULARLAUNDRIES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.adapter_preview, LAYOUT_ADAPTERPREVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.adapter_service_menu, LAYOUT_ADAPTERSERVICEMENU);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.adapter_services, LAYOUT_ADAPTERSERVICES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.adapter_ticket, LAYOUT_ADAPTERTICKET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.adapter_topservices, LAYOUT_ADAPTERTOPSERVICES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.adapter_ulasan_list, LAYOUT_ADAPTERULASANLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.add_address_bottomsheet, LAYOUT_ADDADDRESSBOTTOMSHEET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.dailog_add_ticket, LAYOUT_DAILOGADDTICKET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.dailog_cancel_order, LAYOUT_DAILOGCANCELORDER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.dailog_rating, LAYOUT_DAILOGRATING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.dialog_buat_tiket, LAYOUT_DIALOGBUATTIKET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.fragment_about, LAYOUT_FRAGMENTABOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.fragment_booking, LAYOUT_FRAGMENTBOOKING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.fragment_dynamic, LAYOUT_FRAGMENTDYNAMIC);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.fragment_layanan, LAYOUT_FRAGMENTLAYANAN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.fragment_near_by, LAYOUT_FRAGMENTNEARBY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.fragment_offer_shop, LAYOUT_FRAGMENTOFFERSHOP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.fragment_offers, LAYOUT_FRAGMENTOFFERS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.fragment_outlet, LAYOUT_FRAGMENTOUTLET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.fragment_penjualan, LAYOUT_FRAGMENTPENJUALAN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.fragment_profile, LAYOUT_FRAGMENTPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.fragment_services, LAYOUT_FRAGMENTSERVICES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.home_fragment, LAYOUT_HOMEFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.services_adapter, LAYOUT_SERVICESADAPTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samyotech.laundrymitra.R.layout.special_offers, LAYOUT_SPECIALOFFERS);
  }

  private final ViewDataBinding internalGetViewDataBinding0(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_ACTIVITYABOUT: {
        if ("layout/activity_about_0".equals(tag)) {
          return new ActivityAboutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_about is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYADDDETAILLAYANANITEM: {
        if ("layout/activity_add_detail_layanan_item_0".equals(tag)) {
          return new ActivityAddDetailLayananItemBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_add_detail_layanan_item is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYALLSERVICES: {
        if ("layout/activity_all_services_0".equals(tag)) {
          return new ActivityAllServicesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_all_services is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYBOOKINGCONFIRM: {
        if ("layout/activity_booking_confirm_0".equals(tag)) {
          return new ActivityBookingConfirmBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_booking_confirm is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYBOOKINGPAYMENT: {
        if ("layout/activity_booking_payment_0".equals(tag)) {
          return new ActivityBookingPaymentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_booking_payment is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYBOOKINGPICKADDRESS: {
        if ("layout/activity_booking_pick_address_0".equals(tag)) {
          return new ActivityBookingPickAddressBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_booking_pick_address is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYBOOKINGPICKDATETIME: {
        if ("layout/activity_booking_pick_date_time_0".equals(tag)) {
          return new ActivityBookingPickDateTimeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_booking_pick_date_time is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCHANGPASSWORD: {
        if ("layout/activity_chang_password_0".equals(tag)) {
          return new ActivityChangPasswordBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_chang_password is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCHATLIST: {
        if ("layout/activity_chat_list_0".equals(tag)) {
          return new ActivityChatListBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_chat_list is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYDASHBOARD: {
        if ("layout/activity_dashboard_0".equals(tag)) {
          return new ActivityDashboardBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_dashboard is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYDATETIME: {
        if ("layout/activity_date_time_0".equals(tag)) {
          return new ActivityDateTimeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_date_time is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYDETAILKHUSUSUNTUKMU: {
        if ("layout/activity_detail_khusus_untukmu_0".equals(tag)) {
          return new ActivityDetailKhususUntukmuBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_detail_khusus_untukmu is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYDETAILLAYANANITEM: {
        if ("layout/activity_detail_layanan_item_0".equals(tag)) {
          return new ActivityDetailLayananItemBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_detail_layanan_item is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYDETAILPENJUALAN: {
        if ("layout/activity_detail_penjualan_0".equals(tag)) {
          return new ActivityDetailPenjualanBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_detail_penjualan is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYEDITSERVICE: {
        if ("layout/activity_edit_service_0".equals(tag)) {
          return new ActivityEditServiceBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_edit_service is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYFORGOTPASSWORD: {
        if ("layout/activity_forgot_password_0".equals(tag)) {
          return new ActivityForgotPasswordBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_forgot_password is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYINTRO: {
        if ("layout/activity_intro_0".equals(tag)) {
          return new ActivityIntroBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_intro is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYLISTKHUSUSUNTUKMU: {
        if ("layout/activity_list_khusus_untukmu_0".equals(tag)) {
          return new ActivityListKhususUntukmuBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_list_khusus_untukmu is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYLOGIN: {
        if ("layout/activity_login_0".equals(tag)) {
          return new ActivityLoginBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_login is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMANAGE: {
        if ("layout/activity_manage_0".equals(tag)) {
          return new ActivityManageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_manage is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMANAGEPROFILE: {
        if ("layout/activity_manage_profile_0".equals(tag)) {
          return new ActivityManageProfileBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_manage_profile is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMANAGEPROFILEADDRESS: {
        if ("layout/activity_manage_profile_address_0".equals(tag)) {
          return new ActivityManageProfileAddressBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_manage_profile_address is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMANAGEPROFILECHATEMAIL: {
        if ("layout/activity_manage_profile_chat_email_0".equals(tag)) {
          return new ActivityManageProfileChatEmailBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_manage_profile_chat_email is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMANAGEPROFILEMITRA: {
        if ("layout/activity_manage_profile_mitra_0".equals(tag)) {
          return new ActivityManageProfileMitraBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_manage_profile_mitra is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMANAGEPROFILEOPERASIONAL: {
        if ("layout/activity_manage_profile_operasional_0".equals(tag)) {
          return new ActivityManageProfileOperasionalBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_manage_profile_operasional is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMANAGEPROFILEREKENING: {
        if ("layout/activity_manage_profile_rekening_0".equals(tag)) {
          return new ActivityManageProfileRekeningBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_manage_profile_rekening is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMANAGEPROMOSITOKO: {
        if ("layout/activity_manage_promosi_toko_0".equals(tag)) {
          return new ActivityManagePromosiTokoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_manage_promosi_toko is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMANAGETARIKREKENING: {
        if ("layout/activity_manage_tarik_rekening_0".equals(tag)) {
          return new ActivityManageTarikRekeningBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_manage_tarik_rekening is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYNOTIFICATION: {
        if ("layout/activity_notification_0".equals(tag)) {
          return new ActivityNotificationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_notification is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYORDERDETAILS: {
        if ("layout/activity_order_details_0".equals(tag)) {
          return new ActivityOrderDetailsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_order_details is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYOTP: {
        if ("layout/activity_otp_0".equals(tag)) {
          return new ActivityOtpBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_otp is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPAYMENT: {
        if ("layout/activity_payment_0".equals(tag)) {
          return new ActivityPaymentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_payment is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPICKUP: {
        if ("layout/activity_pickup_0".equals(tag)) {
          return new ActivityPickupBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_pickup is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPREVIEWORDER: {
        if ("layout/activity_preview_order_0".equals(tag)) {
          return new ActivityPreviewOrderBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_preview_order is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPUSATEDUKASI: {
        if ("layout/activity_pusat_edukasi_0".equals(tag)) {
          return new ActivityPusatEdukasiBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_pusat_edukasi is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYREGISTER: {
        if ("layout/activity_register_0".equals(tag)) {
          return new ActivityRegisterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_register is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYREGISTERCHOOSE: {
        if ("layout/activity_register_choose_0".equals(tag)) {
          return new ActivityRegisterChooseBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_register_choose is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYREGISTERMITRA: {
        if ("layout/activity_register_mitra_0".equals(tag)) {
          return new ActivityRegisterMitraBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_register_mitra is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSCHEDULE: {
        if ("layout/activity_schedule_0".equals(tag)) {
          return new ActivityScheduleBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_schedule is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSEARCH: {
        if ("layout/activity_search_0".equals(tag)) {
          return new ActivitySearchBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_search is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSERVICEACITIVITY: {
        if ("layout/activity_service_acitivity_0".equals(tag)) {
          return new ActivityServiceAcitivityBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_service_acitivity is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSERVICEMENU: {
        if ("layout/activity_service_menu_0".equals(tag)) {
          return new ActivityServiceMenuBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_service_menu is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSERVICEPENJUALAN: {
        if ("layout/activity_service_penjualan_0".equals(tag)) {
          return new ActivityServicePenjualanBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_service_penjualan is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSHOPACITIVITY: {
        if ("layout/activity_shop_acitivity_0".equals(tag)) {
          return new ActivityShopAcitivityBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_shop_acitivity is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSUCCESSPENJUALAN: {
        if ("layout/activity_success_penjualan_0".equals(tag)) {
          return new ActivitySuccessPenjualanBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_success_penjualan is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSUKSESREGISTER: {
        if ("layout/activity_sukses_register_0".equals(tag)) {
          return new ActivitySuksesRegisterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_sukses_register is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYTICKETS: {
        if ("layout/activity_tickets_0".equals(tag)) {
          return new ActivityTicketsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_tickets is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYTOPSERVICES: {
        if ("layout/activity_top_services_0".equals(tag)) {
          return new ActivityTopServicesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_top_services is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYULASAN: {
        if ("layout/activity_ulasan_0".equals(tag)) {
          return new ActivityUlasanBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_ulasan is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYUPLOADKTP: {
        if ("layout/activity_upload_ktp_0".equals(tag)) {
          return new ActivityUploadKtpBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_upload_ktp is invalid. Received: " + tag);
      }
    }
    return null;
  }

  private final ViewDataBinding internalGetViewDataBinding1(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_ACTIVITYWELCOMESCREENS: {
        if ("layout/activity_welcome_screens_0".equals(tag)) {
          return new ActivityWelcomeScreensBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_welcome_screens is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERADDRESS: {
        if ("layout/adapter_address_0".equals(tag)) {
          return new AdapterAddressBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_address is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERALLSERVICES: {
        if ("layout/adapter_allservices_0".equals(tag)) {
          return new AdapterAllservicesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_allservices is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERBANK: {
        if ("layout/adapter_bank_0".equals(tag)) {
          return new AdapterBankBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_bank is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERBOOKING: {
        if ("layout/adapter_booking_0".equals(tag)) {
          return new AdapterBookingBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_booking is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERCHAT: {
        if ("layout/adapter_chat_0".equals(tag)) {
          return new AdapterChatBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_chat is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERDETAILPENJUALAN: {
        if ("layout/adapter_detail_penjualan_0".equals(tag)) {
          return new AdapterDetailPenjualanBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_detail_penjualan is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERITEM: {
        if ("layout/adapter_item_0".equals(tag)) {
          return new AdapterItemBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_item is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERKHUSUS: {
        if ("layout/adapter_khusus_0".equals(tag)) {
          return new AdapterKhususBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_khusus is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERKHUSUSLIST: {
        if ("layout/adapter_khusus_list_0".equals(tag)) {
          return new AdapterKhususListBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_khusus_list is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERLAYANANITEM: {
        if ("layout/adapter_layanan_item_0".equals(tag)) {
          return new AdapterLayananItemBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_layanan_item is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERNEAR: {
        if ("layout/adapter_near_0".equals(tag)) {
          return new AdapterNearBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_near is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERNOTIFICATION: {
        if ("layout/adapter_notification_0".equals(tag)) {
          return new AdapterNotificationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_notification is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTEROFFERS: {
        if ("layout/adapter_offers_0".equals(tag)) {
          return new AdapterOffersBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_offers is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERPELAYANAN: {
        if ("layout/adapter_pelayanan_0".equals(tag)) {
          return new AdapterPelayananBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_pelayanan is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERPENJUALAN: {
        if ("layout/adapter_penjualan_0".equals(tag)) {
          return new AdapterPenjualanBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_penjualan is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERPENJUALANLAYANANITEM: {
        if ("layout/adapter_penjualan_layanan_item_0".equals(tag)) {
          return new AdapterPenjualanLayananItemBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_penjualan_layanan_item is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERPENTING: {
        if ("layout/adapter_penting_0".equals(tag)) {
          return new AdapterPentingBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_penting is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERPOPULARLAUNDRIES: {
        if ("layout/adapter_popular_laundries_0".equals(tag)) {
          return new AdapterPopularLaundriesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_popular_laundries is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERPREVIEW: {
        if ("layout/adapter_preview_0".equals(tag)) {
          return new AdapterPreviewBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_preview is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERSERVICEMENU: {
        if ("layout/adapter_service_menu_0".equals(tag)) {
          return new AdapterServiceMenuBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_service_menu is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERSERVICES: {
        if ("layout/adapter_services_0".equals(tag)) {
          return new AdapterServicesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_services is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERTICKET: {
        if ("layout/adapter_ticket_0".equals(tag)) {
          return new AdapterTicketBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_ticket is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERTOPSERVICES: {
        if ("layout/adapter_topservices_0".equals(tag)) {
          return new AdapterTopservicesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_topservices is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERULASANLIST: {
        if ("layout/adapter_ulasan_list_0".equals(tag)) {
          return new AdapterUlasanListBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_ulasan_list is invalid. Received: " + tag);
      }
      case  LAYOUT_ADDADDRESSBOTTOMSHEET: {
        if ("layout/add_address_bottomsheet_0".equals(tag)) {
          return new AddAddressBottomsheetBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for add_address_bottomsheet is invalid. Received: " + tag);
      }
      case  LAYOUT_DAILOGADDTICKET: {
        if ("layout/dailog_add_ticket_0".equals(tag)) {
          return new DailogAddTicketBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dailog_add_ticket is invalid. Received: " + tag);
      }
      case  LAYOUT_DAILOGCANCELORDER: {
        if ("layout/dailog_cancel_order_0".equals(tag)) {
          return new DailogCancelOrderBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dailog_cancel_order is invalid. Received: " + tag);
      }
      case  LAYOUT_DAILOGRATING: {
        if ("layout/dailog_rating_0".equals(tag)) {
          return new DailogRatingBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dailog_rating is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGBUATTIKET: {
        if ("layout/dialog_buat_tiket_0".equals(tag)) {
          return new DialogBuatTiketBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_buat_tiket is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTABOUT: {
        if ("layout/fragment_about_0".equals(tag)) {
          return new FragmentAboutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_about is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTBOOKING: {
        if ("layout/fragment_booking_0".equals(tag)) {
          return new FragmentBookingBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_booking is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTDYNAMIC: {
        if ("layout/fragment_dynamic_0".equals(tag)) {
          return new FragmentDynamicBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_dynamic is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTLAYANAN: {
        if ("layout/fragment_layanan_0".equals(tag)) {
          return new FragmentLayananBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_layanan is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTNEARBY: {
        if ("layout/fragment_near_by_0".equals(tag)) {
          return new FragmentNearByBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_near_by is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTOFFERSHOP: {
        if ("layout/fragment_offer_shop_0".equals(tag)) {
          return new FragmentOfferShopBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_offer_shop is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTOFFERS: {
        if ("layout/fragment_offers_0".equals(tag)) {
          return new FragmentOffersBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_offers is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTOUTLET: {
        if ("layout/fragment_outlet_0".equals(tag)) {
          return new FragmentOutletBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_outlet is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTPENJUALAN: {
        if ("layout/fragment_penjualan_0".equals(tag)) {
          return new FragmentPenjualanBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_penjualan is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTPROFILE: {
        if ("layout/fragment_profile_0".equals(tag)) {
          return new FragmentProfileBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_profile is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSERVICES: {
        if ("layout/fragment_services_0".equals(tag)) {
          return new FragmentServicesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_services is invalid. Received: " + tag);
      }
      case  LAYOUT_HOMEFRAGMENT: {
        if ("layout/home_fragment_0".equals(tag)) {
          return new HomeFragmentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for home_fragment is invalid. Received: " + tag);
      }
      case  LAYOUT_SERVICESADAPTER: {
        if ("layout/services_adapter_0".equals(tag)) {
          return new ServicesAdapterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for services_adapter is invalid. Received: " + tag);
      }
      case  LAYOUT_SPECIALOFFERS: {
        if ("layout/special_offers_0".equals(tag)) {
          return new SpecialOffersBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for special_offers is invalid. Received: " + tag);
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      // find which method will have it. -1 is necessary becausefirst id starts with 1;
      int methodIndex = (localizedLayoutId - 1) / 50;
      switch(methodIndex) {
        case 0: {
          return internalGetViewDataBinding0(component, view, localizedLayoutId, tag);
        }
        case 1: {
          return internalGetViewDataBinding1(component, view, localizedLayoutId, tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(94);

    static {
      sKeys.put("layout/activity_about_0", com.samyotech.laundrymitra.R.layout.activity_about);
      sKeys.put("layout/activity_add_detail_layanan_item_0", com.samyotech.laundrymitra.R.layout.activity_add_detail_layanan_item);
      sKeys.put("layout/activity_all_services_0", com.samyotech.laundrymitra.R.layout.activity_all_services);
      sKeys.put("layout/activity_booking_confirm_0", com.samyotech.laundrymitra.R.layout.activity_booking_confirm);
      sKeys.put("layout/activity_booking_payment_0", com.samyotech.laundrymitra.R.layout.activity_booking_payment);
      sKeys.put("layout/activity_booking_pick_address_0", com.samyotech.laundrymitra.R.layout.activity_booking_pick_address);
      sKeys.put("layout/activity_booking_pick_date_time_0", com.samyotech.laundrymitra.R.layout.activity_booking_pick_date_time);
      sKeys.put("layout/activity_chang_password_0", com.samyotech.laundrymitra.R.layout.activity_chang_password);
      sKeys.put("layout/activity_chat_list_0", com.samyotech.laundrymitra.R.layout.activity_chat_list);
      sKeys.put("layout/activity_dashboard_0", com.samyotech.laundrymitra.R.layout.activity_dashboard);
      sKeys.put("layout/activity_date_time_0", com.samyotech.laundrymitra.R.layout.activity_date_time);
      sKeys.put("layout/activity_detail_khusus_untukmu_0", com.samyotech.laundrymitra.R.layout.activity_detail_khusus_untukmu);
      sKeys.put("layout/activity_detail_layanan_item_0", com.samyotech.laundrymitra.R.layout.activity_detail_layanan_item);
      sKeys.put("layout/activity_detail_penjualan_0", com.samyotech.laundrymitra.R.layout.activity_detail_penjualan);
      sKeys.put("layout/activity_edit_service_0", com.samyotech.laundrymitra.R.layout.activity_edit_service);
      sKeys.put("layout/activity_forgot_password_0", com.samyotech.laundrymitra.R.layout.activity_forgot_password);
      sKeys.put("layout/activity_intro_0", com.samyotech.laundrymitra.R.layout.activity_intro);
      sKeys.put("layout/activity_list_khusus_untukmu_0", com.samyotech.laundrymitra.R.layout.activity_list_khusus_untukmu);
      sKeys.put("layout/activity_login_0", com.samyotech.laundrymitra.R.layout.activity_login);
      sKeys.put("layout/activity_manage_0", com.samyotech.laundrymitra.R.layout.activity_manage);
      sKeys.put("layout/activity_manage_profile_0", com.samyotech.laundrymitra.R.layout.activity_manage_profile);
      sKeys.put("layout/activity_manage_profile_address_0", com.samyotech.laundrymitra.R.layout.activity_manage_profile_address);
      sKeys.put("layout/activity_manage_profile_chat_email_0", com.samyotech.laundrymitra.R.layout.activity_manage_profile_chat_email);
      sKeys.put("layout/activity_manage_profile_mitra_0", com.samyotech.laundrymitra.R.layout.activity_manage_profile_mitra);
      sKeys.put("layout/activity_manage_profile_operasional_0", com.samyotech.laundrymitra.R.layout.activity_manage_profile_operasional);
      sKeys.put("layout/activity_manage_profile_rekening_0", com.samyotech.laundrymitra.R.layout.activity_manage_profile_rekening);
      sKeys.put("layout/activity_manage_promosi_toko_0", com.samyotech.laundrymitra.R.layout.activity_manage_promosi_toko);
      sKeys.put("layout/activity_manage_tarik_rekening_0", com.samyotech.laundrymitra.R.layout.activity_manage_tarik_rekening);
      sKeys.put("layout/activity_notification_0", com.samyotech.laundrymitra.R.layout.activity_notification);
      sKeys.put("layout/activity_order_details_0", com.samyotech.laundrymitra.R.layout.activity_order_details);
      sKeys.put("layout/activity_otp_0", com.samyotech.laundrymitra.R.layout.activity_otp);
      sKeys.put("layout/activity_payment_0", com.samyotech.laundrymitra.R.layout.activity_payment);
      sKeys.put("layout/activity_pickup_0", com.samyotech.laundrymitra.R.layout.activity_pickup);
      sKeys.put("layout/activity_preview_order_0", com.samyotech.laundrymitra.R.layout.activity_preview_order);
      sKeys.put("layout/activity_pusat_edukasi_0", com.samyotech.laundrymitra.R.layout.activity_pusat_edukasi);
      sKeys.put("layout/activity_register_0", com.samyotech.laundrymitra.R.layout.activity_register);
      sKeys.put("layout/activity_register_choose_0", com.samyotech.laundrymitra.R.layout.activity_register_choose);
      sKeys.put("layout/activity_register_mitra_0", com.samyotech.laundrymitra.R.layout.activity_register_mitra);
      sKeys.put("layout/activity_schedule_0", com.samyotech.laundrymitra.R.layout.activity_schedule);
      sKeys.put("layout/activity_search_0", com.samyotech.laundrymitra.R.layout.activity_search);
      sKeys.put("layout/activity_service_acitivity_0", com.samyotech.laundrymitra.R.layout.activity_service_acitivity);
      sKeys.put("layout/activity_service_menu_0", com.samyotech.laundrymitra.R.layout.activity_service_menu);
      sKeys.put("layout/activity_service_penjualan_0", com.samyotech.laundrymitra.R.layout.activity_service_penjualan);
      sKeys.put("layout/activity_shop_acitivity_0", com.samyotech.laundrymitra.R.layout.activity_shop_acitivity);
      sKeys.put("layout/activity_success_penjualan_0", com.samyotech.laundrymitra.R.layout.activity_success_penjualan);
      sKeys.put("layout/activity_sukses_register_0", com.samyotech.laundrymitra.R.layout.activity_sukses_register);
      sKeys.put("layout/activity_tickets_0", com.samyotech.laundrymitra.R.layout.activity_tickets);
      sKeys.put("layout/activity_top_services_0", com.samyotech.laundrymitra.R.layout.activity_top_services);
      sKeys.put("layout/activity_ulasan_0", com.samyotech.laundrymitra.R.layout.activity_ulasan);
      sKeys.put("layout/activity_upload_ktp_0", com.samyotech.laundrymitra.R.layout.activity_upload_ktp);
      sKeys.put("layout/activity_welcome_screens_0", com.samyotech.laundrymitra.R.layout.activity_welcome_screens);
      sKeys.put("layout/adapter_address_0", com.samyotech.laundrymitra.R.layout.adapter_address);
      sKeys.put("layout/adapter_allservices_0", com.samyotech.laundrymitra.R.layout.adapter_allservices);
      sKeys.put("layout/adapter_bank_0", com.samyotech.laundrymitra.R.layout.adapter_bank);
      sKeys.put("layout/adapter_booking_0", com.samyotech.laundrymitra.R.layout.adapter_booking);
      sKeys.put("layout/adapter_chat_0", com.samyotech.laundrymitra.R.layout.adapter_chat);
      sKeys.put("layout/adapter_detail_penjualan_0", com.samyotech.laundrymitra.R.layout.adapter_detail_penjualan);
      sKeys.put("layout/adapter_item_0", com.samyotech.laundrymitra.R.layout.adapter_item);
      sKeys.put("layout/adapter_khusus_0", com.samyotech.laundrymitra.R.layout.adapter_khusus);
      sKeys.put("layout/adapter_khusus_list_0", com.samyotech.laundrymitra.R.layout.adapter_khusus_list);
      sKeys.put("layout/adapter_layanan_item_0", com.samyotech.laundrymitra.R.layout.adapter_layanan_item);
      sKeys.put("layout/adapter_near_0", com.samyotech.laundrymitra.R.layout.adapter_near);
      sKeys.put("layout/adapter_notification_0", com.samyotech.laundrymitra.R.layout.adapter_notification);
      sKeys.put("layout/adapter_offers_0", com.samyotech.laundrymitra.R.layout.adapter_offers);
      sKeys.put("layout/adapter_pelayanan_0", com.samyotech.laundrymitra.R.layout.adapter_pelayanan);
      sKeys.put("layout/adapter_penjualan_0", com.samyotech.laundrymitra.R.layout.adapter_penjualan);
      sKeys.put("layout/adapter_penjualan_layanan_item_0", com.samyotech.laundrymitra.R.layout.adapter_penjualan_layanan_item);
      sKeys.put("layout/adapter_penting_0", com.samyotech.laundrymitra.R.layout.adapter_penting);
      sKeys.put("layout/adapter_popular_laundries_0", com.samyotech.laundrymitra.R.layout.adapter_popular_laundries);
      sKeys.put("layout/adapter_preview_0", com.samyotech.laundrymitra.R.layout.adapter_preview);
      sKeys.put("layout/adapter_service_menu_0", com.samyotech.laundrymitra.R.layout.adapter_service_menu);
      sKeys.put("layout/adapter_services_0", com.samyotech.laundrymitra.R.layout.adapter_services);
      sKeys.put("layout/adapter_ticket_0", com.samyotech.laundrymitra.R.layout.adapter_ticket);
      sKeys.put("layout/adapter_topservices_0", com.samyotech.laundrymitra.R.layout.adapter_topservices);
      sKeys.put("layout/adapter_ulasan_list_0", com.samyotech.laundrymitra.R.layout.adapter_ulasan_list);
      sKeys.put("layout/add_address_bottomsheet_0", com.samyotech.laundrymitra.R.layout.add_address_bottomsheet);
      sKeys.put("layout/dailog_add_ticket_0", com.samyotech.laundrymitra.R.layout.dailog_add_ticket);
      sKeys.put("layout/dailog_cancel_order_0", com.samyotech.laundrymitra.R.layout.dailog_cancel_order);
      sKeys.put("layout/dailog_rating_0", com.samyotech.laundrymitra.R.layout.dailog_rating);
      sKeys.put("layout/dialog_buat_tiket_0", com.samyotech.laundrymitra.R.layout.dialog_buat_tiket);
      sKeys.put("layout/fragment_about_0", com.samyotech.laundrymitra.R.layout.fragment_about);
      sKeys.put("layout/fragment_booking_0", com.samyotech.laundrymitra.R.layout.fragment_booking);
      sKeys.put("layout/fragment_dynamic_0", com.samyotech.laundrymitra.R.layout.fragment_dynamic);
      sKeys.put("layout/fragment_layanan_0", com.samyotech.laundrymitra.R.layout.fragment_layanan);
      sKeys.put("layout/fragment_near_by_0", com.samyotech.laundrymitra.R.layout.fragment_near_by);
      sKeys.put("layout/fragment_offer_shop_0", com.samyotech.laundrymitra.R.layout.fragment_offer_shop);
      sKeys.put("layout/fragment_offers_0", com.samyotech.laundrymitra.R.layout.fragment_offers);
      sKeys.put("layout/fragment_outlet_0", com.samyotech.laundrymitra.R.layout.fragment_outlet);
      sKeys.put("layout/fragment_penjualan_0", com.samyotech.laundrymitra.R.layout.fragment_penjualan);
      sKeys.put("layout/fragment_profile_0", com.samyotech.laundrymitra.R.layout.fragment_profile);
      sKeys.put("layout/fragment_services_0", com.samyotech.laundrymitra.R.layout.fragment_services);
      sKeys.put("layout/home_fragment_0", com.samyotech.laundrymitra.R.layout.home_fragment);
      sKeys.put("layout/services_adapter_0", com.samyotech.laundrymitra.R.layout.services_adapter);
      sKeys.put("layout/special_offers_0", com.samyotech.laundrymitra.R.layout.special_offers);
    }
  }
}
