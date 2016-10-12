package com.cmsc355.curry_crackers_cats.booktrade;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;



public class TakePicUploadPic extends Activity {

    private int cameraopen = 0;
    private int choosefile = 1;
    private Button buttonSelect;
    private ImageView Image;
    private String UserSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_pic_upload_pic);
        buttonSelect = (Button) findViewById(R.id.buttonSelectPhoto);
        buttonSelect.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                chooseanImage();
            }
        });
        Image = (ImageView) findViewById(R.id.ivImage);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case Utility.MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if(UserSelect.equals("Take Picture"))
                        cameraIntent();
                    else if(UserSelect.equals("Choose from Gallery"))
                        galleryIntent();
                } else {

                }
                break;
        }
    }

    private void chooseanImage() {
        final CharSequence[] items = { "Take A Picture", "Choose from Gallery",
                "Cancel" };

        AlertDialog.Builder bld = new AlertDialog.Builder(TakePicUploadPic.this);
        bld.setTitle("Select A Picture");
        bld.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int list) {
                boolean output=Utility.checkPermission(TakePicUploadPic.this);

                if (items[list].equals("Take A Picture")) {
                    UserSelect ="Take A Picture";
                    if(output)
                        cameraIntent();

                } else if (items[list].equals("Choose from Gallery")) {
                    UserSelect ="Choose from Gallery";
                    if(output)
                        galleryIntent();

                } else if (items[list].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        bld.show();
    }
    private void galleryIntent()
    {
        Intent purp = new Intent();
        purp.setType("image/*");
        purp.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(purp, "Select a Picture"),choosefile);
    }
    private void cameraIntent()
    {
        Intent purp2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(purp2, cameraopen);
    }


    @Override
    public void onActivityResult(int reqCode, int resCode, Intent data) {
        super.onActivityResult(reqCode, resCode, data);

        if (resCode == Activity.RESULT_OK) {
            if (reqCode == choosefile)
                onSelectFromGalleryResult(data);
            else if (reqCode == cameraopen)
                onCaptureImageResult(data);
        }
    }
    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);

        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");

        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image.setImageBitmap(thumbnail);
    }



    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {

        Bitmap bit=null;
        if (data != null) {
            try {
                bit = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Image.setImageBitmap(bit);
    }
}

