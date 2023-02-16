package com.example.otakufourever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class game_page extends AppCompatActivity {

    private TextView tvScore;
    private TextView tvNomFruit;
    private ImageView imgvFruit1;
    private ImageView imgvFruit2;
    private ImageView imgvFruit3;
    private ImageView imgvFruit4;

    ArrayList<String> nomFruitsList = new ArrayList<>();
    int indexImageInImgv1 = -1;
    int indexImageInImgv2 = -1;
    int indexImageInImgv3 = -1;
    int indexImageInImgv4 = -1;

    int positionBonneReponse = 0;
    int score = 0;
    int nbrEchec=0;

    int[] idImageFruitsList = {
            R.mipmap.akaza,
            R.mipmap.allmight,
            R.mipmap.armin,
            R.mipmap.baji,
            R.mipmap.beerus,
            R.mipmap.blackgoku,
            R.mipmap.bulma,
            R.mipmap.buu,
            R.mipmap.chifuyu,
            R.mipmap.deku,
            R.mipmap.draken,
            R.mipmap.endevor,
            R.mipmap.eraserhead,
            R.mipmap.eren,
            R.mipmap.freezer,
            R.mipmap.fumikage,
            R.mipmap.gohan,
            R.mipmap.goku,
            R.mipmap.gyomei,
            R.mipmap.hashirama,
            R.mipmap.inosuke,
            R.mipmap.jean,
            R.mipmap.jiren,
            R.mipmap.kakashi,
            R.mipmap.kaneki,
            R.mipmap.katchan,
            R.mipmap.kazutora,
            R.mipmap.kokushibo,
            R.mipmap.kyojuro,
            R.mipmap.levi,
            R.mipmap.madara,
            R.mipmap.mikasa,
            R.mipmap.mikey,
            R.mipmap.minato,
            R.mipmap.muzan,
            R.mipmap.naruto,
            R.mipmap.sakura,
            R.mipmap.sanemi,
            R.mipmap.sasuke,
            R.mipmap.shoto,
            R.mipmap.takemichi,
            R.mipmap.tanjiro,
            R.mipmap.tobirama,
            R.mipmap.tomioka,
            R.mipmap.tomura,
            R.mipmap.trunks,
            R.mipmap.tsunade,
            R.mipmap.vegeta,
            R.mipmap.zenitsu

    };


    Context context;

    MediaPlayer backgroudPlayer;
    MediaPlayer winPlayer;
    MediaPlayer lostPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);


        initView();
        context = this;

        backgroudPlayer =MediaPlayer.create(context, R.raw.bluebird);
        backgroudPlayer.start();



        nomFruitsList.add("Akaza");
        nomFruitsList.add("All Might");
        nomFruitsList.add("Armin");
        nomFruitsList.add("Baji");
        nomFruitsList.add("Beerus");
        nomFruitsList.add("Black Goku");
        nomFruitsList.add("Bulma");
        nomFruitsList.add("Buu");
        nomFruitsList.add("Chifuyu");
        nomFruitsList.add("Deku");
        nomFruitsList.add("Draken");
        nomFruitsList.add("Endevor");
        nomFruitsList.add("Eraser Head");
        nomFruitsList.add("Eren");
        nomFruitsList.add("Freezer");
        nomFruitsList.add("Fumikage");
        nomFruitsList.add("Gohan");
        nomFruitsList.add("Goku");
        nomFruitsList.add("Gyomei");
        nomFruitsList.add("Hashirama");
        nomFruitsList.add("Inosuke");
        nomFruitsList.add("Jean");
        nomFruitsList.add("Jiren");
        nomFruitsList.add("Kakashi");
        nomFruitsList.add("Kaneki Ken");
        nomFruitsList.add("Katchan");
        nomFruitsList.add("Kazutora");
        nomFruitsList.add("Kokushibo");
        nomFruitsList.add("Kyojuro");
        nomFruitsList.add("Leviiii");
        nomFruitsList.add("Madara the Best");
        nomFruitsList.add("Mikassa");
        nomFruitsList.add("Mikey");
        nomFruitsList.add("Minato");
        nomFruitsList.add("Muzan");
        nomFruitsList.add("Naruto");
        nomFruitsList.add("Sakura");
        nomFruitsList.add("Sanemi");
        nomFruitsList.add("Sasuke");
        nomFruitsList.add("Shoto");
        nomFruitsList.add("Takemichou");
        nomFruitsList.add("Tanjiro");
        nomFruitsList.add("Tobirama");
        nomFruitsList.add("Tomioka");
        nomFruitsList.add("Tomura");
        nomFruitsList.add("Trunks");
        nomFruitsList.add("Tsunade");
        nomFruitsList.add("Vegeta");
        nomFruitsList.add("Zeinitsu");


        generateFruit();

        imgvFruit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                verification(1);

            }
        });

        imgvFruit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                verification(2);
            }
        });

        imgvFruit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                verification(3);
            }
        });

        imgvFruit4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                verification(4);
            }
        });

    }

    void generateFruit() {
        Random random = new Random();
        int index = random.nextInt(nomFruitsList.size());
        tvNomFruit.setText(nomFruitsList.get(index));


        positionBonneReponse = random.nextInt(4) + 1;
        if (positionBonneReponse == 1) {
            imgvFruit1.setImageResource(idImageFruitsList[index]);
            indexImageInImgv1 = index;
            genarateImage(imgvFruit2);
            genarateImage(imgvFruit3);
            genarateImage(imgvFruit4);
        } else if (positionBonneReponse == 2) {
            imgvFruit2.setImageResource(idImageFruitsList[index]);
            indexImageInImgv2 = index;
            genarateImage(imgvFruit1);
            genarateImage(imgvFruit3);
            genarateImage(imgvFruit4);
        } else if (positionBonneReponse == 3) {
            imgvFruit3.setImageResource(idImageFruitsList[index]);
            indexImageInImgv3 = index;
            genarateImage(imgvFruit1);
            genarateImage(imgvFruit2);
            genarateImage(imgvFruit4);
        } else if (positionBonneReponse == 4) {
            imgvFruit4.setImageResource(idImageFruitsList[index]);
            indexImageInImgv4 = index;
            genarateImage(imgvFruit1);
            genarateImage(imgvFruit2);
            genarateImage(imgvFruit3);
        }
        //imgvFruit1.setImageResource(idImageFruitsList[index]);

    }

    void genarateImage(ImageView imgv) {
        int index = -1;
        do {
            Random random = new Random();
            index = random.nextInt(idImageFruitsList.length);
        } while (index == indexImageInImgv1 || index == indexImageInImgv2 || index == indexImageInImgv3 || index == indexImageInImgv4);


        if (imgv == imgvFruit1) {
            indexImageInImgv1 = index;
        } else if (imgv == imgvFruit2) {
            indexImageInImgv2 = index;
        } else if (imgv == imgvFruit3) {
            indexImageInImgv3 = index;
        } else if (imgv == imgvFruit4) {
            indexImageInImgv4 = index;
        }

        imgv.setImageResource(idImageFruitsList[index]);

    }

    void verification(int positionClicked) {

        if (positionBonneReponse == positionClicked) {
            score += 10;
            winPlayer = MediaPlayer.create(context, R.raw.win);
            winPlayer.start();
            Toast.makeText(context, "Gagné", Toast.LENGTH_SHORT).show();

        } else {
            score -= 5;
            nbrEchec++;
            lostPlayer = MediaPlayer.create(context, R.raw.lost);
            lostPlayer.start();
            Toast.makeText(context, "Perdu", Toast.LENGTH_SHORT).show();

        }
        tvScore.setText("Score : " + String.valueOf(score));
        if(nbrEchec<3){
            generateFruit();

        }else{
            backgroudPlayer.stop();
            startActivity(new Intent(game_page.this, game_over.class));
        }
    }

    private void initView() {
        tvScore = (TextView) findViewById(R.id.tv_score);
        tvNomFruit = (TextView) findViewById(R.id.tv_nom_fruit);
        imgvFruit1 = (ImageView) findViewById(R.id.imgv_fruit1);
        imgvFruit2 = (ImageView) findViewById(R.id.imgv_fruit2);
        imgvFruit3 = (ImageView) findViewById(R.id.imgv_fruit3);
        imgvFruit4 = (ImageView) findViewById(R.id.imgv_fruit4);
    }
}