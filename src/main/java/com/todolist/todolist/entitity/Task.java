package com.todolist.todolist.entitity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "task")
@EntityListeners(AuditingEntityListener.class)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String title;
    String description;
    boolean done;
    @Column(name = "index_task")
    int index;
    @CreatedDate
    @Column(name = "creation_date")
    Date creationDate;
    @Column(name = "edition_date")
    @LastModifiedDate
    Date editionDate;
    @Column(name = "conclusion_date")
    Date conclusionDate;

    public Task() {
    }

    public Task(int id, String title, String description, boolean done, int index, Date creationDate, Date editionDate, Date conclusionDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.done = done;
        this.index = index;
        this.creationDate = creationDate;
        this.editionDate = editionDate;
        this.conclusionDate = conclusionDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getEditionDate() {
        return editionDate;
    }

    public void setEditionDate(Date editionDate) {
        this.editionDate = editionDate;
    }

    public Date getConclusionDate() {
        return conclusionDate;
    }

    public void setConclusionDate(Date conclusionDate) {
        this.conclusionDate = conclusionDate;
    }
}
