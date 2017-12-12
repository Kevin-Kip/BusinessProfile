package ke.co.sombo.apps.businessprofile.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ke.co.sombo.apps.businessprofile.R;

/**
 * Created by password on
 * 12/11/17.
 */

public class ContactFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.contact_fragment,container,false);

        TextView t = rootView.findViewById(R.id.whatsapp);

        return rootView;
    }
}
