package com.example.neostore.view.model

data class RegisterResponse(

    val status: Int,
    val data: RegisterDataItems,
    val message: String,
    val user_msg: String

)

data class RegisterDataItems(

    val first_name: String,
    val last_name: String,
    val email: String,
    val password: String,
    val confirm_password: String,
    val gender: String,
    val phone_no: String

    //    @SerializedName("id") val id: Int,
//    @SerializedName("role_id") val role_id: Int,
//    @SerializedName("first_name") val first_name: String?,
//    @SerializedName("last_name") val last_name: String?,
//    @SerializedName("email") val email: String?,
//    @SerializedName("username") val username: String?,
//    @SerializedName("profile_pic") val profile_pic: String?,
//    @SerializedName("country_id") val country_id: String?,
//    @SerializedName("gender") val gender: String?,
//    @SerializedName("phone_no") val phone_no: String,
//    @SerializedName("dob") val dob: String?,
//    @SerializedName("is_active") val is_active: Boolean,
//    @SerializedName("created") val created: String?,
//    @SerializedName("modified") val modified: String?,
//    @SerializedName("access_token") val access_token: String?

)

