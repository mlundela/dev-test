package com.github.mlundela;

import org.json.JSONArray;
import org.json.JSONObject;

public class LocationMapper {

    /**
     * Map JSON representations of locations to csv format
     *
     * @param json json as string
     * @return _id, name, type, latitude, longitude
     */
    public String toCSV(String json) {
        StringBuilder sb = new StringBuilder();
        JSONArray arr = new JSONArray(json);
        for (int i = 0; i < arr.length(); i++) {
            JSONObject root = arr.getJSONObject(i);
            JSONObject position = root.getJSONObject("geo_position");
            sb.append(root.get("_id")).append(",");
            sb.append(root.getString("name")).append(",");
            sb.append(root.getString("type")).append(",");
            sb.append(position.getDouble("latitude")).append(",");
            sb.append(position.getDouble("longitude"));
            sb.append("\n");
        }
        return sb.toString();
    }
}
