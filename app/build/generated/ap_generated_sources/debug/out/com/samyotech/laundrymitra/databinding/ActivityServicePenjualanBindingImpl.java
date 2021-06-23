package com.samyotech.laundrymitra.databinding;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityServicePenjualanBindingImpl extends ActivityServicePenjualanBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.appbar, 1);
        sViewsWithIds.put(R.id.collapsing, 2);
        sViewsWithIds.put(R.id.ivBanner, 3);
        sViewsWithIds.put(R.id.back, 4);
        sViewsWithIds.put(R.id.tvServiceName, 5);
        sViewsWithIds.put(R.id.des, 6);
        sViewsWithIds.put(R.id.ivServiceItem, 7);
        sViewsWithIds.put(R.id.ctvItemName, 8);
        sViewsWithIds.put(R.id.ctvPrice, 9);
        sViewsWithIds.put(R.id.ivMinus, 10);
        sViewsWithIds.put(R.id.ctvDeliverenum, 11);
        sViewsWithIds.put(R.id.ivPLus, 12);
        sViewsWithIds.put(R.id.priceTotal, 13);
        sViewsWithIds.put(R.id.quantityTotal, 14);
        sViewsWithIds.put(R.id.booking_btn, 15);
        sViewsWithIds.put(R.id.rvOtherService, 16);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityServicePenjualanBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds));
    }
    private ActivityServicePenjualanBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.ImageView) bindings[4]
            , (mehdi.sakout.fancybuttons.FancyButton) bindings[15]
            , (android.widget.FrameLayout) bindings[2]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[6]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[14]
            , (androidx.recyclerview.widget.RecyclerView) bindings[16]
            , (android.widget.TextView) bindings[5]
            );
        this.mboundView0 = (androidx.core.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}