package jrfeng.player.player;

import android.content.Context;

import java.util.List;

import jrfeng.player.data.Music;
import jrfeng.player.mode.MusicStorage;

interface MusicPlayerController {

    /**
     * 获取 MediaPlayer 的 Session Id。
     *
     * @return MediaPlayer 的 Session Id。
     */
    int getAudioSessionId();

    /**
     * 播放上一首音乐。
     */
    void previous();

    /**
     * 播放下一首音乐。
     */
    void next();

    /**
     * 播放音乐。
     */
    void play();

    /**
     * 播放已加载音乐组的指定序数处的音乐。
     *
     * @param position 要播放的音乐的序数（序数从 0 开始计算）。
     */
    void play(int position);

    void nextButNotPlay();

    /**
     * 加载一个音乐组。
     *
     * @param groupType 组类型。具体请看 {@link jrfeng.player.mode.MusicStorage.GroupType}。
     * @param groupName 组名字。{@link jrfeng.player.mode.MusicStorage} 提供了
     *                  三个默认的值：
     *                  {@link jrfeng.player.mode.MusicStorage#MUSIC_LIST_ALL_MUSIC}、
     *                  {@link jrfeng.player.mode.MusicStorage#MUSIC_LIST_I_LOVE} 、
     *                  {@link jrfeng.player.mode.MusicStorage#MUSIC_LIST_RECENT_PLAY}。
     * @param position  要播放音乐的序数（序数从 0 开始计算）。
     * @param play      是否在加载后立即播放。
     */
    void loadMusicGroup(MusicStorage.GroupType groupType, String groupName, int position, boolean play);

    /**
     * 播放指定音乐组。
     *
     * @param groupType 组类型。
     * @param groupName 组名字。{@link jrfeng.player.mode.MusicStorage} 提供了
     *                  三个默认的值：
     *                  {@link jrfeng.player.mode.MusicStorage#MUSIC_LIST_ALL_MUSIC}、
     *                  {@link jrfeng.player.mode.MusicStorage#MUSIC_LIST_I_LOVE} 、
     *                  {@link jrfeng.player.mode.MusicStorage#MUSIC_LIST_RECENT_PLAY}。
     * @param position  要播放音乐的序数（序数从 0 开始计算）。
     */
    void playMusicGroup(MusicStorage.GroupType groupType, String groupName, int position);

    /**
     * 暂停播放。
     */
    void pause();

    /**
     * 播放/暂停。
     *
     * @see #play()
     * @see #pause()
     */
    void playPause();

    /**
     * 停止播放
     */
    void stop();

    /**
     * 判断是否正在播放音乐。
     *
     * @return 如果正在播放音乐，则返回 true，否则返回 false。
     */
    boolean isPlaying();

    /**
     * 判断是否循环播放。
     *
     * @return 如果是循环播放，则返回 true，否则返回 false。
     */
    boolean isLooping();

    /**
     * 判断播放器是否已经准备好将要播放的音乐。
     *
     * @return 如果已经准备好将要播放的音乐，则返回 true，否则返回 false。
     */
    boolean isPrepared();

    /**
     * 获取正在播放的音乐。
     *
     * @return 正在播放的音乐。
     */
    Music getPlayingMusic();

    /**
     * 获取正在播放的音乐在已加载的音乐组中的序数（序数从 0 开始计算）。
     *
     * @return 正在播放的音乐的序数。
     */
    int getPlayingMusicIndex();

    /**
     * 获取正在播放的音乐组。
     *
     * @return 正在播放的音乐组。如果没有正在播放的音乐组，则返回 null（一般
     * 只会在一首音乐也不存在的情况下返回 null）。
     */
    List<Music> getPlayingMusicGroup();

    /**
     * 获取正在播放的音乐组的类型。
     *
     * @return 正在播放的音乐组的类型 {@link jrfeng.player.mode.MusicStorage.GroupType}。
     */
    MusicStorage.GroupType getPlayingMusicGroupType();

    /**
     * 获取已加载的音乐组的名字。
     *
     * @return 已加载的音乐组的名字。
     */
    String getPlayingMusicGroupName();

    /**
     * 获取 “最近播放” 历史记录列表。{@link MusicStorage} 也提供了一个
     * 类似的方法：{@link MusicStorage#getRecentPlay()}。
     *
     * @return “最近播放” 历史记录列表。
     */
    List<Music> getRecentPlayList();

    /**
     * 获取 “最近播放” 历史记录列表的大小。{@link MusicStorage} 也提供了一个
     * 类似的方法：{@link MusicStorage#getRecentPlayCount()}。
     *
     * @return “最近播放” 历史记录列表的大小。
     */
    int getRecentPlayCount();

