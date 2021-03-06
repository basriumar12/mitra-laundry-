// Generated by data binding compiler. Do not edit!
package com.samyotech.laundrymitra.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bigstark.animatedratingbar.lib.AnimatedRatingBar;
import com.samyotech.laundrymitra.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class AdapterTopservicesBinding extends ViewDataBinding {
  @NonNull
  public final TextView alamat;

  @NonNull
  public final AnimatedRatingBar arb;

  @NonNull
  public final CardView cardView1;

  @NonNull
  public final AppCompatImageView ivImage;

  @NonNull
  public final TextView laundryType;

  @NonNull
  public final LinearLayout laundryTypeContainer;

  @NonNull
  public final TextView rating;

  @NonNull
  public final TextView title;

  protected AdapterTopservicesBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView alamat, AnimatedRatingBar arb, CardView cardView1, AppCompatImageView ivImage,
      TextView laundryType, LinearLayout laundryTypeContainer, TextView rating, TextView title) {
    super(_bindingComponent, _root, _localFieldCount);
    this.alamat = alamat;
    this.arb = arb;
    this.cardView1 = cardView1;
    this.ivImage = ivImage;
    this.laundryType = laundryType;
    this.laundryTypeContainer = laundryTypeContainer;
    this.rating = rating;
    this.title = title;
  }

  @NonNull
  public static AdapterTopservicesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.adapter_topservices, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static AdapterTopservicesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<AdapterTopservicesBinding>inflateInternal(inflater, R.layout.adapter_topservices, root, attachToRoot, component);
  }

  @NonNull
  public static AdapterTopservicesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.adapter_topservices, null, false, component)
   */
  @NonNull
  @Deprecated
  public static AdapterTopservicesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<AdapterTopservicesBinding>inflateInternal(inflater, R.layout.adapter_topservices, null, false, component);
  }

  public static AdapterTopservicesBinding bind(@NonNull View view) {
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
  public static AdapterTopservicesBinding bind(@NonNull View view, @Nullable Object component) {
    return (AdapterTopservicesBinding)bind(component, view, R.layout.adapter_topservices);
  }
}
