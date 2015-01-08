package org.tedxberkeley.www.tedxberkeley.Speakers;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.tedxberkeley.www.tedxberkeley.MainActivity;
import org.tedxberkeley.www.tedxberkeley.R;

import java.util.ArrayList;

public class SpeakerListFragment extends Fragment {

    private ArrayList<Speaker> mSpeakers;

    private OnFragmentInteractionListener mListener;
    private SpeakerListAdapter mAdapter;
    private MainActivity mMainActivity;
    private ListView mSpeakerListView;


    public static SpeakerListFragment newInstance() {
        SpeakerListFragment fragment = new SpeakerListFragment();
        return fragment;
    }

    public SpeakerListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_speaker_list, container, false);

        mSpeakerListView = (ListView) view.findViewById(android.R.id.list);

        mAdapter = new SpeakerListAdapter(mMainActivity, R.layout.speaker_row, getSpeakers());
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
