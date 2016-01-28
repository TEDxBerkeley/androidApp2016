package org.tedxberkeley.www.tedxberkeley2016.Schedule;



import android.app.Activity;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.tedxberkeley.www.tedxberkeley2016.R;
import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class ScheduleFragment extends Fragment implements WeekView.MonthChangeListener,
                                                          WeekView.EventClickListener,
                                                          WeekView.EventLongPressListener {

    private WeekView mWeekView;
    private OnFragmentInteractionListener mListener;


    // TODO: Rename and change types and number of parameters
    public static ScheduleFragment newInstance(String param1, String param2) {
        ScheduleFragment fragment = new ScheduleFragment();
        return fragment;
    }

    public ScheduleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        // Get a reference for the week view in the layout.
        mWeekView = (WeekView) view.findViewById(R.id.weekView);

        // Show a toast message about the touched event.
        mWeekView.setOnEventClickListener(this);

        // The week view has infinite scrolling horizontally. We have to provide the events of a
        // month every time the month changes on the week view.
        mWeekView.setMonthChangeListener(this);

        // Set long press listener for events.
        mWeekView.setEventLongPressListener(this);

        mWeekView.goToHour(8);

        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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

    @Override
    public List<WeekViewEvent> onMonthChange(int newYear, int newMonth) {

        // Populate the week view with some events.
        List<WeekViewEvent> events = new ArrayList<WeekViewEvent>();

        Calendar startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 8);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.DAY_OF_MONTH, 4);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        Calendar endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR, 8);
        endTime.add(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth - 1);
        WeekViewEvent event = new WeekViewEvent(1, "TEDxBerkeley 2 Days Away!", startTime, endTime);
        event.setColor(getResources().getColor(R.color.black));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 8);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.DAY_OF_MONTH, 5);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR, 8);
        endTime.add(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth - 1);
        event = new WeekViewEvent(1, "TEDxBerkeley 1 Day Away!", startTime, endTime);
        event.setColor(getResources().getColor(R.color.ted_red));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 8);
        startTime.set(Calendar.MINUTE, 30);
        startTime.set(Calendar.DAY_OF_MONTH, 6);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR, 1);
        endTime.add(Calendar.MINUTE, 30);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Registration", startTime, endTime);
        event.setColor(getResources().getColor(R.color.black));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 10);
        startTime.set(Calendar.MINUTE, 00);
        startTime.set(Calendar.DAY_OF_MONTH, 6);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR, 2);
        endTime.add(Calendar.MINUTE, 30);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Breaking the Fifth Wall " +  "       Celli@Berkeley \n" +
                "                                                 Naveen Jain\n" +
                "                                                 Jeromy Johnson\n" +
                "                                                 Dr. Susan Lim\n" +
                "                                                 Andrew Siemion\n" +
                "                                                 Jacob Corn\n" +
                "                                                 Kathy Calvin\n" +
                "                                                 Sonia Rao", startTime, endTime);
        event.setColor(getResources().getColor(R.color.ted_red));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 12);
        startTime.set(Calendar.MINUTE, 30);
        startTime.set(Calendar.DAY_OF_MONTH, 6);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR, 1);
        endTime.set(Calendar.MONTH, newMonth - 1);
        event = new WeekViewEvent(1, "Lunch", startTime, endTime);
        event.setColor(getResources().getColor(R.color.black));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 13);
        startTime.set(Calendar.MINUTE, 30);
        startTime.set(Calendar.DAY_OF_MONTH, 6);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR, 1);
        endTime.add(Calendar.MINUTE, 45);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Untold                                    UC Berkeley Azaad\n" +
                "                                                 Christopher Ategeka\n" +
                "                                                 Ellen Petry Leanse\n" +
                "                                                 Isha Ray\n" +
                "                                                 Joshua Toch\n" +
                "                                                 Rev. Deborah Johnson\n" +
                "                                                 OSA Chamber Choir", startTime, endTime);
        event.setColor(getResources().getColor(R.color.ted_red));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 6);
        startTime.set(Calendar.HOUR_OF_DAY,15);
        startTime.set(Calendar.MINUTE, 15);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.MINUTE, 30);
        event = new WeekViewEvent(1, "Break", startTime, endTime);
        event.setColor(getResources().getColor(R.color.black));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 6);
        startTime.set(Calendar.HOUR_OF_DAY,15);
        startTime.set(Calendar.MINUTE, 45);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR, 1);
        endTime.add(Calendar.MINUTE, 30);
        event = new WeekViewEvent(1, "Eye of the Storm  " + "  Rose Gelfand, Molly Gardner, & Isabelle Ansari\n" +
                "                                                 Dr. Sriram Shamasunder\n" +
                "                                                 Aran Khanna\n" +
                "                                                 Stephanie Freid\n" +
                "                                                 John Koenig\n" +
                "                                                 Rob Hotchkiss\n", startTime, endTime);
        event.setColor(getResources().getColor(R.color.ted_red));
        events.add(event);



        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 6);
        startTime.set(Calendar.HOUR_OF_DAY, 17);
        startTime.set(Calendar.MINUTE, 15);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR, 1);
        endTime.add(Calendar.MINUTE, 15);
        event = new WeekViewEvent(1, "Wine Reception", startTime, endTime);
        event.setColor(getResources().getColor(R.color.black));
        events.add(event);

        return events;
    }

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

    private String getEventTitle(Calendar time) {
        return String.format("Event of %02d:%02d %s/%d", time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE), time.get(Calendar.MONTH)+1, time.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public void onEventClick(WeekViewEvent event, RectF eventRect) {
    }

    @Override
    public void onEventLongPress(WeekViewEvent event, RectF eventRect) {
    }

}
