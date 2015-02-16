package org.tedxberkeley.www.tedxberkeley.Speakers;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.tedxberkeley.www.tedxberkeley.MainActivity;
import org.tedxberkeley.www.tedxberkeley.R;

import java.util.ArrayList;

public class SpeakerListFragment extends ListFragment {

    private ArrayList<Speaker> mSpeakers;

    private OnFragmentInteractionListener mListener;
    private SpeakerListAdapter mAdapter;
    private MainActivity mMainActivity;
    private ArrayList<Speaker> mSpeakerList;
    private ListView mSpeakerListView;


    public static SpeakerListFragment newInstance() {
        SpeakerListFragment fragment = new SpeakerListFragment();
        return fragment;
    }

    public SpeakerListFragment() {
    }

    public ArrayList<Speaker> configureSpeakerList(){
        mMainActivity = (MainActivity)getActivity();
        mSpeakerList = new ArrayList<Speaker>();
        mSpeakerList.add(new Speaker("Suzanne Ackerman-Berman", "Transformation Director, Pick n Pay", getString(R.string.ackerman_bio), R.drawable.sab));
        mSpeakerList.add(new Speaker("Cal Bhangra", "Punjabi Dance Group", getString(R.string.bhangra_bio), R.drawable.bhangra));
        mSpeakerList.add(new Speaker("Carolyn Gable", "Co Founder of Expect a Miracle", getString(R.string.gable_bio), R.drawable.gabel));
        mSpeakerList.add(new Speaker("Dan Garcia", "Innovator in Computer Science Education", getString(R.string.garcia_bio), R.drawable.garcia));
        mSpeakerList.add(new Speaker("Marc Gopin", "Director of the CRDC", getString(R.string.gopin_bio), R.drawable.gopin));
        mSpeakerList.add(new Speaker("Viviana Guzmán", "Flutist", getString(R.string.guzman_bio), R.drawable.viviana));
        mSpeakerList.add(new Speaker("Eric Holt-Giménez", "Executive Director of Food First", getString(R.string.giminez_bio), R.drawable.gimenez));
        mSpeakerList.add(new Speaker("Valerie Joi", "Musical Minister", getString(R.string.joi_bio), R.drawable.joi));
        mSpeakerList.add(new Speaker("Prasad Kaipa", "CEO, Kaipa Group", getString(R.string.kaipa_bio), R.drawable.kaipa));
        mSpeakerList.add(new Speaker("Dr. Victoria Kisyombe", "Innovator in Women Empowerment", getString(R.string.kisyombe_bio), R.drawable.kisyombe));
        mSpeakerList.add(new Speaker("Emily Levine", "Producer and Comedian", getString(R.string.levin_bio), R.drawable.good_emily_levine));
        mSpeakerList.add(new Speaker("Alison Meyer", "Haas Leadership Coach", getString(R.string.meyer_bio), R.drawable.meyer));
        mSpeakerList.add(new Speaker("Eric Rasmussen, MD", "CEO for Infinitum Humanitarian Systems", getString(R.string.rass_bio), R.drawable.rasmussen));
        mSpeakerList.add(new Speaker("Mike Robbins", "Author", getString(R.string.robins_bio), R.drawable.robbins));
        mSpeakerList.add(new Speaker("Richmond Sarpong", "Professor of Chemistry", getString(R.string.sarpong_bio), R.drawable.rsarpong));
        mSpeakerList.add(new Speaker("Meera Shenoy", "Founder of Youth4Jobs", getString(R.string.sheenoy_bio), R.drawable.meera));
        mSpeakerList.add(new Speaker("Cal Raiji Taiko", "Performance Drum Group", getString(R.string.taiko_bio), R.drawable.taiko));
        mSpeakerList.add(new Speaker("UC Men's Octet", "Cal A Capella Group", getString(R.string.octet_bio), R.drawable.octet));
        mSpeakerList.add(new Speaker("Dan Viederman", "CEO of Verité", getString(R.string.viederman_bio), R.drawable.viederman));
        return mSpeakerList;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayList<Speaker> speaker;
        View view =  inflater.inflate(R.layout.fragment_speaker_list, container, false);
        mSpeakerListView = (ListView) view.findViewById(android.R.id.list);
        speaker = configureSpeakerList();
        mAdapter = new SpeakerListAdapter(mMainActivity, R.layout.speaker_row, speaker);
        mSpeakerListView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        Speaker speakerSelected = this.mSpeakerList.get(position);
        SpeakerFragment detailFragment = SpeakerFragment.newInstance(speakerSelected);
        mMainActivity.replaceFragment(detailFragment);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

    public ArrayList<Speaker> getSpeakers(){
        return mSpeakers;
    }

}
