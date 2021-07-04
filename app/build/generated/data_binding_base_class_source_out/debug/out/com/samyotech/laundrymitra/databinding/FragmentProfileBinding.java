// Generated by data binding compiler. Do not edit!
package com.samyotech.laundrymitra.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.samyotech.laundrymitra.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentProfileBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout body;

  @NonNull
  public final Button btnTarikPendapatan;

  @NonNull
  public final LinearLayout ctPengaturan;

  @NonNull
  public final LinearLayout ctvAbout;

  @NonNull
  public final LinearLayout ctvChangePassword;

  @NonNull
  public final LinearLayout ctvChat;

  @NonNull
  public final LinearLayout ctvLogout;

  @NonNull
  public final LinearLayout ctvSupport;

  @NonNull
  public final LinearLayout ctvnotification;

  @NonNull
  public final LinearLayout ctvpromosi;

  @NonNull
  public final LinearLayout ctvpusatEdukasi;

  @NonNull
  public final LinearLayout ctvulasan;

  @NonNull
  public final RelativeLayout headerTitle;

  @NonNull
  public final CircleImageView ivAvtaimg;

  @NonNull
  public final ImageView ivBanner;

  @NonNull
  public final FrameLayout relayimage;

  @NonNull
  public final TextView tvName;

  @NonNull
  public final TextView tvPendapatan;

  @NonNull
  public final TextView tvPendapatanPotongan;

  @NonNull
  public final ImageView updateBackground;

  @NonNull
  public final AppCompatImageView updatePhoto;

  protected FragmentProfileBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LinearLayout body, Button btnTarikPendapatan, LinearLayout ctPengaturan,
      LinearLayout ctvAbout, LinearLayout ctvChangePassword, LinearLayout ctvChat,
      LinearLayout ctvLogout, LinearLayout ctvSupport, LinearLayout ctvnotification,
      LinearLayout ctvpromosi, LinearLayout ctvpusatEdukasi, LinearLayout ctvulasan,
      RelativeLayout headerTitle, CircleImageView ivAvtaimg, ImageView ivBanner,
      FrameLayout relayimage, TextView tvName, TextView tvPendapatan, TextView tvPendapatanPotongan,
      ImageView updateBackground, AppCompatImageView updatePhoto) {
    super(_bindingComponent, _root, _localFieldCount);
    this.body = body;
    this.btnTarikPendapatan = btnTarikPendapatan;
    this.ctPengaturan = ctPengaturan;
    this.ctvAbout = ctvAbout;
    this.ctvChangePassword = ctvChangePassword;
    this.ctvChat = ctvChat;
    this.ctvLogout = ctvLogout;
    this.ctvSupport = ctvSupport;
    this.ctvnotification = ctvnotification;
    this.ctvpromosi = ctvpromosi;
    this.ctvpusatEdukasi = ctvpusatEdukasi;
    this.ctvulasan = ctvulasan;
    this.headerTitle = headerTitle;
    this.ivAvtaimg = ivAvtaimg;
    this.ivBanner = ivBanner;
    this.relayimage = relayimage;
    this.tvName = tvName;
    this.tvPendapatan = tvPendapatan;
    this.tvPendapatanPotongan = tvPendapatanPotongan;
    this.updateBackground = updateBackground;
    this.updatePhoto = updatePhoto;
  }

  @NonNull
  public static FragmentProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_profile, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentProfileBinding>inflateInternal(inflater, R.layout.fragment_profile, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_profile, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentProfileBinding>inflateInternal(inflater, R.layout.fragment_profile, null, false, component);
  }

  public static FragmentProfileBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentProfileBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentProfileBinding)bind(component, view, R.layout.fragment_profile);
  }
}
