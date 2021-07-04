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
import androidx.recyclerview.widget.RecyclerView;
import com.samyotech.laundrymitra.R;
import java.lang.Deprecated;
import java.lang.Object;
import mehdi.sakout.fancybuttons.FancyButton;

public abstract class ActivityServicePenjualanBinding extends ViewDataBinding {
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
  public final TextView priceTotal;

  @NonNull
  public final TextView quantityTotal;

  @NonNull
  public final RecyclerView rvLayananItem;

  @NonNull
  public final RecyclerView rvOtherService;

  @NonNull
  public final TextView tvServiceName;

  protected ActivityServicePenjualanBinding(Object _bindingComponent, View _root,
      int _localFieldCount, LinearLayout appbar, ImageView back, FancyButton bookingBtn,
      FrameLayout collapsing, TextView des, ImageView ivBanner, TextView priceTotal,
      TextView quantityTotal, RecyclerView rvLayananItem, RecyclerView rvOtherService,
      TextView tvServiceName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appbar = appbar;
    this.back = back;
    this.bookingBtn = bookingBtn;
    this.collapsing = collapsing;
    this.des = des;
    this.ivBanner = ivBanner;
    this.priceTotal = priceTotal;
    this.quantityTotal = quantityTotal;
    this.rvLayananItem = rvLayananItem;
    this.rvOtherService = rvOtherService;
    this.tvServiceName = tvServiceName;
  }

  @NonNull
  public static ActivityServicePenjualanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_service_penjualan, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityServicePenjualanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityServicePenjualanBinding>inflateInternal(inflater, R.layout.activity_service_penjualan, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityServicePenjualanBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_service_penjualan, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityServicePenjualanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityServicePenjualanBinding>inflateInternal(inflater, R.layout.activity_service_penjualan, null, false, component);
  }

  public static ActivityServicePenjualanBinding bind(@NonNull View view) {
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
  public static ActivityServicePenjualanBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityServicePenjualanBinding)bind(component, view, R.layout.activity_service_penjualan);
  }
}
