package com.example.hw6;

import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hw6.databinding.FragmentItemBinding;
import com.example.hw6.databinding.FragmentItemListBinding;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private ArrayList<Musics> arrayList;
    ItemListFragment listener;



    public void setListener(ArrayList<Musics> arrayList, ItemListFragment listener) {
        this.listener = listener;
        this.arrayList = new ArrayList<>();
        this.arrayList.addAll(arrayList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
holder.onBind(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        private FragmentItemBinding binding;

        public ViewHolder( @NonNull FragmentItemBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void onBind(Musics musics) {
            binding.number.setText(musics.getNumber());
            binding.name.setText(musics.getName());
            binding.minutes.setText(musics.getMinutes());
            binding.author.setText(musics.getAuthor());

            itemView.setOnClickListener(v -> {
                listener.onClick(musics);
            });

        }
    }

    public interface Listener {
        void onClick(Musics musics);
    }
}
