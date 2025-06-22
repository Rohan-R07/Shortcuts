package com.practice.shortcuts

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.practice.shortcuts.ui.theme.ShortcutsTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        enableEdgeToEdge()
        setContent {

            ShortcutsTheme {

                val snackBar = remember { SnackbarHostState() }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = { SnackbarHost(snackBar) }
                ) { innerPadding ->
                    ShortCut(innerPadding, snackBar)
                }
            }
        }
    }

    @Composable
    fun ShortCut(pad: PaddingValues = PaddingValues(0.dp), snackBar: SnackbarHostState) {
        val viewMode = viewModel<ShortViewModel>()
        val couritineScope = rememberCoroutineScope()

        val intent = Intent(applicationContext, ChatActivity::class.java).apply {
            action = Intent.ACTION_VIEW
        }


        val shortcut = ShortcutInfoCompat.Builder(applicationContext, "id1")
            .setShortLabel(viewMode.shortName.value)
            .setIcon(
                IconCompat.createWithResource(
                    applicationContext,
                    R.drawable.baseline_add_to_drive_24
                )
            )
            .setIntent(Intent(intent)).build()
        ShortcutManagerCompat.pushDynamicShortcut(applicationContext, shortcut)


        Column(
            modifier = Modifier
                .padding(pad)
                .fillMaxSize(),
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
        ) {

            Text(
                text = "Long press the button to open the shortcuts",
                modifier = Modifier
                    .padding(16.dp),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Button(
                onClick = {
                    Intent(applicationContext, ChatActivity::class.java).also {
                        startActivity(it)
                    }
                },
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text("press to open Second Screen")
            }

            TextField(
                modifier = Modifier
                    .padding(top = 10.dp),
                value = viewMode.editTextName.value,
                onValueChange = {
                    if (it.length <= 9) {
                        viewMode.updataEditText(it)
//                        editTex = it
                        viewMode.error.value = false
                    } else {

                        viewMode.error.value = true
                        Toast.makeText(
                            applicationContext,
                            "Maximum 8 characters allowed",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                label = {
                    Text("Enter the name of the shortcut")
                },
                placeholder = {
                    Text("ShortCut name")
                },
                trailingIcon = {
                    IconButton(
                        modifier = Modifier,
                        onClick = {
                            viewMode.editTextName.value = ""
                        }
                    ) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "")
                    }
                },
                isError = viewMode.error.value,
                maxLines = 1

            )

            Button(
                modifier = Modifier
                    .padding(top = 20.dp),
                onClick = {
                    viewMode.buttonOnClick.value = true
                    if (!viewMode.editTextName.value.isEmpty()) {
                        viewMode.shortNameing()
                        couritineScope.launch {
                            snackBar.showSnackbar(
                                message = "Sucessfully Created ShortCut"
                            )
                        }
                    viewMode.cleaingAfterSHortCut()
                    }
                    else{
                        Toast.makeText(applicationContext, "Please Enter the Name", Toast.LENGTH_SHORT).show()

                    }
                }

            ) {
                Text(
                    text = "Create Shortcut ;)",
                    modifier = Modifier,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center
                )

//                if (viewMode.buttonOnClick.value) {
//                    viewMode.shortNameing()
//                }
            }
        }
    }
}
