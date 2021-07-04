// Generated by data binding compiler. Do not edit!
package com.samyotech.laundrymitra.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.samyotech.laundrymitra.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class DailogCancelOrderBinding extends ViewDataBinding {
  @NonNull
  public final Button cbCancel;

  @NonNull
  public final Button cbCancelDailog;

  @NonNull
  public final TextView ctvhead;

  protected DailogCancelOrderBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button cbCancel, Button cbCancelDailog, TextView ctvhead) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cbCancel = cbCancel;
    this.cbCancelDailog = cbCancelDailog;
    this.ctvhead = ctvhead;
  }

  @NonNull
  public static DailogCancelOrderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dailog_cancel_order, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static DailogCancelOrderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<DailogCancelOrderBinding>inflateInternal(inflater, R.layout.dailog_cancel_order, root, attachToRoot, component);
  }

  @NonNull
  public static DailogCancelOrderBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dailog_cancel_order, null, false, component)
   */
  @NonNull
  @Deprecated
  public static DailogCancelOrderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<DailogCancelOrderBinding>inflateInternal(inflater, R.layout.dailog_cancel_order, null, false, component);
  }

  public static DailogCancelOrderBinding bind(@NonNull View view) {
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
  public static DailogCancelOrderBinding bind(@NonNull View view, @Nullable Object component) {
    return (DailogCancelOrderBinding)bind(component, view, R.layout.dailog_cancel_order);
  }
}
