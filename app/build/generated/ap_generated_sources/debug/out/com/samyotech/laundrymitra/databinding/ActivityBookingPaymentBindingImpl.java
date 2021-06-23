package com.samyotech.laundrymitra.databinding;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityBookingPaymentBindingImpl extends ActivityBookingPaymentBinding  {

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
        sViewsWithIds.put(R.id.cvAmount, 5);
        sViewsWithIds.put(R.id.kode_promo, 6);
        sViewsWithIds.put(R.id.promo_btn, 7);
        sViewsWithIds.put(R.id.subtotal, 8);
        sViewsWithIds.put(R.id.tax, 9);
        sViewsWithIds.put(R.id.discount, 10);
        sViewsWithIds.put(R.id.total, 11);
        sViewsWithIds.put(R.id.cvHome, 12);
        sViewsWithIds.put(R.id.cvImage, 13);
        sViewsWithIds.put(R.id.ivImage, 14);
        sViewsWithIds.put(R.id.ctvbShopName, 15);
        sViewsWithIds.put(R.id.ctvAddress, 16);
        sViewsWithIds.put(R.id.titleenw, 17);
        sViewsWithIds.put(R.id.cvCoD, 18);
        sViewsWithIds.put(R.id.rdbtn, 19);
        sViewsWithIds.put(R.id.constMain, 20);
        sViewsWithIds.put(R.id.titlehome, 21);
        sViewsWithIds.put(R.id.address, 22);
        sViewsWithIds.put(R.id.confirm_btn, 23);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityBookingPaymentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 24, sIncludes, sViewsWithIds));
    }
    private ActivityBookingPaymentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[22]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.LinearLayout) bindings[1]
            , (mehdi.sakout.fancybuttons.FancyButton) bindings[23]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[20]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[15]
            , (androidx.cardview.widget.CardView) bindings[5]
            , (androidx.cardview.widget.CardView) bindings[18]
            , (androidx.cardview.widget.CardView) bindings[12]
            , (androidx.cardview.widget.CardView) bindings[13]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[4]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.EditText) bindings[6]
            , (mehdi.sakout.fancybuttons.FancyButton) bindings[7]
            , (android.widget.RadioButton) bindings[19]
            , (android.widget.RelativeLayout) bindings[2]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[21]
            , (android.widget.TextView) bindings[11]
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