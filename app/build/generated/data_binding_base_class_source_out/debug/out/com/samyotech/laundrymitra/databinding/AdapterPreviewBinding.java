// Generated by data binding compiler. Do not edit!
package com.samyotech.laundrymitra.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.samyotech.laundrymitra.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class AdapterPreviewBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout clCard;

  @NonNull
  public final TextView ctvName;

  @NonNull
  public final TextView ctvPrice;

  @NonNull
  public final TextView ctvQuantity;

  protected AdapterPreviewBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LinearLayout clCard, TextView ctvName, TextView ctvPrice, TextView ctvQuantity) {
    super(_bindingComponent, _root, _localFieldCount);
    this.clCard = clCard;
    this.ctvName = ctvName;
    this.ctvPrice = ctvPrice;
    this.ctvQuantity = ctvQuantity;
  }

  @NonNull
  public static AdapterPreviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.adapter_preview, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static AdapterPreviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<AdapterPreviewBinding>inflateInternal(inflater, R.layout.adapter_preview, root, attachToRoot, component);
  }

  @NonNull
  public static AdapterPreviewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.adapter_preview, null, false, component)
   */
  @NonNull
  @Deprecated
  public static AdapterPreviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<AdapterPreviewBinding>inflateInternal(inflater, R.layout.adapter_preview, null, false, component);
  }

  public static AdapterPreviewBinding bind(@NonNull View view) {
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
  public static AdapterPreviewBinding bind(@NonNull View view, @Nullable Object component) {
    return (AdapterPreviewBinding)bind(component, view, R.layout.adapter_preview);
  }
}