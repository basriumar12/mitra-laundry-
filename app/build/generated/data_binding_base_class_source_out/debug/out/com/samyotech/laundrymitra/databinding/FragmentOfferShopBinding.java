// Generated by data binding compiler. Do not edit!
package com.samyotech.laundrymitra.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.samyotech.laundrymitra.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentOfferShopBinding extends ViewDataBinding {
  @NonNull
  public final TextView ctvnodata;

  @NonNull
  public final RecyclerView rvoffer;

  protected FragmentOfferShopBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView ctvnodata, RecyclerView rvoffer) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ctvnodata = ctvnodata;
    this.rvoffer = rvoffer;
  }

  @NonNull
  public static FragmentOfferShopBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_offer_shop, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentOfferShopBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentOfferShopBinding>inflateInternal(inflater, R.layout.fragment_offer_shop, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentOfferShopBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_offer_shop, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentOfferShopBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentOfferShopBinding>inflateInternal(inflater, R.layout.fragment_offer_shop, null, false, component);
  }

  public static FragmentOfferShopBinding bind(@NonNull View view) {
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
  public static FragmentOfferShopBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentOfferShopBinding)bind(component, view, R.layout.fragment_offer_shop);
  }
}
