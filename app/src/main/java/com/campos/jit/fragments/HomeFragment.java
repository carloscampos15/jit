package com.campos.jit.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.campos.jit.R;
import com.campos.jit.adapters.HomeAdapter;
import com.campos.jit.models.Enterprise;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView listview;
    private ArrayList<Enterprise> enterprises;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] names = {"SOCOBUSES", "AUTOLEGAL", "METROCAFE", "UNITRANS", "GRAN CALDAS", "SIDERAL", "SERVITURISMO", "CABLE AEREO", "METROPOLITANA"};

        JSONArray jsonArray = null;
        try {
            InputStream is = getContext().getAssets().open("rutas.geojson");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            String jsonString = new String(buffer, "UTF-8");
            JSONObject jsonObject  = new JSONObject(jsonString);
            jsonArray = new JSONArray(jsonObject.getString("features"));
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        listview = (ListView) view.findViewById(R.id.listview_btns);

        enterprises = new ArrayList<>();
        for(String enterprise : names){
            enterprises.add(new Enterprise(enterprise, "https://st.redbus.in/bo-images/COL/WM/16850/985/SI/L/lejRej.jpeg"));
        }

        HomeAdapter homeAdapter = new HomeAdapter(getActivity(), R.layout.list_item_home, enterprises);

        listview.setDivider(null);
        listview.setOnItemClickListener(this);
        listview.setAdapter(homeAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //System.out.println(view.getId());
        System.out.println(i);
        //System.out.println(l);
        System.out.println("me presionaste crack");
        switch (i){
            case 0:
                System.out.println("presionado papa");
                break;
        }
    }
}