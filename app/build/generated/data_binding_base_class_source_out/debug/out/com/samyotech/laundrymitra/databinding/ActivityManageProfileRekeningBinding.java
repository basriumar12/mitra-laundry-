// Generated by data binding compiler. Do not edit!
package com.samyotech.laundrymitra.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.samyotech.laundrymitra.R;
import java.lang.Deprecated;
import java.lang.Object;
import mehdi.sakout.fancybuttons.FancyButton;

public abstract class ActivityManageProfileRekeningBinding extends ViewDataBinding {
  @NonNull
  public final EditText alamat;

  @NonNull
  public final ImageView back;

  @NonNull
  public final ImageView location;

  @NonNull
  public final EditText namaBank;

  @NonNull
  public final EditText namaRekening;

  @NonNull
  public final EditText nomorRekening;

  @NonNull
  public final FancyButton simpan;

  protected ActivityManageProfileRekeningBinding(Object _bindingComponent, View _root,
      int _localFieldCount, EditText alamat, ImageView back, ImageView location, EditText namaBank,
      EditText namaRekening, EditText nomorRekening, FancyButton simpan) {
    super(_bindingComponent, _root, _localFieldCount);
    this.alamat = alamat;
    this.back = back;
    this.location = location;
    this.namaBank = namaBank;
    this.namaRekening = namaRekening;
    this.nomorRekening = nomorRekening;
    this.simpan = simpan;
  }

  @NonNull
  public static ActivityManageProfileRekeningBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_manage_profile_rekening, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityManageProfileRekeningBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityManageProfileRekeningBinding>inflateInternal(inflater, R.layout.activity_manage_profile_rekening, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityManageProfileRekeningBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_manage_profile_rekening, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityManageProfileRekeningBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityManageProfileRekeningBinding>inflateInternal(inflater, R.layout.activity_manage_profile_rekening, null, false, component);
  }

  public static ActivityManageProfileRekeningBinding bind(@NonNull View view) {
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
  public static ActivityManageProfileRekeningBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityManageProfileRekeningBinding)bind(component, view, R.layout.activity_manage_profile_rekening);
  }
}
