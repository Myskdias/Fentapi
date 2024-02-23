package com.myskdias.uhc;

import com.myskdias.api.MyskPlugin;

public class UHCMain extends MyskPlugin {

    private static UHCMain instance;

    @Override
    public void onEnable() {
        instance = this;
        super.onEnable();
    }

    public static UHCMain getInstance() {
        return instance;
    }

}
