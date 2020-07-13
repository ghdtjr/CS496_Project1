package com.example.tab_application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ItemViewHolder> implements ItemTouchHelperListener {
    private ArrayList<PhoneBook> listData;
    private LayoutInflater inflater;
    private Context context;

    //Constructor
    public ListAdapter(ArrayList<PhoneBook> data) {
        this.listData = data;
    }

    //Allocate view holders for Recycler view
    //View holder should be mapped with actual layout
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist, parent, false);
        ListAdapter.ItemViewHolder vh = new ItemViewHolder(view);
        return vh;
    }

    // Connect View Holder With data
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.name.setText(listData.get(position).getName());
        holder.phone.setText(listData.get(position).getPhone());
    }

    @Override
    public boolean onItemMove(int from_position, int to_position) {
        //이동할 객체 저장
        PhoneBook phoneBook = listData.get(from_position);
        //이동할 객체 삭제
        listData.remove(from_position);
        // 이동하고 싶은 position에 추가
        listData.add(to_position, phoneBook);
        // Adapter에 데이터 이동알림
        notifyItemMoved(from_position,to_position);
        return true;
    }

    @Override
    public void onItemSwipe(int position) {
        listData.remove(position);
        notifyItemRemoved(position);
    }

    //number of view holders in recycler view
    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        protected TextView name;
        protected TextView phone;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = (TextView) itemView.findViewById(R.id.name);
            this.phone = (TextView) itemView.findViewById(R.id.phone);
        }

    }
}
