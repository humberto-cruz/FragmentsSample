package com.bignerdranch.android.fragmentssample;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

//In order to receive event callbacks from the fragment,
// the activity that hosts it must implement the interface defined in the fragment class.
public class MainActivity extends FragmentActivity implements BlankFragment.OnHeadlineSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            BlankFragment blankFragment = new BlankFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            blankFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, blankFragment).commit();
        }


    }


    @Override
    public void onButtonClicked() {
        Toast.makeText(getApplicationContext(), "Boton presionado", Toast.LENGTH_SHORT).show();
        /*ListFragment listFragment = (ListFragment)
                getSupportFragmentManager().findFragmentById(R.id.list_fragment);

        if (listFragment != null) {
            // If article frag is available, we're in two-pane layout...

            // Call a method in the ArticleFragment to update its content
            listFragment.updateArticleView(position);
        } else {
            // Otherwise, we're in the one-pane layout and must swap frags...

            // Create fragment and give it an argument for the selected article
            ArticleFragment newFragment = new ArticleFragment();
            Bundle args = new Bundle();
            args.putInt(ArticleFragment.ARG_POSITION, position);
            newFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();*/

        }
}
