package com.hm.entity;

import com.hm.entity.common.BaseEntity;

public class TRoomStuden extends BaseEntity<TRoomStuden> {
    /**
     * HMDN.T_ROOM_STUDEN.ID (主键)
     * @ibatorgenerated 2017-09-05 16:28:01
     */
    private String id;

    /**
     * HMDN.T_ROOM_STUDEN.STU_ID (学员id)
     * @ibatorgenerated 2017-09-05 16:28:01
     */
    private String stuId;

    /**
     * HMDN.T_ROOM_STUDEN.ROOM_ID (宿舍id)
     * @ibatorgenerated 2017-09-05 16:28:01
     */
    private String roomId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}