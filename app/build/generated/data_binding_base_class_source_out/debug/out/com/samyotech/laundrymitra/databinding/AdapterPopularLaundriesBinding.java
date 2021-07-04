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
import com.bigstark.animatedratingbar.lib.AnimatedRatingBar;
import com.samyotech.laundrymitra.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class AdapterPopularLaundriesBinding extends ViewDataBinding {
  @NonNull
  public final TextView alamat;

  @NonNull
  public final AnimatedRatingBar arb;

  @NonNull
  public final LinearLayout cvCard;

  @NonNull
  public final TextView hariBuka;

  @NonNull
  public final TextView jamBuka;

  @NonNull
  public final TextView laundryName;

  @NonNull
  public final TextView laundryType;

  @NonNull
  public final LinearLayout laundryTypeContainer;

  @NonNull
  public final TextView rating;

  protected AdapterPopularLaundriesBinding(Object _bindingComponent, View _root,
      int _localFieldCount, TextView alamat, AnimatedRatingBar arb, LinearLayout cvCard,
      TextView hariBuka, TextView jamBuka, TextView laundryName, TextView laundryType,
      LinearLayout laundryTypeContainer, TextView rating) {
    super(_bindingComponent, _root, _localFieldCount);
    this.alamat = alamat;
    this.arb = arb;
    this.cvCard = cvCard;
    this.hariBuka = hariBuka;
    this.jamBuka = jamBuka;
    this.laundryName = laundryName;
    this.laundryType = laundryType;
    this.laundryTypeContainer = laundryTypeContainer;
    this.rating = rating;
  }

  @NonNull
  public static AdapterPopularLaundriesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.adapter_popular_laundries, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static AdapterPopularLaundriesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<AdapterPopularLaundriesBinding>inflateInternal(inflater, R.layout.adapter_popular_laundries, root, attachToRoot, component);
  }

  @NonNull
  public static AdapterPopularLaundriesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.adapter_popular_laundries, null, false, component)
   */
  @NonNull
  @Deprecated
  public static AdapterPopularLaundriesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<AdapterPopularLaundriesBinding>inflateInternal(inflater, R.layout.adapter_popular_laundries, null, false, component);
  }

  public static AdapterPopularLaundriesBinding bind(@NonNull View view) {
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
  public static AdapterPopularLaundriesBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (AdapterPopularLaundriesBinding)bind(component, view, R.layout.adapter_popular_laundries);
  }
}