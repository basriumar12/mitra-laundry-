// Generated by data binding compiler. Do not edit!
package com.samyotech.laundrymitra.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.samyotech.laundrymitra.R;
import java.lang.Deprecated;
import java.lang.Object;
import mehdi.sakout.fancybuttons.FancyButton;

public abstract class DailogRatingBinding extends ViewDataBinding {
  @NonNull
  public final TextView ctvline;

  @NonNull
  public final RatingBar rbReview;

  @NonNull
  public final FancyButton simpanBtn;

  protected DailogRatingBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView ctvline, RatingBar rbReview, FancyButton simpanBtn) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ctvline = ctvline;
    this.rbReview = rbReview;
    this.simpanBtn = simpanBtn;
  }

  @NonNull
  public static DailogRatingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dailog_rating, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static DailogRatingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<DailogRatingBinding>inflateInternal(inflater, R.layout.dailog_rating, root, attachToRoot, component);
  }

  @NonNull
  public static DailogRatingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dailog_rating, null, false, component)
   */
  @NonNull
  @Deprecated
  public static DailogRatingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<DailogRatingBinding>inflateInternal(inflater, R.layout.dailog_rating, null, false, component);
  }

  public static DailogRatingBinding bind(@NonNull View view) {
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
  public static DailogRatingBinding bind(@NonNull View view, @Nullable Object component) {
    return (DailogRatingBinding)bind(component, view, R.layout.dailog_rating);
  }
}