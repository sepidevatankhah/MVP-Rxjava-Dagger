package com.nwise.javamvptemplate.ui.base;

import java.lang.ref.WeakReference;

public abstract class AbstractPresenter<V> implements Presenter<V> {

   private WeakReference<V> view;

    @Override
    public void onViewAttached(V view) {
        this.view = new WeakReference<>(view);
    }

    @Override
    public void onViewDetached() {
        if (view != null)
            view.clear();
    }

    @Override
    public void onDestroy() {
        if (view != null)
            view.clear();
        view = null;
    }

    @Override
    public boolean isViewAttached() {
        return view != null && view.get() != null;
    }

    protected V getView()
    {
        if(view!= null)
        {
            return view.get();
        }
        else return null;
    }
}
