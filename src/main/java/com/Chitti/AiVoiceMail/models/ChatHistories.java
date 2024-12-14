package com.Chitti.AiVoiceMail.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

@Document(collection = "chat_histories")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatHistories implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    @Field("session_id")
    private String sessionId;

    private String userId;


    private Long timestamp;

    private List<Message> messages;

    private String summary;

    private Long lastUpdated;

    private Metadata metadata;

    public void addMessage(Message message) {
        this.messages.add(message);
    }

    // Inner class for Messages
    public static class Message implements Serializable {
        private static final long serialVersionUID = 1L;
        private String role;
        private String content;
        private Long timestamp;

        public Message(String user, String inputText) {
            this.role = user;
            this.content = inputText;
            this.timestamp = System.currentTimeMillis();
        }

        // Getters and Setters
        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Long timestamp) {
            this.timestamp = timestamp;
        }
    }

    // Inner class for Metadata
    public static class Metadata {
        private String source;
        private String appVersion;

        // Getters and Setters
        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getAppVersion() {
            return appVersion;
        }

        public void setAppVersion(String appVersion) {
            this.appVersion = appVersion;
        }
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }
}

