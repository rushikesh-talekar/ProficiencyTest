package com.test.talekar.rushikesh.proficiencytest.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.test.talekar.rushikesh.model.Row;
import com.test.talekar.rushikesh.proficiencytest.R;

import java.util.List;

/**
 * Created by Rushikesh_Talekar on 20-01-2018.
 */

public class CountryFactsCustomAdapter extends RecyclerView.Adapter<CountryFactsCustomAdapter
    .ViewHolder> {

  private List<Row> mDataset;

  public CountryFactsCustomAdapter(List<Row> dataset) {
    this.mDataset = dataset;
  }

  /**
   * Method to update dataset
   *
   * @param dataset - updated dataset
   */
  public void refreshfacts(List<Row> dataset) {
    mDataset = dataset;
    notifyDataSetChanged();
  }

  // BEGIN_INCLUDE(recyclerViewOnCreateViewHolder)
  // Create new views (invoked by the layout manager)
  @Override
  public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
    // Create a new view.
    View v = LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.item_country_facts, viewGroup, false);

    return new ViewHolder(v);
  }
  // END_INCLUDE(recyclerViewOnCreateViewHolder)

  @Override
  public void onBindViewHolder(ViewHolder viewHolder, int i) {
// Get element from your dataset at this position and replace the contents of the view
    // with that element
    Row factRow = mDataset.get(i);
    Context context = viewHolder.getTvTitle().getContext();

    //Check if title is available or not and set a valid value to title textview
    String title = TextUtils.isEmpty(factRow.getTitle()) ? context.getString(R.string.na) : factRow
        .getTitle();
    viewHolder.getTvTitle().setText(title);

    //Check if description is available or not and set a valid value to descri[ption textview
    String description =
        TextUtils.isEmpty(factRow.getDescription()) ? context.getString(R.string.na) :
            factRow.getDescription();
    viewHolder.getTvDescription().setText(description);

    //Load thumbnail of images
    Picasso.with(viewHolder.getIvThumbnail().getContext())
        .load(factRow.getImageHref())
        .placeholder(R.drawable.ic_no_photo)
        .error(R.drawable.ic_no_photo)
        .into(viewHolder.getIvThumbnail());
  }


  @Override
  public int getItemCount() {
    return mDataset.size();
  }

  // BEGIN_INCLUDE(recyclerView-ViewHolder)

  /**
   * Provide a reference to the type of views that you are using (custom ViewHolder)
   */
  public static class ViewHolder extends RecyclerView.ViewHolder {
    private final TextView tvTitle;
    private final TextView tvDescription;
    private final ImageView ivThumbnail;

    public ViewHolder(View v) {
      super(v);
      // Define click listener for the ViewHolder's View.
      v.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        }
      });
      tvTitle = (TextView) v.findViewById(R.id.item_facts_tv_title);
      tvDescription = (TextView) v.findViewById(R.id.item_facts_tv_description);
      ivThumbnail = (ImageView) v.findViewById(R.id.item_facts_iv);
    }

    public TextView getTvTitle() {
      return tvTitle;
    }

    public TextView getTvDescription() {
      return tvDescription;
    }

    public ImageView getIvThumbnail() {
      return ivThumbnail;
    }


  }
  // END_INCLUDE(recyclerView-ViewHolder)
}
