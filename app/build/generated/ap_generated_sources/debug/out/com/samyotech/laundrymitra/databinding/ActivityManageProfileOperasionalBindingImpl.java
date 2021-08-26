package com.samyotech.laundrymitra.databinding;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityManageProfileOperasionalBindingImpl extends ActivityManageProfileOperasionalBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.back, 1);
        sViewsWithIds.put(R.id.senin, 2);
        sViewsWithIds.put(R.id.tv_buka_senin, 3);
        sViewsWithIds.put(R.id.tv_tutup_senin, 4);
        sViewsWithIds.put(R.id.selasa, 5);
        sViewsWithIds.put(R.id.tv_buka_selasa, 6);
        sViewsWithIds.put(R.id.tv_tutup_selasa, 7);
        sViewsWithIds.put(R.id.rabu, 8);
        sViewsWithIds.put(R.id.tv_buka_rabu, 9);
        sViewsWithIds.put(R.id.tv_tutup_rabu, 10);
        sViewsWithIds.put(R.id.kamis, 11);
        sViewsWithIds.put(R.id.tv_buka_kamis, 12);
        sViewsWithIds.put(R.id.tv_tutup_kamis, 13);
        sViewsWithIds.put(R.id.jumat, 14);
        sViewsWithIds.put(R.id.tv_buka_jumat, 15);
        sViewsWithIds.put(R.id.tv_tutup_jumat, 16);
        sViewsWithIds.put(R.id.sabtu, 17);
        sViewsWithIds.put(R.id.tv_buka_sabtu, 18);
        sViewsWithIds.put(R.id.tv_tutup_sabtu, 19);
        sViewsWithIds.put(R.id.minggu, 20);
        sViewsWithIds.put(R.id.tv_buka_minggu, 21);
        sViewsWithIds.put(R.id.tv_tutup_minggu, 22);
        sViewsWithIds.put(R.id.simpan, 23);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityManageProfileOperasionalBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 24, sIncludes, sViewsWithIds));
    }
    private ActivityManageProfileOperasionalBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[1]
            , (android.widget.Switch) bindings[14]
            , (android.widget.Switch) bindings[11]
            , (android.widget.Switch) bindings[20]
            , (android.widget.Switch) bindings[8]
            , (android.widget.Switch) bindings[17]
            , (android.widget.Switch) bindings[5]
            , (android.widget.Switch) bindings[2]
            , (mehdi.sakout.fancybuttons.FancyButton) bindings[23]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[21]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[4]
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