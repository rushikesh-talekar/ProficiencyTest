package com.test.talekar.rushikesh.proficiencytest.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Utility class for alert dialog.
 *
 * @author rushikesh talekar
 */

public class DialogUtil {

  /**
   * This method will show a alert dialog
   *
   * @param context -  context
   * @param title   - title of dialog
   * @param msg     - message of dialog
   */
  public static void showAlertDialog(Context context, String title, String msg) {
    final AlertDialog.Builder builder;
    builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert);
    builder.setTitle(title)
        .setMessage(msg)
        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
          }
        })
        .setCancelable(false)
        .show();
  }
}
