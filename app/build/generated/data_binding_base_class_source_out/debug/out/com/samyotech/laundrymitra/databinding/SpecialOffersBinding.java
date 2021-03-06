// Generated by data binding compiler. Do not edit!
package com.samyotech.laundrymitra.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.samyotech.laundrymitra.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class SpecialOffersBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatImageView acivOfferImage;

  @NonNull
  public final TextView ctvCode;

  @NonNull
  public final TextView ctvOffer;

  @NonNull
  public final TextView offer;

  protected SpecialOffersBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppCompatImageView acivOfferImage, TextView ctvCode, TextView ctvOffer, TextView offer) {
    super(_bindingComponent, _root, _localFieldCount);
    this.acivOfferImage = acivOfferImage;
    this.ctvCode = ctvCode;
    this.ctvOffer = ctvOffer;
    this.offer = offer;
  }

  @NonNull
  public static SpecialOffersBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.special_offers, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static SpecialOffersBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<SpecialOffersBinding>inflateInternal(inflater, R.layout.special_offers, root, attachToRoot, component);
  }

  @NonNull
  public static SpecialOffersBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.special_offers, null, false, component)
   */
  @NonNull
  @Deprecated
  public static SpecialOffersBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<SpecialOffersBinding>inflateInternal(inflater, R.layout.special_offers, null, false, component);
  }

  public static SpecialOffersBinding bind(@NonNull View view) {
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
  public static SpecialOffersBinding bind(@NonNull View view, @Nullable Object component) {
    return (SpecialOffersBinding)bind(component, view, R.layout.special_offers);
  }
}