    /**
     * 设置播放器的播放器的播放模式。
     * 共有 3 中模式：
     * 1. 顺序播放；
     * 2. 循环播放；
     * 3. 随机播放。
     *
     * @param mode 播放模式 {@link jrfeng.player.player.MusicPlayerClient.PlayMode}。
     * @return 如果设置成功，则返回 true，否则返回 false。
     */
    boolean setPlayMode(MusicPlayerClient.PlayMode mode);

    /**
     * 获取播放器的播放模式 {@link jrfeng.player.player.MusicPlayerClient.PlayMode}。
     * 共有 3 中模式：
     * 1. 顺序播放 {@link jrfeng.player.player.MusicPlayerClient.PlayMode#MODE_ORDER}；
     * 2. 循环播放 {@link jrfeng.player.player.MusicPlayerClient.PlayMode#MODE_LOOP}；
     * 3. 随机播放 {@link jrfeng.player.player.MusicPlayerClient.PlayMode#MODE_RANDOM}。
     *
     * @return 播放器的播放模式。
     */
    MusicPlayerClient.PlayMode getPlayMode();

    /**
     * 添加音乐到 “临时播” 列表。
     *
     * @param music 要添加到 “临时播” 列表的音乐。
     */
    void addTempPlayMusic(Music music);

    /**
     * 添加一组音乐到 “临时播” 列表。
     *
     * @param musics 要添加到 “临时播” 列表的音乐。
     */
    void addTempPlayMusics(List<Music> musics);

    /**
     * 判断当前是否正在播放 “临时播” 列表中的音乐。
     *
     * @return 如果正在播放 “临时播” 列表中的音乐则返回 true，否则返回 false。
     */
    boolean isPlayingTempMusic();

    /**
     * 调整播放器的播放进度。
     *
     * @param msec 要跳到的时间点（单位：毫秒）。如果播放器还未准备好，调用该方法是无效的。
     *             应该在播放器准备好以后再调用该方法 {@link #isPrepared()}。
     */
    void seekTo(int msec);

    /**
     * 获取正在播放音乐的时长（单位：毫秒）。
     *
     * @return 正在播放音乐的时长（单位：毫秒）。如果播放器还未准备好，则会返回 0。
     * 应该在播放器准备好以后再调用该方法 {@link #isPrepared()}。
     */
    int getMusicLength();

    /**
     * 获取音乐的播放进度。
     *
     * @return 音乐的播放进度（单位：毫秒）。如果播放器还未准备好，则会返回 0。
     * 应该在播放器准备好以后再调用该方法 {@link #isPrepared()}。
     */
    int getMusicProgress();

    /**
     * 关闭播放器。注意！这会关闭整个应用！
     *
     * @param context Context 对象。
     */
    void shutdown(Context context);

    /**
     * 添加播放器播放进度监听器。当播放音乐时，播放器会每隔 1 秒向进度监听器
     * 发送通知，广播当前音乐的播放进度。播放器处于暂停/停止状态时会自动停止
     * 向监听器发送通知。
     *
     * @param listener 要添加的播放器播放进度监听器。
     * @see #removeMusicProgressListener(MusicPlayerClient.PlayerProgressListener)
     */
    void addMusicProgressListener(MusicPlayerClient.PlayerProgressListener listener);

    /**
     * 移除播放器播放进度监听器。
     *
     * @param listener 要移除的播放器播放进度监听器。
     * @see #addMusicProgressListener(MusicPlayerClient.PlayerProgressListener)
     */
    void removeMusicProgressListener(MusicPlayerClient.PlayerProgressListener listener);

    /**
     * 获取 “临时播” 列表。
     *
     * @return “临时播” 列表。
     */
    List<Music> getTempList();

    /**
     * 获取 “临时播” 列表中所有音乐的名字。
     *
     * @return “临时播” 列表中所有音乐的名字。
     */
    List<String> getTempListMusicNames();

    /**
     * 清空 “临时播” 列表。
     */
    void clearTempList();

    /**
     * 判断 “临时播” 列表是否为空。
     *
     * @return 如果 “临时播” 列表为空，则返回 true，否则返回 false。
     */
    boolean tempListIsEmpty();

    /**
     * 播放 “临时播” 列表指定位置处的音乐。
     *
     * @param position 要播放的音乐的位置。
     * @param autoPlay 是否自动播放。如果为 true，则会在音乐准备好后
     *                 自动播放，否则不会自动播放。
     */
    void playTempMusic(int position, boolean autoPlay);

    /**
     * 该接口是为 播放器 Service 准备的（例如 {@link MusicPlayerService} 类），用来对其进行初始化。
     */
    interface MustInitialize {
        void init(MusicStorage musicStorage);
    }
}
