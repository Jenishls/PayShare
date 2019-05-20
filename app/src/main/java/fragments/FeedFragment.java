package fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.e.payshare.ItemData;
import com.e.payshare.R;

import adapter.FeedAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedFragment extends Fragment {


    public FeedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_feed, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.list);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ItemData itemsData[] = {
                new ItemData("Indigo", R.drawable.logo),
                new ItemData("Red", R.drawable.logo),
                new ItemData("Blue", R.drawable.logo),
                new ItemData("Green", R.drawable.logo),
                new ItemData("Amber", R.drawable.logo),
                new ItemData("Deep Orange", R.drawable.logo)
        };

        FeedAdapter feedAdapter = new FeedAdapter(itemsData);

        recyclerView.setAdapter(feedAdapter);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return rootView;

//        return inflater.inflate(R.layout.fragment_feed, container, false);
    }

}
