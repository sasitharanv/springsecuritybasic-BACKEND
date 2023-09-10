
package com.eazybytes.springsecuritybasic.modal;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Date;
@Entity
@Table(name = "notice_details")
public class Notice_details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id")
    private long noticeId;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @Column(name = "notice_summary")
    private String noticeSummary;

    @Column(name = "notice_details")
    private String noticeDetails;

    @Column(name = "noticebegin_date")
    private ZonedDateTime noticeBeginDate;

    @Column(name = "noticeclose_date")
    private ZonedDateTime noticeCloseDate;

    @Column(name = "create_date")
    private ZonedDateTime createDate;

    @Column(name = "update_date")
    private ZonedDateTime updateDate;

    public long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(long noticeId) {
        this.noticeId = noticeId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getNoticeSummary() {
        return noticeSummary;
    }

    public void setNoticeSummary(String noticeSummary) {
        this.noticeSummary = noticeSummary;
    }

    public String getNoticeDetails() {
        return noticeDetails;
    }

    public void setNoticeDetails(String noticeDetails) {
        this.noticeDetails = noticeDetails;
    }

    public ZonedDateTime getNoticeBeginDate() {
        return noticeBeginDate;
    }

    public void setNoticeBeginDate(ZonedDateTime noticeBeginDate) {
        this.noticeBeginDate = noticeBeginDate;
    }

    public ZonedDateTime getNoticeCloseDate() {
        return noticeCloseDate;
    }

    public void setNoticeCloseDate(ZonedDateTime noticeCloseDate) {
        this.noticeCloseDate = noticeCloseDate;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public ZonedDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(ZonedDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
