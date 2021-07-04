// Generated by data binding compiler. Do not edit!
package com.samyotech.laundrymitra.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.samyotech.laundrymitra.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityAllServicesBinding extends ViewDataBinding {
  @NonNull
  public final ImageView back;

  @NonNull
  public final RecyclerView recyclerview;

  protected ActivityAllServicesBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView back, RecyclerView recyclerview) {
    super(_bindingComponent, _root, _localFieldCount);
    this.back = back;
    this.recyclerview = recyclerview;
  }

  @NonNull
  public static ActivityAllServicesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_all_services, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityAllServicesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityAllServicesBinding>inflateInternal(inflater, R.layout.activity_all_services, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityAllServicesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_all_services, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityAllServicesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityAllServicesBinding>inflateInternal(inflater, R.layout.activity_all_services, null, false, component);
  }

  public static ActivityAllServicesBinding bind(@NonNull View view) {
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
  public static ActivityAllServicesBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityAllServicesBinding)bind(component, view, R.layout.activity_all_services);
  }
}
