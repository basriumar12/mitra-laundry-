package com.samyotech.laundrymitra.databinding;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityDateTimeBindingImpl extends ActivityDateTimeBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.cardRely, 1);
        sViewsWithIds.put(R.id.relayBackground, 2);
        sViewsWithIds.put(R.id.back, 3);
        sViewsWithIds.put(R.id.header_title, 4);
        sViewsWithIds.put(R.id.titleenw, 5);
        sViewsWithIds.put(R.id.cvHome, 6);
        sViewsWithIds.put(R.id.ctvPickupDate, 7);
        sViewsWithIds.put(R.id.ctvPickupTime, 8);
        sViewsWithIds.put(R.id.ctvDeliveryDate, 9);
        sViewsWithIds.put(R.id.ctvDeliveryTime, 10);
        sViewsWithIds.put(R.id.next_btn, 11);
        sViewsWithIds.put(R.id.RRsncbar, 12);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityDateTimeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private ActivityDateTimeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.RelativeLayout) bindings[12]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.RelativeLayout) bindings[1]
            , (android.widget.EditText) bindings[9]
            , (android.widget.EditText) bindings[10]
            , (android.widget.EditText) bindings[7]
            , (android.widget.EditText) bindings[8]
            , (androidx.cardview.widget.CardView) bindings[6]
            , (android.widget.TextView) bindings[4]
            , (mehdi.sakout.fancybuttons.FancyButton) bindings[11]
            , (android.widget.RelativeLayout) bindings[2]
            , (android.widget.TextView) bindings[5]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
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