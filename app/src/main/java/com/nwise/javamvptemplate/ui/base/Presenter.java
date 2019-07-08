package com.nwise.javamvptemplate.ui.base;

public interface Presenter<V> {

    /**
     * Called when the view attached to the screen.
     *
     * @param view the view that the presenter interacts with
     */
    void onViewAttached(V view);

    /**
     * Called when the view detached from the screen.
     */
    void onViewDetached();

    /**
     * Called when a user leaves the view completely.
     */
    void onDestroy();

    /**
     * @return Returns true if the view is currently attached to the presenter, otherwise returns false.
     */
    boolean isViewAttached();
}
