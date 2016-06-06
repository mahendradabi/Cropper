package croppertest.com.cropper;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.edmodo.cropper.CropImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CropImageView cropImageView;
    ImageView cr;
    private ImageView bdefault, borignal, boneone, bthfour, bfsix, bfseven, bsten, beten, bnsixteen;
    int selected_img[] = {R.drawable.crop_custom_selected,
            R.drawable.crop_og_selected,
            R.drawable.crop_1_1_selected,
            R.drawable.crop_3_4_selected
            , R.drawable.crop_4_6_selected,
            R.drawable.crop_5_7_selected,
            R.drawable.crop_6_10_selected,
            R.drawable.crop_8_10_selected,
            R.drawable.crop_9_16_selected};

    int unselected_img[] = {R.drawable.crop_custom_default,
            R.drawable.crop_og_default,
            R.drawable.crop_1_1_default,
            R.drawable.crop_3_4_default
            , R.drawable.crop_4_6_default,
            R.drawable.crop_5_7_default,
            R.drawable.crop_6_10_default,
            R.drawable.crop_8_10_default,
            R.drawable.crop_9_16_default};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button crop = (Button) findViewById(R.id.crop);

        bdefault = (ImageView) findViewById(R.id.bdefault);
        borignal = (ImageView) findViewById(R.id.borignal);
        boneone = (ImageView) findViewById(R.id.boneone);
        bthfour = (ImageView) findViewById(R.id.bthfour);
        bfsix = (ImageView) findViewById(R.id.bfsix);
        bfseven = (ImageView) findViewById(R.id.bfseven);
        bsten = (ImageView) findViewById(R.id.bsten);
        beten = (ImageView) findViewById(R.id.beten);
        bnsixteen = (ImageView) findViewById(R.id.bnsixteen);

        bdefault.setOnClickListener(this);
        borignal.setOnClickListener(this);
        boneone.setOnClickListener(this);
        bthfour.setOnClickListener(this);
        bfsix.setOnClickListener(this);
        bfseven.setOnClickListener(this);
        bsten.setOnClickListener(this);
        beten.setOnClickListener(this);
        bnsixteen.setOnClickListener(this);
        cr = (ImageView) findViewById(R.id.caroppedimage);
        cropImageView = (CropImageView) findViewById(R.id.CropImageView);
        cropImageView.setFixedAspectRatio(false);
        cropImageView.setGuidelines(1);
        cropImageView.setImageResource(R.drawable.image);
        bdefault.setImageResource(selected_img[0]);

        crop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cr.setImageBitmap(cropImageView.getCroppedImage());
            }
        });


    }

    @Override
    public void onClick(View v) {

        clearPrevoiusSelected();

        switch (v.getId()) {
            case R.id.bdefault:
                cropImageView.setImageResource(R.drawable.image);
                cropImageView.setFixedAspectRatio(false);
                bdefault.setImageResource(selected_img[0]);

                break;
            case R.id.borignal:

                //  cr.setImageResource(R.drawable.image);
                cropImageView.setImageResource(R.drawable.image);
                cropImageView.setFixedAspectRatio(false);
                cropImageView.setGuidelines(0);
                borignal.setImageResource(selected_img[1]);
                origanlImageMessage();

                // changeImage(100,100);
                break;
            case R.id.boneone:
                changeImage(1, 1);
                boneone.setImageResource(selected_img[2]);
                break;
            case R.id.bthfour:
                changeImage(3, 4);
                bthfour.setImageResource(selected_img[3]);
                break;
            case R.id.bfsix:
                changeImage(4, 6);
                bfsix.setImageResource(selected_img[4]);
                break;
            case R.id.bfseven:
                changeImage(5, 7);
                bfseven.setImageResource(selected_img[5]);
                break;
            case R.id.bsten:
                changeImage(6, 10);
                bsten.setImageResource(selected_img[6]);
                break;
            case R.id.beten:
                changeImage(8, 10);
                beten.setImageResource(selected_img[7]);
                break;
            case R.id.bnsixteen:
                changeImage(9, 16);
                bnsixteen.setImageResource(selected_img[8]);
                break;

        }
    }

    void changeImage(int x, int y) {
        cropImageView.setImageResource(R.drawable.image);
        cropImageView.setFixedAspectRatio(true);
        cropImageView.setGuidelines(1);
        cropImageView.setAspectRatio(x, y);
    }

    void clearPrevoiusSelected() {
        bdefault.setImageResource(unselected_img[0]);
        borignal.setImageResource(unselected_img[1]);
        boneone.setImageResource(unselected_img[2]);
        bthfour.setImageResource(unselected_img[3]);
        bfsix.setImageResource(unselected_img[4]);
        bfseven.setImageResource(unselected_img[5]);
        bsten.setImageResource(unselected_img[6]);
        beten.setImageResource(unselected_img[7]);
        bnsixteen.setImageResource(unselected_img[8]);
    }

    void origanlImageMessage() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Orignal Image");
        alert.setMessage("Do you want to continue");
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }
}
