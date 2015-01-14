package org.tedxberkeley.www.tedxberkeley.Speakers;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.tedxberkeley.www.tedxberkeley.MainActivity;
import org.tedxberkeley.www.tedxberkeley.R;

import java.lang.reflect.Array;
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
        Speaker speaker1 = new Speaker("John Smith", "Master Fighter", "John is a master fighter. He is truely a force to be reckoned with");
        Speaker speaker2 = new Speaker("Sal Kahn", "Master Fighter", "John is a master fighter. He is truely a force to be reckoned with");
        Speaker speaker3 = new Speaker("Max Wolffe", "Master Fighter", "John is a master fighter. He is truely a force to be reckoned with");
        mSpeakerList.add(speaker1);
        mSpeakerList.add(speaker2);
        mSpeakerList.add(speaker3);
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
