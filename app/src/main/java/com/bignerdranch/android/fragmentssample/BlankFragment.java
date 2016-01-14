package com.bignerdranch.android.fragmentssample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by SAN on 13/01/2016.
 */
public class BlankFragment extends Fragment {


    private Button mListButton;
    private Button mCallbackButton;

    OnHeadlineSelectedListener mCallback;


    // Container Activity must implement this interface
    public interface OnHeadlineSelectedListener {

        public void onButtonClicked();
    }

    //The Fragment captures the interface implementation during its onAttach() lifecycle method
    // and can then call the Interface methods in order to communicate with the Activity.
    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnHeadlineSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {





        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.blank_fragment, container, false);
        mListButton = (Button) v.findViewById(R.id.listButton);
        mCallbackButton = (Button) v.findViewById(R.id.callBackButton);

        //Now the fragment can deliver messages to the activity by calling methods in the interface
        mCallbackButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                mCallback.onButtonClicked();
            }
        });


        mListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ListFragment listFragment = new ListFragment();

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack so the user can navigate back
                transaction.replace(R.id.fragment_container, listFragment);
                transaction.addToBackStack(null);

// Commit the transaction
                transaction.commit();
            }
        });

        return v;
    }

}
