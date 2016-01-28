package org.tedxberkeley.www.tedxberkeley2016.Speakers;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.tedxberkeley.www.tedxberkeley2016.MainActivity;
import org.tedxberkeley.www.tedxberkeley2016.R;

import java.util.ArrayList;

public class SpeakerListFragment extends ListFragment {

    private ArrayList<Speaker> mSpeakers;

    private OnFragmentInteractionListener mListener;
    private SpeakerListAdapter mAdapter;
    private MainActivity mMainActivity;
    private ArrayList<Speaker> mSpeakerList;
    private ListView mSpeakerListView;


    public static SpeakerListFragment newInstance() {
        return new SpeakerListFragment();
    }

    public SpeakerListFragment() {
    }

    public ArrayList<Speaker> configureSpeakerList(){
        mMainActivity = (MainActivity)getActivity();
        mSpeakerList = new ArrayList<Speaker>();

        mSpeakerList.add(new Speaker("Christopher Ategeka", "Engineer and Social Entrepreneur", getString(R.string.ategeka_bio), R.drawable.ategeka));
        mSpeakerList.add(new Speaker("Kathy Calvin", "CEO of United Nations Foundation", getString(R.string.calvin_bio), R.drawable.calvin));
        mSpeakerList.add(new Speaker("Jacob Corn", "Scientific Director of Innovative Genomics Initiative", getString(R.string.corn_bio), R.drawable.corn));
        mSpeakerList.add(new Speaker("Stephanie Freid", "International Conflicts Journalist", getString(R.string.freid_bio), R.drawable.freid));
        mSpeakerList.add(new Speaker("Rose Gelfand", "OSA Poet", getString(R.string.rose_bio), R.drawable.rose));
        mSpeakerList.add(new Speaker("Molly Gardner", "OSA Poet", getString(R.string.molly_bio), R.drawable.molly));
        mSpeakerList.add(new Speaker("Isa Ansari", "OSA Poet", getString(R.string.isa_bio), R.drawable.isa));
        mSpeakerList.add(new Speaker("Rob Hotchkiss", "Musician", getString(R.string.hotchkiss_bio), R.drawable.hotchkiss));
        mSpeakerList.add(new Speaker("Naveen Jain", "Entrepreneur and Philanthropist", getString(R.string.jain_bio), R.drawable.jain));
        mSpeakerList.add(new Speaker("Jeromy Johnson", "Expert in EMF Exposure", getString(R.string.johnson_bio), R.drawable.johnson));
        mSpeakerList.add(new Speaker("Reverend Deborah Johnson", "Minister, Author, and Diversity Expert", getString(R.string.deborah_bio), R.drawable.deborah));
        mSpeakerList.add(new Speaker("Celli@Berkeley", "UC Berkeley Celli Performance Group", getString(R.string.celli_bio), R.drawable.celli));

        mSpeakerList.add(new Speaker("Aran Khanna", "Computer Scientist and Security Researcher", getString(R.string.khanna_bio), R.drawable.khanna));
        mSpeakerList.add(new Speaker("John Koenig", "Creator of the Dictionary of Obscure Sorrows", getString(R.string.koenig_bio), R.drawable.koenig));
        mSpeakerList.add(new Speaker("Ellen Leanse", "Digital Pioneer", getString(R.string.leanse_bio), R.drawable.leanse));
        mSpeakerList.add(new Speaker("Dr. Susan Lim", "Surgeon and Entrepreneur", getString(R.string.lim_bio), R.drawable.lim));
        mSpeakerList.add(new Speaker("OSA Chamber Choir", "Choir Group", getString(R.string.choir_bio), R.drawable.choir));
        mSpeakerList.add(new Speaker("Sonia Rao", "Singer and Songwriter", getString(R.string.rao_bio), R.drawable.rao));
        mSpeakerList.add(new Speaker("Isha Ray", "Co-Director of Berkeley Water Center", getString(R.string.ray_bio), R.drawable.ray));

        mSpeakerList.add(new Speaker("Amandine Roche", "Human Rights Expert", getString(R.string.roche_bio), R.drawable.roche));
        mSpeakerList.add(new Speaker("Dr. Sriram Shamasunder", "Co-Founder of HEAL Initiative", getString(R.string.shamasunder_bio), R.drawable.shamasunder));
        mSpeakerList.add(new Speaker("Dr. Andrew Siemion", "Astrophysicist", getString(R.string.siemion_bio), R.drawable.siemion));
        mSpeakerList.add(new Speaker("Joshua Toch", "UC Berkeley Student, Founder of Mind before Mouth", getString(R.string.toch_bio), R.drawable.toch));
        mSpeakerList.add(new Speaker("UC Berkeley Azaad", "UC Berkeley Bollywood Dance Team", getString(R.string.azaad_bio), R.drawable.azaad));
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
