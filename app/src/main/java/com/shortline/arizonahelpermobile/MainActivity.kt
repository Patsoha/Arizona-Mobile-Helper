package com.shortline.arizonahelpermobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily.Companion.SansSerif
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navButtonNames = arrayOf("Шахта", "Профиль", "Хлопок")

            val profileImg = painterResource(id = R.drawable.profile_img)
            val mineImg = painterResource(id = R.drawable.mine_img)
            val cottonImg = painterResource(id = R.drawable.cotton_new_img)

            val stoneImg = painterResource(id = R.drawable.stone_img)
            val ironImg = painterResource(id = R.drawable.iron_img)
            val bronzeImg = painterResource(id = R.drawable.bronze_img)



            val navController = rememberNavController()

            Scaffold(backgroundColor = Color.White,
                bottomBar ={
                    BottomNavigation {
                        navButtonNames.forEach {
                            name -> 
                            BottomNavigationItem(
                                selected = false,
                                onClick = {navController.navigate(name)},
                                label ={ Text(text = name, color = Color.DarkGray)},
                                icon = {
                                    if (name == navButtonNames[0]){
                                        Image(painter = mineImg, contentDescription = "mine", modifier = Modifier.size(20.dp))
                                    }
                                    if (name == navButtonNames[1]){
                                        Image(painter = profileImg, contentDescription = "profile", modifier = Modifier.size(20.dp))
                                    }
                                    if (name == navButtonNames[2]){
                                        Image(painter = cottonImg, contentDescription = "cotton", modifier = Modifier.size(20.dp))
                                    }
                                },
                                modifier = Modifier.background(Color.White)
                            )
                        }
                    }
                }
            ){
                NavHost(navController = navController, startDestination = "Профиль"){
                    composable("Шахта"){
                        Column{
                            Product(image = stoneImg, name = "Камень", price = 22000)
                            Product(image = ironImg, name = "Железо", price = 23500)
                            Product(image = bronzeImg, name = "Бронза", price = 24000)
                        }
                    }
                    composable("Профиль"){
                        Text(text = "dsfdsaf")

                    }
                    composable("Хлопок"){
                        Text(text = "wertfsfgrsagdrsaf")

                    }
                }
            }

        }
    }

    @Composable
    fun Product(image:Painter, name:String, price:Int){
        Row {
            Image(
                painter = image,
                contentDescription = "",
                modifier = Modifier
                    .padding(15.dp, 20.dp, 0.dp, 15.dp)
                    .size(30.dp)
            )
            Column (modifier = Modifier.padding(15.dp, 20.dp, 40.dp, 15.dp)) {
                Text(text = name, color = Color.Black, fontSize = 25.sp, fontFamily = SansSerif)
                Text(text = "$price$", color = Color.Gray, modifier = Modifier.align(Alignment.CenterHorizontally))
            }
        }
    }
}
