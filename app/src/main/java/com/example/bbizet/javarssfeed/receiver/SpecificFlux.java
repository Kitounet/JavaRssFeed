package com.example.bbizet.javarssfeed.receiver;


import android.media.Image;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bbizet on 27/04/2017.
 */

public class SpecificFlux {

    private Integer idfeed;
    private Integer userid;
    private String alias;
    private String title;
    private String description;
    private String link;
    private String copyright;
    private String pubDate;
    private Image image;
    private List<Item> item = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getIdfeed() {
        return idfeed;
    }

    public void setIdfeed(Integer idfeed) {
        this.idfeed = idfeed;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public class Image {

        private Integer idimage;
        private Integer idfeed;
        private String title;
        private String link;
        private String url;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        public Integer getIdimage() {
            return idimage;
        }

        public void setIdimage(Integer idimage) {
            this.idimage = idimage;
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

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public class Item {

        private Integer iditem;
        private Integer idfeed;
        private String title;
        private String description;
        private String link;
        private String guid;
        private String pubDate;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }
}
