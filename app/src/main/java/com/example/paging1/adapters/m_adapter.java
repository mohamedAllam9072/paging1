package com.example.paging1.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paging1.databinding.ItemMainBinding;
import com.example.paging1.db.model.Items;

import java.util.List;

public class m_adapter extends PagedListAdapter<Items, m_adapter.mVH> {
    private List<Items> itemsList;
    private Context context;

    protected m_adapter(Context context) {
        super(DIFF_CALLBACK);
        this.context = context;
    }

    @NonNull
    @Override
    public mVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMainBinding binding = ItemMainBinding.
                inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new mVH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull mVH holder, int position) {
        holder.binding.title.setText(itemsList.get(position).getOwner().getDisplay_name());
        holder.binding.subTitle.setText(itemsList.get(position).getContent_license());
    }

    public class mVH extends RecyclerView.ViewHolder {
        ItemMainBinding binding;

        public mVH(@NonNull ItemMainBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    private static DiffUtil.ItemCallback<Items> DIFF_CALLBACK = new DiffUtil.ItemCallback<Items>() {
        @Override
        public boolean areItemsTheSame(@NonNull Items oldItem, @NonNull Items newItem) {
            return oldItem.getAnswer_id() == newItem.getAnswer_id();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Items oldItem, @NonNull Items newItem) {
            return oldItem.equals(newItem);
        }
    };
}
