package net.protoprint.ttwiitter.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String text;
    private String tag;

    @DateTimeFormat
    private LocalDateTime timestamp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    private String filename;

    public Message() {
    }

    public Message(String text, String tag, User user, LocalDateTime timestamp) {
        this.author = user;
        this.text = text;
        this.tag = tag;
        this.timestamp = timestamp;
    }


    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public LocalTime getTimestamp() {
        return timestamp !=null ? LocalTime.from(timestamp) : LocalTime.parse("00:00:00");
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = LocalDateTime.from(LocalTime.now());
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}