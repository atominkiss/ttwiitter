package net.protoprint.ttwiitter.domain;

import org.apache.tomcat.jni.Time;
import org.hibernate.query.criteria.internal.expression.function.CurrentTimeFunction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.Date;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @DateTimeFormat
    private String time;

    private String text;
    private String tag;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Message() {
    }

    public Message(String text, String tag, User user, String time) {
        this.author = user;
        this.text = text;
        this.tag = tag;
        this.time = time;
    }

    public String getAuthorName(){
        return author != null ? author.getUsername() : "<none>";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getTime() {
        return time !=null ? time : "<no time stamp>";
    }

    public void setTime(String time) {
        this.time = CurrentTimeFunction.NAME;
    }
}
