package com.test.talekar.rushikesh.proficiencytest.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.talekar.rushikesh.model.Row;
import com.test.talekar.rushikesh.presenter.CountryFactsPresenter;
import com.test.talekar.rushikesh.presenter.contracts.CountryFactsContract;
import com.test.talekar.rushikesh.proficiencytest.R;
import com.test.talekar.rushikesh.proficiencytest.adapters.CountryFactsCustomAdapter;
import com.test.talekar.rushikesh.proficiencytest.util.DialogUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends AppFragment implements CountryFactsContract.View {

  private OnFragmentInteractionListener mListener;
  private RecyclerView mRVCountryFacts;
  private SwipeRefreshLayout swipLayout;
  private CountryFactsCustomAdapter countryFactsCustomAdapter;
  private TextView tvEmptyState;
  private CountryFactsContract.UserActionListner userActionListner;

  public HomeFragment() {
    // Required empty public constructor
  }

  /**
   * Use this factory method to create a new instance of
   * this fragment using the provided parameters.
   *
   * @return A new instance of fragment HomeFragment.
   */
  public static HomeFragment newInstance() {
    HomeFragment fragment = new HomeFragment();
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    showLoading(true);
    userActionListner = new CountryFactsPresenter(this);
    initiateAPIToGetFacts();
  }

  private void initiateAPIToGetFacts() {
    if (isNetworkConnected()) {
      setRefreshingState(true);
      userActionListner.getCountryFacts();
    } else {
      showLoading(false);
      showNoNetworkError();
      setRefreshingState(false);
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_home, container, false);
    initUI(v);
    setListners();
    return v;
  }

  /**
   * Method to add listners
   */
  private void setListners() {
    swipLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override
      public void onRefresh() {
        initiateAPIToGetFacts();
      }
    });
  }

  private void initUI(View v) {
    // BEGIN_INCLUDE(initializeRecyclerView)
    mRVCountryFacts = (RecyclerView) v.findViewById(R.id.fragment_home_rv);
    mRVCountryFacts.setLayoutManager(new LinearLayoutManager(getActivity()));
    // END_INCLUDE(initializeRecyclerView)

    // BEGIN_INCLUDE(initializeSwipeLayout)
    swipLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipeRefreshLayout);
    // END_INCLUDE(initializeSwipeLayout)

    // BEGIN_INCLUDE(initializeCustomAdapter)
    countryFactsCustomAdapter = new CountryFactsCustomAdapter(new ArrayList<Row>());
    mRVCountryFacts.setAdapter(countryFactsCustomAdapter);
    // END_INCLUDE(initializeCustomAdapter)

    tvEmptyState = (TextView) v.findViewById(R.id.tv_empty_state);
  }


  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof OnFragmentInteractionListener) {
      mListener = (OnFragmentInteractionListener) context;
    } else {
      throw new RuntimeException(context.toString()
          + " must implement OnFragmentInteractionListener");
    }
  }

  @Override
  public void onDetach() {
    super.onDetach();
    mListener = null;
  }

  @Override
  public void onGetCountryFactsSuccess(List<Row> rowsData) {
    setRefreshingState(false);
    showLoading(false);
    setUIstate(true);
    countryFactsCustomAdapter.refreshfacts(rowsData);
  }

  @Override
  public void showError() {
    setRefreshingState(false);
    showLoading(false);
    DialogUtil.showAlertDialog(getContext(), getString(R.string.error),
        getString(R.string.something_went_wrong));
    setUIstate(false);
  }

  @Override
  public void showEmptyReponseError() {
    setRefreshingState(false);
    showLoading(false);
    DialogUtil.showAlertDialog(getContext(), getString(R.string.error),
        getString(R.string.error_data_not_available));
    setUIstate(false);
  }

  @Override
  public void setToolbarTitle(String title) {
    mListener.setToolbarTitle(title);
  }

  /**
   * This interface must be implemented by activities that contain this
   * fragment to allow an interaction in this fragment to be communicated
   * to the activity and potentially other fragments contained in that
   * activity.
   * <p>
   * See the Android Training lesson <a href=
   * "http://developer.android.com/training/basics/fragments/communicating.html"
   * >Communicating with Other Fragments</a> for more information.
   */
  public interface OnFragmentInteractionListener {
    void setToolbarTitle(String title);
  }

  /**
   * This method check if data is available to show and load UI accordingly.
   *
   * @param isDataAvailable - if data available or not
   */
  public void setUIstate(boolean isDataAvailable) {
    if (isDataAvailable) {
      mRVCountryFacts.setVisibility(View.VISIBLE);
      tvEmptyState.setVisibility(View.GONE);
    } else {
      mRVCountryFacts.setVisibility(View.GONE);
      tvEmptyState.setVisibility(View.VISIBLE);
    }
  }

  /**
   * This method will check whether is page refreshing
   *
   * @param setRefreshing - true if page is refreshing
   */
  public void setRefreshingState(boolean setRefreshing) {
    if (null == swipLayout) {
      return;
    }
    // Stop refresh animation
    swipLayout.setRefreshing(false);

  }
}
