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
import com.samyotech.laundrymitra.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityManagePromosiTokoBinding extends ViewDataBinding {
  @NonNull
  public final ImageView back;

  protected ActivityManagePromosiTokoBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ImageView back) {
    super(_bindingComponent, _root, _localFieldCount);
    this.back = back;
  }

  @NonNull
  public static ActivityManagePromosiTokoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_manage_promosi_toko, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityManagePromosiTokoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityManagePromosiTokoBinding>inflateInternal(inflater, R.layout.activity_manage_promosi_toko, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityManagePromosiTokoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_manage_promosi_toko, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityManagePromosiTokoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityManagePromosiTokoBinding>inflateInternal(inflater, R.layout.activity_manage_promosi_toko, null, false, component);
  }

  public static ActivityManagePromosiTokoBinding bind(@NonNull View view) {
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
  public static ActivityManagePromosiTokoBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityManagePromosiTokoBinding)bind(component, view, R.layout.activity_manage_promosi_toko);
  }
}
