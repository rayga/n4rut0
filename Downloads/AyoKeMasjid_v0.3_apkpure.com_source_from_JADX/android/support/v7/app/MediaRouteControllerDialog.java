package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.content.IntentSender;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaControllerCompat.Callback;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouter.RouteInfo;
import android.support.v7.mediarouter.C0142R;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MediaRouteControllerDialog extends Dialog {
    private static final String TAG = "MediaRouteControllerDialog";
    private static final int VOLUME_UPDATE_DELAY_MILLIS = 250;
    private ImageView mArtView;
    private boolean mAttachedToWindow;
    private final MediaRouterCallback mCallback;
    private View mControlView;
    private MediaControllerCallback mControllerCallback;
    private boolean mCreated;
    private MediaDescriptionCompat mDescription;
    private Button mDisconnectButton;
    private MediaControllerCompat mMediaController;
    private Drawable mMediaRouteConnectingDrawable;
    private Drawable mMediaRouteOnDrawable;
    private ImageButton mPlayPauseButton;
    private final RouteInfo mRoute;
    private TextView mRouteNameView;
    private final MediaRouter mRouter;
    private ImageButton mSettingsButton;
    private PlaybackStateCompat mState;
    private Button mStopCastingButton;
    private TextView mSubtitleView;
    private TextView mTitleView;
    private View mTitlesWrapper;
    private boolean mVolumeControlEnabled;
    private LinearLayout mVolumeLayout;
    private SeekBar mVolumeSlider;
    private boolean mVolumeSliderTouched;

    /* renamed from: android.support.v7.app.MediaRouteControllerDialog.1 */
    class C01051 implements OnSeekBarChangeListener {
        private final Runnable mStopTrackingTouch;

        /* renamed from: android.support.v7.app.MediaRouteControllerDialog.1.1 */
        class C01041 implements Runnable {
            C01041() {
            }

            public void run() {
                if (MediaRouteControllerDialog.this.mVolumeSliderTouched) {
                    MediaRouteControllerDialog.this.mVolumeSliderTouched = false;
                    MediaRouteControllerDialog.this.updateVolume();
                }
            }
        }

        C01051() {
            this.mStopTrackingTouch = new C01041();
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            if (MediaRouteControllerDialog.this.mVolumeSliderTouched) {
                MediaRouteControllerDialog.this.mVolumeSlider.removeCallbacks(this.mStopTrackingTouch);
            } else {
                MediaRouteControllerDialog.this.mVolumeSliderTouched = true;
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            MediaRouteControllerDialog.this.mVolumeSlider.postDelayed(this.mStopTrackingTouch, 250);
        }

        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (fromUser) {
                MediaRouteControllerDialog.this.mRoute.requestSetVolume(progress);
            }
        }
    }

    private final class ClickListener implements OnClickListener {
        private ClickListener() {
        }

        public void onClick(View v) {
            int id = v.getId();
            if (id == C0142R.id.stop || id == C0142R.id.disconnect) {
                if (MediaRouteControllerDialog.this.mRoute.isSelected()) {
                    MediaRouteControllerDialog.this.mRouter.unselect(id == C0142R.id.stop ? 2 : 1);
                }
                MediaRouteControllerDialog.this.dismiss();
            } else if (id == C0142R.id.play_pause) {
                if (MediaRouteControllerDialog.this.mMediaController != null && MediaRouteControllerDialog.this.mState != null) {
                    if (MediaRouteControllerDialog.this.mState.getState() == 3) {
                        MediaRouteControllerDialog.this.mMediaController.getTransportControls().pause();
                    } else {
                        MediaRouteControllerDialog.this.mMediaController.getTransportControls().play();
                    }
                }
            } else if (id == C0142R.id.settings) {
                IntentSender is = MediaRouteControllerDialog.this.mRoute.getSettingsIntent();
                if (is != null) {
                    try {
                        is.sendIntent(null, 0, null, null, null);
                        MediaRouteControllerDialog.this.dismiss();
                    } catch (Exception e) {
                        Log.e(MediaRouteControllerDialog.TAG, "Error opening route settings.", e);
                    }
                }
            }
        }
    }

    private final class MediaControllerCallback extends Callback {
        private MediaControllerCallback() {
        }

        public void onSessionDestroyed() {
            if (MediaRouteControllerDialog.this.mMediaController != null) {
                MediaRouteControllerDialog.this.mMediaController.unregisterCallback(MediaRouteControllerDialog.this.mControllerCallback);
                MediaRouteControllerDialog.this.mMediaController = null;
            }
        }

        public void onPlaybackStateChanged(PlaybackStateCompat state) {
            MediaRouteControllerDialog.this.mState = state;
            MediaRouteControllerDialog.this.update();
        }

        public void onMetadataChanged(MediaMetadataCompat metadata) {
            MediaRouteControllerDialog.this.mDescription = metadata == null ? null : metadata.getDescription();
            MediaRouteControllerDialog.this.update();
        }
    }

    private final class MediaRouterCallback extends MediaRouter.Callback {
        private MediaRouterCallback() {
        }

        public void onRouteUnselected(MediaRouter router, RouteInfo route) {
            MediaRouteControllerDialog.this.update();
        }

        public void onRouteChanged(MediaRouter router, RouteInfo route) {
            MediaRouteControllerDialog.this.update();
        }

        public void onRouteVolumeChanged(MediaRouter router, RouteInfo route) {
            if (route == MediaRouteControllerDialog.this.mRoute) {
                MediaRouteControllerDialog.this.updateVolume();
            }
        }
    }

    public MediaRouteControllerDialog(Context context) {
        this(context, 0);
    }

    public MediaRouteControllerDialog(Context context, int theme) {
        super(MediaRouterThemeHelper.createThemedContext(context), theme);
        this.mVolumeControlEnabled = true;
        context = getContext();
        this.mControllerCallback = new MediaControllerCallback();
        this.mRouter = MediaRouter.getInstance(context);
        this.mCallback = new MediaRouterCallback();
        this.mRoute = this.mRouter.getSelectedRoute();
        setMediaSession(this.mRouter.getMediaSessionToken());
    }

    public RouteInfo getRoute() {
        return this.mRoute;
    }

    public View onCreateMediaControlView(Bundle savedInstanceState) {
        return null;
    }

    public View getMediaControlView() {
        return this.mControlView;
    }

    public void setVolumeControlEnabled(boolean enable) {
        if (this.mVolumeControlEnabled != enable) {
            this.mVolumeControlEnabled = enable;
            if (this.mCreated) {
                updateVolume();
            }
        }
    }

    public boolean isVolumeControlEnabled() {
        return this.mVolumeControlEnabled;
    }

    private void setMediaSession(Token sessionToken) {
        PlaybackStateCompat playbackStateCompat = null;
        if (this.mMediaController != null) {
            this.mMediaController.unregisterCallback(this.mControllerCallback);
            this.mMediaController = null;
        }
        if (sessionToken != null && this.mAttachedToWindow) {
            try {
                this.mMediaController = new MediaControllerCompat(getContext(), sessionToken);
            } catch (RemoteException e) {
                Log.e(TAG, "Error creating media controller in setMediaSession.", e);
            }
            if (this.mMediaController != null) {
                this.mMediaController.registerCallback(this.mControllerCallback);
            }
            MediaMetadataCompat metadata = this.mMediaController == null ? null : this.mMediaController.getMetadata();
            this.mDescription = metadata == null ? null : metadata.getDescription();
            if (this.mMediaController != null) {
                playbackStateCompat = this.mMediaController.getPlaybackState();
            }
            this.mState = playbackStateCompat;
            update();
        }
    }

    public Token getMediaSession() {
        return this.mMediaController == null ? null : this.mMediaController.getSessionToken();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(1);
        setContentView(C0142R.layout.mr_media_route_controller_material_dialog_b);
        ClickListener listener = new ClickListener();
        this.mDisconnectButton = (Button) findViewById(C0142R.id.disconnect);
        this.mDisconnectButton.setOnClickListener(listener);
        this.mStopCastingButton = (Button) findViewById(C0142R.id.stop);
        this.mStopCastingButton.setOnClickListener(listener);
        this.mSettingsButton = (ImageButton) findViewById(C0142R.id.settings);
        this.mSettingsButton.setOnClickListener(listener);
        this.mArtView = (ImageView) findViewById(C0142R.id.art);
        this.mTitleView = (TextView) findViewById(C0142R.id.title);
        this.mSubtitleView = (TextView) findViewById(C0142R.id.subtitle);
        this.mTitlesWrapper = findViewById(C0142R.id.text_wrapper);
        this.mPlayPauseButton = (ImageButton) findViewById(C0142R.id.play_pause);
        this.mPlayPauseButton.setOnClickListener(listener);
        this.mRouteNameView = (TextView) findViewById(C0142R.id.route_name);
        this.mVolumeLayout = (LinearLayout) findViewById(C0142R.id.media_route_volume_layout);
        this.mVolumeSlider = (SeekBar) findViewById(C0142R.id.media_route_volume_slider);
        this.mVolumeSlider.setOnSeekBarChangeListener(new C01051());
        this.mCreated = true;
        if (update()) {
            this.mControlView = onCreateMediaControlView(savedInstanceState);
            FrameLayout controlFrame = (FrameLayout) findViewById(C0142R.id.media_route_control_frame);
            if (this.mControlView != null) {
                controlFrame.findViewById(C0142R.id.default_control_frame).setVisibility(8);
                controlFrame.addView(this.mControlView);
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mAttachedToWindow = true;
        this.mRouter.addCallback(MediaRouteSelector.EMPTY, this.mCallback, 2);
        setMediaSession(this.mRouter.getMediaSessionToken());
    }

    public void onDetachedFromWindow() {
        this.mRouter.removeCallback(this.mCallback);
        setMediaSession(null);
        this.mAttachedToWindow = false;
        super.onDetachedFromWindow();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 25 && keyCode != 24) {
            return super.onKeyDown(keyCode, event);
        }
        int i;
        RouteInfo routeInfo = this.mRoute;
        if (keyCode == 25) {
            i = -1;
        } else {
            i = 1;
        }
        routeInfo.requestUpdateVolume(i);
        return true;
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == 25 || keyCode == 24) {
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    private boolean update() {
        if (!this.mRoute.isSelected() || this.mRoute.isDefault()) {
            dismiss();
            return false;
        } else if (!this.mCreated) {
            return false;
        } else {
            updateVolume();
            this.mRouteNameView.setText(this.mRoute.getName());
            if (this.mRoute.canDisconnect()) {
                this.mDisconnectButton.setVisibility(0);
            } else {
                this.mDisconnectButton.setVisibility(8);
            }
            if (this.mRoute.getSettingsIntent() != null) {
                this.mSettingsButton.setVisibility(0);
            } else {
                this.mSettingsButton.setVisibility(8);
            }
            if (this.mControlView == null) {
                if (this.mDescription != null) {
                    if (this.mDescription.getIconBitmap() != null) {
                        this.mArtView.setImageBitmap(this.mDescription.getIconBitmap());
                        this.mArtView.setVisibility(0);
                    } else if (this.mDescription.getIconUri() != null) {
                        this.mArtView.setImageURI(this.mDescription.getIconUri());
                        this.mArtView.setVisibility(0);
                    } else {
                        this.mArtView.setImageDrawable(null);
                        this.mArtView.setVisibility(8);
                    }
                    boolean haveText = false;
                    CharSequence text = this.mDescription.getTitle();
                    if (TextUtils.isEmpty(text)) {
                        this.mTitleView.setText(null);
                        this.mTitleView.setVisibility(8);
                    } else {
                        this.mTitleView.setText(text);
                        haveText = true;
                    }
                    if (TextUtils.isEmpty(this.mDescription.getSubtitle())) {
                        this.mSubtitleView.setText(null);
                        this.mSubtitleView.setVisibility(8);
                    } else {
                        this.mSubtitleView.setText(this.mDescription.getSubtitle());
                        haveText = true;
                    }
                    if (haveText) {
                        this.mTitlesWrapper.setVisibility(0);
                    } else {
                        this.mTitlesWrapper.setVisibility(8);
                    }
                } else {
                    this.mArtView.setVisibility(8);
                    this.mTitlesWrapper.setVisibility(8);
                }
                if (this.mState != null) {
                    boolean isPlaying = this.mState.getState() == 6 || this.mState.getState() == 3;
                    boolean supportsPlay = (this.mState.getActions() & 516) != 0;
                    boolean supportsPause = (this.mState.getActions() & 514) != 0;
                    if (isPlaying && supportsPause) {
                        this.mPlayPauseButton.setVisibility(0);
                        this.mPlayPauseButton.setImageResource(MediaRouterThemeHelper.getThemeResource(getContext(), C0142R.attr.mediaRoutePauseDrawable));
                        this.mPlayPauseButton.setContentDescription(getContext().getResources().getText(C0142R.string.mr_media_route_controller_pause));
                    } else if (isPlaying || !supportsPlay) {
                        this.mPlayPauseButton.setVisibility(8);
                    } else {
                        this.mPlayPauseButton.setVisibility(0);
                        this.mPlayPauseButton.setImageResource(MediaRouterThemeHelper.getThemeResource(getContext(), C0142R.attr.mediaRoutePlayDrawable));
                        this.mPlayPauseButton.setContentDescription(getContext().getResources().getText(C0142R.string.mr_media_route_controller_play));
                    }
                } else {
                    this.mPlayPauseButton.setVisibility(8);
                }
            }
            return true;
        }
    }

    private Drawable getIconDrawable() {
        if (this.mRoute.isConnecting()) {
            if (this.mMediaRouteConnectingDrawable == null) {
                this.mMediaRouteConnectingDrawable = MediaRouterThemeHelper.getThemeDrawable(getContext(), C0142R.attr.mediaRouteConnectingDrawable);
            }
            return this.mMediaRouteConnectingDrawable;
        }
        if (this.mMediaRouteOnDrawable == null) {
            this.mMediaRouteOnDrawable = MediaRouterThemeHelper.getThemeDrawable(getContext(), C0142R.attr.mediaRouteOnDrawable);
        }
        return this.mMediaRouteOnDrawable;
    }

    private void updateVolume() {
        if (!this.mVolumeSliderTouched) {
            if (isVolumeControlAvailable()) {
                this.mVolumeLayout.setVisibility(0);
                this.mVolumeSlider.setMax(this.mRoute.getVolumeMax());
                this.mVolumeSlider.setProgress(this.mRoute.getVolume());
                return;
            }
            this.mVolumeLayout.setVisibility(8);
        }
    }

    private boolean isVolumeControlAvailable() {
        return this.mVolumeControlEnabled && this.mRoute.getVolumeHandling() == 1;
    }
}
