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

public abstract class ActivityForgotPasswordBinding extends ViewDataBinding {
  @NonNull
  public final RelativeLayout RRsncbarF;

  @NonNull
  public final EditText cetEmailADD;

  @NonNull
  public final TextView registerNow;

  @NonNull
  public final FancyButton resetBtn;

  protected ActivityForgotPasswordBinding(Object _bindingComponent, View _root,
      int _localFieldCount, RelativeLayout RRsncbarF, EditText cetEmailADD, TextView registerNow,
      FancyButton resetBtn) {
    super(_bindingComponent, _root, _localFieldCount);
    this.RRsncbarF = RRsncbarF;
    this.cetEmailADD = cetEmailADD;
    this.registerNow = registerNow;
    this.resetBtn = resetBtn;
  }

  @NonNull
  public static ActivityForgotPasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_forgot_password, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityForgotPasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityForgotPasswordBinding>inflateInternal(inflater, R.layout.activity_forgot_password, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityForgotPasswordBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_forgot_password, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityForgotPasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityForgotPasswordBinding>inflateInternal(inflater, R.layout.activity_forgot_password, null, false, component);
  }

  public static ActivityForgotPasswordBinding bind(@NonNull View view) {
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
  public static ActivityForgotPasswordBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityForgotPasswordBinding)bind(component, view, R.layout.activity_forgot_password);
  }
}
