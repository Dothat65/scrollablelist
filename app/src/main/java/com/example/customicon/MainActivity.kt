package com.example.customicon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.customicon.ui.theme.CustomIconTheme
import com.example.customicon.R
import com.example.customicon.FoodItem
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.example.customicon.ui.theme.CustomIconTheme
import androidx.compose.material3.CardDefaults

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomIconTheme {
                FoodListScreen()
            }
        }
    }
}

@Composable
fun FoodListScreen() {
    val foodItems = listOf(
        FoodItem(R.drawable.food, "Pizza Margherita", "Classic Italian pizza with tomato sauce, mozzarella, and basil"),
        FoodItem(R.drawable.food2, "Sushi Platter", "Assortment of fresh sushi including maki, nigiri, and sashimi"),
        FoodItem(R.drawable.food3, "Burger and Fries", "Juicy beef burger with melted cheese and crispy fries"),
        FoodItem(R.drawable.food4, "Caesar Salad", "Fresh romaine lettuce with Caesar dressing, croutons, and parmesan"),
        FoodItem(R.drawable.food, "Pasta Carbonara", "Traditional Italian pasta with eggs, cheese, pancetta, and black pepper"),
        FoodItem(R.drawable.food2, "Chicken Curry", "Aromatic chicken curry with basmati rice and naan bread"),
        FoodItem(R.drawable.food3, "Chocolate Cake", "Rich chocolate cake with ganache frosting and berries"),
        FoodItem(R.drawable.food4, "Tacos", "Corn tortillas filled with seasoned beef, lettuce, cheese, and salsa"),
        FoodItem(R.drawable.food, "Pad Thai", "Thai stir-fried noodles with tofu, shrimp, peanuts, and bean sprouts"),
        FoodItem(R.drawable.food2, "Greek Salad", "Mediterranean salad with feta cheese, olives, tomatoes, and cucumber")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Delicious Food Gallery",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(foodItems) { foodItem ->
                FoodItemCard(foodItem)
            }
        }
    }
}

@Composable
fun FoodItemCard(foodItem: FoodItem) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = foodItem.imageResource),
                contentDescription = foodItem.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = foodItem.name,
                    style = MaterialTheme.typography.headlineMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = foodItem.description,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview
@Composable
fun FoodListPreview() {
    CustomIconTheme {
        FoodListScreen()
    }
}