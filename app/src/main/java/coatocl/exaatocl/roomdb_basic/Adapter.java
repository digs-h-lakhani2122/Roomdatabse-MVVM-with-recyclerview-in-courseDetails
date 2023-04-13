package coatocl.exaatocl.roomdb_basic;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewModel>
{
    List<CustomModel> listItem = new ArrayList<>();

    @SuppressLint("NotifyDataSetChanged")
    public void setListItem(List<CustomModel> listItem) {
        this.listItem = listItem;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Adapter.ViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recyclerview,parent,false);
        return new ViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewModel holder, int position)
    {

        CustomModel customModel = listItem.get(position);

        holder.CourseNameText.setText(customModel.getName());
        holder.DurationText.setText(customModel.getDuration());
        holder.DescriptionText.setText(customModel.getDescription());
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public static class ViewModel extends RecyclerView.ViewHolder
    {
        TextView CourseNameText,DurationText,DescriptionText;
        public ViewModel(@NonNull View itemView) {
            super(itemView);

            CourseNameText = itemView.findViewById(R.id.CourseNameText);
            DurationText = itemView.findViewById(R.id.DurationText);
            DescriptionText = itemView.findViewById(R.id.DescriptionText);
        }
    }

}
