package com.practice.shortcuts

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel

class ShortViewModel : ViewModel() {

    var shortName = mutableStateOf("Default")

    var editTextName = mutableStateOf("")
    var buttonOnClick = mutableStateOf(false)
    var error = mutableStateOf(false)
    fun updataEditText(newName: String) {
        editTextName.value = newName
    }

//    @Composable
    fun shortNameing() {
//        if (editTextName.value.isEmpty()) {
//            val contex = LocalContext.current
//        } else {

            shortName.value = editTextName.value

//        }
    }

    fun cleaingAfterSHortCut() {

        editTextName.value = ""
    }
}