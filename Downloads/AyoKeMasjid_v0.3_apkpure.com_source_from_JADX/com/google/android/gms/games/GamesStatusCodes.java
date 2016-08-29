package com.google.android.gms.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveStatusCodes;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.places.Place;

public final class GamesStatusCodes {
    public static final int STATUS_ACHIEVEMENT_NOT_INCREMENTAL = 3002;
    public static final int STATUS_ACHIEVEMENT_UNKNOWN = 3001;
    public static final int STATUS_ACHIEVEMENT_UNLOCKED = 3003;
    public static final int STATUS_ACHIEVEMENT_UNLOCK_FAILURE = 3000;
    public static final int STATUS_APP_MISCONFIGURED = 8;
    public static final int STATUS_CLIENT_RECONNECT_REQUIRED = 2;
    public static final int STATUS_GAME_NOT_FOUND = 9;
    public static final int STATUS_INTERNAL_ERROR = 1;
    public static final int STATUS_INTERRUPTED = 14;
    public static final int STATUS_INVALID_REAL_TIME_ROOM_ID = 7002;
    public static final int STATUS_LICENSE_CHECK_FAILED = 7;
    public static final int STATUS_MATCH_ERROR_ALREADY_REMATCHED = 6505;
    public static final int STATUS_MATCH_ERROR_INACTIVE_MATCH = 6501;
    public static final int STATUS_MATCH_ERROR_INVALID_MATCH_RESULTS = 6504;
    public static final int STATUS_MATCH_ERROR_INVALID_MATCH_STATE = 6502;
    public static final int STATUS_MATCH_ERROR_INVALID_PARTICIPANT_STATE = 6500;
    public static final int STATUS_MATCH_ERROR_LOCALLY_MODIFIED = 6507;
    public static final int STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION = 6503;
    public static final int STATUS_MATCH_NOT_FOUND = 6506;
    public static final int STATUS_MILESTONE_CLAIMED_PREVIOUSLY = 8000;
    public static final int STATUS_MILESTONE_CLAIM_FAILED = 8001;
    public static final int STATUS_MULTIPLAYER_DISABLED = 6003;
    public static final int STATUS_MULTIPLAYER_ERROR_CREATION_NOT_ALLOWED = 6000;
    public static final int STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE = 6002;
    public static final int STATUS_MULTIPLAYER_ERROR_INVALID_OPERATION = 6004;
    public static final int STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER = 6001;
    public static final int STATUS_NETWORK_ERROR_NO_DATA = 4;
    public static final int STATUS_NETWORK_ERROR_OPERATION_DEFERRED = 5;
    public static final int STATUS_NETWORK_ERROR_OPERATION_FAILED = 6;
    public static final int STATUS_NETWORK_ERROR_STALE_DATA = 3;
    public static final int STATUS_OK = 0;
    public static final int STATUS_OPERATION_IN_FLIGHT = 7007;
    public static final int STATUS_PARTICIPANT_NOT_CONNECTED = 7003;
    public static final int STATUS_QUEST_NOT_STARTED = 8003;
    public static final int STATUS_QUEST_NO_LONGER_AVAILABLE = 8002;
    public static final int STATUS_REAL_TIME_CONNECTION_FAILED = 7000;
    public static final int STATUS_REAL_TIME_INACTIVE_ROOM = 7005;
    public static final int STATUS_REAL_TIME_MESSAGE_SEND_FAILED = 7001;
    public static final int STATUS_REAL_TIME_ROOM_NOT_JOINED = 7004;
    public static final int STATUS_REQUEST_TOO_MANY_RECIPIENTS = 2002;
    public static final int STATUS_REQUEST_UPDATE_PARTIAL_SUCCESS = 2000;
    public static final int STATUS_REQUEST_UPDATE_TOTAL_FAILURE = 2001;
    public static final int STATUS_SNAPSHOT_COMMIT_FAILED = 4003;
    public static final int STATUS_SNAPSHOT_CONFLICT = 4004;
    public static final int STATUS_SNAPSHOT_CONFLICT_MISSING = 4006;
    public static final int STATUS_SNAPSHOT_CONTENTS_UNAVAILABLE = 4002;
    public static final int STATUS_SNAPSHOT_CREATION_FAILED = 4001;
    public static final int STATUS_SNAPSHOT_FOLDER_UNAVAILABLE = 4005;
    public static final int STATUS_SNAPSHOT_NOT_FOUND = 4000;
    public static final int STATUS_TIMEOUT = 15;

