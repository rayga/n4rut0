package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.CapabilityApi.AddLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.RemoveLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.FutureTask;

final class zzbm {

    static abstract class zzb<T> extends zza {
        private com.google.android.gms.common.api.zzc.zzb<T> zzPW;

        public zzb(com.google.android.gms.common.api.zzc.zzb<T> com_google_android_gms_common_api_zzc_zzb_T) {
            this.zzPW = com_google_android_gms_common_api_zzc_zzb_T;
        }

        public void zzR(T t) {
            com.google.android.gms.common.api.zzc.zzb com_google_android_gms_common_api_zzc_zzb = this.zzPW;
            if (com_google_android_gms_common_api_zzc_zzb != null) {
                com_google_android_gms_common_api_zzc_zzb.zzn(t);
                this.zzPW = null;
            }
        }
    }

    static final class zzo extends zza {
        zzo() {
        }

        public void zzc(Status status) {
        }
    }

    static final class zza extends zzb<AddLocalCapabilityResult> {
        public zza(com.google.android.gms.common.api.zzc.zzb<AddLocalCapabilityResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_wearable_CapabilityApi_AddLocalCapabilityResult) {
            super(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_wearable_CapabilityApi_AddLocalCapabilityResult);
        }

        public void zza(AddLocalCapabilityResponse addLocalCapabilityResponse) {
            zzR(new com.google.android.gms.wearable.internal.zzi.zzb(zzbj.zzfx(addLocalCapabilityResponse.statusCode)));
        }
    }

    static final class zzc extends zzb<Status> {
        public zzc(com.google.android.gms.common.api.zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status);
        }

