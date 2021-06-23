package com.samyotech.laundrymitra.databinding;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityDetailPenjualanBindingImpl extends ActivityDetailPenjualanBinding  {

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
        sViewsWithIds.put(R.id.nama_pesanan, 5);
        sViewsWithIds.put(R.id.no_order, 6);
        sViewsWithIds.put(R.id.nama_pemesan, 7);
        sViewsWithIds.put(R.id.date_time_jemput, 8);
        sViewsWithIds.put(R.id.address_jemput, 9);
        sViewsWithIds.put(R.id.date_time_antar, 10);
        sViewsWithIds.put(R.id.address_antar, 11);
        sViewsWithIds.put(R.id.rvDetailPenjualan, 12);
        sViewsWithIds.put(R.id.subtotal, 13);
        sViewsWithIds.put(R.id.pajak, 14);
        sViewsWithIds.put(R.id.diskon, 15);
        sViewsWithIds.put(R.id.totalPembayaran, 16);
        sViewsWithIds.put(R.id.confirm_btn, 17);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityDetailPenjualanBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }
    private ActivityDetailPenjualanBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[9]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.LinearLayout) bindings[1]
            , (mehdi.sakout.fancybuttons.FancyButton) bindings[17]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[14]
            , (android.widget.RelativeLayout) bindings[2]
            , (androidx.recyclerview.widget.RecyclerView) bindings[12]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[16]
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