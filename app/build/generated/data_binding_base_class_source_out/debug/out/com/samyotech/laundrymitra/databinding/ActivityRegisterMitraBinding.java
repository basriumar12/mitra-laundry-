// Generated by data binding compiler. Do not edit!
package com.samyotech.laundrymitra.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.samyotech.laundrymitra.R;
import java.lang.Deprecated;
import java.lang.Object;
import mehdi.sakout.fancybuttons.FancyButton;

public abstract class ActivityRegisterMitraBinding extends ViewDataBinding {
  @NonNull
  public final RelativeLayout RRsncbar;

  @NonNull
  public final TextView cariAlamat;

  @NonNull
  public final EditText cetAlamat;

  @NonNull
  public final EditText cetName;

  @NonNull
  public final FancyButton cvRegister;

  protected ActivityRegisterMitraBinding(Object _bindingComponent, View _root, int _localFieldCount,
      RelativeLayout RRsncbar, TextView cariAlamat, EditText cetAlamat, EditText cetName,
      FancyButton cvRegister) {
    super(_bindingComponent, _root, _localFieldCount);
    this.RRsncbar = RRsncbar;
    this.cariAlamat = cariAlamat;
    this.cetAlamat = cetAlamat;
    this.cetName = cetName;
    this.cvRegister = cvRegister;
  }

  @NonNull
  public static ActivityRegisterMitraBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_register_mitra, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityRegisterMitraBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityRegisterMitraBinding>inflateInternal(inflater, R.layout.activity_register_mitra, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityRegisterMitraBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_register_mitra, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityRegisterMitraBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityRegisterMitraBinding>inflateInternal(inflater, R.layout.activity_register_mitra, null, false, component);
  }

  public static ActivityRegisterMitraBinding bind(@NonNull View view) {
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
  public static ActivityRegisterMitraBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityRegisterMitraBinding)bind(component, view, R.layout.activity_register_mitra);
  }
}