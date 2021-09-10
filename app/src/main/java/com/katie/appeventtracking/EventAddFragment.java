package com.katie.appeventtracking;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.katie.appeventtracking.databinding.FragmentEventAddBinding;

public class EventAddFragment extends Fragment {

    private FragmentEventAddBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentEventAddBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // initiate database
        Database database = new Database(getContext());

        // Button: submiteupdate event
        //FIXME: error. potential cause: fragment and SQL compatibility issue
        //FIXME: also need clicks from eventFragments to correspond with correct method
        binding.createUpdateEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //add or update event
                /*
                Event event = new Event();
                long eventID = event.getmId();

                int i = 1;
                if (id does not exist)
                    //add event
                    database.addEvent(date, time, name, describe);
                else {

                    database.updateEvent(eventID, date, time, name, describe);
                }
                //NavHostFragment.findNavController(EventAddFragment.this)
                //        .navigate(R.id.action_SecondFragment_to_FirstFragment);
                */
            }
        });

        // Button: return to overview event
        binding.returnFromAddEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(EventAddFragment.this)
                        .navigate(R.id.action_SecondFragment_to_EventFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}