package com.compproject.samplestorageapp.model.samples;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name= "sample_info")
public class Sample {

    @Id
    @Column(name = "sample_Id")
    private int sampleId;

    @Column(name = "batch_Num")
    private String batch;
    @Column(name = "last_Action")
    private String lastAction;
    @Column(name = "last_Action_Date")
    private Date lastActionDate;
    @Column(name = "location_Stored")
    private String locationStored;
    @Column(name = "performed_By")
    private String performedBy;

    protected Sample() {
    }



    public int getSampleId() {
        return sampleId;
    }

    public void setSampleId(int sampleId) {
        this.sampleId = sampleId;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getLastAction() {
        return lastAction;
    }

    public void setLastAction(String lastAction) {
        this.lastAction = lastAction;
    }

    public Date getLastActionDate() {
        return lastActionDate;
    }

    public void setLastActionDate(Date lastActionDate) {
        this.lastActionDate = lastActionDate;
    }

    public String getLocationStored() {
        return locationStored;
    }

    public void setLocationStored(String locationStored) {
        this.locationStored = locationStored;
    }

    public String getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(String performedBy) {
        this.performedBy = performedBy;
    }

    @Override
    public String toString() {
        return "Sample{" +
                "sampleId=" + sampleId +
                ", batch='" + batch + '\'' +
                ", lastAction='" + lastAction + '\'' +
                ", lastActionDate=" + lastActionDate +
                ", locationStored='" + locationStored + '\'' +
                ", performedBy='" + performedBy + '\'' +
                '}';
    }
}


