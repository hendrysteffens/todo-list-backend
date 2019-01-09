package com.todolist.todolist.entitity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Task {

    @Id
    int id;
    String title;
    String description;
    boolean done;
    int index;
    @Column(name = "creation_date")
    Date creationDate;
    @Column(name = "edition_date")
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