        public void zza(CloseChannelResponse closeChannelResponse) {
            zzR(new Status(closeChannelResponse.statusCode));
        }
    }

    static final class zzd extends zzb<Status> {
        public zzd(com.google.android.gms.common.api.zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status);
        }

        public void zzb(CloseChannelResponse closeChannelResponse) {
            zzR(new Status(closeChannelResponse.statusCode));
        }
    }

    static final class zze extends zzb<DeleteDataItemsResult> {
        public zze(com.google.android.gms.common.api.zzc.zzb<DeleteDataItemsResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_wearable_DataApi_DeleteDataItemsResult) {
            super(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_wearable_DataApi_DeleteDataItemsResult);
        }

        public void zza(DeleteDataItemsResponse deleteDataItemsResponse) {
            zzR(new com.google.android.gms.wearable.internal.zzw.zzc(zzbj.zzfx(deleteDataItemsResponse.statusCode), deleteDataItemsResponse.zzbaq));
        }
    }

    static final class zzf extends zzb<GetAllCapabilitiesResult> {
        public zzf(com.google.android.gms.common.api.zzc.zzb<GetAllCapabilitiesResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_wearable_CapabilityApi_GetAllCapabilitiesResult) {
            super(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_wearable_CapabilityApi_GetAllCapabilitiesResult);
        }

        public void zza(GetAllCapabilitiesResponse getAllCapabilitiesResponse) {
            zzR(new com.google.android.gms.wearable.internal.zzi.zzd(zzbj.zzfx(getAllCapabilitiesResponse.statusCode), zzbm.zzv(getAllCapabilitiesResponse.zzbar)));
        }
    }

    static final class zzg extends zzb<GetCapabilityResult> {
        public zzg(com.google.android.gms.common.api.zzc.zzb<GetCapabilityResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_wearable_CapabilityApi_GetCapabilityResult) {
            super(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_wearable_CapabilityApi_GetCapabilityResult);
        }

        public void zza(GetCapabilityResponse getCapabilityResponse) {
            zzR(new com.google.android.gms.wearable.internal.zzi.zze(zzbj.zzfx(getCapabilityResponse.statusCode), new com.google.android.gms.wearable.internal.zzi.zzc(getCapabilityResponse.zzbas)));
        }
    }

    static final class zzh extends zzb<GetInputStreamResult> {
        private final zzs zzbaT;

        public zzh(com.google.android.gms.common.api.zzc.zzb<GetInputStreamResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_wearable_Channel_GetInputStreamResult, zzs com_google_android_gms_wearable_internal_zzs) {
            super(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_wearable_Channel_GetInputStreamResult);
            this.zzbaT = (zzs) zzx.zzv(com_google_android_gms_wearable_internal_zzs);
        }

        public void zza(GetChannelInputStreamResponse getChannelInputStreamResponse) {
            InputStream inputStream = null;
            if (getChannelInputStreamResponse.zzbat != null) {
                inputStream = new zzo(new AutoCloseInputStream(getChannelInputStreamResponse.zzbat));
                this.zzbaT.zza(inputStream.zzCD());
            }
            zzR(new zza(new Status(getChannelInputStreamResponse.statusCode), inputStream));
        }
    }

    static final class zzi extends zzb<GetOutputStreamResult> {
        private final zzs zzbaT;

        public zzi(com.google.android.gms.common.api.zzc.zzb<GetOutputStreamResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_wearable_Channel_GetOutputStreamResult, zzs com_google_android_gms_wearable_internal_zzs) {
            super(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_wearable_Channel_GetOutputStreamResult);
            this.zzbaT = (zzs) zzx.zzv(com_google_android_gms_wearable_internal_zzs);
        }

        public void zza(GetChannelOutputStreamResponse getChannelOutputStreamResponse) {
            OutputStream outputStream = null;
            if (getChannelOutputStreamResponse.zzbat != null) {
                outputStream = new zzp(new AutoCloseOutputStream(getChannelOutputStreamResponse.zzbat));
                this.zzbaT.zza(outputStream.zzCD());
            }
            zzR(new zzb(new Status(getChannelOutputStreamResponse.statusCode), outputStream));
        }
    }

    static final class zzj extends zzb<GetConnectedNodesResult> {
        public zzj(com.google.android.gms.common.api.zzc.zzb<GetConnectedNodesResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_wearable_NodeApi_GetConnectedNodesResult) {
            super(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_wearable_NodeApi_GetConnectedNodesResult);
        }

        public void zza(GetConnectedNodesResponse getConnectedNodesResponse) {
            List arrayList = new ArrayList();
            arrayList.addAll(getConnectedNodesResponse.zzbaz);
            zzR(new com.google.android.gms.wearable.internal.zzba.zzb(zzbj.zzfx(getConnectedNodesResponse.statusCode), arrayList));
        }
    }

    static final class zzk extends zzb<DataItemResult> {
        public zzk(com.google.android.gms.common.api.zzc.zzb<DataItemResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_wearable_DataApi_DataItemResult) {
            super(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_wearable_DataApi_DataItemResult);
        }

        public void zza(GetDataItemResponse getDataItemResponse) {
            zzR(new com.google.android.gms.wearable.internal.zzw.zzb(zzbj.zzfx(getDataItemResponse.statusCode), getDataItemResponse.zzbaA));
        }
    }

    static final class zzl extends zzb<DataItemBuffer> {
        public zzl(com.google.android.gms.common.api.zzc.zzb<DataItemBuffer> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_wearable_DataItemBuffer) {
            super(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_wearable_DataItemBuffer);
        }

        public void zzae(DataHolder dataHolder) {
            zzR(new DataItemBuffer(dataHolder));
        }
    }

    static final class zzm extends zzb<GetFdForAssetResult> {
        public zzm(com.google.android.gms.common.api.zzc.zzb<GetFdForAssetResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_wearable_DataApi_GetFdForAssetResult) {
            super(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_wearable_DataApi_GetFdForAssetResult);
        }

        public void zza(GetFdForAssetResponse getFdForAssetResponse) {
            zzR(new com.google.android.gms.wearable.internal.zzw.zzd(zzbj.zzfx(getFdForAssetResponse.statusCode), getFdForAssetResponse.zzbaB));
        }
    }

    static final class zzn extends zzb<GetLocalNodeResult> {
        public zzn(com.google.android.gms.common.api.zzc.zzb<GetLocalNodeResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_wearable_NodeApi_GetLocalNodeResult) {
            super(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_wearable_NodeApi_GetLocalNodeResult);
        }

        public void zza(GetLocalNodeResponse getLocalNodeResponse) {
            zzR(new com.google.android.gms.wearable.internal.zzba.zzc(zzbj.zzfx(getLocalNodeResponse.statusCode), getLocalNodeResponse.zzbaC));
        }
    }

    static final class zzp extends zzb<OpenChannelResult> {
        public zzp(com.google.android.gms.common.api.zzc.zzb<OpenChannelResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_wearable_ChannelApi_OpenChannelResult) {
            super(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_wearable_ChannelApi_OpenChannelResult);
        }

        public void zza(OpenChannelResponse openChannelResponse) {
            zzR(new zzb(zzbj.zzfx(openChannelResponse.statusCode), openChannelResponse.zzaZR));
        }
    }

    static final class zzq extends zzb<DataItemResult> {
        private final List<FutureTask<Boolean>> zzxu;

        zzq(com.google.android.gms.common.api.zzc.zzb<DataItemResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_wearable_DataApi_DataItemResult, List<FutureTask<Boolean>> list) {
            super(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_wearable_DataApi_DataItemResult);
            this.zzxu = list;
        }

        public void zza(PutDataResponse putDataResponse) {
            zzR(new com.google.android.gms.wearable.internal.zzw.zzb(zzbj.zzfx(putDataResponse.statusCode), putDataResponse.zzbaA));
            if (putDataResponse.statusCode != 0) {
                for (FutureTask cancel : this.zzxu) {
                    cancel.cancel(true);
                }
            }
        }
    }

    static final class zzr extends zzb<Status> {
        public zzr(com.google.android.gms.common.api.zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status);
        }

        public void zza(ChannelSendFileResponse channelSendFileResponse) {
            zzR(new Status(channelSendFileResponse.statusCode));
        }
    }

    static final class zzs extends zzb<RemoveLocalCapabilityResult> {
        public zzs(com.google.android.gms.common.api.zzc.zzb<RemoveLocalCapabilityResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_wearable_CapabilityApi_RemoveLocalCapabilityResult) {
            super(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_wearable_CapabilityApi_RemoveLocalCapabilityResult);
        }

        public void zza(RemoveLocalCapabilityResponse removeLocalCapabilityResponse) {
            zzR(new com.google.android.gms.wearable.internal.zzi.zzb(zzbj.zzfx(removeLocalCapabilityResponse.statusCode)));
        }
    }

    static final class zzt extends zzb<SendMessageResult> {
        public zzt(com.google.android.gms.common.api.zzc.zzb<SendMessageResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_wearable_MessageApi_SendMessageResult) {
            super(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_wearable_MessageApi_SendMessageResult);
        }

        public void zza(SendMessageResponse sendMessageResponse) {
            zzR(new com.google.android.gms.wearable.internal.zzay.zzb(zzbj.zzfx(sendMessageResponse.statusCode), sendMessageResponse.zzaBi));
        }
    }

    static final class zzu extends zzb<Status> {
        public zzu(com.google.android.gms.common.api.zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status);
        }

        public void zza(ChannelReceiveFileResponse channelReceiveFileResponse) {
            zzR(new Status(channelReceiveFileResponse.statusCode));
        }
    }

    private static Map<String, CapabilityInfo> zzv(List<CapabilityInfoParcelable> list) {
        Map hashMap = new HashMap(list.size() * 2);
        for (CapabilityInfoParcelable capabilityInfoParcelable : list) {
            hashMap.put(capabilityInfoParcelable.getName(), new com.google.android.gms.wearable.internal.zzi.zzc(capabilityInfoParcelable));
        }
        return hashMap;
    }
}
