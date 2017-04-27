package com.example.bbizet.javarssfeed.row;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bbizet on 26/04/2017.
 */

public class FluxRow {
    private Integer iditem;
    private Integer idfeed;
    private String title;
    private String description;
    private String link;

    public FluxRow(Integer iditem, Integer idfeed, String title, String description, String link, String guid, String pubDate) {
        this.iditem = iditem;
        this.idfeed = idfeed;
        this.title = title;
        this.description = description;
        this.link = link;
        this.guid = guid;
        this.pubDate = pubDate;
    }

    private String guid;
    private String pubDate;

    public Integer getIditem() {
        return iditem;
    }

    public void setIditem(Integer iditem) {
        this.iditem = iditem;
    }

    public Integer getIdfeed() {
        return idfeed;
    }

    public void setIdfeed(Integer idfeed) {
        this.idfeed = idfeed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }
}
