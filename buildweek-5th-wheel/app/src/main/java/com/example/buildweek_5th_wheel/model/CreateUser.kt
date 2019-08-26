package com.example.buildweek_5th_wheel.model

import java.io.Serializable

///Class to create users and gives option if they are a land owners or not

class CreateUser (userName: String, passWord: String, var isLandOwner: Boolean = false) : Serializable