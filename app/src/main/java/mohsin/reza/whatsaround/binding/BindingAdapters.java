package mohsin.reza.whatsaround.binding;

import android.databinding.BindingAdapter;
import android.view.View;

/**
 * Created by mohsin on 10/5/2017.
 */

public class BindingAdapters {
    @BindingAdapter("visibleGone")
    public static void showHide(View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}
