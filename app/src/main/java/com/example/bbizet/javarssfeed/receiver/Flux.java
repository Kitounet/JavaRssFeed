package com.example.bbizet.javarssfeed.receiver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bbizet on 27/04/2017.
 */

public class Flux {
    private List<Channel> channels = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public class Channel {

        private Integer idfeed;
        private Integer userid;
        private String alias;
        private String title;
        private String description;
        private String link;
        private String copyright;
        private String pubDate;
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

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }
}


