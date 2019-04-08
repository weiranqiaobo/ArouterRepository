package com.test.base.adapter.absrecyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.util.Linkify;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.*;


public class ViewHolder extends RecyclerView.ViewHolder
{
    private SparseArray<View> mViews;
    private View mConvertView;
    private Context mContext;

    public ViewHolder(Context context, View itemView)
    {
        super(itemView);
        mContext = context;
        mConvertView = itemView;
        mViews = new SparseArray<View>();
    }


    public static ViewHolder createViewHolder(Context context, View itemView)
    {
        ViewHolder holder = new ViewHolder(context, itemView);
        return holder;
    }

    public static ViewHolder createViewHolder(Context context,
                                              ViewGroup parent, int layoutId)
    {
        View itemView = LayoutInflater.from(context).inflate(layoutId, parent,
                false);
        ViewHolder holder = new ViewHolder(context, itemView);
        return holder;
    }

    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId)
    {
        View view = mViews.get(viewId);
        if (view == null)
        {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView()
    {
        return mConvertView;
    }




    /****以下为辅助方法*****/

    /**
     * 设置TextView的值
     *
     * @param viewId
     * @param text
     * @return
     */
    public ViewHolder setText(int viewId, String text)
    {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }
    /**
     * 设置TextView的值
     *
     * @param viewId
     * @param text
     * @return
     */
    public ViewHolder setText(int viewId, Spannable text)
    {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    /**
     * @param viewId
     * @param resId
     * @return
     */
    public ViewHolder setImageResource(int viewId, int resId)
    {
        ImageView view = getView(viewId);
        view.setImageResource(resId);
        return this;
    }
  /**
     * @param viewId
     * @param url
     * @return
     */
    public ViewHolder setImageResource(int viewId, String url)
    {
        ImageView view = getView(viewId);
//        LoaderManager.getLoader().loadNet(view,url);
        return this;
    }

    /**
     * @param viewId
     * @param bitmap
     * @return
     */
    public ViewHolder setImageBitmap(int viewId, Bitmap bitmap)
    {
        ImageView view = getView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }

    /**
     * @param viewId
     * @param drawable
     * @return
     */
    public ViewHolder setImageDrawable(int viewId, Drawable drawable)
    {
        ImageView view = getView(viewId);
        view.setImageDrawable(drawable);
        return this;
    }

    /**
     * @param viewId
     * @param color
     * @return
     */
    public ViewHolder setBackgroundColor(int viewId, int color)
    {
        View view = getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    /**
     * @param viewId
     * @param backgroundRes
     * @return
     */
    public ViewHolder setBackgroundRes(int viewId, int backgroundRes)
    {
        View view = getView(viewId);
        view.setBackgroundResource(backgroundRes);
        return this;
    }

    /**
     * @param viewId
     * @param textColor
     * @return
     */
    public ViewHolder setTextColor(int viewId, int textColor)
    {
        TextView view = getView(viewId);
        view.setTextColor(textColor);
        return this;
    }

    /**
     * @param viewId
     * @param textColorRes
     * @return
     */
    public ViewHolder setTextColorRes(int viewId, int textColorRes)
    {
        TextView view = getView(viewId);
        view.setTextColor(mContext.getResources().getColor(textColorRes));
        return this;
    }

    /**
     * @param viewId
     * @param value
     * @return
     */
    @SuppressLint("NewApi")
    public ViewHolder setAlpha(int viewId, float value)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
        {
            getView(viewId).setAlpha(value);
        } else
        {
            // Pre-honeycomb hack to set Alpha value
            AlphaAnimation alpha = new AlphaAnimation(value, value);
            alpha.setDuration(0);
            alpha.setFillAfter(true);
            getView(viewId).startAnimation(alpha);
        }
        return this;
    }

    /**
     * @param viewId
     * @param visible
     * @return
     */
    public ViewHolder setVisible(int viewId, boolean visible)
    {
        View view = getView(viewId);
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
        return this;
    }

  /**
     * @param viewId
     * @param visible
     * @return
     */
    public ViewHolder setVisibility(int viewId,int visible)
    {
        View view = getView(viewId);
        view.setVisibility(visible);
        return this;
    }

    /**
     * @param viewId
     * @return
     */
    public ViewHolder linkify(int viewId)
    {
        TextView view = getView(viewId);
        Linkify.addLinks(view, Linkify.ALL);
        return this;
    }

    /**
     * @param typeface
     * @param viewIds
     * @return
     */
    public ViewHolder setTypeface(Typeface typeface, int... viewIds)
    {
        for (int viewId : viewIds)
        {
            TextView view = getView(viewId);
            view.setTypeface(typeface);
            view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        }
        return this;
    }

    /**
     * @param viewId
     * @param progress
     * @return
     */
    public ViewHolder setProgress(int viewId, int progress)
    {
        ProgressBar view = getView(viewId);
        view.setProgress(progress);
        return this;
    }

    /**
     * @param viewId
     * @param progress
     * @param max
     * @return
     */
    public ViewHolder setProgress(int viewId, int progress, int max)
    {
        ProgressBar view = getView(viewId);
        view.setMax(max);
        view.setProgress(progress);
        return this;
    }

    /**
     * @param viewId
     * @param max
     * @return
     */
    public ViewHolder setMax(int viewId, int max)
    {
        ProgressBar view = getView(viewId);
        view.setMax(max);
        return this;
    }

    /**
     * @param viewId
     * @param rating
     * @return
     */
    public ViewHolder setRating(int viewId, float rating)
    {
        RatingBar view = getView(viewId);
        view.setRating(rating);
        return this;
    }

    /**
     * @param viewId
     * @param rating
     * @param max
     * @return
     */
    public ViewHolder setRating(int viewId, float rating, int max)
    {
        RatingBar view = getView(viewId);
        view.setMax(max);
        view.setRating(rating);
        return this;
    }

    /**
     * @param viewId
     * @param tag
     * @return
     */
    public ViewHolder setTag(int viewId, Object tag)
    {
        View view = getView(viewId);
        view.setTag(tag);
        return this;
    }

    /**
     * @param viewId
     * @param key
     * @param tag
     * @return
     */
    public ViewHolder setTag(int viewId, int key, Object tag)
    {
        View view = getView(viewId);
        view.setTag(key, tag);
        return this;
    }

    /**
     * @param viewId
     * @param checked
     * @return
     */
    public ViewHolder setChecked(int viewId, boolean checked)
    {
        Checkable view = (Checkable) getView(viewId);
        view.setChecked(checked);
        return this;
    }

    /**
     * 关于事件的
     * @param viewId
     * @param listener
     * @return
     */
    public ViewHolder setOnClickListener(int viewId,
                                         View.OnClickListener listener)
    {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    /**
     * @param viewId
     * @param listener
     * @return
     */
    public ViewHolder setOnTouchListener(int viewId,
                                         View.OnTouchListener listener)
    {
        View view = getView(viewId);
        view.setOnTouchListener(listener);
        return this;
    }

    /**
     * @param viewId
     * @param listener
     * @return
     */
    public ViewHolder setOnLongClickListener(int viewId,
                                             View.OnLongClickListener listener)
    {
        View view = getView(viewId);
        view.setOnLongClickListener(listener);
        return this;
    }


}
