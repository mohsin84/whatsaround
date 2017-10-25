package mohsin.reza.whatsaround.binding;

import android.support.v4.app.Fragment;
import android.databinding.DataBindingComponent;

/**
 * Created by mohsin on 10/5/2017.
 */

public class FragmentDataBindingComponent implements DataBindingComponent {
 private final FragmentBindingAdapters adapter;

 public FragmentDataBindingComponent(Fragment fragment){
     this.adapter=new FragmentBindingAdapters(fragment);
 }

    @Override
    public FragmentBindingAdapters getFragmentBindingAdapters() {
        return adapter;
    }
}
