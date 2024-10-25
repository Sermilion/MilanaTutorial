package io.feature.newonboarding.posts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberAsyncImagePainter
import io.readian.milanatutorial.R
import io.readian.milanatutorial.feature.newonboarding.posts.NewPost
import io.readian.milanatutorial.feature.newonboarding.posts.NewPostsScreenViewModel

@Composable
fun NewPostsScreen(
    viewModel: NewPostsScreenViewModel = hiltViewModel()
) {

    val posts by viewModel.post.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomNavigationBar()
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(posts) { post ->
                PostItem(post = post)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = R.drawable.onerealogo),
            contentDescription = "Logo Icon",
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = "Spotlight",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.weight(1f))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.sortingtoolbaricon),
                contentDescription = "Sorting Icon",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Icon(
                painter = painterResource(id = R.drawable.filtertoolbaricon),
                contentDescription = "Filter Icon",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun PostItem(post: NewPost) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = post.source,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(id = R.drawable.onerealogo),
                contentDescription = "Notification Icon",
                modifier = Modifier.size(24.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = post.title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 2
        )

        Spacer(modifier = Modifier.height(8.dp))

        Image(
            painter = rememberAsyncImagePainter(post.imageUrl),
            contentDescription = "io.readian.milanatutorial.feature.newonboarding.posts.Post Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(Color.Gray)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            post.tags.forEach { tag ->
                Text(
                    text = tag,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
                        .padding(4.dp)
                )
            }
        }
    }
}

@Composable
fun BottomNavigationBar() {
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Black
    ) {
        BottomNavigationItem(
            icon = { Icon(painter = painterResource(id = R.drawable.onerealogo), contentDescription = "Home") },
            selected = false,
            onClick = {  }
        )
        BottomNavigationItem(
            icon = { Icon(painter = painterResource(id = R.drawable.onerealogo), contentDescription = "Bookmark") },
            selected = false,
            onClick = {  }
        )
        BottomNavigationItem(
            icon = { Icon(painter = painterResource(id = R.drawable.onerealogo), contentDescription = "Profile") },
            selected = false,
            onClick = {  }
        )
    }
}