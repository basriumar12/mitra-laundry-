// Generated by data binding compiler. Do not edit!
package com.samyotech.laundrymitra.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.samyotech.laundrymitra.R;
import java.lang.Deprecated;
import java.lang.Object;
import mehdi.sakout.fancybuttons.FancyButton;

public abstract class ActivityEditServiceBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout appbar;

  @NonNull
  public final ImageView back;

  @NonNull
  public final FancyButton btnSave;

  @NonNull
  public final FrameLayout collapsing;

  @NonNull
  public final EditText des;

  @NonNull
  public final ImageView ivBanner;

  @NonNull
  public final TextView ivShopName;

  @NonNull
  public final RecyclerView rvServiceItem;

  @NonNull
  public final NestedScrollView scrollNested;

  @NonNull
  public final EditText serviceName;

  protected ActivityEditServiceBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LinearLayout appbar, ImageView back, FancyButton btnSave, FrameLayout collapsing,
      EditText des, ImageView ivBanner, TextView ivShopName, RecyclerView rvServiceItem,
      NestedScrollView scrollNested, EditText serviceName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appbar = appbar;
    this.back = back;
    this.btnSave = btnSave;
    this.collapsing = collapsing;
    this.des = des;
    this.ivBanner = ivBanner;
    this.ivShopName = ivShopName;
    this.rvServiceItem = rvServiceItem;
    this.scrollNested = scrollNested;
    this.serviceName = serviceName;
  }

  @NonNull
  public static ActivityEditServiceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_edit_service, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityEditServiceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityEditServiceBinding>inflateInternal(inflater, R.layout.activity_edit_service, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityEditServiceBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_edit_service, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityEditServiceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityEditServiceBinding>inflateInternal(inflater, R.layout.activity_edit_service, null, false, component);
  }

  public static ActivityEditServiceBinding bind(@NonNull View view) {
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
  public static ActivityEditServiceBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityEditServiceBinding)bind(component, view, R.layout.activity_edit_service);
  }
}
