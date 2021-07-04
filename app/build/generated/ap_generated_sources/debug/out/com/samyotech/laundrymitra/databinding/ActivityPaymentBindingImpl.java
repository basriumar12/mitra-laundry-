package com.samyotech.laundrymitra.databinding;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityPaymentBindingImpl extends ActivityPaymentBinding  {

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
        sViewsWithIds.put(R.id.cvLinkAja, 12);
        sViewsWithIds.put(R.id.rdbtnLinkAja, 13);
        sViewsWithIds.put(R.id.titleLinkAja, 14);
        sViewsWithIds.put(R.id.cvAtm, 15);
        sViewsWithIds.put(R.id.rdbtnAtm, 16);
        sViewsWithIds.put(R.id.titleAtm, 17);
        sViewsWithIds.put(R.id.cvMbanking, 18);
        sViewsWithIds.put(R.id.rdbtMbanking, 19);
        sViewsWithIds.put(R.id.titleMbanking, 20);
        sViewsWithIds.put(R.id.cvCOD, 21);
        sViewsWithIds.put(R.id.rdbtCOD, 22);
        sViewsWithIds.put(R.id.titleCOD, 23);
        sViewsWithIds.put(R.id.titleenw, 24);
        sViewsWithIds.put(R.id.cvCoD, 25);
        sViewsWithIds.put(R.id.rdbtn, 26);
        sViewsWithIds.put(R.id.constMain, 27);
        sViewsWithIds.put(R.id.titlehome, 28);
        sViewsWithIds.put(R.id.address, 29);
        sViewsWithIds.put(R.id.confirm_payment, 30);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityPaymentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 31, sIncludes, sViewsWithIds));
    }
    private ActivityPaymentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[29]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.LinearLayout) bindings[1]
            , (mehdi.sakout.fancybuttons.FancyButton) bindings[30]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[27]
            , (androidx.cardview.widget.CardView) bindings[5]
            , (androidx.cardview.widget.CardView) bindings[15]
            , (androidx.cardview.widget.CardView) bindings[21]
            , (androidx.cardview.widget.CardView) bindings[25]
            , (androidx.cardview.widget.CardView) bindings[12]
            , (androidx.cardview.widget.CardView) bindings[18]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[4]
            , (android.widget.EditText) bindings[6]
            , (mehdi.sakout.fancybuttons.FancyButton) bindings[7]
            , (android.widget.RadioButton) bindings[22]
            , (android.widget.RadioButton) bindings[19]
            , (android.widget.RadioButton) bindings[26]
            , (android.widget.RadioButton) bindings[16]
            , (android.widget.RadioButton) bindings[13]
            , (android.widget.RelativeLayout) bindings[2]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[23]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[24]
            , (android.widget.TextView) bindings[28]
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