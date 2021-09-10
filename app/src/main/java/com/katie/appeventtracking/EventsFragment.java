package com.katie.appeventtracking;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.katie.appeventtracking.databinding.FragmentEventsBinding;

public class EventsFragment extends Fragment {

    private FragmentEventsBinding binding;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentEventsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //initiate database
        Database database = new Database(getContext());

        // update event button
        binding.buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // update event on linked fragment
                NavHostFragment.findNavController(EventsFragment.this)
                      .navigate(R.id.action_EventFragment_to_SecondFragment);
                //Intent intent = new Intent(getContext(), ManageEvent.class);
                //startActivity(intent);
            }
        });

        // add event button
        binding.buttonAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // add event on linked fragment
                NavHostFragment.findNavController(EventsFragment.this)
                        .navigate(R.id.action_EventFragment_to_SecondFragment);
            }
        });

        // delete event button
        binding.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //FIXME: error. potential issue: sqlite and fragments on conflicting
                // delete event
                //database.deleteEvent(eventID);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}