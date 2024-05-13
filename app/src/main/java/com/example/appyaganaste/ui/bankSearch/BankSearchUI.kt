import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit
) {
    var searchText by remember { mutableStateOf("") }

    Surface(
        modifier = modifier.fillMaxWidth(),
        color = Color.LightGray,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            TextField(
                value = searchText,
                onValueChange = { searchText = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text(text = "Search...") },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        onSearch(searchText)
                    }
                ),
                singleLine = true
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = { onSearch(searchText) },
                modifier = Modifier.wrapContentWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
            ) {
                Text(text = "Search", color = Color.White)
            }
        }
    }
}

@Preview
@Composable
fun PreviewSearchBar() {
    SearchBar(modifier = Modifier.fillMaxWidth()) {}
}
