package com.google.android.gms.fitness;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DailyTotalResult;
import com.google.android.gms.fitness.result.DataReadResult;
import java.util.concurrent.TimeUnit;

public interface HistoryApi {

    public static class ViewIntentBuilder {
        private final Context mContext;
        private long zzMS;
        private final DataType zzanl;
        private DataSource zzanm;
        private long zzann;
        private String zzano;

        public ViewIntentBuilder(Context context, DataType dataType) {
            this.mContext = context;
            this.zzanl = dataType;
        }

        private Intent zzj(Intent intent) {
            if (this.zzano == null) {
                return intent;
            }
            Intent intent2 = new Intent(intent).setPackage(this.zzano);
            ResolveInfo resolveActivity = this.mContext.getPackageManager().resolveActivity(intent2, 0);
            if (resolveActivity == null) {
                return intent;
            }
            intent2.setComponent(new ComponentName(this.zzano, resolveActivity.activityInfo.name));
            return intent2;
        }

        public Intent build() {
            boolean z = true;
            zzx.zza(this.zzMS > 0, (Object) "Start time must be set");
            if (this.zzann <= this.zzMS) {
                z = false;
            }
            zzx.zza(z, (Object) "End time must be set and after start time");
            Intent intent = new Intent(Fitness.ACTION_VIEW);
            intent.setType(DataType.getMimeType(this.zzanm.getDataType()));
            intent.putExtra(Fitness.EXTRA_START_TIME, this.zzMS);
            intent.putExtra(Fitness.EXTRA_END_TIME, this.zzann);
            zzc.zza(this.zzanm, intent, DataSource.EXTRA_DATA_SOURCE);
            return zzj(intent);
        }

        public ViewIntentBuilder setDataSource(DataSource dataSource) {
            zzx.zzb(dataSource.getDataType().equals(this.zzanl), "Data source %s is not for the data type %s", dataSource, this.zzanl);
            this.zzanm = dataSource;
            return this;
        }

        public ViewIntentBuilder setPreferredApplication(String packageName) {
            this.zzano = packageName;
            return this;
        }

        public ViewIntentBuilder setTimeInterval(long start, long end, TimeUnit timeUnit) {
            this.zzMS = timeUnit.toMillis(start);
            this.zzann = timeUnit.toMillis(end);
            return this;
        }
    }

    PendingResult<Status> deleteData(GoogleApiClient googleApiClient, DataDeleteRequest dataDeleteRequest);

    PendingResult<Status> insertData(GoogleApiClient googleApiClient, DataSet dataSet);

    PendingResult<DailyTotalResult> readDailyTotal(GoogleApiClient googleApiClient, DataType dataType);

    PendingResult<DataReadResult> readData(GoogleApiClient googleApiClient, DataReadRequest dataReadRequest);
}
