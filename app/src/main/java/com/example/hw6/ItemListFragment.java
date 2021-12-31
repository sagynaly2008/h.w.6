package com.example.hw6;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ItemListFragment extends Fragment implements Listener {
    private Adapter adapter;
    private ArrayList<Musics> arrayList = new ArrayList<>();
    private RecyclerView recyclerView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_list, container, false);

    }


    private void CreateList() {
        arrayList = new ArrayList<>();
        arrayList.add(new Musics("Angel","3:22","1","Miyagi",1));
        arrayList.add(new Musics("Trenchtown","3:39","2","Miyagi",2));
        arrayList.add(new Musics("Цепи","3:27","3","Скриптонит",3));
        arrayList.add(new Musics("Believer","3:24","4","Imagine Dragons",4));
        arrayList.add(new Musics("I can fly","2:45","5","Xcho",5));
        arrayList.add(new Musics("Blank Space", "3:22", "1", "Taylor Swift", 6));
        arrayList.add(new Musics("Watch Me", "5:36", "2", "Silento", 7));
        arrayList.add(new Musics("Earned it", "4:51", "3", "The Weekend", 8));
        arrayList.add(new Musics("The Hills", "3:41", "4", "The Weekend", 9));

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CreateList();
        initFrag(view);
    }

    private void initFrag(@NotNull View view) {
        recyclerView = view.findViewById(R.id.recycler);
        adapter = new Adapter();
        adapter.setListener(arrayList, this);
        recyclerView.setAdapter(adapter);
    }


    public void onClick(Musics musics) {
        Intent intent = new Intent(getActivity(), MainActivity2.class);
        intent.putExtra("key", musics.getName());
        startActivity(intent);
    }
}