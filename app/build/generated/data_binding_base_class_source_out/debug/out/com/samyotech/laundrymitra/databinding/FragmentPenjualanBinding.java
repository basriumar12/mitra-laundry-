// Generated by data binding compiler. Do not edit!
package com.samyotech.laundrymitra.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.samyotech.laundrymitra.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentPenjualanBinding extends ViewDataBinding {
  @NonNull
  public final EditText cetSearch;

  @NonNull
  public final FloatingActionButton fab;

  @NonNull
  public final TextView headerTitle;

  @NonNull
  public final AppCompatImageView ivNotification;

  @NonNull
  public final AppCompatImageView ivSearch;

  @NonNull
  public final ConstraintLayout relayTop;

  @NonNull
  public final RecyclerView rvPenjualan;

  protected FragmentPenjualanBinding(Object _bindingComponent, View _root, int _localFieldCount,
      EditText cetSearch, FloatingActionButton fab, TextView headerTitle,
      AppCompatImageView ivNotification, AppCompatImageView ivSearch, ConstraintLayout relayTop,
      RecyclerView rvPenjualan) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cetSearch = cetSearch;
    this.fab = fab;
    this.headerTitle = headerTitle;
    this.ivNotification = ivNotification;
    this.ivSearch = ivSearch;
    this.relayTop = relayTop;
    this.rvPenjualan = rvPenjualan;
  }

  @NonNull
  public static FragmentPenjualanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_penjualan, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentPenjualanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentPenjualanBinding>inflateInternal(inflater, R.layout.fragment_penjualan, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentPenjualanBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_penjualan, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentPenjualanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentPenjualanBinding>inflateInternal(inflater, R.layout.fragment_penjualan, null, false, component);
  }

  public static FragmentPenjualanBinding bind(@NonNull View view) {
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
  public static FragmentPenjualanBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentPenjualanBinding)bind(component, view, R.layout.fragment_penjualan);
  }
}