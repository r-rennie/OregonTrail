/*
File Name: MainActivity.java
Date: April 4th, 2023
Author(s): Lila Baxter, Maria Lyons, Daniel MacDonald, Rachael Rennie
Description: This is the main activity class that implements all of the methods/classes for the game
 */

package com.example.mp2_mvp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity  {
    private ListView inventoryListView;
    private Button addButton;
    private EditText itemEdt;
    private ArrayList<String> invList;
    private Button removeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // on below line we are initializing our variables.
        inventoryListView = findViewById(R.id.inventoryListView);
        addButton = findViewById(R.id.addButton);
        removeButton = findViewById(R.id.removeButton);
        itemEdt = findViewById(R.id.InventoryEdit);
        invList = new ArrayList<>();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, invList);

        inventoryListView.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = itemEdt.getText().toString();

                if (!item.isEmpty()) {
                    invList.add(item);
                    adapter.notifyDataSetChanged();
                }

            }
        });
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = itemEdt.getText().toString();

                if (!item.isEmpty()) {
                    invList.remove(item);
                    adapter.notifyDataSetChanged();
                }
            }
        });
        // GUI variables for buttons, images, and text
        final TextView text = findViewById(R.id.textBox);
        final EditText userInput = findViewById(R.id.editTextInput);
        final EditText nameInput = findViewById(R.id.editTextNameInput);
        final EditText inventoryEdit = findViewById(R.id.InventoryEdit);
        final Button startEnter = findViewById(R.id.enterButton1);
        final Button nameEnter = findViewById(R.id.enterButton2);
        final Button startButton = findViewById(R.id.startButton);
        final Button nextDayButton = findViewById(R.id.nextDay);
        final Button inventoryButton = findViewById(R.id.inventoryButton);
        final Button backButton = findViewById(R.id.backButton);
        final TextView dateBox = findViewById(R.id.date);
        final TextView locationBox = findViewById(R.id.location);
        final TextView hattieStats = findViewById(R.id.hattieStats);
        final TextView p2Stats = findViewById(R.id.p2Stats);
        final TextView p3Stats = findViewById(R.id.p3Stats);
        final TextView p4Stats = findViewById(R.id.p4Stats);
        final TextView p5Stats = findViewById(R.id.p5Stats);
        final TextView healthBox = findViewById(R.id.groupHealth);
        final TextView foodBox = findViewById(R.id.foodBox);
        final TextView randomEvent = findViewById(R.id.randomEventText);
        final ImageView hattie_img = findViewById(R.id.hattieImg);
        final TextView climateStats = findViewById(R.id.climateStats);
        final ListView inventoryListView = findViewById(R.id.inventoryListView);
        final RelativeLayout inventoryDisplay = findViewById(R.id.idRLContainer);


        final Entities[] entities = new Entities[5];

        //===================================================START GAME========================================================

        startEnter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                userInput.setVisibility(View.GONE);
                nameInput.setVisibility(View.VISIBLE);
                nameInput.setHint("Enter names here - press ENTER in between");
                startEnter.setVisibility(View.GONE);
                nameEnter.setVisibility(View.VISIBLE);
                text.setText("Your name is Hattie Campbell.\nWhat are the names of the other members in your party?\n     1. Hattie");

                entities[0] = new Entities(0, "Hattie");

                nameEnter.setOnClickListener(new View.OnClickListener() {
                    int entityCount = 1;

                    public void onClick(View v) {
                        entityCount++;
                        if (entityCount > 5) {
                            nameInput.setVisibility(View.GONE);
                            nameEnter.setVisibility(View.GONE);
                            text.setVisibility(View.GONE);
                            startButton.setVisibility(View.VISIBLE);
                            return;
                        } else {
                            String name = nameInput.getText().toString();
                            entities[entityCount - 1] = new Entities(entityCount, name);
                            text.setText(text.getText() + "\n     " + entityCount + ". " + name);
                        }
                    }
                });
            }
        });

        //===================================================GAME========================================================

        // Start of the game

        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                System.out.println(Arrays.toString(entities));
                startButton.setVisibility(View.GONE);
                nextDayButton.setVisibility(View.VISIBLE);
                dateBox.setVisibility(View.VISIBLE);
                locationBox.setVisibility(View.VISIBLE);
                climateStats.setVisibility(View.VISIBLE);
                hattieStats.setVisibility(View.VISIBLE);
                p2Stats.setVisibility(View.VISIBLE);
                p3Stats.setVisibility(View.VISIBLE);
                p4Stats.setVisibility(View.VISIBLE);
                p5Stats.setVisibility(View.VISIBLE);
                healthBox.setVisibility(View.VISIBLE);
                foodBox.setVisibility(View.VISIBLE);
                hattie_img.setVisibility(View.VISIBLE);
                randomEvent.setVisibility(View.INVISIBLE);
                inventoryButton.setVisibility(View.VISIBLE);
                // Sets the generic game info
                Date currentDate = new Date(5, 1, 1850);
                Inventory.addSupplies(2, 2000);
                Entities.setFoodRations(3);
                Entities.setPace(3);

                Location[] locations = new Location[5];

                // creates the locations
                locations[0] = new Location(0, 1, "Independence, Missouri");
                locations[1] = new Fort(35, 2, "Fort Leavenworth");
                locations[2] = new River(105, 3, "Kansas River Crossing", 5);
                locations[3] = new Fort(335, 4, "Fort Kearny");
                locations[4] = new Location(505, 5, "Ash Hollow, Nebraska");

                dateBox.setText(Date.printDate(currentDate) + " - Days Elapsed: " + Date.getDaysElapsed() + " - Miles Traveled: " + Date.getMilesElapsed());
                locationBox.setText(Location.findLocation(0, locations[0]));
                climateStats.setText("Temperature: " + Weather.getTemperature() + "; Precipitation: " + Weather.getPrecipitation() + "\" of " + Weather.getRainOrSnow());
                hattieStats.setText(Entities.entityName[0] + " Health: " + Entities.getMemberIllness(0) + "; Injury: " + Entities.getMemberInjury(0));
                p2Stats.setText(Entities.entityName[2] + " Health: " + Entities.getMemberIllness(2) + "; Injury: " + Entities.getMemberInjury(2));
                p3Stats.setText(Entities.entityName[3] + " Health: " + Entities.getMemberIllness(3) + "; Injury: " + Entities.getMemberInjury(3));
                p4Stats.setText(Entities.entityName[4] + " Health: " + Entities.getMemberIllness(4) + "; Injury: " + Entities.getMemberInjury(4));
                p5Stats.setText(Entities.entityName[5] + " Health: " + Entities.getMemberIllness(5) + "; Injury: " + Entities.getMemberInjury(5));
                healthBox.setText("Overall Health: " + Entities.getHealth());
                foodBox.setText("Rations: " + Entities.getFoodRations() + "; Food Remaining: " + Inventory.getItemCount(2));


                inventoryButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        nextDayButton.setVisibility(View.GONE);
                        dateBox.setVisibility(View.GONE);
                        locationBox.setVisibility(View.GONE);
                        hattieStats.setVisibility(View.GONE);
                        p2Stats.setVisibility(View.GONE);
                        p3Stats.setVisibility(View.GONE);
                        p4Stats.setVisibility(View.GONE);
                        p5Stats.setVisibility(View.GONE);
                        healthBox.setVisibility(View.GONE);
                        foodBox.setVisibility(View.GONE);
                        randomEvent.setVisibility(View.GONE);
                        hattie_img.setVisibility(View.GONE);
                        text.setVisibility(View.GONE);
                        randomEvent.setVisibility(View.GONE);
                        inventoryButton.setVisibility(View.GONE);
                        removeButton.setVisibility(View.VISIBLE);
                        addButton.setVisibility(View.VISIBLE);
                        inventoryListView.setVisibility(View.VISIBLE);
                        inventoryEdit.setVisibility(View.VISIBLE);
                        inventoryDisplay.setVisibility(View.VISIBLE);



                    }

                });

                backButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        nextDayButton.setVisibility(View.VISIBLE);
                        dateBox.setVisibility(View.VISIBLE);
                        locationBox.setVisibility(View.VISIBLE);
                        hattieStats.setVisibility(View.VISIBLE);
                        p2Stats.setVisibility(View.VISIBLE);
                        p3Stats.setVisibility(View.VISIBLE);
                        p4Stats.setVisibility(View.VISIBLE);
                        p5Stats.setVisibility(View.VISIBLE);
                        healthBox.setVisibility(View.VISIBLE);
                        foodBox.setVisibility(View.VISIBLE);
                        randomEvent.setVisibility(View.VISIBLE);
                        hattie_img.setVisibility(View.VISIBLE);
                        randomEvent.setVisibility(View.VISIBLE);
                        inventoryButton.setVisibility(View.VISIBLE);


                        inventoryDisplay.setVisibility(View.GONE);
                    }
                });

                nextDayButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        Date.nextDay(currentDate);
                        randomEvent.setVisibility(View.INVISIBLE);
                        //what decreases health: food, pace, events
                        System.out.println("Ration damage: " + Entities.getDamageFromRations());
                        // System.out.println("Pace damage: " + Entities.getDamageFromPace());

                        //System.out.println("Event damage: " + Entities.getDamageFromEvent());
                        Entities.healthModifier = Entities.getDamageFromRations(); /* + Entities.getDamageFromPace() + Entities.getDamageFromEvent()*/
                        ;

                        Entities.healthModifier = Entities.getDamageFromRations(); /* + Entities.getDamageFromPace(); */

                        Entities.setHealth(Entities.healthModifier);

                        dateBox.setText(Date.printDate(currentDate) + " - Days Elapsed: " + Date.getDaysElapsed() + " - Miles Traveled: " + Date.getMilesElapsed() + " - Miles per Day: " + Entities.getPace());
                        locationBox.setText(Location.location(Date.getMilesElapsed(), Entities.pace));
                        hattieStats.setText(Entities.entityName[0] + "Health: " + Entities.getMemberIllness(0) + "; Injury: " + Entities.getMemberInjury(0));
                        p2Stats.setText(Entities.entityName[2] + " Health: " + Entities.getMemberIllness(2) + "; Injury: " + Entities.getMemberInjury(2));
                        p3Stats.setText(Entities.entityName[3] + " Health: " + Entities.getMemberIllness(3) + "; Injury: " + Entities.getMemberInjury(3));
                        p4Stats.setText(Entities.entityName[4] + " Health: " + Entities.getMemberIllness(4) + "; Injury: " + Entities.getMemberInjury(4));
                        p5Stats.setText(Entities.entityName[5] + " Health: " + Entities.getMemberIllness(5) + "; Injury: " + Entities.getMemberInjury(5));
                        healthBox.setText("Health: " + Entities.getHealth());
                        Inventory.removeSupplies(2, Entities.foodEaten(Entities.pace));
                        foodBox.setText("Rations: " + Entities.getFoodRations() + "; Food Remaining: " + Inventory.getItemCount(2));

                        /*
                        // Random event generator [OBSOLETE]
                        int chosenEvent = Event.getEvent();
                        int affectedEntity = (int)((Math.random() * 6) + 1);
                        if (chosenEvent == 1 || chosenEvent == 2) {
                           // Event.fallIll(entities[affectedEntity]);
                            randomEvent.setVisibility(View.VISIBLE);
                            randomEvent.setText("Cholera spreads...");
                        } else if (chosenEvent == 3 || chosenEvent == 4) {
                            //Event.recover(entities[affectedEntity]);
                            randomEvent.setText("Recovered.");
                            randomEvent.setVisibility(View.VISIBLE);
                        } else if (chosenEvent == 5 || chosenEvent == 6) {
                           // Event.snakeBite(entities[affectedEntity]);
                            randomEvent.setText("Ouch! Snake Bite");
                            randomEvent.setVisibility(View.VISIBLE);
                        }
                        */

                        if (Location.location(Date.getMilesElapsed(), Entities.pace).equals("Kansas River Crossing")) {

                        }

                        // Ends the game once the final location is reached
                        if (Location.location(Date.getMilesElapsed(), Entities.pace).equals("Ash Hollow, Nebraska")) {
                            nextDayButton.setVisibility(View.GONE);
                            dateBox.setVisibility(View.GONE);
                            locationBox.setVisibility(View.GONE);
                            hattieStats.setVisibility(View.GONE);
                            p2Stats.setVisibility(View.GONE);
                            p3Stats.setVisibility(View.GONE);
                            p4Stats.setVisibility(View.GONE);
                            p5Stats.setVisibility(View.GONE);
                            healthBox.setVisibility(View.GONE);
                            foodBox.setVisibility(View.GONE);
                            randomEvent.setVisibility(View.GONE);
                            hattie_img.setVisibility(View.VISIBLE);
                            text.setVisibility(View.VISIBLE);
                            randomEvent.setVisibility(View.GONE);
                            text.setText("ASH HOLLOW REACHED");
                        }
                    }
                });
            }
        });


        //---------------------------------------------------------------------------------


        // Creating the item array
        Item[] items = new Item[22];

        // Creating the ID for each item in the game
        items[0] = new Item(0, "Coffee", 0.10, 10);
        items[1] = new Item(1, "Flour", 0.02, 10);
        items[2] = new Item(2, "Bacon", 0.05, 10);
        items[3] = new Item(3, "Clothing", 5, 10);
        items[4] = new Item(4, "Rifle", 20, 10);
        items[5] = new Item(5, "Shotgun", 10, 10);
        items[6] = new Item(6, "Shots", 5, 10);
        items[7] = new Item(7, "Oxen", 50, 10);
        items[8] = new Item(8, "Spare Wagon Wheel", 8, 10);
        items[9] = new Item(9, "Spare Axle", 3, 10);
        items[10] = new Item(10, "Spare Wagon Tongue", 3, 10);
        items[11] = new Item(11, "Medical Supply Box", 1.5, 10);
        items[12] = new Item(12, "Sewing Kit", 0.50, 10);
        items[13] = new Item(13, "Fire Starting Kit", 0.25, 10);
        items[14] = new Item(14, "Kids' Toys", 0.05, 10);
        items[15] = new Item(15, "Family Keepsakes", 0, 10);
        items[16] = new Item(16, "Seed Packages", 0.01, 10);
        items[17] = new Item(17, "Shovel", 2.5, 10);
        items[18] = new Item(18, "Coffee Mill", 1, 10);
        items[19] = new Item(19, "Frying Pan", 1.5, 10);
        items[20] = new Item(20, "Pan", 0.25, 10);
        items[21] = new Item(21, "Enchantment Table", 400, 10);


        //---------------------------------------------------------------------------------


    }
}
