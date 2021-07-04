// Generated by data binding compiler. Do not edit!
package com.samyotech.laundrymitra.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.samyotech.laundrymitra.R;
import java.lang.Deprecated;
import java.lang.Object;
import mehdi.sakout.fancybuttons.FancyButton;

public abstract class ActivityPickupBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatImageView add;

  @NonNull
  public final TextView address;

  @NonNull
  public final TextView addressOther;

  @NonNull
  public final TextView addressWork;

  @NonNull
  public final ImageView back;

  @NonNull
  public final RelativeLayout cardRely;

  @NonNull
  public final ConstraintLayout constMain;

  @NonNull
  public final ConstraintLayout constMainOther;

  @NonNull
  public final ConstraintLayout constMainWork;

  @NonNull
  public final CardView cvAddAddress;

  @NonNull
  public final CardView cvHome;

  @NonNull
  public final CardView cvOther;

  @NonNull
  public final CardView cvWork;

  @NonNull
  public final TextView headerTitle;

  @NonNull
  public final FancyButton nextBtn;

  @NonNull
  public final RadioButton rdbtn;

  @NonNull
  public final RadioButton rdbtnOther;

  @NonNull
  public final RadioButton rdbtnWork;

  @NonNull
  public final RecyclerView recyleList;

  @NonNull
  public final RelativeLayout relayBackground;

  @NonNull
  public final TextView titleOther;

  @NonNull
  public final TextView titleWork;

  @NonNull
  public final TextView titleenw;

  @NonNull
  public final TextView titlehome;

  protected ActivityPickupBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppCompatImageView add, TextView address, TextView addressOther, TextView addressWork,
      ImageView back, RelativeLayout cardRely, ConstraintLayout constMain,
      ConstraintLayout constMainOther, ConstraintLayout constMainWork, CardView cvAddAddress,
      CardView cvHome, CardView cvOther, CardView cvWork, TextView headerTitle, FancyButton nextBtn,
      RadioButton rdbtn, RadioButton rdbtnOther, RadioButton rdbtnWork, RecyclerView recyleList,
      RelativeLayout relayBackground, TextView titleOther, TextView titleWork, TextView titleenw,
      TextView titlehome) {
    super(_bindingComponent, _root, _localFieldCount);
    this.add = add;
    this.address = address;
    this.addressOther = addressOther;
    this.addressWork = addressWork;
    this.back = back;
    this.cardRely = cardRely;
    this.constMain = constMain;
    this.constMainOther = constMainOther;
    this.constMainWork = constMainWork;
    this.cvAddAddress = cvAddAddress;
    this.cvHome = cvHome;
    this.cvOther = cvOther;
    this.cvWork = cvWork;
    this.headerTitle = headerTitle;
    this.nextBtn = nextBtn;
    this.rdbtn = rdbtn;
    this.rdbtnOther = rdbtnOther;
    this.rdbtnWork = rdbtnWork;
    this.recyleList = recyleList;
    this.relayBackground = relayBackground;
    this.titleOther = titleOther;
    this.titleWork = titleWork;
    this.titleenw = titleenw;
    this.titlehome = titlehome;
  }

  @NonNull
  public static ActivityPickupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_pickup, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityPickupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityPickupBinding>inflateInternal(inflater, R.layout.activity_pickup, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityPickupBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_pickup, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityPickupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityPickupBinding>inflateInternal(inflater, R.layout.activity_pickup, null, false, component);
  }

  public static ActivityPickupBinding bind(@NonNull View view) {
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
  public static ActivityPickupBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityPickupBinding)bind(component, view, R.layout.activity_pickup);
  }
}
