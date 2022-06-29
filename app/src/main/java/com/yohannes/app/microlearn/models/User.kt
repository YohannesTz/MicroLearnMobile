package com.yohannes.app.microlearn.models

data class User(
    var name: String,
    var sirname: String,
    var profilePictureUrl: String,
    var wishList: List<Course>,
    var enrolledCourse: List<Course>,
    var joinedDate: String,
    var password: String,
    var achievements: List<Achievement>,
    var isVerified: Boolean,
    var role: String = "user",
    var paymentData: Int = 0
)
