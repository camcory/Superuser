package com.koushikdutta.superuser;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;

import com.koushikdutta.widgets.BetterListFragment;
import com.koushikdutta.widgets.ListItem;

public class AboutFragment extends BetterListFragment {
    ContextThemeWrapper mWrapper;
    @Override
    public Context getContext() {
        if (mWrapper != null)
            return mWrapper;
        TypedValue value = new TypedValue();
        super.getContext().getTheme().resolveAttribute(R.attr.largeIconTheme, value, true);
        mWrapper = new ContextThemeWrapper(super.getContext(), value.resourceId);
        return mWrapper;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState, View view) {
        super.onCreate(savedInstanceState, view);

        PackageManager manager = getContext().getPackageManager();
        String version = "unknown";
        try {
            PackageInfo info = manager.getPackageInfo(getContext().getPackageName(), 0);
            version = info.versionName;
        }
        catch (NameNotFoundException e) {
        }

        addItem(R.string.about, new ListItem(this, getString(R.string.superuser), version, R.drawable.ic_launcher) {
            @Override
            public void onClick(View view) {
                super.onClick(view);
                Intent i = new Intent();
                i.setData(Uri.parse("https://github.com/camcory/Superuser"));
                startActivity(i);
            }
        });

        addItem(R.string.about, new ListItem(this, "Koushik Dutta", "@koush", R.drawable.koush) {
            @Override
            public void onClick(View view) {
                super.onClick(view);
                Intent i = new Intent();
                i.setClassName("com.twitter.android", "com.twitter.android.ProfileActivity");
                i.putExtra("screen_name", "koush");
                try {
                    startActivity(i);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });

        final String uri = "http://github.com/koush/Superuser";
        addItem(R.string.about, new ListItem(this, "Original Github source", uri, R.drawable.github) {
            @Override
            public void onClick(View view) {
                super.onClick(view);
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse(uri));
                startActivity(i);
            }
        });
        addItem(R.string.apps, new ListItem(this, "AllCast", "Send photos, music, and videos on your Android to your TV", R.drawable.allcast) {
            @Override
            public void onClick(View view) {
                super.onClick(view);
                Intent i = new Intent();
                i.setData(Uri.parse("market://details?id=com.koushikdutta.cast"));
                startActivity(i);
            }
        });
        addItem(R.string.apps, new ListItem(this, "Helium", "Android's missing backup solution", R.drawable.carbon) {
            @Override
            public void onClick(View view) {
                super.onClick(view);
                Intent i = new Intent();
                i.setData(Uri.parse("market://details?id=com.koushikdutta.backup"));
                startActivity(i);
            }
        });
        addItem(R.string.apps, new ListItem(this, "Tether", "Use your phone's web connection on a laptop or PC", R.drawable.tether) {
            @Override
            public void onClick(View view) {
                super.onClick(view);
                Intent i = new Intent();
                i.setData(Uri.parse("market://details?id=com.koushikdutta.tether"));
                startActivity(i);
            }
        });
        addItem(R.string.apps, new ListItem(this, "Vysor", "Android control on PC", R.drawable.vysor) {
            @Override
            public void onClick(View view) {
                super.onClick(view);
                Intent i = new Intent();
                i.setData(Uri.parse("market://details?id=com.koushikdutta.vysor"));
                startActivity(i);
            }
        });
    }
}
