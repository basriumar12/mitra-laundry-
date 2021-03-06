// Generated by data binding compiler. Do not edit!
package com.samyotech.laundrymitra.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
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

public abstract class ActivityRegisterBinding extends ViewDataBinding {
  @NonNull
  public final RelativeLayout RRsncbar;

  @NonNull
  public final EditText alamat;

  @NonNull
  public final EditText cetEmail;

  @NonNull
  public final EditText cetName;

  @NonNull
  public final EditText cetNumber;

  @NonNull
  public final EditText cetPassword1;

  @NonNull
  public final EditText cetPassword2;

  @NonNull
  public final FancyButton cvRegister;

  @NonNull
  public final ImageView ivNewPass;

  @NonNull
  public final ImageView ivOldPass;

  @NonNull
  public final ImageView location;

  @NonNull
  public final TextView loginNow;

  protected ActivityRegisterBinding(Object _bindingComponent, View _root, int _localFieldCount,
      RelativeLayout RRsncbar, EditText alamat, EditText cetEmail, EditText cetName,
      EditText cetNumber, EditText cetPassword1, EditText cetPassword2, FancyButton cvRegister,
      ImageView ivNewPass, ImageView ivOldPass, ImageView location, TextView loginNow) {
    super(_bindingComponent, _root, _localFieldCount);
    this.RRsncbar = RRsncbar;
    this.alamat = alamat;
    this.cetEmail = cetEmail;
    this.cetName = cetName;
    this.cetNumber = cetNumber;
    this.cetPassword1 = cetPassword1;
    this.cetPassword2 = cetPassword2;
    this.cvRegister = cvRegister;
    this.ivNewPass = ivNewPass;
    this.ivOldPass = ivOldPass;
    this.location = location;
    this.loginNow = loginNow;
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_register, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityRegisterBinding>inflateInternal(inflater, R.layout.activity_register, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_register, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityRegisterBinding>inflateInternal(inflater, R.layout.activity_register, null, false, component);
  }

  public static ActivityRegisterBinding bind(@NonNull View view) {
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
  public static ActivityRegisterBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityRegisterBinding)bind(component, view, R.layout.activity_register);
  }
}
