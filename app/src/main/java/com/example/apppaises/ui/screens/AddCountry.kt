package com.example.apppaises.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.apppaises.model.Country
import com.example.apppaises.ui.viewmodels.CountryViewModel

@Composable
fun AddCountryDialog(
                     countryViewModel: CountryViewModel,
                     onAddCountry: (Country) -> Unit,
                     onDismiss: () -> Unit) {
    var name by remember { mutableStateOf("") }
    var capital by remember { mutableStateOf("") }
    var imagen by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Add Country") },
        text = {
            Column {
                TextField(value = name, onValueChange = { name = it }, label = { Text("Country Name") })
                TextField(value = capital, onValueChange = { capital = it }, label = { Text("Capital") })
                TextField(value = imagen, onValueChange = { imagen = it }, label = { Text("URL image") })
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (name.isNotEmpty() && capital.isNotEmpty()) {
                        val newCountry = Country(
                            name = name,
                            capital = capital,
                            image = imagen
                        )
                        countryViewModel.addCountry(newCountry)
                        onAddCountry(newCountry)
                        onDismiss()
                    }
                    onDismiss()
                }
            ) {
                Text("Add")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}
