package com.govi.jetpackassignment

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController

val lightBlue = Color(0xFFD9ECF4)

@Composable
fun FeedPage(
    contentImage: Int,
    postType: String,
    contentText: String,
    navController: NavHostController
) {
    Card(
        elevation = 6.dp,
        modifier = Modifier
            .padding(all = 1.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .padding(all = 8.dp)
        ) {
            val (image, nameTimeCol, msgText, ques, threeDots) = createRefs()
            Image(
                painter = painterResource(id = R.drawable.govind),
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp)
                    .padding(start = 3.dp)
                    .clip(CircleShape)
                    .fillMaxWidth()
                    .border(
                        width = 0.3.dp,
                        color = Color.Blue,
                        shape = CircleShape
                    )
                    .constrainAs(image) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top, 2.dp)
                        end.linkTo(nameTimeCol.start)
                        bottom.linkTo(msgText.top)
                    }
            )

            Column(verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .padding(start = 5.dp)
                    .constrainAs(nameTimeCol) {
                        start.linkTo(image.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(msgText.top)
                    }
            ) {
                Text(
                    text = "Govind Gupta",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier
                        .padding(all = 3.dp)
                )
                Spacer(
                    modifier = Modifier
                        .width(0.3.dp)
                )
                Text(
                    text = "2 hours ago",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(all = 3.dp)
                )
            }

            Text(
                text = postType,
                color = Color.Blue,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(top = 5.dp)
                    .padding(start = 8.dp)
                    .background(lightBlue)
                    .constrainAs(ques) {
                        start.linkTo(nameTimeCol.end)
                        top.linkTo(parent.top)
                        end.linkTo(threeDots.start)
                    }
            )

            Image(painter = painterResource(id = R.drawable.dots),
                contentDescription = "Three Dots",
                modifier = Modifier
                    .size(25.dp)
                    .constrainAs(threeDots) {
//                        start.linkTo(ques.end)
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        bottom.linkTo(msgText.top)
                    }
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(msgText) {
                        top.linkTo(nameTimeCol.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = contentText,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(all = 8.dp)
                    )

                    Image(
                        painter = painterResource(id = contentImage),
                        contentDescription = "Feed Photos",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(
                                width = 0.3.dp,
                                color = Color.Blue,
                                shape = RectangleShape
                            )
                            .padding(
                                all = 3.dp
                            )
                    )
                }

                ConstraintLayout(
                    modifier = Modifier
                        .padding(all = 8.dp)
                        .fillMaxWidth()
                ) {
                    val (rowLove, rowComment, rowShare) = createRefs()
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .constrainAs(rowLove) {
                                start.linkTo(parent.start)
                            }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.love),
                            contentDescription = "Love States",
                            modifier = Modifier
                                .size(22.dp)
                                .padding(top = 3.dp)
                                .padding(all = 2.dp)
                        )
                        Text(
                            text = "121",
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier
                                .padding(start = 3.dp)
                                .padding(all = 1.dp)
                        )
                        Text(
                            text = "Likes",
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier
                                .padding(all = 1.dp)
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .constrainAs(rowComment) {
                                start.linkTo(rowLove.end)
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                                end.linkTo(rowShare.start)
                            }
                            .clickable {
                                navController.navigate(route = Screen.CommentPage.route)
                            }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.comment),
                            contentDescription = "Comment States",
                            modifier = Modifier
                                .size(22.dp)
                                .padding(top = 3.dp)
                                .padding(all = 2.dp)
                        )
                        Text(
                            text = "97",
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier
                                .padding(start = 3.dp)
                                .padding(all = 1.dp)
                        )
                        Text(
                            text = "Comments",
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier
                                .padding(all = 1.dp)
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .constrainAs(rowShare) {
                                end.linkTo(parent.end)
                            }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.share),
                            contentDescription = "Share Button",
                            modifier = Modifier
                                .size(22.dp)
                                .padding(top = 3.dp)
                                .padding(all = 2.dp)
                        )
                        Text(
                            text = "Share",
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier
                                .padding(start = 3.dp)
                                .padding(all = 1.dp)
                        )
                    }
                }
            }
        }
    }
}


data class DataCollection(
    val feedImage: Int,
    val postType: String,
    val contentText: String
)


fun getdataList(): MutableList<DataCollection> {
    val list = mutableListOf<DataCollection>()
    list.add(DataCollection(R.drawable.celes1, "Question", "This is Celestial Body."))
    list.add(DataCollection(R.drawable.celes2, "Marketing", "This is Celestial Body."))
    list.add(DataCollection(R.drawable.celes3, "Question", "This is Celestial Body."))
    list.add(DataCollection(R.drawable.celes4, "Marketing", "This is Celestial Body."))
    list.add(DataCollection(R.drawable.celes5, "Question", "01010101010101010101010."))
    list.add(DataCollection(R.drawable.tech1, "Question", "Tools and Technologies."))
    list.add(DataCollection(R.drawable.tech2, "Marketing", "Networking System."))
    list.add(DataCollection(R.drawable.tech3, "Question", "Modern Devices."))
    list.add(DataCollection(R.drawable.tech4, "Marketing", "Artificial Intelligence."))
    list.add(DataCollection(R.drawable.tech5, "Question", "Internet of Things."))
    return list
}


//@Preview(showBackground = true)
@Composable
fun FeedPagePreview(navController: NavHostController) {

    Column {
        Card(
            elevation = 3.dp,
            modifier = Modifier
                .padding(all = 1.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 16.dp)
            ) {
                ConstraintLayout(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    val (topBar1, topBar2, topBar3) = createRefs()
                    Text(text = "charcha",
                        style = MaterialTheme.typography.body1,
                        color = Color.Blue,
                        modifier = Modifier
                            .constrainAs(topBar1) {
                                start.linkTo(parent.start)
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                            }
                    )

                    Text(text = "bazaar",
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier
                            .constrainAs(topBar2) {
                                start.linkTo(topBar1.end)
                                end.linkTo(topBar3.start)
                            }
                    )

                    Text(text = "profile",
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier
                            .constrainAs(topBar3) {
                                top.linkTo(parent.top)
                                end.linkTo(parent.end)
                                bottom.linkTo(parent.bottom)
                            }
                    )
                }
            }
        }


//        LazyColumn(content = {
//        items(getdataList()){ item ->
//            FeedPage(contentImage = item.feedImage,
//                postType = item.postType ,
//                contentText = item.contentText
//            )
//        }
//    })


        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            getdataList().map { item ->
                FeedPage(
                    contentImage = item.feedImage,
                    postType = item.postType,
                    contentText = item.contentText,
                    navController = navController
                )
            }
        }

    }
}