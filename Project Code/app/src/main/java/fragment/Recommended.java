package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mastert.bookmyseat.R;

import java.util.ArrayList;

import adapter.RecommendedAdapter;
import adapter.TopReviewAdapter;
import model.RecommendedModel;
import model.TopReviewModel;



public class Recommended extends Fragment {

    Integer[] nearbyimg1 = {R.drawable.foodimg4,R.drawable.img2,R.drawable.foodimg3,R.drawable.img1};
    Integer[] nearbyimg2 = {R.drawable.ic_like,R.drawable.ic_like,R.drawable.ic_like,R.drawable.ic_like};

    String[] nearbytext1 = {"Cocobolo Poolside \nBar + Grill","Wild Honey at Scotts Square","Palm Beach Seafood Restaurant","Shin Minori Japanese Restaurant"};
    String[] nearbytext2 = {"60 Kub Pines Apt. 797","473 Keeling Station","55 Dicki Point Suite 867","833 Kuhn Mission Suite 860"};
    String[] nearbytext3 = {"238 reviews","238 reviews","238 reviews","238 reviews"};


    private RecommendedAdapter homepageAdapter;
    private RecyclerView recyclerview;
    private ArrayList<RecommendedModel> homepageModelList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nearbyfragment,container,false);


        recyclerview = view.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager( getContext(),2);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());

        homepageModelList = new ArrayList<>();


        for (int i = 0; i < nearbyimg1.length; i++) {
            RecommendedModel view1 = new RecommendedModel(nearbyimg1[i],nearbyimg2[i],nearbytext1[i],nearbytext2[i],nearbytext3[i]);
            homepageModelList.add(view1);
        }
        homepageAdapter = new RecommendedAdapter(getActivity(),homepageModelList);
        recyclerview.setAdapter(homepageAdapter);

        return view;
    }
}
