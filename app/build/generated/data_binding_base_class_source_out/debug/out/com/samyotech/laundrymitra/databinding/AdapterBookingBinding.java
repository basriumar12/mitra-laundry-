// Generated by data binding compiler. Do not edit!
package com.samyotech.laundrymitra.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.samyotech.laundrymitra.R;
import java.lang.Deprecated;
import java.lang.Object;
import mehdi.sakout.fancybuttons.FancyButton;

public abstract class AdapterBookingBinding extends ViewDataBinding {
  @NonNull
  public final FancyButton batalkan;

  @NonNull
  public final TextView harga;

  @NonNull
  public final TextView layanan;

  @NonNull
  public final TextView namaToko;

  @NonNull
  public final FancyButton selengkapnya;

  @NonNull
  public final ImageView status;

  protected AdapterBookingBinding(Object _bindingComponent, View _root, int _localFieldCount,
      FancyButton batalkan, TextView harga, TextView layanan, TextView namaToko,
      FancyButton selengkapnya, ImageView status) {
    super(_bindingComponent, _root, _localFieldCount);
    this.batalkan = batalkan;
    this.harga = harga;
    this.layanan = layanan;
    this.namaToko = namaToko;
    this.selengkapnya = selengkapnya;
    this.status = status;
  }

  @NonNull
  public static AdapterBookingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.adapter_booking, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static AdapterBookingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<AdapterBookingBinding>inflateInternal(inflater, R.layout.adapter_booking, root, attachToRoot, component);
  }

  @NonNull
  public static AdapterBookingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.adapter_booking, null, false, component)
   */
  @NonNull
  @Deprecated
  public static AdapterBookingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<AdapterBookingBinding>inflateInternal(inflater, R.layout.adapter_booking, null, false, component);
  }

  public static AdapterBookingBinding bind(@NonNull View view) {
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
  public static AdapterBookingBinding bind(@NonNull View view, @Nullable Object component) {
    return (AdapterBookingBinding)bind(component, view, R.layout.adapter_booking);
  }
}
