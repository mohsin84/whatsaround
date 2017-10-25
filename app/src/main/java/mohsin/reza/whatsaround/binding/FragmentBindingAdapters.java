package mohsin.reza.whatsaround.binding;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

/**
 * Created by mohsin on 10/5/2017.
 */

public class FragmentBindingAdapters {
    final Fragment fragment;

    @Inject
    public FragmentBindingAdapters(Fragment fragment){ this.fragment=fragment;}
    @BindingAdapter("imageUrl")
    public void bindImage(ImageView imageView, String url)
    {
        Glide.with(fragment).load(url).into(imageView);
    }
}
