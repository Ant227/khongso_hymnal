package com.deveant.broahlemkhng;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import com.deveant.broahlemkhng.Adapter.Adapter;
import com.deveant.broahlemkhng.Model.Constant;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<String> songsList;
    private Adapter adapter;
    private EditText searchET;
    private Toolbar toolbar;
    private ImageButton searchClearBtn;
    private TextView textView;
    private MaterialSearchBar materialSearchBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.main_recycler_view);
        searchET = findViewById(R.id.main_search);
        toolbar = findViewById(R.id.main_toolbar);
        searchClearBtn = findViewById(R.id.search_clear_btn);
        materialSearchBar = findViewById(R.id.searchBar);


        textView = findViewById(R.id.main_toolbar_title);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "developed by \n Ant Bone Kyaw", Toast.LENGTH_SHORT).show();
            }
        });


        setSupportActionBar(toolbar);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        addSongsToSongList();

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new Adapter(this, songsList, searchET);
        recyclerView.setAdapter(adapter);


        materialSearchBar.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

//        searchET.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                filter(s.toString());
//            }
//        });

//        searchET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if(hasFocus){
//                    searchClearBtn.setVisibility(View.VISIBLE);
//                    searchClearBtn.setVisibility(View.VISIBLE);
//                    searchClearBtn.setVisibility(View.VISIBLE);
//                }
//                else {
//                    searchClearBtn.setVisibility(View.GONE);
//                    searchET.getText().clear();
//                    hideKeyboard(searchET);
//                }
//            }
//        });



       HideNotiBarWhenLandscape();

    }

    private void HideNotiBarWhenLandscape() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

//        searchET.getText().clear();
//        hideKeyboard(searchET);
    }

