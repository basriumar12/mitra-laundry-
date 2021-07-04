package com.samyotech.laundrymitra.databinding;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentProfileBindingImpl extends FragmentProfileBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.header_title, 1);
        sViewsWithIds.put(R.id.ivBanner, 2);
        sViewsWithIds.put(R.id.updateBackground, 3);
        sViewsWithIds.put(R.id.body, 4);
        sViewsWithIds.put(R.id.tvName, 5);
        sViewsWithIds.put(R.id.tv_pendapatan, 6);
        sViewsWithIds.put(R.id.tv_pendapatan_potongan, 7);
        sViewsWithIds.put(R.id.btn_tarik_pendapatan, 8);
        sViewsWithIds.put(R.id.ctvpromosi, 9);
        sViewsWithIds.put(R.id.ctvulasan, 10);
        sViewsWithIds.put(R.id.ctvChat, 11);
        sViewsWithIds.put(R.id.ctvpusatEdukasi, 12);
        sViewsWithIds.put(R.id.ctPengaturan, 13);
        sViewsWithIds.put(R.id.ctvChangePassword, 14);
        sViewsWithIds.put(R.id.ctvnotification, 15);
        sViewsWithIds.put(R.id.ctvSupport, 16);
        sViewsWithIds.put(R.id.ctvAbout, 17);
        sViewsWithIds.put(R.id.ctvLogout, 18);
        sViewsWithIds.put(R.id.relayimage, 19);
        sViewsWithIds.put(R.id.ivAvtaimg, 20);
        sViewsWithIds.put(R.id.updatePhoto, 21);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentProfileBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 22, sIncludes, sViewsWithIds));
    }
    private FragmentProfileBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.Button) bindings[8]
            , (android.widget.LinearLayout) bindings[13]
            , (android.widget.LinearLayout) bindings[17]
            , (android.widget.LinearLayout) bindings[14]
            , (android.widget.LinearLayout) bindings[11]
            , (android.widget.LinearLayout) bindings[18]
            , (android.widget.LinearLayout) bindings[16]
            , (android.widget.LinearLayout) bindings[15]
            , (android.widget.LinearLayout) bindings[9]
            , (android.widget.LinearLayout) bindings[12]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.RelativeLayout) bindings[1]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[20]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.FrameLayout) bindings[19]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[7]
            , (android.widget.ImageView) bindings[3]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[21]
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