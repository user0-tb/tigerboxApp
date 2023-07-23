package com.google.android.material.bottomnavigation;

import android.content.Context;
import com.google.android.material.C1241R;
import com.google.android.material.navigation.NavigationBarItemView;

public class BottomNavigationItemView extends NavigationBarItemView {
    public BottomNavigationItemView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public int getItemLayoutResId() {
        return C1241R.C1246layout.design_bottom_navigation_item;
    }

    /* access modifiers changed from: protected */
    public int getItemDefaultMarginResId() {
        return C1241R.dimen.design_bottom_navigation_margin;
    }
}
