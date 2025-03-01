package com.example.qwez.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.ButterKnife;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    //data to bind to this viewholder
    protected T data;


    /**
     * Create a BaseViewHolder with {@code layoutRes} layout
     * @param layoutRes
     * @param parent
     */
    public BaseViewHolder(@LayoutRes int layoutRes, ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext())
                .inflate(layoutRes, parent, false));
        ButterKnife.bind(this, itemView);
    }

    /**
     * Get bound viewholder data
     * @return bound data
     */
    public T getData(){
        return data;
    }

    /**
     * Returns the View associated with this viewholder
     * @return Viewholders View
     */
    public View getItemView(){
        return itemView;
    }

    /**
     * Binds {@code data} to this viewholder
     * @param data to bind
     */
    public abstract void bind(@Nullable T data);

}
