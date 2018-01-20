package com.test.talekar.rushikesh.proficiencytest.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.talekar.rushikesh.model.Row;
import com.test.talekar.rushikesh.presenter.CountryFactsPresenter;
import com.test.talekar.rushikesh.presenter.contracts.CountryFactsContract;
import com.test.talekar.rushikesh.proficiencytest.R;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements CountryFactsContract {

  private OnFragmentInteractionListener mListener;

  public HomeFragment() {
    // Required empty public constructor
  }

  /**
   * Use this factory method to create a new instance of
   * this fragment using the provided parameters.
   *
   * @return A new instance of fragment HomeFragment.
   */
  // TODO: Rename and change types and number of parameters
  public static HomeFragment newInstance() {
    HomeFragment fragment = new HomeFragment();
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initiateAPIToGetNews();
  }

  private void initiateAPIToGetNews() {
    CountryFactsContract.UserActionListner userActionListner = new CountryFactsPresenter(this);
    userActionListner.getCountryFacts();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_home, container, false);
    initUI(v);
    return v;
  }

  private void initUI(View v) {

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

  }

  @Override
  public void showError() {

  }

  @Override
  public void showEmptyReponseError() {

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
}
