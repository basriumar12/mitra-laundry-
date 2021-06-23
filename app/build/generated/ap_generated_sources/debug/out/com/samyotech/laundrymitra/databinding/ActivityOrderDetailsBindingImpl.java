package com.samyotech.laundrymitra.databinding;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityOrderDetailsBindingImpl extends ActivityOrderDetailsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.header_container, 1);
        sViewsWithIds.put(R.id.back, 2);
        sViewsWithIds.put(R.id.header_title, 3);
        sViewsWithIds.put(R.id.recyclerview_orders, 4);
        sViewsWithIds.put(R.id.subtotal, 5);
        sViewsWithIds.put(R.id.tax, 6);
        sViewsWithIds.put(R.id.discount, 7);
        sViewsWithIds.put(R.id.total, 8);
        sViewsWithIds.put(R.id.buy_now, 9);
        sViewsWithIds.put(R.id.text_status, 10);
        sViewsWithIds.put(R.id.pickup_day, 11);
        sViewsWithIds.put(R.id.pickup_time, 12);
        sViewsWithIds.put(R.id.pickup_address, 13);
        sViewsWithIds.put(R.id.delivery_date, 14);
        sViewsWithIds.put(R.id.delivery_time, 15);
        sViewsWithIds.put(R.id.delivery_address, 16);
        sViewsWithIds.put(R.id.rate_now_btn, 17);
        sViewsWithIds.put(R.id.view5, 18);
        sViewsWithIds.put(R.id.hubungi_title, 19);
        sViewsWithIds.put(R.id.kirim_pesan_btn, 20);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityOrderDetailsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 21, sIncludes, sViewsWithIds));
    }
    private ActivityOrderDetailsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[2]
            , (mehdi.sakout.fancybuttons.FancyButton) bindings[9]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[7]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[19]
            , (mehdi.sakout.fancybuttons.FancyButton) bindings[20]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[12]
            , (mehdi.sakout.fancybuttons.FancyButton) bindings[17]
            , (androidx.recyclerview.widget.RecyclerView) bindings[4]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[8]
            , (android.view.View) bindings[18]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
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