package com.tt.dev.instagramdownload.clip;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.Log;

import static android.content.ClipDescription.MIMETYPE_TEXT_PLAIN;

public class Clip {
    public static final String getClipboardText(Context context) {

        try {
            ClipboardManager clipboard = (ClipboardManager)
                    context.getSystemService(Context.CLIPBOARD_SERVICE);
            if (clipboard.hasPrimaryClip()) {
                ClipData clipData = clipboard.getPrimaryClip();
                if (clipData != null && clipData.getItemCount() > 0) {
                    CharSequence clipboardText = clipData.getItemAt(0).coerceToText(context);
                    if (clipboardText != null) {
                        return clipboardText.toString();
                    }
                }
            }
        } catch (Exception e) {
            try {
                return getClip(context);
            } catch (Exception ex) {
                return null;
            }
        }
        return null;
    }

    public static final void setClipboardText(Context context) throws Exception {
        try {
            ClipboardManager clipboard = (ClipboardManager)
                    context.getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("", null);
            clipboard.setPrimaryClip(clip);
        } catch (Exception e) {

        }
    }

    public static String getClip(Context context) throws Exception {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        String pasteData = null;

        // If it does contain data, decide if you can handle the data.
        if (!(clipboard.hasPrimaryClip())) {

        } else if (!(clipboard.getPrimaryClipDescription().hasMimeType(MIMETYPE_TEXT_PLAIN))) {

            // since the clipboard has data but it is not plain text

        } else {

            //since the clipboard contains plain text.
            ClipData.Item item = clipboard.getPrimaryClip().getItemAt(0);

            // Gets the clipboard as text.
            pasteData = item.getText().toString();
        }
        return pasteData;
    }

}
