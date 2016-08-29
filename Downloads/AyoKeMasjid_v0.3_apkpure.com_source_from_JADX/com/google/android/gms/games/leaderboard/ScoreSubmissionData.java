package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.internal.constants.TimeSpan;
import java.util.HashMap;

public final class ScoreSubmissionData {
    private static final String[] zzaxr;
    private String zzWn;
    private int zzWu;
    private HashMap<Integer, Result> zzaxX;
    private String zzaxt;

    public static final class Result {
        public final String formattedScore;
        public final boolean newBest;
        public final long rawScore;
        public final String scoreTag;

        public Result(long rawScore, String formattedScore, String scoreTag, boolean newBest) {
            this.rawScore = rawScore;
            this.formattedScore = formattedScore;
            this.scoreTag = scoreTag;
            this.newBest = newBest;
        }

        public String toString() {
            return zzw.zzu(this).zzg("RawScore", Long.valueOf(this.rawScore)).zzg("FormattedScore", this.formattedScore).zzg("ScoreTag", this.scoreTag).zzg("NewBest", Boolean.valueOf(this.newBest)).toString();
        }
    }

    static {
        zzaxr = new String[]{"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};
    }

    public ScoreSubmissionData(DataHolder dataHolder) {
        this.zzWu = dataHolder.getStatusCode();
        this.zzaxX = new HashMap();
        int count = dataHolder.getCount();
        zzx.zzZ(count == 3);
        for (int i = 0; i < count; i++) {
            int zzbo = dataHolder.zzbo(i);
            if (i == 0) {
                this.zzaxt = dataHolder.zzd("leaderboardId", i, zzbo);
                this.zzWn = dataHolder.zzd("playerId", i, zzbo);
            }
            if (dataHolder.zze("hasResult", i, zzbo)) {
                zza(new Result(dataHolder.zzb("rawScore", i, zzbo), dataHolder.zzd("formattedScore", i, zzbo), dataHolder.zzd("scoreTag", i, zzbo), dataHolder.zze("newBest", i, zzbo)), dataHolder.zzc("timeSpan", i, zzbo));
            }
        }
    }

    private void zza(Result result, int i) {
        this.zzaxX.put(Integer.valueOf(i), result);
    }

    public String getLeaderboardId() {
        return this.zzaxt;
    }

    public String getPlayerId() {
        return this.zzWn;
    }

    public Result getScoreResult(int timeSpan) {
        return (Result) this.zzaxX.get(Integer.valueOf(timeSpan));
    }

    public String toString() {
        zza zzg = zzw.zzu(this).zzg("PlayerId", this.zzWn).zzg("StatusCode", Integer.valueOf(this.zzWu));
        for (int i = 0; i < 3; i++) {
            Result result = (Result) this.zzaxX.get(Integer.valueOf(i));
            zzg.zzg("TimesSpan", TimeSpan.zzfQ(i));
            zzg.zzg("Result", result == null ? "null" : result.toString());
        }
        return zzg.toString();
    }
}
