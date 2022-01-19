package com.volnetiks.lol;

import com.volnetiks.lol.http.HttpRequest;

import java.io.IOException;
import java.util.List;

/*
 * Created by Volnetiks
 * Date: 19/01/2022
 * Time: 7:54 PM
 */
public class Runes {

    private String displayName;
    private String rawDescription;
    private String rawDisplayName;
    private int id;

    public Runes(String displayName, int id, String rawDescription, String rawDisplayName) {
        this.displayName = displayName;
        this.id = id;
        this.rawDescription = rawDescription;
        this.rawDisplayName = displayName;
    }

    public static List<Runes> getActiveRunes() throws IOException {
        String request = HttpRequest.sendRequest("https://127.0.0.1:2999/liveclientdata/activeplayerrunes", "", "GET", true, true);

    }

}
