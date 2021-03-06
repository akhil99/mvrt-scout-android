package com.mvrt.scoutview.tba;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Akhil Palla
 */
public class TBARequests{

    private RequestQueue queue;

    public TBARequests(Context context){
        queue = Volley.newRequestQueue(context);
    }

    public void tbaRequest(String path, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener){
        TBAObjectRequest req = new TBAObjectRequest(path, listener, errorListener);
        Log.d("MVRT", "req: " + req.toString());
        Log.d("MVRT", "req url: " + req.getUrl());
        queue.add(req);
    }

    public void loadTeams(String event, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener){
        TBAArrayRequest req = new TBAArrayRequest("event/" + event + "/teams", listener, errorListener);
        queue.add(req);
    }

    public void loadSched(String event, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener){
        TBAArrayRequest req = new TBAArrayRequest("event/" + event + "/matches", listener, errorListener);
        queue.add(req);
    }

    public void loadRanks(String event, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener){
        TBAArrayRequest req = new TBAArrayRequest("event/" + event + "/rankings", listener, errorListener);
        queue.add(req);
    }

    public void loadStats(String event, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener){
        TBAObjectRequest req = new TBAObjectRequest("event/" + event + "/stats", listener, errorListener);
        queue.add(req);
    }

}
