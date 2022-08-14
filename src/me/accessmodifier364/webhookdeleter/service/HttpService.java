package me.accessmodifier364.webhookdeleter.service;

import javax.swing.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author accessmodifier364
 * @since 5/16/2022 at 05:22
 */

public class HttpService {

    /**
     * Method which sends a DELETE request.
     *
     * @param webhook The webhook as String.
     */
    public static void deleteWebhook(String webhook) {
        try {
            final HttpURLConnection conn = (HttpURLConnection) new URL(webhook).openConnection();
            conn.setRequestMethod("DELETE");
            conn.addRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.64 Safari/537.11");

            /* Get the response code to check if the webhook has been deleted */
            if (conn.getResponseCode() == 204) {
                JOptionPane.showMessageDialog(null, "Webhook has been deleted!", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}