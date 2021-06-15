package es.iesrafaelalberti.daw.dwes.clickcompetitionbase.model;

import lombok.Data;

@Data
public class Clicks {
    private int clicks;

    public Clicks() {}
    public Clicks(int clicks) {

        this.clicks = clicks;
    }
}
