package com.example.finalexam;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {
    String countrylist[]={"All","Canada","USA","England"};
    ArrayList<Places> plclist=new ArrayList<>();
    ArrayList<Places>tempList=new ArrayList<>();
    ArrayList<String>tempNames=new ArrayList<>();
    ArrayList<String>tempCost=new ArrayList<>();
    Spinner cnames;
    ListView cdetails;
    EditText vnumber;
    TextView total;
    Button select;
    String plctitle,plcost,noofvis;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        cnames=findViewById(R.id.country);
        cdetails=findViewById(R.id.lv_cdetails);
        vnumber=findViewById(R.id.ext_visitors);
        total=findViewById(R.id.tv_total);
        select=findViewById(R.id.button);
        fillData();
        ArrayAdapter aa1=new ArrayAdapter(this, R.layout.spinnerdes,countrylist);
        cnames.setAdapter(aa1);
        cdetails.setAdapter(new PlacesAdapter(this,plclist));
        fillTemp(countrylist[0]);
        cnames.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    index=0;
                    cdetails.setAdapter(new PlacesAdapter(DetailsActivity.this,plclist));
                }
                else {
                    fillTemp(countrylist[i]);
                    cdetails.setAdapter(new PlacesAdapter(DetailsActivity.this,tempList));
                    index=i;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        cdetails.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(index==0)
                {
                    plctitle=plclist.get(i).getPois();
                    plcost=String.valueOf(plclist.get(i).getLiving_cost());

                }
                else
                {
                    plctitle=tempList.get(i).getPois();
                    plcost=String.valueOf(tempList.get(i).getLiving_cost());
                }
            }
        });
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noofvis =vnumber.getText().toString();

                if(noofvis.isEmpty())
                {
                    Toast.makeText(DetailsActivity.this,"Enter Number",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Log.d("tempNames",tempNames.toString());
                    if(tempNames.contains(plctitle))
                    {//tempList.get(index).getPois()
                        Toast.makeText(DetailsActivity.this,"You have already added place",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        tempNames.add(plctitle);
                        tempCost.add(plcost);
                        Log.d("tempNames",tempNames.toString());
                        Log.d("tempCost",tempCost.toString());
                        calculateCost();
                    }

                }

            }
        });
    }

    public void fillData(){
        plclist.add(new Places(countrylist[1], "Ottawa","Niagara falls", 100,R.drawable.canada,R.drawable.nf));
        plclist.add(new Places(countrylist[1], "Ottawa","CN Tower", 30,R.drawable.canada,R.drawable.cn));
        plclist.add(new Places(countrylist[1], "Ottawa","The Butchart Gardens", 30,R.drawable.canada,R.drawable.b1));
        plclist.add(new Places(countrylist[1], "Ottawa","Notre-Dame Basilica", 50,R.drawable.canada,R.drawable.nd));
        plclist.add(new Places(countrylist[2], "Washington","The Statue of Liberty", 90,R.drawable.usa,R.drawable.tsl));
        plclist.add(new Places(countrylist[2], "Washington","The White House", 60,R.drawable.usa,R.drawable.wh));
        plclist.add(new Places(countrylist[2], "Washington","Times Square", 75,R.drawable.usa,R.drawable.ts));
        plclist.add(new Places(countrylist[3], "London","Big Ben", 30,R.drawable.eng,R.drawable.bb));
        plclist.add(new Places(countrylist[3], "London","Westminster Abbey", 25,R.drawable.eng,R.drawable.wa));
        plclist.add(new Places(countrylist[3], "London","Hyde Park", 15,R.drawable.eng,R.drawable.hp));

    }

    public void fillTemp(String cat)
    {
        tempList.clear();//remove all items in the temp list
        tempNames.clear();
        tempCost.clear();
        for(Places prd:plclist)
            if(prd.getCategory().equals(cat)) {
                tempList.add(prd);
                tempNames.add(prd.getPois());
                tempCost.add(String.valueOf(prd.getLiving_cost()));
            }
    }

    public void calculateCost(){
        double totalCost = 0;
        Boolean applyDiscount = Double.parseDouble(noofvis) > 15 ? true: false;
        for(int i=0; i < this.tempCost.size(); i++){
            totalCost += Double.parseDouble(this.tempCost.get(i)) * Double.parseDouble(noofvis);
        }
        if(applyDiscount){
            totalCost *= 0.95;
        }
        total.setText("" + totalCost);
    }
    /*
    public static void addToCart(Places location, int noOfPeople){
        String key = location.getCategory() +"-"+ location.getPois();
        Integer count = currentCartMap.get(key);
        if (count == null) {
            currentCartMap.put(key, noOfPeople);
        }
        else {
            currentCartMap.put(key, count + noOfPeople);
        }

    }
    private static double getPlaceCost(String key){
        String[] keySplit = key.split("-");
        String country = keySplit[0];
        String location = keySplit[1];
        for (Places locationtemp: plclist) {
            if(country.equals(locationtemp.getCategory()) && location.equals(locationtemp.getPois())){
                return locationtemp.getLiving_cost();
            }
        }

        return 0;
    }*/

}
