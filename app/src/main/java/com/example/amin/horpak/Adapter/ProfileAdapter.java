package com.example.amin.horpak.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;

import com.example.amin.horpak.R;
import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.views.AboutView;

public class ProfileAdapter implements View.OnClickListener{

    private Activity activity;
    private int theme = R.style.AppThemeDark;

    private ProfileAdapter(Activity activity) {
        this.activity = activity;
    }

    public static ProfileAdapter with(Activity activity) {
        return new ProfileAdapter(activity);
    }

    public ProfileAdapter init() {
        activity.setTheme(theme);

        return this;
    }

    public void loadAbout() {
        final FrameLayout flHolder = activity.findViewById(R.id.about);

        AboutBuilder builder = AboutBuilder.with(activity)
                .setAppIcon(R.mipmap.ic_launcher)
                .setAppName(R.string.app_name)
                .setPhoto(R.mipmap.profile_picture)
                .setCover(R.mipmap.profile_cover)
                .setLinksAnimated(true)
                .setDividerDashGap(13)
                .setName("Your Full Name")
                .setSubTitle("Mobile Developer")
                .setLinksColumnsCount(4)
                .setBrief("I'm warmed of mobile technologies. Ideas maker, curious and nature lover.")
                .addGooglePlayStoreLink("8002078663318221363")
                .addGitHubLink("jrvansuita")
                .addBitbucketLink("jrvansuita")
                .addFacebookLink("user")
                .addTwitterLink("user")
                .addInstagramLink("jnrvans")
                .addGooglePlusLink("+JuniorVansuita")
                .addYoutubeChannelLink("CaseyNeistat")
                .addDribbbleLink("user")
                .addLinkedInLink("arleu-cezar-vansuita-júnior-83769271")
                .addEmailLink("vansuita.jr@gmail.com")
                .addWhatsappLink("Jr", "+554799650629")
                .addSkypeLink("user")
                .addGoogleLink("user")
                .addAndroidLink("user")
                .addWebsiteLink("site")
                .addFiveStarsAction()
                .addMoreFromMeAction("Vansuita")
                .setVersionNameAsAppSubTitle()
                .addShareAction(R.string.app_name)
                .addUpdateAction()
                .setActionsColumnsCount(2)
                .addFeedbackAction("vansuita.jr@gmail.com")
                .addPrivacyPolicyAction("http://www.docracy.com/2d0kis6uc2")
                .addIntroduceAction((Intent) null)
                .addHelpAction((Intent) null)
                .addChangeLogAction((Intent) null)
                .addRemoveAdsAction((Intent) null)
                .addDonateAction((Intent) null)
                .setWrapScrollView(true)
                .setShowAsCard(true);

        AboutView view = builder.build();

        flHolder.addView(view);
    }

    @Override
    public void onClick(View v) {

    }
}
