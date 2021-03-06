// Generated by data binding compiler. Do not edit!
package com.samyotech.laundrymitra.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.samyotech.laundrymitra.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityIntroBinding extends ViewDataBinding {
  @NonNull
  public final RelativeLayout clPagerIndicator;

  @NonNull
  public final LinearLayout clPagerdotCounts;

  @NonNull
  public final ViewPager vpIntro;

  protected ActivityIntroBinding(Object _bindingComponent, View _root, int _localFieldCount,
      RelativeLayout clPagerIndicator, LinearLayout clPagerdotCounts, ViewPager vpIntro) {
    super(_bindingComponent, _root, _localFieldCount);
    this.clPagerIndicator = clPagerIndicator;
    this.clPagerdotCounts = clPagerdotCounts;
    this.vpIntro = vpIntro;
  }

  @NonNull
  public static ActivityIntroBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_intro, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityIntroBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityIntroBinding>inflateInternal(inflater, R.layout.activity_intro, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityIntroBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_intro, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityIntroBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityIntroBinding>inflateInternal(inflater, R.layout.activity_intro, null, false, component);
  }

  public static ActivityIntroBinding bind(@NonNull View view) {
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
  public static ActivityIntroBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityIntroBinding)bind(component, view, R.layout.activity_intro);
  }
}
