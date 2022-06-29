package com.yohannes.app.microlearn.models

data class Course(
    var title: String,
    var estimatedHours: String,
    var backDropPictureUrl: String,
    var coverPictureUrl: String,
    var instructor: Instructor,
    var uploadedDate: String,
    var items: List<VideoItem>,
    var coupons: List<String>,
    var price: Int,
    var couponValue: Int,
    var chapters: List<Chapter>
)