    private GamesStatusCodes() {
    }

    public static String getStatusString(int statusCode) {
        switch (statusCode) {
            case STATUS_OK /*0*/:
                return "STATUS_OK";
            case STATUS_INTERNAL_ERROR /*1*/:
                return "STATUS_INTERNAL_ERROR";
            case STATUS_CLIENT_RECONNECT_REQUIRED /*2*/:
                return "STATUS_CLIENT_RECONNECT_REQUIRED";
            case STATUS_NETWORK_ERROR_STALE_DATA /*3*/:
                return "STATUS_NETWORK_ERROR_STALE_DATA";
            case STATUS_NETWORK_ERROR_NO_DATA /*4*/:
                return "STATUS_NETWORK_ERROR_NO_DATA";
            case STATUS_NETWORK_ERROR_OPERATION_DEFERRED /*5*/:
                return "STATUS_NETWORK_ERROR_OPERATION_DEFERRED";
            case STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                return "STATUS_NETWORK_ERROR_OPERATION_FAILED";
            case STATUS_LICENSE_CHECK_FAILED /*7*/:
                return "STATUS_LICENSE_CHECK_FAILED";
            case STATUS_APP_MISCONFIGURED /*8*/:
                return "STATUS_APP_MISCONFIGURED";
            case STATUS_GAME_NOT_FOUND /*9*/:
                return "STATUS_GAME_NOT_FOUND";
            case STATUS_INTERRUPTED /*14*/:
                return "STATUS_INTERRUPTED";
            case STATUS_TIMEOUT /*15*/:
                return "STATUS_TIMEOUT";
            case 500:
                return "STATUS_RESOLVE_STALE_OR_NO_DATA";
            case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                return "STATUS_AUTH_ERROR_HARD";
            case Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_1 /*1001*/:
                return "STATUS_AUTH_ERROR_USER_RECOVERABLE";
            case Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_2 /*1002*/:
                return "STATUS_AUTH_ERROR_UNREGISTERED_CLIENT_ID";
            case Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_3 /*1003*/:
                return "STATUS_AUTH_ERROR_API_ACCESS_DENIED";
            case DriveStatusCodes.DRIVE_EXTERNAL_STORAGE_REQUIRED /*1500*/:
                return "STATUS_PLAYER_OOB_REQUIRED";
            case STATUS_REQUEST_UPDATE_PARTIAL_SUCCESS /*2000*/:
                return "STATUS_REQUEST_UPDATE_PARTIAL_SUCCESS";
            case STATUS_REQUEST_UPDATE_TOTAL_FAILURE /*2001*/:
                return "STATUS_REQUEST_UPDATE_TOTAL_FAILURE";
            case STATUS_REQUEST_TOO_MANY_RECIPIENTS /*2002*/:
                return "STATUS_REQUEST_TOO_MANY_RECIPIENTS";
            case STATUS_ACHIEVEMENT_UNLOCK_FAILURE /*3000*/:
                return "STATUS_ACHIEVEMENT_UNLOCK_FAILURE";
            case STATUS_ACHIEVEMENT_UNKNOWN /*3001*/:
                return "STATUS_ACHIEVEMENT_UNKNOWN";
            case STATUS_ACHIEVEMENT_NOT_INCREMENTAL /*3002*/:
                return "STATUS_ACHIEVEMENT_NOT_INCREMENTAL";
            case STATUS_ACHIEVEMENT_UNLOCKED /*3003*/:
                return "STATUS_ACHIEVEMENT_UNLOCKED";
            case STATUS_SNAPSHOT_NOT_FOUND /*4000*/:
                return "STATUS_SNAPSHOT_NOT_FOUND";
            case STATUS_SNAPSHOT_CREATION_FAILED /*4001*/:
                return "STATUS_SNAPSHOT_CREATION_FAILED";
            case STATUS_SNAPSHOT_CONTENTS_UNAVAILABLE /*4002*/:
                return "STATUS_SNAPSHOT_CONTENTS_UNAVAILABLE";
            case STATUS_SNAPSHOT_COMMIT_FAILED /*4003*/:
                return "STATUS_SNAPSHOT_COMMIT_FAILED";
            case STATUS_SNAPSHOT_CONFLICT /*4004*/:
                return "STATUS_SNAPSHOT_CONFLICT";
            case STATUS_SNAPSHOT_CONFLICT_MISSING /*4006*/:
                return "STATUS_SNAPSHOT_CONFLICT_MISSING";
            case STATUS_MULTIPLAYER_ERROR_CREATION_NOT_ALLOWED /*6000*/:
                return "STATUS_MULTIPLAYER_ERROR_CREATION_NOT_ALLOWED";
            case STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER /*6001*/:
                return "STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER";
            case STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE /*6002*/:
                return "STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE";
            case STATUS_MULTIPLAYER_DISABLED /*6003*/:
                return "STATUS_MULTIPLAYER_DISABLED";
            case STATUS_MATCH_ERROR_INVALID_PARTICIPANT_STATE /*6500*/:
                return "STATUS_MATCH_ERROR_INVALID_PARTICIPANT_STATE";
            case STATUS_MATCH_ERROR_INACTIVE_MATCH /*6501*/:
                return "STATUS_MATCH_ERROR_INACTIVE_MATCH";
            case STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION /*6503*/:
                return "STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION";
            case STATUS_MATCH_ERROR_INVALID_MATCH_RESULTS /*6504*/:
                return "STATUS_MATCH_ERROR_INVALID_MATCH_RESULTS";
            case STATUS_MATCH_ERROR_ALREADY_REMATCHED /*6505*/:
                return "STATUS_MATCH_ERROR_ALREADY_REMATCHED";
            case STATUS_MATCH_NOT_FOUND /*6506*/:
                return "STATUS_MATCH_NOT_FOUND";
            case STATUS_MATCH_ERROR_LOCALLY_MODIFIED /*6507*/:
                return "STATUS_MATCH_ERROR_LOCALLY_MODIFIED";
            case STATUS_REAL_TIME_CONNECTION_FAILED /*7000*/:
                return "STATUS_REAL_TIME_CONNECTION_FAILED";
            case STATUS_REAL_TIME_MESSAGE_SEND_FAILED /*7001*/:
                return "STATUS_REAL_TIME_MESSAGE_SEND_FAILED";
            case STATUS_INVALID_REAL_TIME_ROOM_ID /*7002*/:
                return "STATUS_INVALID_REAL_TIME_ROOM_ID";
            case STATUS_PARTICIPANT_NOT_CONNECTED /*7003*/:
                return "STATUS_PARTICIPANT_NOT_CONNECTED";
            case STATUS_REAL_TIME_ROOM_NOT_JOINED /*7004*/:
                return "STATUS_REAL_TIME_ROOM_NOT_JOINED";
            case STATUS_REAL_TIME_INACTIVE_ROOM /*7005*/:
                return "STATUS_REAL_TIME_INACTIVE_ROOM";
            case 7006:
                return "STATUS_REAL_TIME_SERVICE_NOT_CONNECTED";
            case STATUS_OPERATION_IN_FLIGHT /*7007*/:
                return "STATUS_OPERATION_IN_FLIGHT";
            case STATUS_MILESTONE_CLAIMED_PREVIOUSLY /*8000*/:
                return "STATUS_MILESTONE_CLAIMED_PREVIOUSLY";
            case STATUS_MILESTONE_CLAIM_FAILED /*8001*/:
                return "STATUS_MILESTONE_CLAIM_FAILED";
            case STATUS_QUEST_NO_LONGER_AVAILABLE /*8002*/:
                return "STATUS_QUEST_NO_LONGER_AVAILABLE";
            case STATUS_QUEST_NOT_STARTED /*8003*/:
                return "STATUS_QUEST_NOT_STARTED";
            default:
                Object[] objArr = new Object[STATUS_INTERNAL_ERROR];
                objArr[STATUS_OK] = Integer.valueOf(statusCode);
                return String.format("Status code (%d) not found!", objArr);
        }
    }

    public static Status zzfx(int i) {
        return new Status(i, getStatusString(i));
    }
}
