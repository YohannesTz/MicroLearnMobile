package com.yohannes.app.microlearn.models

data class Instructor(
    var name: String,
    var sirname: String,
    var profilePictureUrl: String,
    //var givenCourseList: List<Course>,
    var title: String,
    var joinedDate: String,
    var password: String,
    var isVerified: Boolean,
    var paymentData: Int = 0
)
