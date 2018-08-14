package ru.yandex.yamblz.ui.fragments;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import ru.yandex.yamblz.R;
import ru.yandex.yamblz.models.Artist;
import ru.yandex.yamblz.util.ArtistManager;

public class ArtistFragment extends Fragment {
    private int artistIndex;

    public ArtistFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_artist, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get Artist data for the app:
        ArtistManager artistManager = new ArtistManager(this.getContext());
        Artist artist = artistManager.getArtist(artistIndex);

        showArtistDataInView(view, artist);

        // Set more button click handler:
        Button moreButton = (Button) view.findViewById(R.id.moreButton);
        moreButton.setOnClickListener(v -> showArtistDetailsFragment());
    }

    public void setArtistIndex(int index) {
        artistIndex = index;
    }

    private void showArtistDataInView(View view, Artist artist) {
        ImageView artistPhotoImageView = (ImageView) view.findViewById(R.id.artistPhoto);
        TextView artistNameTextView = (TextView) view.findViewById(R.id.artistName);
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.loadImage(artist.photo, new SimpleImageLoadingListener() {
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                artistNameTextView.setText(artist.artistName);
                artistPhotoImageView.setImageBitmap(loadedImage);
            }
        });
    }

    private void showArtistDetailsFragment() {
        ArtistDetailsFragment artistDetailsFragment = new ArtistDetailsFragment();
        getFragmentManager().beginTransaction()
                .replace(R.id.main_frame_layout, artistDetailsFragment)
                .addToBackStack(null)
                .commit();
    }
}
