// Generated by data binding compiler. Do not edit!
package com.samyotech.laundrymitra.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.samyotech.laundrymitra.R;
import java.lang.Deprecated;
import java.lang.Object;
import mehdi.sakout.fancybuttons.FancyButton;

public abstract class ActivityServiceAcitivityBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout appbar;

  @NonNull
  public final ImageView back;

  @NonNull
  public final FancyButton bookingBtn;

  @NonNull
  public final FrameLayout collapsing;

  @NonNull
  public final TextView des;

  @NonNull
  public final ImageView ivBanner;

  @NonNull
  public final TextView ivShopName;

  @NonNull
  public final ImageView serviceIcon;

  protected ActivityServiceAcitivityBinding(Object _bindingComponent, View _root,
      int _localFieldCount, LinearLayout appbar, ImageView back, FancyButton bookingBtn,
      FrameLayout collapsing, TextView des, ImageView ivBanner, TextView ivShopName,
      ImageView serviceIcon) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appbar = appbar;
    this.back = back;
    this.bookingBtn = bookingBtn;
    this.collapsing = collapsing;
    this.des = des;
    this.ivBanner = ivBanner;
    this.ivShopName = ivShopName;
    this.serviceIcon = serviceIcon;
  }

  @NonNull
  public static ActivityServiceAcitivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_service_acitivity, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityServiceAcitivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityServiceAcitivityBinding>inflateInternal(inflater, R.layout.activity_service_acitivity, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityServiceAcitivityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_service_acitivity, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityServiceAcitivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityServiceAcitivityBinding>inflateInternal(inflater, R.layout.activity_service_acitivity, null, false, component);
  }

  public static ActivityServiceAcitivityBinding bind(@NonNull View view) {
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
  public static ActivityServiceAcitivityBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityServiceAcitivityBinding)bind(component, view, R.layout.activity_service_acitivity);
  }
}
