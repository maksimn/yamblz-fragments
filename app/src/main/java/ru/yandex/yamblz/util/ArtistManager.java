package ru.yandex.yamblz.util;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import ru.yandex.yamblz.R;
import ru.yandex.yamblz.models.Artist;

public class ArtistManager {
    private static List<Artist> smArtistList;

    public ArtistManager(Context context) {
        if (smArtistList == null) {
            Type listType = new TypeToken<ArrayList<Artist>>(){}.getType();
            String json = ResourceManager.readToString(context.getResources(),
                    R.raw.some_app_data);

            smArtistList = new Gson().fromJson(json, listType);
        }
    }

    public List<Artist> getArtistList() {
        return smArtistList;
    }

    public Artist getArtist(int index) {
        return smArtistList.get(index);
    }
}
