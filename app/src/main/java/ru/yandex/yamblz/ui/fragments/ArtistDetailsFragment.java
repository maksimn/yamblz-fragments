package ru.yandex.yamblz.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import ru.yandex.yamblz.R;
import ru.yandex.yamblz.models.Artist;

public class ArtistDetailsFragment extends Fragment {
    private Artist artist;

    private TextView artistNameTextView;
    private TextView yearsOfLifeTextView;
    private TextView descriptionTextView;
    private Button backButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_artist_details, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setViews(view);
        bindDataToViews();

        backButton.setOnClickListener(v -> onBackButtonPress());
    }

    private void setViews(View view) {
        artistNameTextView = (TextView) view.findViewById(R.id.name);
        yearsOfLifeTextView = (TextView) view.findViewById(R.id.yearsOfLife);
        descriptionTextView = (TextView) view.findViewById(R.id.description);
        backButton = (Button) view.findViewById(R.id.backButton);
    }

    private void bindDataToViews() {
        artistNameTextView.setText(artist.artistName);
        yearsOfLifeTextView.setText(artist.deathYear > artist.birthYear ? "(" + artist.birthYear +
                " - " + artist.deathYear + ")" : "born in " + artist.birthYear);
        descriptionTextView.setText(artist.description);
    }

    private void onBackButtonPress() {
        getFragmentManager().popBackStack();
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
