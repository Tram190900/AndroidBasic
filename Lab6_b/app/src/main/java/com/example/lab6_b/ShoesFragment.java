package com.example.lab6_b;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShoesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShoesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ShoesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShoesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShoesFragment newInstance(String param1, String param2) {
        ShoesFragment fragment = new ShoesFragment();
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
    private List<Shoes> listShoes;
    private ListView lvShoes;
    private AdpaterShoes adpaterShoes;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shoes,container,false);

        listShoes = new ArrayList<>();
        listShoes.add(new Shoes(R.drawable.shoes_rm_preview,"Nike shoes-discount 50%"));
        listShoes.add(new Shoes(R.drawable.shoes_rm_preview_a,"Adidas shoes-discount 80%"));
        listShoes.add(new Shoes(R.drawable.shoes_rm_preview_b,"Nike Bicycle-discount 30%") );
        listShoes.add(new Shoes(R.drawable.shoes_rm_purple,"Yonex shoes-discount 50%"));
        listShoes.add(new Shoes(R.drawable.shoes_rm_yellow,"Victor shoes-discount 50%"));
        listShoes.add(new Shoes(R.drawable.shoes_white_removebg_preview,"Lining shoes-discount 50%"));

        lvShoes = view.findViewById(R.id.lv_Shoes);
        adpaterShoes = new AdpaterShoes(getActivity(),R.layout.item_shoes,listShoes);
        lvShoes.setAdapter(adpaterShoes);
        return view;
    }
}