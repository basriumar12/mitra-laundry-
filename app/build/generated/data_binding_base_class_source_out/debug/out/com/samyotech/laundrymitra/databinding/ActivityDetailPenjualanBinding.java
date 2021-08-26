// Generated by data binding compiler. Do not edit!
package com.samyotech.laundrymitra.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.samyotech.laundrymitra.R;
import java.lang.Deprecated;
import java.lang.Object;
import mehdi.sakout.fancybuttons.FancyButton;

public abstract class ActivityDetailPenjualanBinding extends ViewDataBinding {
  @NonNull
  public final TextView addressAntar;

  @NonNull
  public final TextView addressJemput;

  @NonNull
  public final ImageView back;

  @NonNull
  public final LinearLayout cardRely;

  @NonNull
  public final FancyButton confirmBtn;

  @NonNull
  public final FancyButton confirmBtnStatus;

  @NonNull
  public final TextView dateTimeAntar;

  @NonNull
  public final TextView dateTimeJemput;

  @NonNull
  public final TextView diskon;

  @NonNull
  public final TextView headerTitle;

  @NonNull
  public final LinearLayoutCompat layoutParent;

  @NonNull
  public final TextView namaPemesan;

  @NonNull
  public final TextView namaPesanan;

  @NonNull
  public final TextView noOrder;

  @NonNull
  public final TextView pajak;

  @NonNull
  public final RelativeLayout relayBackground;

  @NonNull
  public final RecyclerView rvDetailPenjualan;

  @NonNull
  public final TextView subtotal;

  @NonNull
  public final TextView totalPembayaran;

  @NonNull
  public final TextView tvStatus;

  protected ActivityDetailPenjualanBinding(Object _bindingComponent, View _root,
      int _localFieldCount, TextView addressAntar, TextView addressJemput, ImageView back,
      LinearLayout cardRely, FancyButton confirmBtn, FancyButton confirmBtnStatus,
      TextView dateTimeAntar, TextView dateTimeJemput, TextView diskon, TextView headerTitle,
      LinearLayoutCompat layoutParent, TextView namaPemesan, TextView namaPesanan, TextView noOrder,
      TextView pajak, RelativeLayout relayBackground, RecyclerView rvDetailPenjualan,
      TextView subtotal, TextView totalPembayaran, TextView tvStatus) {
    super(_bindingComponent, _root, _localFieldCount);
    this.addressAntar = addressAntar;
    this.addressJemput = addressJemput;
    this.back = back;
    this.cardRely = cardRely;
    this.confirmBtn = confirmBtn;
    this.confirmBtnStatus = confirmBtnStatus;
    this.dateTimeAntar = dateTimeAntar;
    this.dateTimeJemput = dateTimeJemput;
    this.diskon = diskon;
    this.headerTitle = headerTitle;
    this.layoutParent = layoutParent;
    this.namaPemesan = namaPemesan;
    this.namaPesanan = namaPesanan;
    this.noOrder = noOrder;
    this.pajak = pajak;
    this.relayBackground = relayBackground;
    this.rvDetailPenjualan = rvDetailPenjualan;
    this.subtotal = subtotal;
    this.totalPembayaran = totalPembayaran;
    this.tvStatus = tvStatus;
  }

  @NonNull
  public static ActivityDetailPenjualanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_detail_penjualan, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityDetailPenjualanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityDetailPenjualanBinding>inflateInternal(inflater, R.layout.activity_detail_penjualan, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityDetailPenjualanBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_detail_penjualan, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityDetailPenjualanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityDetailPenjualanBinding>inflateInternal(inflater, R.layout.activity_detail_penjualan, null, false, component);
  }

  public static ActivityDetailPenjualanBinding bind(@NonNull View view) {
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
  public static ActivityDetailPenjualanBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityDetailPenjualanBinding)bind(component, view, R.layout.activity_detail_penjualan);
  }
}
