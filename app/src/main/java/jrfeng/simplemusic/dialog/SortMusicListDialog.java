package jrfeng.simplemusic.dialog;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import jrfeng.player.mode.MusicStorage;
import jrfeng.player.player.MusicPlayerClient;
import jrfeng.player.utils.sort.MusicComparator;
import jrfeng.simplemusic.R;
import jrfeng.simplemusic.widget.TopMenuDialog;

public class SortMusicListDialog {
    private SortMusicListDialog() {
    }

    public static void show(final Activity activity, final String musicListName) {
        TopMenuDialog sortMenu = new TopMenuDialog(activity, R.menu.music_list_sort, new TopMenuDialog.OnItemClickListener() {
            @Override
            public void onItemClick(MenuItem item) {
                final int itemId = item.getItemId();
                new AsyncTask<Void, Void, Void>() {

                    @Override
                    protected Void doInBackground(Void... voids) {
                        //调试
                        long start = System.currentTimeMillis();
                        MusicStorage musicStorage = MusicPlayerClient.getInstance().getMusicStorage();
                        switch (itemId) {
                            case R.id.sortByName:
                                musicStorage.sortMusicList(musicListName, MusicComparator.BY_NAME);
                                break;
                            case R.id.sortByNameReverse:
                                musicStorage.sortMusicList(musicListName, MusicComparator.BY_NAME_REVERSE);
                                break;
                            case R.id.sortByArtist:
                                musicStorage.sortMusicList(musicListName, MusicComparator.BY_ARTIST);
                                break;
                            case R.id.sortByArtistReverse:
                                musicStorage.sortMusicList(musicListName, MusicComparator.BY_ARTIST_REVERSE);
                                break;
                        }

                        //调试
                        long end = System.currentTimeMillis();
                        Log.d("Sort", "耗时 : " + (end - start));
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void aVoid) {
                        super.onPostExecute(aVoid);
                        Toast.makeText(activity, "排序完成", Toast.LENGTH_SHORT).show();
                    }
                }.execute();
            }
        });

        sortMenu.show(activity);
    }
}
