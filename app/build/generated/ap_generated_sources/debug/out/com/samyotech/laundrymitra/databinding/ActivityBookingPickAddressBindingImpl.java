package com.samyotech.laundrymitra.databinding;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityBookingPickAddressBindingImpl extends ActivityBookingPickAddressBinding  {

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
        sViewsWithIds.put(R.id.rdbtn, 7);
        sViewsWithIds.put(R.id.constMain, 8);
        sViewsWithIds.put(R.id.titlehome, 9);
        sViewsWithIds.put(R.id.address, 10);
        sViewsWithIds.put(R.id.cvWork, 11);
        sViewsWithIds.put(R.id.rdbtnWork, 12);
        sViewsWithIds.put(R.id.constMainWork, 13);
        sViewsWithIds.put(R.id.titleWork, 14);
        sViewsWithIds.put(R.id.addressWork, 15);
        sViewsWithIds.put(R.id.cvOther, 16);
        sViewsWithIds.put(R.id.rdbtnOther, 17);
        sViewsWithIds.put(R.id.constMainOther, 18);
        sViewsWithIds.put(R.id.titleOther, 19);
        sViewsWithIds.put(R.id.addressOther, 20);
        sViewsWithIds.put(R.id.recyleList, 21);
        sViewsWithIds.put(R.id.cvAddAddress, 22);
        sViewsWithIds.put(R.id.add, 23);
        sViewsWithIds.put(R.id.next_btn, 24);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityBookingPickAddressBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 25, sIncludes, sViewsWithIds));
    }
    private ActivityBookingPickAddressBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatImageView) bindings[23]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[15]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.RelativeLayout) bindings[1]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[8]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[18]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[13]
            , (androidx.cardview.widget.CardView) bindings[22]
            , (androidx.cardview.widget.CardView) bindings[6]
            , (androidx.cardview.widget.CardView) bindings[16]
            , (androidx.cardview.widget.CardView) bindings[11]
            , (android.widget.TextView) bindings[4]
            , (mehdi.sakout.fancybuttons.FancyButton) bindings[24]
            , (android.widget.RadioButton) bindings[7]
            , (android.widget.RadioButton) bindings[17]
            , (android.widget.RadioButton) bindings[12]
            , (androidx.recyclerview.widget.RecyclerView) bindings[21]
            , (android.widget.RelativeLayout) bindings[2]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[9]
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