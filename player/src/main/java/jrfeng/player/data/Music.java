package jrfeng.player.data;

import java.io.Serializable;

public class Music implements Serializable {
    private static final long serialVersionUID = 1L;
    private String path;        //路径
    private String name;        //歌曲名
    private String artist;      //作者
    private String album;       //专辑
    private String year;        //出品年份
    private String comment;     //备注信息

    public Music(String path, String name, String artist,
                 String album, String year, String comment) {
        this.path = path;
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.year = year;
        this.comment = comment;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public String getYear() {
        return year;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj instanceof Music) {
            Music other = (Music) obj;
            return path.equals(other.getPath());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 20;
        result = result * 31 + path.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "[" + path + ", " +
                name + ", " +
                artist + ", " +
                album + ", " +
                year + ", " +
                comment + "]";
    }
}
