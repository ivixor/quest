package com.android.androiddevteam.quest.fragment;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Project: Quest
 * Author: priadko
 * Date: 02.07.15
 */

public abstract class FragBaseAbstract extends Fragment{

    /**
     * Return fragment tag. Tag will be used in transition in SupportFragmentManager.
     * @see android.support.v4.app.FragmentManager
     * @return fragment tag.
     */
    public abstract String getFragmentTag();

    /**
     * Return fragment title. Title will be set to ActionBar.
     * @see android.app.ActionBar
     * @return fragment title.
     */
    public abstract String getFragmentTitle();

    /**
     * Return id of root layout.
     * @return id of layout as int
     */
    protected abstract int getRootLayoutId();

    /**
     * We can set listeners to views in rootView.
     * @param rootView Root view of fragment.
     */
    protected abstract void setClickListeners(View rootView);

    /**
     * We can customize ActionBar here.
     * @param actionBar ActionBar that can be customized.
     * @see ActionBar
     */
    protected abstract void customizeActionBar(ActionBar actionBar);

    /**
     * We can customize views that rootView contain here.
     * @param rootView Root view of fragment.
     */
    protected abstract void customizeViews(View rootView);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = LayoutInflater.from(getActivity()).inflate(getRootLayoutId(), null, false);
        setClickListeners(rootView);
        if (getActivity().getActionBar() != null){
            customizeActionBar(getActivity().getActionBar());
        }
        customizeViews(rootView);

        return rootView;
    }
}
