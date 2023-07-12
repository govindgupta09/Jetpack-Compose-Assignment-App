package com.govi.jetpackassignment

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun CommentPage(navController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {

        Row(
            modifier = Modifier
                .padding(all = 5.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.back_asset),
                contentDescription = "Back Button",
                modifier = Modifier
                    .padding(all = 5.dp)
                    .padding(top = 1.dp)
                    .clickable {
                        navController.navigate(route = Screen.FeedPage.route) {
                            popUpTo(route = Screen.FeedPage.route) {
                                inclusive = true
                            }
                        }
                    }
            )

            Text(
                text = "Comment",
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(all = 6.dp)
                    .padding(start = 2.dp)
            )
        }

        Card(
            elevation = 6.dp,
            modifier = Modifier
                .padding(all = 6.dp)
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .padding(all = 2.dp)
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
                    text = "Question",
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
                            text = "A yellow face with frown and closed ,downcast eyes, as if aching with sorrow or pain ? ",
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(all = 8.dp)
                        )

                        Image(
                            painter = painterResource(id = R.drawable.place_holder),
                            contentDescription = "Feed Photos",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(150.dp)
                                .border(
                                    width = 0.3.dp,
                                    color = Color.Blue,
                                    shape = RectangleShape
                                )
                                .padding(all = 3.dp)
                        )
                    }

                    ConstraintLayout(
                        modifier = Modifier
                            .padding(all = 8.dp)
                            .fillMaxWidth()
                    ) {
                        val (rowLove, rowShare) = createRefs()
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier
                                .constrainAs(rowLove) {
                                    start.linkTo(parent.start)
                                }
                        ) {
                            Text(
                                text = "165",
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
                                painter = painterResource(id = R.drawable.updown_arrows),
                                contentDescription = "Share Button",
                                modifier = Modifier
                                    .padding(top = 2.dp)
                                    .size(22.dp)
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

        Column(Modifier.verticalScroll(rememberScrollState())) {
            CommentCard()
            CommentCard()
            CommentCard()
            CommentCard()
            CommentCard()
            CommentCard()
            CommentCard()
            CommentCard()
            CommentCard()
            CommentCard()
        }
    }
}

@Composable
fun CommentCard() {
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
                    text = "Public",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(all = 3.dp)
                )
            }

            Text(
                text = "Question",
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
                        text = "A yellow face with frown and closed ,downcast eyes, as if aching with sorrow or pain ? ",
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(all = 8.dp)
                    )
                }

                ConstraintLayout(
                    modifier = Modifier
                        .padding(all = 8.dp)
                        .fillMaxWidth()
                ) {
                    val theme = remember { mutableStateOf(false) }
                    val (rowLove) = createRefs()
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
                                .size(25.dp)
                                .padding(top = 1.dp)
                                .padding(all = 2.dp)
                                .clickable {
                                    theme.value = !theme.value
                                }
                        )
                        Text(
                            text = "Likes",
                            color = Color.Blue,
                            modifier = Modifier
                                .padding(all = 1.dp)
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CommentPagePreview() {
    CommentPage(navController = rememberNavController())
}