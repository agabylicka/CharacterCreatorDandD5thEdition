package org.example.HTTP;

import java.util.List;

public class AllRacesResponse {
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<AllRacesResult> getResults() {
        return results;
    }

    public void setResults(List<AllRacesResult> results) {
        this.results = results;
    }

    private List<AllRacesResult> results;
}
