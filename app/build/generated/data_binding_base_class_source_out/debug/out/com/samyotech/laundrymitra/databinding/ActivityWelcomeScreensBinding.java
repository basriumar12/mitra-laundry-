// Generated by data binding compiler. Do not edit!
package com.samyotech.laundrymitra.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.samyotech.laundrymitra.R;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityWelcomeScreensBinding extends ViewDataBinding {
  @NonNull
  public final WormDotsIndicator tabDots;

  @NonNull
  public final ViewPager viewpager;

  protected ActivityWelcomeScreensBinding(Object _bindingComponent, View _root,
      int _localFieldCount, WormDotsIndicator tabDots, ViewPager viewpager) {
    super(_bindingComponent, _root, _localFieldCount);
    this.tabDots = tabDots;
    this.viewpager = viewpager;
  }

  @NonNull
  public static ActivityWelcomeScreensBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_welcome_screens, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityWelcomeScreensBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityWelcomeScreensBinding>inflateInternal(inflater, R.layout.activity_welcome_screens, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityWelcomeScreensBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_welcome_screens, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityWelcomeScreensBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityWelcomeScreensBinding>inflateInternal(inflater, R.layout.activity_welcome_screens, null, false, component);
  }

  public static ActivityWelcomeScreensBinding bind(@NonNull View view) {
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
  public static ActivityWelcomeScreensBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityWelcomeScreensBinding)bind(component, view, R.layout.activity_welcome_screens);
  }
}