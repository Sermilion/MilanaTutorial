package io.readian.milanatutorial.feature.posts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.memory.MemoryCache
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.compose.SubcomposeAsyncImage
import io.readian.milanatutorial.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PostsScreen(viewModel: PostsViewModel) {

  val uiState by viewModel.uiState.collectAsStateWithLifecycle()

  LazyColumn {
    items(items = uiState) { item ->
      Card(
        shape = MaterialTheme.shapes.small,
        onClick = {

        },
        elevation = 8.dp,
        modifier = Modifier
          .fillMaxWidth()
          .height(300.dp),
      ) {
        Column {
          PostImage(
            imageUrl = item.imageUrl,
            modifier = Modifier
              .fillMaxWidth()
              .height(200.dp),
          )

          Text(
            text = item.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
          )

          Text(
            text = item.body,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
          )
        }
      }
    }
  }
}

@Composable
fun PostImage(
  imageUrl: String?,
  modifier: Modifier = Modifier,
) {
  val cacheKey = MemoryCache.Key(imageUrl.orEmpty())

  val request = ImageRequest.Builder(LocalContext.current)
    .memoryCachePolicy(CachePolicy.ENABLED)
    .diskCachePolicy(CachePolicy.ENABLED)
    .diskCacheKey(imageUrl)
    .memoryCacheKey(cacheKey)
    .data(imageUrl)
    .build()

  SubcomposeAsyncImage(
    model = request,
    loading = {
      Image(
        painter = painterResource(id = R.drawable.ic_no_image),
        contentDescription = stringResource(id = R.string.listing_post_image_error),
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize(),
      )
    },
    error = {
      Image(
        painter = painterResource(id = R.drawable.ic_no_image),
        contentDescription = stringResource(id = R.string.listing_post_image_error),
        contentScale = ContentScale.Crop,
      )
    },
    contentDescription = stringResource(R.string.listing_post),
    contentScale = ContentScale.Crop,
    modifier = modifier,
    onError = {
      print("Error: $it")
    }
  )
}