//    public void hideKeyboard(View view) {
//        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
//        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
//    }

    private void filter(String toString) {

        ArrayList<String> filterList = new ArrayList<>();

        for (String string : songsList) {
            if (string.toLowerCase().contains(toString.toLowerCase())) {
                filterList.add(string);
            }
        }

        adapter.filterList(filterList);
    }

    private void addSongsToSongList() {
        songsList = new ArrayList<String>();
        songsList.add(Constant.Song1);
        songsList.add(Constant.Song2);
        songsList.add(Constant.Song3);
        songsList.add(Constant.Song4);
        songsList.add(Constant.Song5);
        songsList.add(Constant.Song6);
        songsList.add(Constant.Song7);
        songsList.add(Constant.Song8);
        songsList.add(Constant.Song9);
        songsList.add(Constant.Song10);

        songsList.add(Constant.Song11);
        songsList.add(Constant.Song12);
        songsList.add(Constant.Song13);
        songsList.add(Constant.Song14);
        songsList.add(Constant.Song15);
        songsList.add(Constant.Song16);
        songsList.add(Constant.Song17);
        songsList.add(Constant.Song18);
        songsList.add(Constant.Song19);
        songsList.add(Constant.Song20);

        songsList.add(Constant.Song21);
        songsList.add(Constant.Song22);
        songsList.add(Constant.Song23);
        songsList.add(Constant.Song24);
        songsList.add(Constant.Song25);
        songsList.add(Constant.Song26);
        songsList.add(Constant.Song27);
        songsList.add(Constant.Song28);
        songsList.add(Constant.Song29);
        songsList.add(Constant.Song30);


        songsList.add(Constant.Song31);
        songsList.add(Constant.Song32);
        songsList.add(Constant.Song33);
        songsList.add(Constant.Song34);
        songsList.add(Constant.Song35);
        songsList.add(Constant.Song36);
        songsList.add(Constant.Song37);
        songsList.add(Constant.Song38);
        songsList.add(Constant.Song39);
        songsList.add(Constant.Song40);

        songsList.add(Constant.Song41);
        songsList.add(Constant.Song42);
        songsList.add(Constant.Song43);
        songsList.add(Constant.Song44);
        songsList.add(Constant.Song45);
        songsList.add(Constant.Song46);
        songsList.add(Constant.Song47);
        songsList.add(Constant.Song48);
        songsList.add(Constant.Song49);
        songsList.add(Constant.Song50);

        songsList.add(Constant.Song51);
        songsList.add(Constant.Song52);
        songsList.add(Constant.Song53);
        songsList.add(Constant.Song54);
        songsList.add(Constant.Song55);
        songsList.add(Constant.Song56);
        songsList.add(Constant.Song57);
        songsList.add(Constant.Song58);
        songsList.add(Constant.Song59);
        songsList.add(Constant.Song60);

        songsList.add(Constant.Song61);
        songsList.add(Constant.Song62);
        songsList.add(Constant.Song63);
        songsList.add(Constant.Song64);
        songsList.add(Constant.Song65);
        songsList.add(Constant.Song66);
        songsList.add(Constant.Song67);
        songsList.add(Constant.Song68);
        songsList.add(Constant.Song69);
        songsList.add(Constant.Song70);

        songsList.add(Constant.Song71);
        songsList.add(Constant.Song72);
        songsList.add(Constant.Song73);
        songsList.add(Constant.Song74);
        songsList.add(Constant.Song75);
        songsList.add(Constant.Song76);
        songsList.add(Constant.Song77);
        songsList.add(Constant.Song78);
        songsList.add(Constant.Song79);
        songsList.add(Constant.Song80);

        songsList.add(Constant.Song81);
        songsList.add(Constant.Song82);
        songsList.add(Constant.Song83);
        songsList.add(Constant.Song84);
        songsList.add(Constant.Song85);
        songsList.add(Constant.Song86);
        songsList.add(Constant.Song87);
        songsList.add(Constant.Song88);
        songsList.add(Constant.Song89);
        songsList.add(Constant.Song90);

        songsList.add(Constant.Song91);
        songsList.add(Constant.Song92);
        songsList.add(Constant.Song93);
        songsList.add(Constant.Song94);
        songsList.add(Constant.Song95);
        songsList.add(Constant.Song96);
        songsList.add(Constant.Song97);
        songsList.add(Constant.Song98);
        songsList.add(Constant.Song99);
        songsList.add(Constant.Song100);

        songsList.add(Constant.Song101);
        songsList.add(Constant.Song102);
        songsList.add(Constant.Song103);
        songsList.add(Constant.Song104);
        songsList.add(Constant.Song105);
        songsList.add(Constant.Song106);
        songsList.add(Constant.Song107);
        songsList.add(Constant.Song108);
        songsList.add(Constant.Song109);
        songsList.add(Constant.Song110);

        songsList.add(Constant.Song111);
        songsList.add(Constant.Song112);
        songsList.add(Constant.Song113);
        songsList.add(Constant.Song114);
        songsList.add(Constant.Song115);
        songsList.add(Constant.Song116);
        songsList.add(Constant.Song117);
        songsList.add(Constant.Song118);
        songsList.add(Constant.Song119);
        songsList.add(Constant.Song120);

        songsList.add(Constant.Song121);
        songsList.add(Constant.Song122);
        songsList.add(Constant.Song123);
        songsList.add(Constant.Song124);
        songsList.add(Constant.Song125);
        songsList.add(Constant.Song126);
        songsList.add(Constant.Song127);
        songsList.add(Constant.Song128);
        songsList.add(Constant.Song129);
        songsList.add(Constant.Song130);

        songsList.add(Constant.Song131);
        songsList.add(Constant.Song132);
        songsList.add(Constant.Song133);
        songsList.add(Constant.Song134);
        songsList.add(Constant.Song135);
        songsList.add(Constant.Song136);
        songsList.add(Constant.Song137);
        songsList.add(Constant.Song138);
        songsList.add(Constant.Song139);
        songsList.add(Constant.Song140);

        songsList.add(Constant.Song141);
        songsList.add(Constant.Song142);
        songsList.add(Constant.Song143);
        songsList.add(Constant.Song144);
        songsList.add(Constant.Song145);
        songsList.add(Constant.Song146);
        songsList.add(Constant.Song147);
        songsList.add(Constant.Song148);
        songsList.add(Constant.Song149);
        songsList.add(Constant.Song150);

        songsList.add(Constant.Song151);
        songsList.add(Constant.Song152);
        songsList.add(Constant.Song153);
        songsList.add(Constant.Song154);
        songsList.add(Constant.Song155);
        songsList.add(Constant.Song156);
        songsList.add(Constant.Song157);
        songsList.add(Constant.Song158);
        songsList.add(Constant.Song159);
        songsList.add(Constant.Song160);

        songsList.add(Constant.Song161);
        songsList.add(Constant.Song162);
        songsList.add(Constant.Song163);
        songsList.add(Constant.Song164);
        songsList.add(Constant.Song165);
        songsList.add(Constant.Song166);
        songsList.add(Constant.Song167);
        songsList.add(Constant.Song168);
        songsList.add(Constant.Song169);
        songsList.add(Constant.Song170);

        songsList.add(Constant.Song171);
        songsList.add(Constant.Song172);
        songsList.add(Constant.Song173);
        songsList.add(Constant.Song174);
        songsList.add(Constant.Song175);
        songsList.add(Constant.Song176);
        songsList.add(Constant.Song177);
        songsList.add(Constant.Song178);
        songsList.add(Constant.Song179);
        songsList.add(Constant.Song180);

        songsList.add(Constant.Song181);
        songsList.add(Constant.Song182);
        songsList.add(Constant.Song183);
        songsList.add(Constant.Song184);
        songsList.add(Constant.Song185);
        songsList.add(Constant.Song186);
        songsList.add(Constant.Song187);
        songsList.add(Constant.Song188);
        songsList.add(Constant.Song189);
        songsList.add(Constant.Song190);

        songsList.add(Constant.Song191);
        songsList.add(Constant.Song192);
        songsList.add(Constant.Song193);
        songsList.add(Constant.Song194);
        songsList.add(Constant.Song195);
        songsList.add(Constant.Song196);
        songsList.add(Constant.Song197);
        songsList.add(Constant.Song198);
        songsList.add(Constant.Song199);
        songsList.add(Constant.Song200);

        songsList.add(Constant.Song201);
        songsList.add(Constant.Song202);
        songsList.add(Constant.Song203);
        songsList.add(Constant.Song204);
        songsList.add(Constant.Song205);
        songsList.add(Constant.Song206);
        songsList.add(Constant.Song207);
        songsList.add(Constant.Song208);
        songsList.add(Constant.Song209);
        songsList.add(Constant.Song210);

        songsList.add(Constant.Song211);
        songsList.add(Constant.Song212);
        songsList.add(Constant.Song213);


    }


}
