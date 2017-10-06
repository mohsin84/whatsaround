package mohsin.reza.whatsaround.ui.common;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
/**
 * Created by mohsin on 10/5/2017.
 */

public class DataBoundViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    public final T binding;
    DataBoundViewHolder(T binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
