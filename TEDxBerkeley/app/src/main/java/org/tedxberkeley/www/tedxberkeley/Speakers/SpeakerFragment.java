package org.tedxberkeley.www.tedxberkeley.Speakers;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.tedxberkeley.www.tedxberkeley.R;

import java.util.ArrayList;

public class SpeakerFragment extends Fragment {

    private Activity mListener;
    private Speaker mSpeaker;
    public static SpeakerFragment newInstance(Speaker speaker) {
        SpeakerFragment fragment = new SpeakerFragment();
        fragment.configureWithSpeaker(speaker);
        return fragment;
    }

    public SpeakerFragment() {
    }

    private void configureWithSpeaker(Speaker speaker){
        mSpeaker = speaker;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_speaker, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = activity;
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


}
