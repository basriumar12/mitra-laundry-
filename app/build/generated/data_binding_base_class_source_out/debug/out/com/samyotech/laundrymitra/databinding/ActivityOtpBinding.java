// Generated by data binding compiler. Do not edit!
package com.samyotech.laundrymitra.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.chaos.view.PinView;
import com.samyotech.laundrymitra.R;
import java.lang.Deprecated;
import java.lang.Object;
import mehdi.sakout.fancybuttons.FancyButton;

public abstract class ActivityOtpBinding extends ViewDataBinding {
  @NonNull
  public final FancyButton btnKonfirmasi;

  @NonNull
  public final ImageView imgLogo;

  @NonNull
  public final TextView otp;

  @NonNull
  public final PinView pinview;

  @NonNull
  public final ProgressBar progressCircular;

  @NonNull
  public final TextView tvKirimUlang;

  protected ActivityOtpBinding(Object _bindingComponent, View _root, int _localFieldCount,
      FancyButton btnKonfirmasi, ImageView imgLogo, TextView otp, PinView pinview,
      ProgressBar progressCircular, TextView tvKirimUlang) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnKonfirmasi = btnKonfirmasi;
    this.imgLogo = imgLogo;
    this.otp = otp;
    this.pinview = pinview;
    this.progressCircular = progressCircular;
    this.tvKirimUlang = tvKirimUlang;
  }

  @NonNull
  public static ActivityOtpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_otp, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityOtpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityOtpBinding>inflateInternal(inflater, R.layout.activity_otp, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityOtpBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_otp, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityOtpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityOtpBinding>inflateInternal(inflater, R.layout.activity_otp, null, false, component);
  }

  public static ActivityOtpBinding bind(@NonNull View view) {
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
  public static ActivityOtpBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityOtpBinding)bind(component, view, R.layout.activity_otp);
  }
}
