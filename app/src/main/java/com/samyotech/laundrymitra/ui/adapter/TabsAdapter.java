package com.samyotech.laundrymitra.ui.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.samyotech.laundrymitra.model.CurrencyDTO;
import com.samyotech.laundrymitra.model.ItemDTO;
import com.samyotech.laundrymitra.ui.fragment.DynamicFragment;


public class TabsAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    ItemDTO itemListDTO;
    CurrencyDTO currencyDTO;

    public TabsAdapter(FragmentManager fm, int NoofTabs, ItemDTO itemListDTO, CurrencyDTO currencyDTO) {
        super(fm);
        this.mNumOfTabs = NoofTabs;
        this.itemListDTO = itemListDTO;
        this.currencyDTO = currencyDTO;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        return DynamicFragment.addfrag(position, itemListDTO.getItem_list().get(position), currencyDTO);
    }
}
